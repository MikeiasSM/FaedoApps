/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface FornecedorDao {
    
    public void insert(Fornecedor obj);
    public void update(Fornecedor obj);
    public void delete(Fornecedor obj);
    public List<Fornecedor> findAll();
    public Fornecedor findById(Fornecedor obj);
    
}
