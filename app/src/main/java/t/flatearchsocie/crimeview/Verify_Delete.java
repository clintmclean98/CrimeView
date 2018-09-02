package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.SQLException;

public class Verify_Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify__delete);
        Intent intent = getIntent();
        Crime crime = (Crime) intent.getSerializableExtra("crime");





    }

    public void populateUI(Crime crime) throws SQLException {

        DatabaseHandler databaseHandler = DatabaseHandler.getinstance();

        TextView txtCrimeType = findViewById(R.id.txtCrimeType);
        txtCrimeType.setText("Crime Type : " + databaseHandler.getCategory(crime.getCategoryID()));

        TextView txtUser = findViewById(R.id.txtUserReported);
        txtUser.setText("Reported By : " + databaseHandler.getUser(crime.getUserID()));

        TextView txtDate = findViewById(R.id.txtDateReported);
        txtDate.setText("Date Reported : " + crime.getTimeRecorded().toString());

        TextView txtVerified = findViewById(R.id.txtVerified);

        if (crime.getVerified()) {
            txtVerified.setText("Verified : Yes" );
        }
        else {
            txtVerified.setText("Verified : No" );
        }





    }
}
