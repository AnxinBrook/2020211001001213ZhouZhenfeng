<%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/3/22
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="register" >
    name:<input type="text" name="username"></br>
    password:<input type="text" name="password"></br>
    email:<input type="text" name="email"></br>
    gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female</br>
   birthDate:<input type="text name=" name="birthDate"></br>
    <input type="submit"  value="Register"/>
</form>
<%@include file="footer.jsp"%>