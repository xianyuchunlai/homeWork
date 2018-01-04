package com.lanou3g.web;

import com.lanou3g.bean.Book;
import com.lanou3g.dao.BookDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zyf on 2018/1/3.
 */
@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    private BookDao bd = new BookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        List<Book> books = bd.showAll();
        JSONArray jsonArray = JSONArray.fromObject(books);
        System.out.println(books);
        response.getWriter().write(jsonArray.toString());

    }
}
