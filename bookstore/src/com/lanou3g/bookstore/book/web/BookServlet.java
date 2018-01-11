package com.lanou3g.bookstore.book.web;

import com.lanou3g.bookstore.book.bookService.BookService;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookService bs = new BookService();

    public String queryByBid(HttpServletRequest request, HttpServletResponse response) {
        //获得传进来的bid
        String bid = request.getParameter("bid");
        //通过bid查找到book
        Book book = bs.queryByBname( bid);

        //把book对象传进requset请求中 然后再jsp文件获得对象 显示出来
        request.setAttribute("book",book);
        request.getSession().setAttribute("book",book);

        return "f:/jsps/book/desc.jsp";
    }
}
