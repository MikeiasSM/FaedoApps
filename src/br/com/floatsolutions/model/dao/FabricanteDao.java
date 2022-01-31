/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Fabricante_Veiculo;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface FabricanteDao {
    
    public void insert(Fabricante_Veiculo obj);
    public void update(Fabricante_Veiculo obj);
    public void delete(Fabricante_Veiculo obj);
    public List<Fabricante_Veiculo> findAll();
    public Fabricante_Veiculo findById(Fabricante_Veiculo obj);
    
}
