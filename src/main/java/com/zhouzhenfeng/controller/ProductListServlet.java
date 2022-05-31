package com.zhouzhenfeng.controller;

import com.zhouzhenfeng.model.Product;
import com.zhouzhenfeng.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao=new ProductDao();
        try {
            List<Product> productList=productDao.findAll(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String path="WEB-INF/views/admin/productList.jsp";
request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
