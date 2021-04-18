/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Pessoa;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface PersonDao {
    
    public void insert(Pessoa pessoa);
    public void update(Pessoa pessoa);
    public void delete(Pessoa pessoa);
    public List<Pessoa> findAll();
    public Pessoa findById(Pessoa pessoa);
    
}
