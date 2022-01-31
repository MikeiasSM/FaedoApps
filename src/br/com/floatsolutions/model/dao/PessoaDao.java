/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Pessoa;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface PessoaDao {
    
    public void insert(Pessoa obj);
    public void update(Pessoa obj);
    public void delete(Pessoa obj);
    public List<Pessoa> findAll();
    public Pessoa findById(Pessoa obj);
    
}
