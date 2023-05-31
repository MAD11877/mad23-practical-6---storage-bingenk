package sg.edu.np.mad.madpractical;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < 21; i++) {
            Random r = new Random();
            int randomUsername = r.nextInt(1000000000);
            int randomDescription =  r.nextInt(1000000000);
            users.add(new User("Name" + " " + randomUsername , "Description" + " " + randomDescription));
//            users.add(new User("Name-" + i , "Description-" + i));

        }

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdapter(ListActivity.this, users));
    }
}