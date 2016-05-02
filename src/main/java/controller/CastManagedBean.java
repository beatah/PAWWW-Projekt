/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mycompany.pawww.projekt.bean.CastDAO;
import com.mycompany.pawww.projekt.model.Cast;
import com.mycompany.pawww.projekt.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Beata
 */
@Named(value = "castManagedBean")
@RequestScoped
public class CastManagedBean {

    @EJB
    CastDAO castDAO;

    private Cast cast;
    private List<Cast> stars;
    private List<Movie> movies;
    private Movie selectedMovie;
    
    @PostConstruct
    public void init() {
        stars = new ArrayList<>();
    }
    public Cast getById(Long id){
        return castDAO.getById(id);
    }
    public String showStar(Cast cast) {
        this.cast = cast;
        return "star";
    }

    public Cast getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast = cast;
    }

    public List<Cast> getStars() {
        return (List<Cast>)castDAO.getAll();
    }

    public void setStars(List<Cast> stars) {
        this.stars = stars;
    }


    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
    
    
    
    

}
