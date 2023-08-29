package Controller;

import Connection.DbConnection;
import Service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/add_todo")
public class TodoController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        boolean isValidData = true;

        String username = request.getParameter("username");
        String todo = request.getParameter("todo");
        String status = request.getParameter("status");

        if (username == null || username.isEmpty()) {
            session.setAttribute("nameError", "Invalid username field");
            isValidData = false;
        }
        if (todo == null || todo.isEmpty()) {
            session.setAttribute("todoError", "Invalid todo field");
            isValidData = false;
        }
        if (status == null || status.isEmpty()) {
            session.setAttribute("statusError", "Invalid status field");
            isValidData = false;
        }

        if (!isValidData) {
            session.setAttribute("usernameValue", username);
            session.setAttribute("todoValue", todo);
            session.setAttribute("statusValue", status);
            System.out.println("Attributes set: " + username + ", " + todo + ", " + status);
            response.sendRedirect("add_todo.jsp");
        }
        else {
            session.removeAttribute("usernameValue");
            session.removeAttribute("todoValue");
            session.removeAttribute("statusValue");

            TodoService service = new TodoService(DbConnection.getConnection());
            boolean dataFetched = false;
            try {
                dataFetched = service.addTodo(username, todo, status);
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            if (dataFetched) {
                session.setAttribute("success", "Todo Added Successfully!!");
                response.sendRedirect("index.jsp");
            } else {
                session.setAttribute("error", "Failed");
                response.sendRedirect("index.jsp");
            }
        }
    }
}
