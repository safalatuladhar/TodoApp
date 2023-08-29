<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Todo App</title>
    <%@include file="components/common_css.jsp" %>
</head>
<body style="background-color: grey;">
    <%@include file="components/navbar.jsp" %>
    <div class="container">
        <div class="row p-5">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <h3 class="text-center">Add form</h3>
                        <form action="add_todo" method="post">

                            <div class="mb-3">
                                <label for="formGroupExampleInput" class="form-label">Name</label>
                                <input type="text" class="form-control" id="formGroupExampleInput" name="username"
                                    value="<%= (session.getAttribute("usernameValue") != null) ? session.getAttribute("usernameValue") : "" %>"
                                     placeholder="Enter a name">
                                     <%= session.getAttribute("usernameValue") %>

                                <% String nameError = (String) session.getAttribute("nameError");
                                    if (nameError != null) {%>
                                <div class="alert alert-danger" role="alert">
                                    <%= nameError %>
                                </div>
                                <% session.removeAttribute("nameError");
                                } %>
                            </div>
                            <input type="hidden">
                            <div class="mb-3">
                                <label for="formGroupExampleInput" class="form-label">Add Todo</label>
                                <input type="text" class="form-control" id="formGroupExampleInput" name="todo"
                                    value="<%= (session.getAttribute("todoValue") != null) ? session.getAttribute("todoValue") : "" %>"
                                    placeholder="Add a todo">
                                <%= session.getAttribute("todoValue") %>

                                <% String todoError = (String) session.getAttribute("todoError");
                                    if (todoError != null) {%>
                                <div class="alert alert-danger" role="alert">
                                    <%= todoError %>
                                </div>
                                <% session.removeAttribute("todoError");
                                } %>
                            </div>
                            <div class="mb-3">
                                <label for="formGroupExampleInput2" class="form-label">Status</label>
                                <select class="form-select" aria-label="Default select example" name="status">
                               <option value="Pending" <%= (session.getAttribute("statusValue") != null && session.getAttribute("statusValue").equals("Pending")) ? "selected" : "" %>>Pending</option>
                                <option value="Completed" <%= (session.getAttribute("statusValue") != null && session.getAttribute("statusValue").equals("Completed")) ? "selected" : "" %>>Completed</option>
                                </select>
                                <% String statusError = (String) session.getAttribute("statusError");
                                    if (statusError != null) { %>
                                <div class="alert alert-danger" role="alert">
                                    <%= statusError %>
                                </div>
                                <% session.removeAttribute("statusError");
                                } %>
                            </div>
                            <div class="col-12 m-3">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
