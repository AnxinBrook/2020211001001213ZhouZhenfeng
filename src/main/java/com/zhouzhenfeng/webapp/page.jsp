<%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/5/3
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo#1- week 10</title>
</head>
<body>
<h2>Use of pageContext to set,get,remove attribute from 4 scopes:page,request,session,application</h2>
<%
    pageContext.setAttribute("attName","in page");
    request.setAttribute("attName","in request");
    session.setAttribute("attName","in session");
    pageContext.setAttribute("attName","in application",PageContext.APPLICATION_SCOPE);
%>
<h2>way1</h2>
Att value : <%=pageContext.setAttribute("attName")%></br>
Att value : <%=request.setAttribute("attName")%></br>
Att value : <%=session.setAttribute("attName")%></br>
Att value : <%=application.setAttribute("attName")%></br>

</body>

</html>
