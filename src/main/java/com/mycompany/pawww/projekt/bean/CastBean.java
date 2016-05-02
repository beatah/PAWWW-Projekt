/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.Cast;
import com.mycompany.pawww.projekt.model.Movie;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Beata
 */
@Stateless
public class CastBean implements CastDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Cast getById(Long id) {
        return entityManager.getReference(Cast.class, id);
    }
    @Override
    public Collection<Cast> getAll() {
        TypedQuery<Cast> query = entityManager.createQuery(
                "SELECT c FROM Cast c", Cast.class);
        return query.getResultList();
    }
}
