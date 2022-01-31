/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Categoria_Produto;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface CategoriaDao {
    
    public void insert(Categoria_Produto obj);
    public void update(Categoria_Produto obj);
    public void delete(Categoria_Produto obj);
    public List<Categoria_Produto> findAll();
    public Categoria_Produto findById(Categoria_Produto obj);
    
}
