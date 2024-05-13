package com.service;

import java.util.List;

import javax.persistence.Persistence;

import com.dao.ProductDao;
import com.entityClass.Product;

public class ProductService {
    private ProductDao productDao;
    public ProductService() {
        try{
            productDao = new ProductDao(Persistence.createEntityManagerFactory("JavaFxTest"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void addProduct(Product newProduct){
        productDao.create(newProduct);
    }
    public void updateProduct(Product updateProduct){
        productDao.update(updateProduct);
    }
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }

    //for login
    public Product findProduct(String product, String password) throws Exception{
        List<Product> products = productDao.find(product);
        if(products.size() == 0){
            throw new Exception("Product not found!");
        }
        Product p = products.get(0);

        //if(password.compareTo(p.getPassword()) != 0){
            //throw new Exception("Wrong password!");
       // }
        return p;
    }
}
