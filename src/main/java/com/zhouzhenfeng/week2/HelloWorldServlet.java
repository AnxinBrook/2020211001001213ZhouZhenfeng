package com.zhouzhenfeng.week2;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
    public class HelloWorldServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException {
            PrintWriter writer = response.getWriter();
            Date date=new Date();
            writer.println("name:zhouzhenfeng ");
            writer.println("id:2020211001001213");
            writer.println("Date and Time:"+date);

        }
        public void doPost(HttpServletRequest request, HttpServletResponse response){

        }
    }