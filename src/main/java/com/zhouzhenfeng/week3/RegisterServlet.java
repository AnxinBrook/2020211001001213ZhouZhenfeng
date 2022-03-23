package com.zhouzhenfeng.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    Connection con= null;
    @Override
    public void  init() throws ServletException{
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=new String(request.getParameter("username"));
        String password=new String(request.getParameter("password"));
        String  email=new String(request.getParameter("email"));
        String  gender=new String(request.getParameter("gender"));
        String birthDate=new String(request.getParameter("birthDate"));
        System.out.println("1,username:"+username+"\t password:" +password);
        Connection con = null;
        Statement sql;
        String dbname="userdb";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        String userName="sa";
        String userPwd="123456";
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try{
            Class.forName(driverName);
            con=DriverManager.getConnection(url,userName,userPwd);
            sql=con.createStatement();
            sql.executeUpdate("insert into users values("+"'"+username+"'"+","+"'"+password+"'"+")");
            con.close();
        }
        catch(Exception e){
            System.out.print(e+"\n");
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("insert success!");
        out.flush();
        out.close();
    }

    public void destroy() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}