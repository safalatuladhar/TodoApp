<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Connection.DbConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="Service.TodoService" %>
<%@ page import="Model.Todo" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Todo App</title>
    <%@ include file="components/common_css.jsp" %>
</head>
<body>
    <%@ include file="components/navbar.jsp" %>

    <h1 class="text-center text-black">Todo Application</h1>

    <% String success = (String) session.getAttribute("success");
       if (success != null) { %>
        <div class="alert alert-success" role="alert">
            <%= success %>
        </div>
        <% session.removeAttribute("success");
       } %>

    <% String error = (String) session.getAttribute("error");
       if (error != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= error %>
        </div>
        <% session.removeAttribute("error");
       } %>

    <div class="container p-4">
        <table class="table table-striped m-1">
            <thead style="background-color: white">
                <tr>
                    <th scope="col">Id.No</th>
                    <th scope="col">Name</th>
                    <th scope="col">Todo</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    TodoService service = new TodoService(DbConnection.getConnection());
                    List<Todo> todos = service.getAllTodo();
                    for (Todo t : todos) { %>
                    <tr>
                        <th scope="row"><%= t.getId() %></th>
                        <td><%= t.getName() %></td>
                        <td><%= t.getTodo() %></td>
                        <td><%= t.getStatus() %></td>
                        <td>
                            <a href="edit.jsp?id=<%= t.getId() %>" class="btn btn-sm btn-primary">Edit</a>
                            <a href="#" class="btn btn-sm btn-danger" onClick="confirmDelete('<%= t.getId() %>')">Delete</a>
                        </td>
                    </tr>
                    <%
                    } %>
            </tbody>
        </table>
    </div>

    <script>

    function confirmDelete(id) {
        if (confirm("Are you sure you want to delete?")) {
            window.location.href = "delete?id=" + id;
        }
    }
    </script>
</body>
</html>
