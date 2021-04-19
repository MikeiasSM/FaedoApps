/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Veiculo;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.VeiculoDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class VeiculoService {
    Veiculo vehicle;
    VeiculoDaoJPA vehicleDao = DaoFactory.createVeiculoDao();
    
    public void insertOrUpdate(Veiculo pVehicle){
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
    
    public void insert(Veiculo pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.insert(pVehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Veiculo pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.update(vehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public void deleteById(Veiculo pVehicle){
        vehicle = pVehicle;
        if(vehicle != null){
            vehicleDao.delete(vehicle);
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Veiculo findById(Veiculo pVehicle){
        if(vehicle != null){
           Veiculo ve = vehicleDao.findById(pVehicle);
           return ve;
        } else {
            JOptionPane.showMessageDialog(null, "Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Veiculo> findAll(){
        List<Veiculo> listPessoa = vehicleDao.findAll();
        return listPessoa;                
    }
    
    public List<Veiculo> findByName(String pName){
        if(pName != null && vehicleDao != null){
            try{
                List<Veiculo> listPessoa = vehicleDao.findByName(pName);
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
