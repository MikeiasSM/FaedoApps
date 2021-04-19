/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Fabricante;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface FabricanteDao {
    
    public void insert(Fabricante obj);
    public void update(Fabricante obj);
    public void delete(Fabricante obj);
    public List<Fabricante> findAll();
    public Fabricante findById(Fabricante obj);
    
}
