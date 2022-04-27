<%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/4/20
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
User u=(User) session.getAttribute("user");
%>



<form method="post" action="updateUser" >
    <input type="hidden" name="id" value="<%=u.getId()%>">
    name:<input type="text" name="username" value="<%=u.getUsername()%>"></br>
    password:<input type="text" name="password" value="<%=u.getPassword()%>"></br>
    email:<input type="text" name="email" value="<%=u.getEmail()%>"></br>
    gender:<input type="radio" name="gender" value="male" <%="male".equals(u.getGender()) ?"checked":""%>>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender()) ?"checked":""%>>Female</br>
    birthDate:<input type="text name=" name="birthDate" value="<%=u.getBirthdate()%>"></br>
    <input type="submit"  value="Save Changes"/>
</form>
<%@include file="footer.jsp"%>
