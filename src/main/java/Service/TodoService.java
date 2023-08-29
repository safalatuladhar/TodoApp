package Service;

import Model.Todo;
import Connection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoService extends DbConnection {
    private final Connection conn;

    public TodoService(Connection conn) {
        super();
        this.conn = conn;
    }

    public List<Todo> getAllTodo() {
        List<Todo> todo = new ArrayList<Todo>();

        try {
            String query = "Select * from todo.todo_app";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Todo t = new Todo();
                t.setId(resultSet.getLong(1));
                t.setName(resultSet.getString(2));
                t.setTodo(resultSet.getString(3));
                t.setStatus(resultSet.getString(4));
                todo.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }

    public Todo getTodoById(Long id) throws SQLException {
        Todo t = null;
        try {
            String query = "Select * from todo.todo_app WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setLong(1, id);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                t = new Todo();
                t.setId(resultSet.getLong(1));
                t.setName(resultSet.getString(2));
                t.setTodo(resultSet.getString(3));
                t.setStatus(resultSet.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return t;
    }


    public boolean addTodo(String name, String todo, String status) throws SQLException {
        try {
            String query = "INSERT INTO todo_app (name, todo,status) VALUES (?,?,? )";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, todo);
            pst.setString(3, status);
            int i = pst.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean updateTodo(Todo todo) {
        try {

            String query = "UPDATE todo_app set name=?, todo=?, status=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, todo.getName());
            pst.setString(2, todo.getTodo());
            pst.setString(3, todo.getStatus());
            pst.setLong(4, todo.getId());

            int i = pst.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean deleteTodo(Long id) {
        try {
            String query = "DELETE FROM todo_app WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setLong(1, id);
            int i = pst.executeUpdate();
            if (i == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return false;
    }

}
