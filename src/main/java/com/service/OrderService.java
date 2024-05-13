package com.service;

import javax.persistence.Persistence;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.entityClass.Order;
import com.entityClass.Product;

import java.util.List;

public class OrderService {
    private OrderDao orderDao;
    public OrderService() {
        try{
            orderDao = new OrderDao(Persistence.createEntityManagerFactory("JavaFxTest"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void addOrder(Order newOrder){
        orderDao.create(newOrder);
    }
    public void updateOrder(Order updateOrder){
        orderDao.update(updateOrder);
    }
    public List<Order> getAllOrders(){
        return orderDao.findAll();
    }
}
