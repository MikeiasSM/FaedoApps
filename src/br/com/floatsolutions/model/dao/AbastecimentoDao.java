/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Abastecimento;
import br.com.floatsolutions.model.Empresa;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface AbastecimentoDao {
    
    public void insert(Abastecimento obj);
    public void update(Abastecimento obj);
    public void delete(Abastecimento obj);
    public List<Abastecimento> findAll();
    public List<Abastecimento> findAll(Empresa obj);
    public Abastecimento findById(Abastecimento obj);
    
}
