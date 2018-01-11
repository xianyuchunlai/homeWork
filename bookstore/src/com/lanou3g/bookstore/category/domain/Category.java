package com.lanou3g.bookstore.category.domain;

public class Category {
                private String category;
                private String cid;

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Category(String category, String cid) {

        this.category = category;
        this.cid = cid;
    }
}
