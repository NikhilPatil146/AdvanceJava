<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr,td{
      padding:10px
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<center>
  <h1>User Registaions </h1>
</center>
<hr>
<b style="color:blue">
<%
  if(request.getAttribute("msg")!=null)
  {
	  out.print(request.getAttribute("msg"));
  }
%>
</b>
<form name="frm" method="post" action="UserController">
<table>
    <tr>
    <td>First Name</td>
    <td><input type="text" name="fname"></td>
    </tr>
    <tr>
    <td>Last Name</td>
    <td><input type="text" name="lname"></td>
    </tr>
    <tr>
    <td>Email</td>
    <td><input type="text" name="email"></td>
    </tr>
    <tr>
    <td>Mobile</td>
    <td><input type="text" name="mobile"></td>
    </tr>
    <tr>
    <td>Password</td>
    <td><input type="password" name="password"></td>
    </tr>
    <tr>
    <td>Confirm Password</td>
    <td><input type="password" name="cpassword"></td>
    </tr>
      <tr>
      <td colspan="2" align="center">
      <input type="submit" name="action" value="REGISTER">
      </td>
      </tr>
</table>
</form>
</body>
</html>
</body>
</html>