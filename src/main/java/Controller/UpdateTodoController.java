package Controller;

import Connection.DbConnection;
import Model.Todo;
import Service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update")
public class UpdateTodoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        boolean isValidData = true;

        String value = request.getParameter("id");
        String username = request.getParameter("username");
        String todo = request.getParameter("todo");
        String status = request.getParameter("status");
        System.out.println(value + username + " " + todo + " " + status);

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

        if (isValidData && value != null && !value.isEmpty()) {
            TodoService service = new TodoService(DbConnection.getConnection());

            Long id = Long.parseLong(value);
            Todo t = new Todo();
            t.setId(id);
            t.setName(username);
            t.setTodo(todo);
            t.setStatus(status);

            boolean dataFetched = service.updateTodo(t);

            if (dataFetched) {
                session.setAttribute("success", "Todo Updated Successfully!!");
                response.sendRedirect("index.jsp");
                System.out.println("Update success");
            } else {
                session.setAttribute("error", "Failed");
                response.sendRedirect("index.jsp");
                System.out.println("Error");
            }

        } else {
            session.setAttribute("usernameValue", username);
            session.setAttribute("todoValue", todo);
            session.setAttribute("statusValue", status);

            response.sendRedirect("edit.jsp?id=" + value);
        }
    }
}
