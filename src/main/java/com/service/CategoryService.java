package com.service;

import java.util.List;

import javax.persistence.Persistence;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entityClass.Category;
import com.entityClass.Product;

public class CategoryService {
    private CategoryDao categoryDao;

    public CategoryService() {
        try{
            categoryDao = new CategoryDao(Persistence.createEntityManagerFactory("JavaFxTest"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void addCategory(Category newCategory){
        categoryDao.create(newCategory);
    }
    public void updateProduct(Category updateCategory){
        categoryDao.update(updateCategory);
    }
    public List<Category> getAllCategorys(){
        return categoryDao.findAll();
    }
}
