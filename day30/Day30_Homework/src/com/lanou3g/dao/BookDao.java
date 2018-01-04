package com.lanou3g.dao;

import com.lanou3g.bean.Book;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();
    public Book queryByBookName(String bookName){
        String sql = "select * from books where username = ?";
        Connection conn = JdbcUtil.getConnection();
        Book book = null;
        try {
            book = qr.query(
                    conn,
                    sql,
                    new BeanHandler<Book>(Book.class),
                    bookName
            );
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> showAll(){
        String sql = "select * from book";
        Connection conn = JdbcUtil.getConnection();
        Book book = null;
        try {
            List<Book> books = qr.query(
                    conn,
                    sql,
                    new BeanListHandler<>(Book.class)
            );
            System.out.println(books);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }



}
