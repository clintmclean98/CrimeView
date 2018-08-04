package t.flatearchsocie.crimeview;


import android.os.StrictMode;
import android.util.Log;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class DatabaseHandler implements Serializable {

    private Connection connection;
    private Statement preparedStatement;
    private CallableStatement storedProcedure;

    public DatabaseHandler() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connURL = "jdbc:jtds:sqlserver://openbox.nmmu.ac.za/JN07;instance=WRR";
            connection = DriverManager.getConnection(connURL, "JN07User", "u7WVFDBj");
        } catch (ClassNotFoundException e) {
            Log.e("Class not found Error", e.getMessage());
        } catch (SQLException e) {
            Log.e("SQL Error", e.getMessage());
        }

    }

    public Boolean signIn(String username, String password) throws SQLException {


        //preparedStatement = connection.prepareStatement("SELECT * FROM USERTABlE WHERE USERNAME = ? AND PASSWORD = ?");

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERTABLE WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");

        if (!resultSet.next()) {
            return false;
        } else {
            return true;
        }


    }

    public ArrayList<Crime> getCrimeDetails() throws SQLException {


        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM CRIME");
        ArrayList<Crime> crimes = new ArrayList<>();

        while (resultSet.next()) {
            int crimeID = resultSet.getInt("CrimeID");
            int categoryID = resultSet.getInt("CategoryID");
            int locationID = resultSet.getInt("LocationID");
            int userID = resultSet.getInt("UserID");
            int verified = resultSet.getInt("Verified");
            Time time = resultSet.getTime("TimeRecorded");
            float latitude = resultSet.getFloat("Latitude");
            float longitude = resultSet.getFloat("Longitude");
            Boolean bool;
            if (verified == 0) {
                bool = false;
            } else {
                bool = true;
            }
            Crime crime = new Crime(crimeID, categoryID, locationID, userID, bool, time, latitude, longitude);
            crimes.add(crime);

        }
        return crimes;

    }


}
