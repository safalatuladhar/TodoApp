package Service;

import Connection.DbConnection;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public int signup(User user) throws ClassNotFoundException {
        String query = "INSERT INTO users (first_name, last_name, username, password) VALUES (?,?,?,?)";
        int result = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getPassword());
            System.out.println(pst);
            result = pst.executeUpdate();

        } catch (SQLException e) {
//            DbConnection.printSqlException(e);
        }

        return result;
    }
}
