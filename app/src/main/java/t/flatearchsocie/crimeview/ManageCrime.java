package t.flatearchsocie.crimeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.sql.SQLException;
import java.util.List;

public class ManageCrime extends AppCompatActivity {
 DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_crime);
        databaseHandler = DatabaseHandler.getinstance();
    }

    public void populateCrimes() throws SQLException {


        List<Crime> crimes = databaseHandler.getCrimeDetails();




    }

}
