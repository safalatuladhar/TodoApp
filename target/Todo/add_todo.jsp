 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
  <title>Todo App </title>
 <%@include file = "components/common_css.jsp" %>
  </head>
<body style="background-color: grey;">
 <%@include file = "components/navbar.jsp" %>
 <div class="container">
    <div class="row p-5" >
        <div class="col-md-6 offset-md-3">
            <div class="card">
                <div class="card-body">
                    <h3 class = "text-center"> Add form </h3>
                    <form action="http://localhost:8080/add_todo" method="post">
                       <div class="mb-3">
                         <label for="formGroupExampleInput" class="form-label">Name</label>
                         <input type="text" class="form-control" id="formGroupExampleInput" name="username"
                          placeholder="Enter a name">
                      </div>
                       <div class="mb-3">
                         <label for="formGroupExampleInput" class="form-label">Add Todo</label>
                         <input type="text" class="form-control" id="formGroupExampleInput" name="todo"
                         placeholder="Add a todo">
                       </div>
                    <div class="mb-3">
                      <label for="formGroupExampleInput2" class="form-label">Status</label>
                      <select class="form-select" aria-label="Default select example" name = "status">
                      <option selected> --Select--</option>
                        <option value="Pending">Pending</option>
                        <option value="Completed">Completed</option>
                      </select>
                    </div>
                     <div class="col-12 m-3">
                        <button type="submit" class="btn btn-primary">Add</button>
                     </div>
                </div>
                    </form>
             </div>
         </div>
     </div>
  </div>
</body>
</html>