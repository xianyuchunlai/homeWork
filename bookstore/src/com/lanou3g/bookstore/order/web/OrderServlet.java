package com.lanou3g.bookstore.order.web;

import com.lanou3g.bookstore.cart.cartDao.CartDao;
import com.lanou3g.bookstore.cart.domain.Cart;

import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.service.OrderService;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
    private OrderService os = new OrderService();
    private CartDao cd = new CartDao();
    public String order(HttpServletRequest request , HttpServletResponse response){
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String total = request.getParameter("total");
        String address = request.getParameter("address");
        Order order = new Order();
        BigDecimal bigDecimal = new BigDecimal(total);
        order.setTotal(bigDecimal);
        order.setAddress(address);
        User user = (User)request.getSession().getAttribute("user");
        order.setUid(user.getUid());
        os.add(order);
        request.getSession().setAttribute("order",order);
        os.addOrderItem(cart,order);
        cd.clear(cart);
        return "r://jsps/order/desc.jsp";
    }

    public void showOrder(HttpServletRequest request , HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = os.queryUserOrder(user);
        request.getSession().setAttribute("MyOrder",orders);

    }

}
