/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Vehicle;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.VehicleDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class VehicleService {
    Vehicle vehicle;
    VehicleDaoJPA vehicleDao = DaoFactory.createVehicleDao();
    
    public void insertOrUpdate(Vehicle pVehicle){
    	vehicle = pVehicle;
        if(pVehicle != null && vehicle != null){
            if(pVehicle.getId() == null) {
                vehicleDao.insert(vehicle);        		
            }else {
                vehicleDao.update(vehicle);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insert(Vehicle pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.insert(pVehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Vehicle pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.update(vehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void deleteById(Vehicle pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.delete(vehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Vehicle findById(Vehicle pVehicle){
        if(vehicle != null){
           Vehicle ve = vehicleDao.findById(pVehicle);
           return ve;
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Vehicle> findAll(){
        List<Vehicle> listPessoa = vehicleDao.findAll();
        return listPessoa;                
    }
    
    public List<Vehicle> findByName(String pName){
        if(pName != null && vehicleDao != null){
            try{
                List<Vehicle> listPessoa = vehicleDao.findByName(pName);
                if(!listPessoa.isEmpty()){
                    return listPessoa;                
                }else{
                    JOptionPane.showMessageDialog(null, "Register not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(vehicle);
            return null;
        }
    }
}
