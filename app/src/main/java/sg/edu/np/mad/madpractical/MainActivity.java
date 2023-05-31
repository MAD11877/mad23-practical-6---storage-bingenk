package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private Button followButton;
    private boolean isFollowing = false;
    private Button messageButton;
    private TextView header;
    private TextView username;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.textView3);
        description = findViewById(R.id.textView4);
        messageButton = findViewById(R.id.button2);
        followButton = findViewById(R.id.btnFollow);

        Intent receivingEnd = getIntent();
        String username = receivingEnd.getStringExtra("USERNAME");
        String description = receivingEnd.getStringExtra("DESCRIPTION");

        this.username.setText(username);
        this.description.setText(description);
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFollowing) {
                    followButton.setText("FOLLOW");
                    isFollowing = false;
                    showToast("Unfollowed");
                } else {
                    followButton.setText("UNFOLLOW");
                    isFollowing = true;
                    showToast("Followed");
                }
            }

        });
        //CHALLENGE PART
        messageButton.setOnClickListener(view -> {
            Intent activityMessage = new Intent(MainActivity.this, MessageGroup.class);
            startActivity(activityMessage);
        });

    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}