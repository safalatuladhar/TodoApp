<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Connection.DbConnection"  %>
<%@page import= "java.sql.Connection"  %>

<!DOCTYPE html>
<html>
<head>
 <title>Todo App </title>
<%@include file = "components/common_css.jsp" %>
 </head>
 <body>
<%@include file = "components/navbar.jsp" %>

   /* <%
    Connection conn = DbConnection.getConnection();
    out.print(conn);
    %>*/

    <h1 class= "text-center text-black"> Todo Application</h1>

    <div class = "container p-4">
   <table class="table table-striped m-1">
     <thead class = "bg-warning ">
       <tr>
         <th scope="col">S.No</th>
          <th scope="col">Name</th>
         <th scope="col">Todo</th>
         <th scope="col">Status</th>
         <th scope="col">Action</th>
       </tr>
     </thead>
     <tbody>
       <tr>
         <th scope="row">1</th>
         <td>Safala</td>
         <td>Learn</td>
         <td>Pending</td>
         <td>
         <a href="" class = "btn btn-sm btn-primary">Edit</a>
         <a href="" class = "btn btn-sm btn-danger">Delete</a>
         </td>
       </tr>

     </tbody>
   </table>
    </div>

  </body>
</html>