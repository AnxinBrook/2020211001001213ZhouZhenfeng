package com.zhouzhenfeng.controller;

import com.zhouzhenfeng.dao.OrderDao;
import com.zhouzhenfeng.model.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=request.getParameter("orderId")!=null?
                Integer.parseInt(request.getParameter("orderId")):0;
        Item item;
        item = new Item();
        OrderDao orderDao = new OrderDao();
        List<Item> items = orderDao.findItemsByOrderId(con, orderId);
        request.setAttribute("itemList",items);
        String path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}