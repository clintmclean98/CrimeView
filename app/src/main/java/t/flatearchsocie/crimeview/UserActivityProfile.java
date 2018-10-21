package t.flatearchsocie.crimeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserActivityProfile extends AppCompatActivity {
User 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("username");
        }

    }
}
