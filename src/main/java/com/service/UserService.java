package com.service;

import java.util.List;

import javax.persistence.Persistence;

import com.dao.UserDao;
import com.entityClass.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        try{
            userDao = new UserDao(Persistence.createEntityManagerFactory("JavaFxTest"));
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public void addUser(User newUser){
        userDao.create(newUser);
    }
    public void updateUser(User updateUser){
        userDao.update(updateUser);
    }
    public List<User> getAllUsers(){
        return userDao.findAll();
    }
//for login
    public User findUser(String user, String password) throws Exception{
        List<User> users = userDao.find(user);
        if(users.size() == 0){
            throw new Exception("User not found!");
        }
        User u = users.get(0);

        if(password.compareTo(u.getPassword()) != 0){
            throw new Exception("Wrong password!");
        }
        return u;
    }

}
