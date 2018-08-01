package t.flatearchsocie.crimeview;



import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseHandler implements Serializable {

    private Connection connection;
    private Statement statement;
    private CallableStatement storedProcedure;

    public DatabaseHandler() {
    }
}
