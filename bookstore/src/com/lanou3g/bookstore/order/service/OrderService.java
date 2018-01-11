package com.lanou3g.bookstore.order.service;

import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.cart.domain.Cart;
import com.lanou3g.bookstore.cart.domain.Cartltem;
import com.lanou3g.bookstore.order.dao.OrderDao;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.Orderitem;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.util.JdbcUtil;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderService {
    static int i = 0;
    static int b = 0;
    private OrderDao od = new OrderDao();



    public void add(Order order) {
        i++;
        order.setOid(i+"");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = df.format(new Date());
        order.setOrderTime(format);
        order.setState(0);
        od.addOrder(order);
    }

    public void addOrderItem(Cart cart,Order order) {
        List<Orderitem> orderItems = new ArrayList<>();
        Map<String, Cartltem> cart1 = cart.getCarts();
        for (String s : cart1.keySet()) {
            b++;
            Cartltem cartItem = cart1.get(s);
            Book book = cartItem.getBook();
            Orderitem orderItem = new Orderitem();
            orderItem.setIid(b+"");
            System.out.println(s);
            orderItem.setCount(Integer.valueOf(s));
            orderItem.setSubtotal(order.getTotal());
            orderItem.setOid(order.getOid());
            orderItem.setBid(book.getBid());
            orderItems.add(orderItem);
        }
  od.addOrderItemlist(orderItems);
    }

        public List<Order> queryUserOrder(User user) {
            List<Order> orders = od.queryOrderbyUidState(user);
                return orders;
        }

}
