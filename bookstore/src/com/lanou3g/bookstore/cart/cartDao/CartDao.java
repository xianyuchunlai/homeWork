package com.lanou3g.bookstore.cart.cartDao;

import com.lanou3g.bookstore.cart.domain.Cart;
import com.lanou3g.bookstore.cart.domain.Cartltem;

import java.util.Map;

public class CartDao {
    //    private BookDao bookDao = new BookDao();
    public void delete(Cart cart, String bid) {
//        Book bybid = bookDao.findBybid(bid);
        Map<String, Cartltem> map = cart.getCarts();
        if (map != null) {
            map.remove(bid);
        }
    }

    public void clear(Cart cart) {
        Map<String, Cartltem> cart1 = cart.getCarts();
        for (String s : cart1.keySet()) {
            cart1.remove(s);
        }
    }
}
