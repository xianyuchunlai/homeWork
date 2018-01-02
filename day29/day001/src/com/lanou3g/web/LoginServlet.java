package com.lanou3g.web;

import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao ud = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int a= 0;
        List<User> users = ud.queryAll();
        for (User user : users) {
//            System.out.println(user);
//            System.out.println(username+"\t"+password);
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
//                response.setStatus(302);
                response.sendRedirect("http://localhost:8080/index.jsp");
                a=1;
            }else {
//                RequestDispatcher dispatcher  =
//                        request.getRequestDispatcher("/login.html");
//                dispatcher.forward(request,response);
            }
        }
        if (a==0){
            RequestDispatcher dispatcher  =
                    request.getRequestDispatcher("/login.html");
            dispatcher.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
