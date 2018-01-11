package com.lanou3g.bookstore.book.domain;

public class Book {
            private String bid;
            private String bname;
            private String price;
            private String author;
            private String image;

    public Book() {
    }

    public String getBid() {

        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Book(String bid, String bname, String price, String author, String img, String cid) {

        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = img;
        this.cid = cid;
    }

    private String cid;

}
