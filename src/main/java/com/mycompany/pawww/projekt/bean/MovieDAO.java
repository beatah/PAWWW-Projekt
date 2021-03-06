/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;

import com.mycompany.pawww.projekt.model.Movie;
import com.mycompany.pawww.projekt.model.Review;
import java.util.Collection;

/**
 *
 * @author Adam Wasilczuk
 */
public interface MovieDAO {
        public Movie create(Movie movie);
        public Movie getMovieById(Long id);
        public Collection<Movie> getAll();
        public void addReview(Review review);
        public Collection getMoviesByTitle(String title);
        public Collection<Movie> getTop();
}
