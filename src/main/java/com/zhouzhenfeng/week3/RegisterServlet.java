package com.zhouzhenfeng.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con= null;
    @Override
    public void  init() throws ServletException{
        super.init();
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init --> "+con);
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
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthDate)" +
                    "values(' "+username+" ',' "+password+" ',' "+email+" ',' "+gender+" ','" + birthDate+"')";

            System.out.println("sql" + sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);
            sql = "insert username,password,email,gender,birthDate from usertable";
            ResultSet rs = st.executeQuery(sql);
            PrintWriter out = response.getWriter();
            out.println("<html><title></title><body><table border=1><tr>");
            out.println("<td>username</td><td>password</td><td>email</td><td>gender</td><td>birthDate</td>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("gender") + "</td>");
                out.println("<td>" + rs.getString("birthDate") + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
        } catch (SQLException e){
            e.printStackTrace();
        }



        /*try{
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
    }*/
    }
}
