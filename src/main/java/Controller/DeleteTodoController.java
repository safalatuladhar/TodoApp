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

@WebServlet("/delete")
public class DeleteTodoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        TodoService service = new TodoService(DbConnection.getConnection());

        boolean a = service.deleteTodo(id);
        HttpSession session = request.getSession();
        if (a){
            session.setAttribute("success", "Todo Deleted Successfully!!");
            response.sendRedirect("index.jsp");
            System.out.println("Delete success");
        }else {
            session.setAttribute("error", "Failed");
            response.sendRedirect("index.jsp");
            System.out.println("Error");
        }

    }
}
