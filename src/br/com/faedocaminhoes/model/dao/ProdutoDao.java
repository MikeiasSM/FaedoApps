/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Produto;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface ProdutoDao {
    
    public void insert(Produto obj);
    public void update(Produto obj);
    public void delete(Produto obj);
    public List<Produto> findAll();
    public Produto findById(Produto obj);
    
}
