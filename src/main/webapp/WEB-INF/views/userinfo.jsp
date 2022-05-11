<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/4/5
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    Cookie [] allCookies=request.getCookies();
    for (Cookie c :allCookies){
        out.println("<br/>"+c.getName()+"---"+c.getValue());
    }

%>
<%
  User u= (User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
        <td>password:</td><td><%=u.getPassword()%></td>
</tr><tr>
        <td>email:</td><td><%=u.getEmail()%></td>
</tr><tr>
        <td>gender:</td><td><%=u.getGender()%></td>
</tr><tr>
        <td>birthDate:</td><td><%=u.getBirthdate()%></td>

    </tr>
</table>
<%@include file="footer.jsp"%>