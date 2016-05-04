/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.User;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adam Wasilczuk
 */
@Stateless
public class UserBean implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User vaidateUsernamaPassword(String login, String password) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.validateLogin", User.class);
        query.setParameter("login", login);
        query.setParameter("password", password);
        try {
            User user = query.getSingleResult();
            return user;
        } catch(NoResultException e) {
            return new User();
        }
    }
    @Override
    public Collection<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u", User.class);
        return query.getResultList();
    }
    @Override
    public void create(User user) {
        entityManager.persist(user);
    }
    
}
