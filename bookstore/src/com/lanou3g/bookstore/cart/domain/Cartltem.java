package com.lanou3g.bookstore.cart.domain;

import com.lanou3g.bookstore.book.domain.Book;

public class Cartltem {
            private Book book;
            private String count;

    public Cartltem() {
    }

    public Book getBook() {

        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Cartltem(Book book, String count) {

        this.book = book;
        this.count = count;
    }
}
