package com.lanou3g.bookstore.user.dao;

import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

   private QueryRunner qr = new QueryRunner();



        public void insertUser(User user){
            String sql = "insert into user values(?,?,?,?,?,?)";
            Connection conn = null;
            conn = JdbcUtil.getConnection();
            try {
                qr.update(conn,sql,user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),user.getState());
            } catch (SQLException e) {
                e.printStackTrace();
            }

                JdbcUtil.close(conn);
        }

        public User queryByEmail(User fromU) {
            String sql = "select  * from user where email=?";
            Connection conn = null;
            conn = JdbcUtil.getConnection();
            try {
                User user = qr.query(conn, sql, new BeanHandler<User>(User.class), fromU.getEmail());
                return user;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            } finally {
                JdbcUtil.close(conn);
            }
        }

            public User queryByUserName(User fromU){

              String sql = "select * from user where username=?";

                Connection  conn= JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class), fromU.getUsername());
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }finally {
            JdbcUtil.close(conn);
        }

    }

    public void  alter(String code){
               String sql = "update user set state='1' where code=?";
                Connection conn = null;
                conn = JdbcUtil.getConnection();
        try {
                qr.update(conn, sql, code);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public User queryByCode(String code) {
        String sql = "select  * from user where code=?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            User user = qr.query(conn, sql, new BeanHandler<User>(User.class), code);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            JdbcUtil.close(conn);
        }
    }
}
