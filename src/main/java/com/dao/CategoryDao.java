package com.dao;

import com.entityClass.Category;
import com.entityClass.Ingredient;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

public class CategoryDao extends GenericDao<Category> {

    public EntityManagerFactory factory;
    public CategoryDao(EntityManagerFactory factory) {
        super(Category.class);
        this.factory = factory;
    }

    @Override
    public EntityManager getEntityManager() {
        try{
            return factory.createEntityManager();
        }catch(Exception ex){
            System.out.println("entity manager cannot be created");
            return null;
        }
    }

    //for login
    public List<Category> find(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Category> q = cb.createQuery(Category.class);

        Root<Category> c = q.from(Category.class);
        ParameterExpression<String> paramName = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("id"), paramName));
        TypedQuery<Category>query = em.createQuery(q);
        query.setParameter(paramName, name);

        List<Category> results = query.getResultList();
        return results;

    }
}
