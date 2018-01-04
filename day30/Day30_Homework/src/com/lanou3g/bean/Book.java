package com.lanou3g.bean;

public class Book {
  private String bkname;
  private String author;
  private String price;

    @Override
    public String toString() {
        return "Book{" +
                "bkname='" + bkname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Book() {
    }

    public String getbkname() {

        return bkname;
    }

    public void setbkname(String bkname) {
        this.bkname = bkname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
