/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Fabricante;
import br.com.faedocaminhoes.model.Fornecedor;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.FornecedorDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class FornecedorService {
    Fornecedor fornecedor;
    FornecedorDaoJPA fornecedorDao = DaoFactory.createFornecedorDao();
    
    public void insertOrUpdate(Fornecedor obj) {
        fornecedor = obj;
        if (fornecedor != null && fornecedorDao != null) {
            if (obj.getId() == null) {
                fornecedorDao.insert(fornecedor);
            } else {
                fornecedorDao.update(fornecedor);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Fornecedor obj) {
        fornecedor = obj;
        if(fornecedor != null && fornecedorDao != null){
            fornecedorDao.insert(fornecedor);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Fornecedor obj){
        fornecedor = obj;
        if(fornecedor != null && fornecedorDao != null){
            fornecedorDao.update(obj);
        }       
    }
    
    public void deleteById(Fornecedor obj){
        fornecedor = obj;
        if(fornecedor != null && fornecedorDao != null){
            fornecedorDao.delete(fornecedor);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Fornecedor findById(Fornecedor obj){
        if(obj != null && fornecedorDao != null){
           Fornecedor p = fornecedorDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Fornecedor> findAll() {
        if(fornecedorDao != null){
        List<Fornecedor> listPessoa = fornecedorDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Fornecedor> findByName(String pName){
        if(pName != null && fornecedorDao != null){
            try{
                List<Fornecedor> listPessoa = fornecedorDao.findByName(pName);
                return listPessoa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(fornecedor);
            return null;
        }
    }
}
