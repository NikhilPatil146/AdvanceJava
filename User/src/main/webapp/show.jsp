<%@page import="com.dao.UserDao"%>
<%@page import="com.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<table border="1" cellpadding="10px" cellspacing="10px" width="100%">
 <tr>
 <th>U_ID</th>
  <th>FIRST NAME</th>
   <th>LAST NAME</th>
    <th>EMAIL</th>
     <th>MOBILE</th>
      <th>DATE OF BIRTH</th>
       <th>GENDER</th>
        <th>PASSWORD</th>
        <th>EDIT</th>
        <th>DELETE</th>
 </tr>

  <%
    List<User> list=UserDao.getAllUser();
    for(User u:list )
    {
    %>
    <tr>
    <td><%=u.getU_id() %> </td>
    <td><%=u.getFname() %> </td>
    <td><%=u.getLname()%> </td>
    <td><%=u.getEmail() %> </td>
    <td><%=u.getMobile()%> </td>
    <td><%=u.getDob()%> </td>
    <td><%=u.getGender() %> </td>
    <td><%=u.getPas() %> </td>
    <td>
    <form name="edit" method="post" action="UserController">
      <input type="hidden" name="u_id" value="<%=u.getU_id() %>" >
      <input type="submit" name="action" value="EDIT" class="btn btn-primary">  
    </form>
    </td>
    <td>
    <form name="delete" method="post" action="UserController">
       <input type="hidden" name="u_id" value="<%=u.getU_id()%>">
       <input type="submit" name="action" value="DELETE" class="btn btn-danger">
    </form>
    
    </td>
    </tr>
    <%
    }
   %>

</table>
<a href="index.jsp">Add New User</a>
</body>
</html>