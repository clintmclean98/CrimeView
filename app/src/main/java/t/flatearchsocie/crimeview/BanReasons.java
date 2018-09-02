package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BanReasons extends AppCompatActivity {
    TextView test;
    DatabaseHandler databaseHandler;
    private Connection connection = null;
    private Statement preparedStatement = null;
    ResultSet resultSet = null;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban_reasons);

        databaseHandler = DatabaseHandler.getinstance();
        connection = databaseHandler.getCon();

        test = (TextView) findViewById(R.id.textView3);
        Intent thisIntent = getIntent();
        if (thisIntent != null) {
            Bundle extras = thisIntent.getExtras();
            if (extras != null) {
                userName = extras.getString("nameOfUser");
                test.setText(userName);

            }
        }
    }

    public void proceedButton() {

    }
}
