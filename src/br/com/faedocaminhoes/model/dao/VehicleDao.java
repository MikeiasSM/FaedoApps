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
public interface VehicleDao {
    
    public void insert(Veiculo pVehicle);
    public void update(Veiculo pVehicle);
    public void delete(Veiculo pVehicle);
    public List<Veiculo> findAll();
    public Veiculo findById(Veiculo pVehicle);
    
}
