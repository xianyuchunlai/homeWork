package com.lanou3g.dao;

import com.lanou3g.domain.User;
import com.lanou3g.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private static QueryRunner qr = new QueryRunner();

    public static void insertUser(User user){
        String sql = "insert into stu_user values(?,?,?)";
        Connection conn = JdbcUtils.getConnection();
        try {
            qr.update(conn,sql,user.getName(),user.getUsername(),user.getPassword());
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> queryAll() {
        String sql = "select * from stu_user";
        Connection conn = JdbcUtils.getConnection();
        try {
            List<User> users = qr.query(conn, sql, new BeanListHandler<>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
