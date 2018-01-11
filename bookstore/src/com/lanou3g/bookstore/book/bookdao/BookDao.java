package com.lanou3g.bookstore.book.bookdao;

import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();



    public List<Book> queryByCid(String cid){

        String sql  = "select * from book where cid=?";

       Connection conn= JdbcUtil.getConnection();
        try {
            List<Book> book = qr.query(conn, sql, new BeanListHandler<Book>(Book.class),cid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        public List<Book> queryAll(){
            String sql  = "select * from book";

            Connection conn= JdbcUtil.getConnection();
            try {
                List<Book> book = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
                    return book;
            } catch   (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    public Book queryByBid(String bid){

        String sql  = "select * from book where bid=?";

        Connection conn= JdbcUtil.getConnection();
        try {
           Book book = qr.query(conn, sql, new BeanHandler<Book>(Book.class),bid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
