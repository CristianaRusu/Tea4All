package com.dao;

import com.entityClass.Order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
public class OrderDao extends GenericDao<Order>{

    public EntityManagerFactory factory;
    public OrderDao(EntityManagerFactory factory) {
        super(Order.class);
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
    public List<Order> find(String name) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> q = cb.createQuery(Order.class);

        Root<Order> c = q.from(Order.class);
        ParameterExpression<String> paramName = cb.parameter(String.class);
        q.select(c).where(cb.equal(c.get("id"), paramName));
        TypedQuery<Order>query = em.createQuery(q);
        query.setParameter(paramName, name);

        List<Order> results = query.getResultList();
        return results;

    }
}
