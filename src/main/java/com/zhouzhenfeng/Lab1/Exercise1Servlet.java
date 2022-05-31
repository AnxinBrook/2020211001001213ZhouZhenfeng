package com.zhouzhenfeng.Lab1;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Exercise1Servlet", value = "/exercise1")
public class Exercise1Servlet extends HttpServlet {
    int index;
    @Override
    public void init() throws ServletException {
        super.init();
        index=0;
        System.out.println("I Am from default constructor");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String val="since loading ,this servlet has been accessed "+index+" times";
       ++index;
        request.setAttribute("val",val);
        request.getRequestDispatcher("Lib1/exercise1.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
