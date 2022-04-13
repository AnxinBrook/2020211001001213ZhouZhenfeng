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
<%
Cookie[] allCookies=request.getCookies();
String username="",password="",rememberMeVale="";
if (allCookies!=null){
    for (Cookie c:allCookies){
        if (c.getName().equals("cUsername")){
            username=c.getValue();
        }
        if (c.getName().equals("cpassword")){
            password=c.getValue();
        }
        if (c.getName().equals("cRememberMe")){
            rememberMeVale=c.getValue();
        }

    }
}

%>
<form method="post" action="login" >
    name:<input type="text" name="username" value="<%=username%>"></br>
    password:<input type="text" name="password" value="<%=password%>"></br>
    <input type="checkbox" name="RememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%>checked/>RememberMe<br/>


    <input type="submit" value="Sumber"/>
</form>
<%@include file="footer.jsp"%>

