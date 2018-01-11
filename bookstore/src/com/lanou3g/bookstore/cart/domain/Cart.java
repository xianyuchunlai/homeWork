package com.lanou3g.bookstore.cart.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String,Cartltem> carts = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<String, Cartltem> carts) {

        this.carts = carts;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "carts=" + carts +
                '}';
    }

    public Map<String, Cartltem> getCarts() {

        return carts;
    }

    public void setCarts(Map<String, Cartltem> carts) {
        this.carts = carts;
    }
}
