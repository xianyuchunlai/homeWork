package com.lanou3g.bookstore.category.categoryService;

import com.lanou3g.bookstore.category.dao.CategoryDao;

public class CategoryService {

            private CategoryDao cd = new CategoryDao();

            public Object[] showAll(){
                Object[] category = cd.queryAll();
                return category;
            }

}
