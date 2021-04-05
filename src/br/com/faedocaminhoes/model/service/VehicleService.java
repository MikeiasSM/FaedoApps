/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Person;
import br.com.faedocaminhoes.model.Vehicle;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.VehicleDaoJPA;
import java.util.List;

/**
 *
 * @author Poison
 */
public class VehicleService {
    Vehicle vehicle;
    VehicleDaoJPA vehicleDao = DaoFactory.createVehicleDao();
    
    public boolean insertOrUpdate(Vehicle pVehicle){
    	vehicle = pVehicle;
        try{
            if(pVehicle.getId() == null) {
                vehicleDao.insert(vehicle);        		
            }else {
                vehicleDao.update(vehicle);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean insert(Vehicle pVehicle){
        vehicle = pVehicle;
        try{
            vehicleDao.insert(pVehicle);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update(Vehicle pVehicle){
        vehicle = pVehicle;
        try{
            vehicleDao.update(vehicle);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean deleteById(Vehicle pVehicle){
        vehicle = pVehicle;
        try{
            vehicleDao.delete(vehicle);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Vehicle findById(Vehicle pVehicle){
        try{
           Vehicle ve = vehicleDao.findById(pVehicle);
           return ve;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public List<Vehicle> findAll(){
        try{
            List<Vehicle> listPessoa = vehicleDao.findAll();
            if(!listPessoa.isEmpty()){
                return listPessoa;                
            }else{
                throw new IllegalAccessError("List was null");
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
