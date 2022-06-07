package com.zhouzhenfeng.controller;

import com.zhouzhenfeng.dao.OrderDao;
import com.zhouzhenfeng.model.Item;
import com.zhouzhenfeng.model.Order;
import com.zhouzhenfeng.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("connection");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypeList = Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList", paymentTypeList);
        String path = "/WEB-INF/views/order.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获得所有参数
        int customerId = request.getParameter("customerId") != null
                ? Integer.parseInt(request.getParameter("customerId")) : 0;
        int paymentId = request.getParameter("paymentId") != null
                ? Integer.parseInt(request.getParameter("paymentId")) : 0;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String postalCode = request.getParameter("postalCode");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String notes = request.getParameter("notes");
        double orderTotal = request.getParameter("orderTotal") != null
                ? Double.parseDouble(request.getParameter("orderTotal")) : 0.0;

//        验证
        String message = null;
        if (customerId == 0 || paymentId == 0 || firstName == null || firstName.trim().length() == 0 || phone == null
                || phone.trim().length() == 0 || address1 == null || address1.trim().length() == 0 || postalCode == null || postalCode.trim().length() == 0) {
            //出错
            message = "Error！！！Enter Required(*) Info.";
            request.setAttribute("message", message);
            List<Payment> paymentTypeList = Payment.findAllPayment(con);
            request.setAttribute("paymentTypeList", paymentTypeList);
            String path = "/WEB-INF/views/order.jsp";
            request.getRequestDispatcher(path).forward(request, response);
            return;
        }
        Order o = new Order();
        o.setCustomerId(customerId);
        o.setPaymentId(paymentId);
        o.setFirstName(firstName);
        o.setLastName(lastName);
        o.setPhone(phone);
        o.setAddress1(address1);
        o.setAddress2(address2);
        o.setCity(city);
        o.setCountry(country);
        o.setState(state);
        o.setNotes(notes);
        o.setPostalCode(postalCode);
        o.setOrderTotal(orderTotal);
        HttpSession session = request.getSession(false);
//        有点不太懂
        if (session != null && session.getAttribute("user") != null) {
            ArrayList<Item> cartItems = (ArrayList<Item>) session.getAttribute("cart");
            o.setOrderDetails(new HashSet<Item>(cartItems));
        }
//        保存order
        OrderDao orderDao = new OrderDao();
        int n = 0;
        try {
            n = orderDao.save(con, o);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        转发
        if (n > 0) {
            String path = "/WEB-INF/views/orderSuccess.jsp";
            request.getRequestDispatcher(path).forward(request, response);
        }
    }
}