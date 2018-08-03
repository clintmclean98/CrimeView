package t.flatearchsocie.crimeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;
import java.util.ArrayList;

public class ManageCrime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_crime);
    }

    public void populateCrimes() throws SQLException {

        DatabaseHandler dbDatabaseHandler = new DatabaseHandler();
        ArrayList crimes = dbDatabaseHandler.getCrimeDetails();


    }

}
