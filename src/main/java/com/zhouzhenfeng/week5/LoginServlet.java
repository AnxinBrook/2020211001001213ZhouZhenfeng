package com.zhouzhenfeng.week5;

import com.zhouzhenfeng.dao.IUserDao;
import com.zhouzhenfeng.dao.UserDao;
import com.zhouzhenfeng.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
        //doPost(request,response);//
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");



        UserDao userDao=new UserDao();
        try {
           User user=  userDao.findByUsernamePassword(con,username,password);
           if (user!=null){
            String rememberMe=request.getParameter("RememberMe");
            if (rememberMe!=null && rememberMe.equals("1")){
                Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                usernameCookie.setMaxAge(5);
                passwordCookie.setMaxAge(5);
                rememberMeCookie.setMaxAge(5);

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(rememberMeCookie);

            }








               Cookie c= new Cookie("SessionID",""+user.getId());
                c.setMaxAge(10*60);
                response.addCookie(c);

            HttpSession session= request.getSession();
            System.out.println("Session id-->"+session.getId());
            session.setMaxInactiveInterval(10);

              session.setAttribute("user",user);
               request.getRequestDispatcher("WER-INF/views/userinfo.jsp ").forward(request,response);
           }else{
               request.setAttribute("message","Username or Password Error!!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

       /*String sql=" select id,username,password from usertable where username=' "+username+" ' and password=' "+password+" ' ";
try{
    ResultSet rs=con.createStatement().executeQuery(sql);
    if (rs.next()) {
        //out.print("Login Successful!!!");
        //out.print("Welcome" + username);
        request.setAttribute("id",rs.getInt("id"));
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
    }*/
    }
}
