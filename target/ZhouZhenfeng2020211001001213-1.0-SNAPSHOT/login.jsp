<%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/3/29
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("massage")==null)){
        out.println(request.getAttribute("massage"));
    }
%>
<form method="post" action="register" >
    name:<input type="text" name="username"></br>
    password:<input type="text" name="password"></br>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp"%>

