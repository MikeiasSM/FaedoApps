/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Cidade;
import java.util.List;


/**
 *
 * @author Mikeias
 */
public interface CidadeDao {
    
    public void save(Cidade obj);
    public void update(Cidade obj);
    public void delete(Cidade obj);
    public Cidade findById(Cidade obj);
    public List<Cidade> findAll();
    
}
