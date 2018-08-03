package t.flatearchsocie.crimeview;


import android.os.StrictMode;
import android.util.Log;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler implements Serializable {

    private Connection connection;
    private PreparedStatement preparedStatement;
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

    public Boolean signIn(String username, String password) throws SQLException{



            preparedStatement = connection.prepareStatement("SELECT * FROM USERTABlE WHERE USERNAME = ? AND PASSWORD = ?");

            preparedStatement.setString(1, username);

            preparedStatement.setString(2, password);

        /*statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        tempModules = new ArrayList<>();
        ResultSet result = statement.executeQuery("SELECT * FROM Module");*/

            preparedStatement.execute();
            return true;



    }


}
