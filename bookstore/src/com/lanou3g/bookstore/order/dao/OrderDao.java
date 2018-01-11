package com.lanou3g.bookstore.order.dao;

import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.Orderitem;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;



public class OrderDao {
    private QueryRunner qr = new QueryRunner();

    public void addOrder(){
        String sql = "insert into orders values(?,?,?,?,?,?) ";
    }

    public void addOrder(Order order) {
        String sql =
                "insert into orders values(?,?,?,?,?,?)";

        Connection conn = JdbcUtil.getConnection();
        try {

            Timestamp ts = new Timestamp (System.currentTimeMillis());
            ts = Timestamp.valueOf(order.getOrderTime());
            qr.update(conn, sql,
                    order.getOid(),
                    ts,
                    order.getTotal(),
                    order.getState(),
                    order.getUid(),
                    order.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrderItemlist(List<Orderitem> orderItems) {
        for (Orderitem orderItem : orderItems) {
            String sql =
                    "insert into orderitem values(?,?,?,?,?)";

            Connection conn = JdbcUtil.getConnection();
            try {

                qr.update(conn,sql,
                        orderItem.getIid(),
                        orderItem.getCount(),
                        orderItem.getSubtotal(),
                        orderItem.getOid(),
                        orderItem.getBid());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Order> queryOrder(){
        String sql = "select *  from order";
        Connection conn = JdbcUtil.getConnection();
        try {
            List<Order> orders = qr.query(conn, sql, new BeanListHandler<Order>(Order.class));
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally{
                JdbcUtil.close(conn);
        }
    }

    public List<Order> queryOrderbyUidState(User user){
            String sql = "select * from orders where uid=? and state=0";
            Connection conn = JdbcUtil.getConnection();
        try {
            List<Order> orders = qr.query(conn, sql, new BeanListHandler<Order>(Order.class), user.getUid());
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }finally {
            JdbcUtil.close(conn);
        }


    }

}
