/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.service;

import br.com.floatsolutions.model.Estado;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.floatsolutions.model.dao.implement.EstadoDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class EstadoService {
    Estado estado;
    EstadoDaoJPA estadoDao = DaoFactory.createEstadoDao();
    
    public void insertOrUpdate(Estado obj) {
        estado = obj;
        if (estado != null && estadoDao != null) {
            if (obj.getId() == null) {
                insert(estado);
            } else {
                update(estado);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Estado obj) {
        estado = obj;
        if(estado != null && estadoDao != null){
            estadoDao.save(estado);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Estado obj){
        estado = obj;
        if(estado != null && estadoDao != null){
            estadoDao.update(estado);
        }       
    }
    
    public void deleteById(Estado obj){
        estado = obj;
        if(estado != null && estadoDao != null){
            estadoDao.delete(estado);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Estado findById(Estado obj){
        if(obj != null && estadoDao != null){
           Estado p = estadoDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Estado> findAll() {
        if(estadoDao != null){
        List<Estado> listEstado = estadoDao.findAll();
        return listEstado;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Estado> findByName(String pName){
        if(pName != null && estadoDao != null){
            try{
                List<Estado> listEstado = estadoDao.findByName(pName);
                return listEstado;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            System.out.println(estado);
            return null;
        }
    }
}
