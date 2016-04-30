/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.Movie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adam Wasilczuk
 */
@Stateless
public class MovieBean implements MovieDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Movie create(Movie movie) {
       entityManager.persist(movie);
       return movie;
    }
    
    
            
}
