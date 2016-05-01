/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.Genre;
import com.mycompany.pawww.projekt.model.Movie;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Adam Wasilczuk
 */
@Stateless
public class MovieBean implements MovieDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Movie create(Movie movie) {
        movie = entityManager.find(Movie.class, 1L);

        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        genre1.setName("Genre1");
        genre2.setName("Genre2");
        genre1.setMovie(movie);
        genre2.setMovie(movie);
        movie.getGenre().add(genre1);
        movie.getGenre().add(genre2);
        entityManager.merge(movie);

        return movie;
    }

    @Override
    public Movie getMovieById(Long id) {
        return entityManager.getReference(Movie.class, id);
    }

    @Override
    public Collection<Movie> getAll() {
        TypedQuery<Movie> query = entityManager.createQuery(
                "SELECT m FROM Movie m", Movie.class);
        return query.getResultList();
    }

}
