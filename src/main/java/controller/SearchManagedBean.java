/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mycompany.pawww.projekt.bean.MovieDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Adam Wasilczuk
 */
@Named(value = "search")
@ViewScoped
public class SearchManagedBean implements Serializable {

    @EJB
    MovieDAO dao;

    private String search;
    private List<Object[]> searchResult;

    public List<TmpMovie> getTitles() {
        List<TmpMovie> tmp = new ArrayList<>();
        for (Object[] result : searchResult) {
            tmp.add(new TmpMovie((String) result[1], (Long) result[0]));
        }
        return new ArrayList<>(tmp);
    }

    @PostConstruct
    public void init() {
        searchResult = new ArrayList<>();
    }

    public List<Object[]> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<Object[]> searchResult) {
        this.searchResult = searchResult;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void getMovies() {
        searchResult = (List) dao.getMoviesByTitle(search);

    }

    public class TmpMovie {

        private String title;
        private Long id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public TmpMovie(String title, Long id) {
            this.title = title;
            this.id = id;
        }
    }
}
