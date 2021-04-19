/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Veiculo;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface VeiculoDao {
    
    public void insert(Veiculo obj);
    public void update(Veiculo obj);
    public void delete(Veiculo obj);
    public List<Veiculo> findAll();
    public Veiculo findById(Veiculo obj);
    
}
