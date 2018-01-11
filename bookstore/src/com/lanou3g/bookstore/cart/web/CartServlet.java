package com.lanou3g.bookstore.cart.web;

import com.lanou3g.bookstore.book.bookService.BookService;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.cart.cartDao.CartDao;
import com.lanou3g.bookstore.cart.domain.Cart;
import com.lanou3g.bookstore.cart.domain.Cartltem;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "cartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet{
       private BookService bs =  new BookService();

       private CartDao cd = new CartDao();


        public String addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {

            Cartltem cartltem = new Cartltem();
            String bid = request.getParameter("bid");
            Book book = bs.queryByBid((String) bid);
            cartltem.setBook( book);
            cartltem.setCount(request.getParameter("count"));


            Cart cart = (Cart)request.getSession().getAttribute("cart");
//        System.out.println(cartltem.getBook().getBname());
//            System.out.println(book.getImage());
            Map<String, Cartltem> map = cart.getCarts();
            map.put(book.getBid(),cartltem);

            return "r:/jsps/cart/list.jsp";
        }


    public String delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        cd.delete(cart,bid);
        return "r:/jsps/cart/list.jsp";
    }

    public String clear(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cd.clear(cart);
        return "r:/jsps/cart/list.jsp";
    }

}
