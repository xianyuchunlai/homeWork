package com.lanou3g.bookstore.user.service;

import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.exception.LoginException;
import com.lanou3g.bookstore.user.service.exception.LoginPassWordNotMath;
import com.lanou3g.bookstore.user.service.exception.NotActive;
import com.lanou3g.bookstore.user.service.exception.UserException;


public class UserService {
        private UserDao userDao = new UserDao();




        public boolean register(User fromU) throws UserException {
            User fromDd1 = userDao.queryByEmail(fromU);
            User fromDd2 = userDao.queryByUserName(fromU);
            if (fromDd1.getEmail() ==null) {
                if (fromDd2.getUsername() == null) {
                    return true;
                }else{
                    throw new UserException();
                }
            }
            else{
                throw  new UserException();
            }
        }



        public User login(User fromU) throws LoginException, LoginPassWordNotMath, NotActive {
            User fromDd = userDao.queryByUserName(fromU);
            if (fromDd.getState().equals("1")){

                if (fromDd.getUsername().equals(fromU.getUsername()) && fromDd.getPassword().equals(fromU.getPassword())){
                    return fromDd;
                }else{
                    throw  new LoginException();
                }

            }else{
                    throw  new NotActive();
            }

        }
        public boolean active(User fromDd, User fromUu){
            if (fromDd.getCode().equals(fromUu.getCode())){
                userDao.alter(fromUu.getCode());

                return true;
            }else{
                return false;
            }
        }


}
