package com.lanou3g.bookstore.book.bookService;

import com.lanou3g.bookstore.book.bookdao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;

import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

        public List<Book> queryAll(){
            List<Book> books = bookDao.queryAll();
            return books;
        }
        public List<Book> queryByCid(String cid){
            List<Book> books = bookDao.queryByCid(cid);
            return books;
        }

        public Book queryByBname(String bid){
            Book book = bookDao.queryByBid(bid);
            return book;
        }

        public  Book queryByBid(String bid){
            Book book =  bookDao.queryByBid(bid);
            return book;
        }
}
