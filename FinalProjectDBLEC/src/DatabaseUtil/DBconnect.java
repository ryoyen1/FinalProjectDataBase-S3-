package DatabaseUtil;

import javax.xml.transform.Result;
import java.sql.*;

public class DBconnect {
    private static final String username="root";
    private static final String password="";
    private static final String CONN="jdbc:mysql://localhost:3306/unyu";
    private static final String SELECT_QUERY="SELECT * FROM employee WHERE username = ? and password = ?";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(CONN, username, password);
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
