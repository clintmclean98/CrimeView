package t.flatearchsocie.crimeview;


import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class DatabaseHandler {

    private static DatabaseHandler databaseHandler;
    private Connection connection = null;
    private Statement preparedStatement = null;
    //private CallableStatement storedProcedure = null;

    private DatabaseHandler() {

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

    public static DatabaseHandler getinstance() {

        if (databaseHandler == null) {
            databaseHandler = new DatabaseHandler();
        }
        return databaseHandler;
    }

    public Boolean signIn(String password, String username) throws SQLException {

        //preparedStatement = connection.prepareStatement("SELECT * FROM USERTABlE WHERE USERNAME = ? AND PASSWORD = ?");

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERTABLE WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");


        if (resultSet.next()) {
            return true;
        }
        return false;
    }


    public Statement getStatement() throws SQLException {
        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return preparedStatement;
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

    public Boolean editProfile(String password, String username) throws SQLException {


        // ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERTABLE WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'");

        // String sql = " UPDATE UserTable SET Username = '" + username + "', Password = '" + password + "', UserType=1  WHERE UserID = 2 ";

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


        int resultSet = preparedStatement.executeUpdate("UPDATE UserTable SET Password = '" + password + "'  WHERE Username = '" + username + "'");


        if (resultSet == 0) {
            return false;
        } else {
            return true;
        }


    }

    public Boolean usernameExists(String username) throws SQLException {

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERTABLE WHERE USERNAME = '" + username + "' ");
        if (resultSet.getFetchSize() == 0) {
            return true;
        } else {
            return false;
        }


    }

    public String getCategory(int categoryID) throws SQLException {

        //Check Query
        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT CATEGORYNAME FROM CATEGORY WHERE CATEGORYID = '" + categoryID + "'");


        return resultSet.getString(0);


    }

    public String getUser(int userID) throws SQLException {

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM USERTABLE WHERE USERID = " + userID + "");

        return resultSet.getString("Username");



    }

    public Crime getCrime(int crimeID) throws SQLException {

        preparedStatement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM CRIME");

        Crime crime = null;
        while (resultSet.next()) {

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
            crime = new Crime(crimeID, categoryID, locationID, userID, bool, time, latitude, longitude);


        }
        return crime;


    }


}
