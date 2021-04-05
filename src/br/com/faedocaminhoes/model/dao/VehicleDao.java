/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Vehicle;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface VehicleDao {
    
    public void insert(Vehicle pVehicle);
    public void update(Vehicle pVehicle);
    public void delete(Vehicle pVehicle);
    public List<Vehicle> findAll();
    public Vehicle findById(Vehicle pVehicle);
    
}
