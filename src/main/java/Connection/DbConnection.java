package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection conn = null;

    public static Connection getConnection(){
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo", "root", "I@mgre@t1");
//                System.out.println("Connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(){
        if (conn !=null){
            try {
                conn.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
