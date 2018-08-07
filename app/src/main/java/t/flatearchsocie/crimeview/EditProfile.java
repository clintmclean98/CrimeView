package t.flatearchsocie.crimeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EditProfile extends AppCompatActivity {
 //   private Connection connection = null;
    private Statement preparedStatement = null;
 //   private CallableStatement storedProcedure = null;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        connectToDB();
    }

    public void connectToDB() {
        databaseHandler = new DatabaseHandler();
        try {
            preparedStatement = databaseHandler.getStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

    public Integer getUserId() {

        return null;
    }

    public void editProfileSQL(View view) {
         EditText UN = findViewById(R.id.nameChange);
         EditText PW = findViewById(R.id.surnameChange);
        //Integer UserID = 2;
        String Username = UN.getText().toString();
        String Password = PW.getText().toString();


        String Name = "Clint";
        String Surname = "Mclean";
        Integer UserType = 1;

        try {
            //Query works
            //  String sql = " UPDATE UserTable SET Username = '" + Username.toString() + "', Password = '" + Password.toString() + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE UserID = 2 ";
         //   String sql = " UPDATE UserTable SET Username = '" + Username + "', Password = '" + Password + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE UserID = 2 ";
               String sql = " UPDATE UserTable SET Username = '" + Username + "', Password = '" + Password + "'  WHERE UserID = 2 ";
            preparedStatement.execute(sql);
            Toast.makeText(this, "Update successful", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Could not update", Toast.LENGTH_LONG).show();
            //   System.out.println("Could not insert new record... " + e.getMessage());
        }
    }
}
