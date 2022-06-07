<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" scope="page" class="com.zhouzhenfeng.Lab2.login"/>
<%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="*"/>
    <%
   //todo 3: use if check username is admin and ppassword is admin
    String u=user.getUsername();
    String p=user.getPassword();
    System.out.println(u+"u");
    System.out.println(p+"p");
    if(u.equals("admin")&&p.equals("admin")){
//        session.setAttribute("user",u);
%>
<%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
<%--todo 5: else part{ --%>
    <%}else{%>

<!--todo 6: print username or password error message-->
<h3>your password or username is wrong!!!2020211001001213ZhouZhenfeng </h3>
<%--todo 7: use jsp:include login.jsp page --%>
<%@include file="login.jsp"%>
<%--todo 8: close else --%>
<%
    }
%>