/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mycompany.pawww.projekt.bean.MovieDAO;
import com.mycompany.pawww.projekt.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    
    private List<Movie> movies;
    
    public String showMovie(Movie movie) {
        this.movie = movie;
        return "movie";
    }
    
    @PostConstruct
    public void init() {
        movies = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return (List<Movie>) movieDAO.getAll();
    }

    public void setMovie(List<Movie> movie) {
        this.movies = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
}
