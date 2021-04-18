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
public interface ProviderDao {
    
    public void insert(Fabricante pProvider);
    public void update(Fabricante pProvider);
    public void delete(Fabricante pProvider);
    public List<Fabricante> findAll();
    public Fabricante findById(Fabricante pProvider);
    
}
