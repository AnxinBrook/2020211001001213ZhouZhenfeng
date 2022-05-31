package com.zhouzhenfeng.Lab1;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "Exercise2Servlet", value = "/exercise2")
public class Exercise2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("Lib1/exercise2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String name=request.getParameter("name");
                    String cla=request.getParameter("class");
                    String id=request.getParameter("id");
                    request.setAttribute("name",name);
                    request.setAttribute("cla",cla);
                    request.setAttribute("id",id);
                    request.getRequestDispatcher("Lib1/MyDear.jsp").forward(request,response);
    }
}
