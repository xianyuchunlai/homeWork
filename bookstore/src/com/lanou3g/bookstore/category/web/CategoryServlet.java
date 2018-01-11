package com.lanou3g.bookstore.category.web;

import com.lanou3g.bookstore.book.bookService.BookService;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.category.categoryService.CategoryService;
import com.lanou3g.bookstore.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name="CategoryServlet",urlPatterns = "/cate")
public class CategoryServlet extends BaseServlet{
        private CategoryService cs = new CategoryService();
        private BookService bs = new BookService();

    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Book> books = bs.queryAll();
        request.setAttribute("book",books);
        return  "f:/jsps/book/list.jsp";
    }

    public String queryCid1(HttpServletRequest request, HttpServletResponse response){
        String cid ="1";
        List<Book> books = bs.queryByCid(cid);
        request.setAttribute("book",books);
        return  "f:/jsps/book/list.jsp";
    }

    public String queryCid2(HttpServletRequest request, HttpServletResponse response){
        String cid ="2";
        List<Book> books = bs.queryByCid(cid);
        request.setAttribute("book",books);
        return  "f:/jsps/book/list.jsp";
    }

    public String queryCid3(HttpServletRequest request, HttpServletResponse response){
        String cid ="3";
        List<Book> books = bs.queryByCid(cid);
        request.setAttribute("book",books);
        return  "f:/jsps/book/list.jsp";
    }
}
