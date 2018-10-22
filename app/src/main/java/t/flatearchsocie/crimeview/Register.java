package t.flatearchsocie.crimeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    DatabaseHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    //use an intent to parse info to next screen
    private boolean validate() {

        boolean temp=true;
        TextView txtPassword = findViewById(R.id.txtPassword); //How to get something from the screen.
        String pass= txtPassword.getText().toString(); //Convert it so it can be used.

        TextView txtUserID = findViewById(R.id.txtUserID);
        String userID = txtUserID.getText().toString();

        TextView txtcPassword = findViewById(R.id.txtCPassword);
        String cpass= txtcPassword.getText().toString();

        if(!dbHandler.usernameExists(userID)){
            Toast.makeText(Register.this,"Invalid Email Address",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        else if(!pass.equals(cpass)){
            Toast.makeText(Register.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            temp=false;
        }
        return temp;
    }
}
