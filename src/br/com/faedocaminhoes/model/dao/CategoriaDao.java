/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.CategoriaProd;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface CategoriaDao {
    
    public void insert(CategoriaProd obj);
    public void update(CategoriaProd obj);
    public void delete(CategoriaProd obj);
    public List<CategoriaProd> findAll();
    public CategoriaProd findById(CategoriaProd obj);
    
}
