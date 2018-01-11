package com.lanou3g.bookstore.user.web;

import com.lanou3g.bookstore.cart.domain.Cart;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.service.exception.LoginException;
import com.lanou3g.bookstore.user.service.exception.LoginPassWordNotMath;
import com.lanou3g.bookstore.user.service.exception.NotActive;
import com.lanou3g.bookstore.util.BaseServlet;
import com.lanou3g.bookstore.util.SendEmail;
import com.lanou3g.bookstore.util.Uid;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;


@WebServlet (name="UserServlet",urlPatterns = "/user")
public class UserServlet  extends BaseServlet {
    private UserService userService = new UserService();
    private SendEmail sendEmail = new SendEmail();
    private UserDao userDao = new UserDao();
    private Uid uuid = new Uid();

    public String register(HttpServletRequest request, HttpServletResponse response) {

        User fromU = new User();
        try {
            BeanUtils.populate(fromU, request.getParameterMap());
            HttpSession session = request.getSession();

            session.setAttribute("user", fromU.getUsername());

            session.setAttribute("email", fromU.getEmail());
            String code = this.uuid.getCode();
            fromU.setUid(uuid.getUid());
            fromU.setCode(code);
            sendEmail.send(fromU, code);
            userDao.insertUser(fromU);
            //  return "f:/jsps/user/login.jsp";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return "f:/jsps/user/regist.jsp";
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return "f:/jsps/user/regist.jsp";
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "r:/jsps/user/regist.jsp";
    }

    public String active(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        String code = request.getParameter("code");

        User fromDd = userDao.queryByCode(code);

        User fromU = new User();
        BeanUtils.populate(fromU, request.getParameterMap());
        boolean active = userService.active(fromDd, fromU);
      if (active==true){
              System.out.println("激活成功");
            return "r:/jsps/msg.jsp";
        }else{
            return "r:/jsps/user/login.jsp";
        }

    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        User fromU = new User();
        try {
            BeanUtils.populate(fromU, request.getParameterMap());
            User fromDd = userService.login(fromU);
            HttpSession session = request.getSession();
            request.getSession().setAttribute("user",fromDd);
            request.getSession().setAttribute("cart",new Cart());
            session.setAttribute("username", fromU.getUsername());
            return "r:/jsps/main.jsp";
        } catch (LoginException e) {
            return "f:/jsps/user/login.jsp";
        } catch (LoginPassWordNotMath e) {
            return "f:/jsps/user/login.jsp";
        } catch (NotActive notActive) {
            notActive.printStackTrace();
            return "r:/jsps/user/regist.jsp";
        }
    }

        public  String  quit(HttpServletRequest request, HttpServletResponse response){
            HttpSession session = request.getSession();
            session.invalidate();
            return "r:/jsps/main.jsp";
        }
}