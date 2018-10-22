package t.flatearchsocie.crimeview;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

public class ViewUserActivity extends AppCompatActivity {
TableLayout tl;
TableRow tr;
TextView username, firstname, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);
         tl = (TableLayout) findViewById(R.id.tblUser);
        addHeaders();
        addData();
    }

    public void addHeaders(){
        /** Create a TableRow dynamically **/
        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView username = new TextView(this);
        username.setText("Username");
        username.setTextColor(Color.GRAY);
        username.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        username.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        username.setPadding(5, 5, 5, 0);
        tr.addView(username);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView fname = new TextView(this);
        fname.setText("First Name");
        fname.setTextColor(Color.GRAY);
        fname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        fname.setPadding(5, 5, 5, 0);
        fname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(fname); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout

        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns

        tr = new TableRow(this);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
        TextView divider = new TextView(this);
        divider.setText("-----------------");
        divider.setTextColor(Color.GREEN);
        divider.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        divider.setPadding(5, 0, 0, 0);
        divider.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider); // Adding textView to tablerow.

        TextView divider2 = new TextView(this);
        divider2.setText("-------------------------");
        divider2.setTextColor(Color.GREEN);
        divider2.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        divider2.setPadding(5, 0, 0, 0);
        divider2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(divider2); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout

        tl.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
    }

    public void addData(){
        ArrayList<User> userdetails = new ArrayList();
        try {
            userdetails = DatabaseHandler.getInstance().getUserDetails();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < userdetails.size(); i++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(this);
            tr.setLayoutParams(new LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            username = new TextView(this);
            username.setText(userdetails.get(i).getUsername());
            username.setTextColor(Color.RED);
            username.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            username.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            username.setPadding(5, 5, 5, 5);
            tr.addView(username);  // Adding textView to tablerow.



            /** Creating another textview **/
            firstname = new TextView(this);
            firstname.setText(userdetails.get(i).getName());
            firstname.setTextColor(Color.GREEN);
            firstname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            firstname.setPadding(5, 5, 5, 5);
            firstname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(firstname); // Adding textView to tablerow.

            surname = new TextView(this);
            surname.setText(userdetails.get(i).getSurname());
            surname.setTextColor(Color.GREEN);
            surname.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
            surname.setPadding(5, 5, 5, 5);
            surname.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(surname); // Adding textView to tablerow.
            // Add the TableRow to the TableLayout
            final int userID = userdetails.get(i).getUserID();
            tr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(getApplicationContext(), UserActivityProfile.class);
                    myIntent.putExtra("username", userID);
                    startActivity(myIntent);
                }
            });
            tl.addView(tr, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
        }

    }


}
