/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mycompany.pawww.projekt.bean.MovieDAO;
import com.mycompany.pawww.projekt.model.Movie;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "movieManagedBean")
@RequestScoped
public class MovieManagedBean {

    @EJB
    MovieDAO movieDAO;
    
    private Movie movie;

    public Movie getMovie() {
        return movieDAO.getMovieById(1L);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
//    public Movie getMovieById(Long id) {
//        
//    }
    
    /**
     * Creates a new instance of MovieManagedBean
     */
    public MovieManagedBean() {
    }
    
    public void a() {
        Movie movie = new Movie();
        movieDAO.create(movie);
    }
    
}
