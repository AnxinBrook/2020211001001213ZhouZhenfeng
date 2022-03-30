package com.zhouzhenfeng.week5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con= null;
    @Override
    public void  init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql=" select  username,password from usertable where username=' "+username+" ' and password=' "+password+" ' ";
try{
    ResultSet rs=con.createStatement().executeQuery(sql);
    if (rs.next()) {
        //out.print("Login Successful!!!");
        //out.print("Welcome" + username);
        request.setAttribute("username",rs.getString("username"));
        request.setAttribute("password",rs.getString("password"));
        request.setAttribute("email",rs.getString("email"));
        request.setAttribute("gender",rs.getString("gender"));
        request.setAttribute("birthDate",rs.getString("birthDate"));

        request.getRequestDispatcher("userinfo.jsp").forward(request,response);
    }else {
        //out.print("username or password Error!!!");
        request.setAttribute("message","Username or Password Error!!!");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
} catch (SQLException e) {
    e.printStackTrace();
}
    }
}
