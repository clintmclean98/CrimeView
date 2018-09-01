package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Statement;

public class EditProfile extends AppCompatActivity {


    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Intent intent = getIntent();
        databaseHandler = (DatabaseHandler) intent.getSerializableExtra("connection");


    }


    public Integer getUserId() {

        return null;
    }

    public void editProfileSQL(View view) {
        EditText edtTextUsername = findViewById(R.id.nameChange);
        EditText edtTextPassword = findViewById(R.id.surnameChange);
        //Integer UserID = 2;
        String username = edtTextUsername.getText().toString();
        String password = edtTextPassword.getText().toString();


        String Name = "Clint";
        String Surname = "Mclean";
        Integer UserType = 1;

        try {
            //Query works
            //  String sql = " UPDATE UserTable SET Username = '" + Username.toString() + "', Password = '" + Password.toString() + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE UserID = 2 ";
            //   String sql = " UPDATE UserTable SET Username = '" + Username + "', Password = '" + Password + "', Name ='" + Name + "', Surname='" + Surname + "', UserType=1  WHERE UserID = 2 ";
            String sql = " UPDATE UserTable SET Username = '" + username + "', Password = '" + password + "'  WHERE UserID = 2 ";
            preparedStatement.execute(sql);
            Toast.makeText(this, "Update successful", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Could not update", Toast.LENGTH_LONG).show();
            //   System.out.println("Could not insert new record... " + e.getMessage());
        }
    }
}
