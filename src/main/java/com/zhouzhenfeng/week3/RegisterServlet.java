package com.zhouzhenfeng.week3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//@WebServlet(urlPatterns={"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException{
        super.init();
        /*ServletContext context =getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);


        //System.out.println("register serlvet doGet");
        //response.sendRedirect("./register.jsp");
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        //System.out.println("register servlet dopost");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
//        java.sql.Date releaseDate = java.sql.Date.valueOf(birthDate);
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(birthDate);

        try {
            Statement st=con.createStatement();
            String sql = "insert into usertable (username,password,email,gender,birthDate) " +
                    "values(\'"+username+"\',\'" +password+"\',\'"+email+"\',\'"+gender+"\',\'"+birthDate+"\')";
            System.out.println("sql"+sql);

            int n= st.executeUpdate(sql);
            System.out.println("n-->"+n);

            //con.setAutoCommit(false);
            //PreparedStatement preparedStatement = con.prepareStatement(sql);
            //preparedStatement.executeUpdate();
            //con.commit();
            //System.out.println("insert successfully");
            //sql = "select * from usertable";

            //con.setAutoCommit(false);

            //PreparedStatement preparedStatement = con.prepareStatement(sql);
            //ResultSet rs = st.executeQuery(sql);
            //PrintWriter out = response.getWriter();

            //writer.println("<table border=\"1\">");
            //writer.println("<tr>");
            //writer.println("<th>ID</th>");
            //writer.println("<th>username</th>");
            //writer.println("<th>password</th>");
            //writer.println("<th>email</th>");
            //writer.println("<th>gender</th>");
            //writer.println("<th>birthDate</th>");
            //writer.println("</tr>");
            /*while (resultSet.next()) {
                writer.println("<tr>");
                writer.println("<td>"+resultSet.getString("id")+"</td>");
                writer.println("<td>"+resultSet.getString("username")+"</td>");
                writer.println("<td>"+resultSet.getString("password")+"</td>");
                writer.println("<td>"+ resultSet.getString("email")+"</td>");
                writer.println("<td>"+resultSet.getString("gender")+"</td>");
                writer.println("<td>"+ resultSet.getString("birthDate")+"</td>");
                writer.println("<tr>");
            }*/
            //writer.println("</table>");
            //con.commit();

            //writer.close();
            //request.setAttribute("rsname",rs);

            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("i am in RegisterServlet-->doPost()--> after forward()");

            //response.sendRedirect("login.jsp");


            response.sendRedirect("login");



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}