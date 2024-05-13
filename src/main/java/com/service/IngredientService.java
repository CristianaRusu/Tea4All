package com.service;

import com.dao.IngredientDao;
import com.entityClass.Ingredient;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class IngredientService {
    private IngredientDao ingredientDao;

    public IngredientService() {
        try {
            ingredientDao = new IngredientDao(Persistence.createEntityManagerFactory("JavaFxTest"));
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public Ingredient findIngredient(String ingredient, String password) throws Exception{
        List<Ingredient> ingredients = ingredientDao.find(ingredient);
        if(ingredients.size() == 0){
            throw new Exception("Ingredient not found!");
        }
        Ingredient i = ingredients.get(0);

      //  if(password.compareTo(u.getPassword()) != 0){
           // throw new Exception("Wrong password!");
        //}
        return i;
    }
}
