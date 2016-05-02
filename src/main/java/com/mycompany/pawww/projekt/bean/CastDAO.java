/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pawww.projekt.bean;


import com.mycompany.pawww.projekt.model.Cast;
import java.util.Collection;

/**
 *
 * @author Beata
 */
public interface CastDAO {
    public Cast getById(Long id);
    public Collection<Cast> getAll();
}
