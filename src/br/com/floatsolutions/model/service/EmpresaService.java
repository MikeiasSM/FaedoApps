/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.service;

import br.com.floatsolutions.model.Empresa;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.floatsolutions.model.dao.implement.EmpresaDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class EmpresaService {
    Empresa empresa;
    EmpresaDaoJPA dao = DaoFactory.createEmpresaDao();
    
    public void insertOrUpdate(Empresa obj) {
        empresa = obj;
        if (empresa != null && dao != null) {
            if (empresa.getId() == null) {
                dao.insert(empresa);
            } else {
                dao.update(empresa);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Empresa obj) {
        empresa = obj;
        if(empresa != null && dao != null){
            dao.insert(empresa);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Empresa obj){
        empresa = obj;
        if(empresa != null && dao != null){
            dao.update(empresa);
        }       
    }
    
    public void deleteById(Empresa obj){
        empresa = obj;
        if(empresa != null && dao != null){
            dao.delete(empresa);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Empresa findById(Empresa obj){
        if(obj != null && dao != null){
           Empresa p = dao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public Empresa findByIdInteger(Integer id){
        if(id != null && dao != null){
           Empresa p = dao.findByIdInteger(id);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Empresa> findAll() {
        if(dao != null){
        List<Empresa> listEmpresa = dao.findAll();
        return listEmpresa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Empresa> findByName(String pName){
        if(pName != null && dao != null){
            try{
                List<Empresa> listEmpresa = dao.findByName(pName);
                return listEmpresa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(empresa);
            return null;
        }
    }
}
