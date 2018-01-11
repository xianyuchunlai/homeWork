package com.lanou3g.bookstore.category.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoryDao {
        private QueryRunner qr = new QueryRunner();

        public Object[] queryAll() {
            Connection conn = null;
            String sql = "select * from category";
            try {
                Object[] categoryArray = qr.query(conn, sql, new ArrayHandler());
                return categoryArray;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
}
