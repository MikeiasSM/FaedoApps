/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.service;

import br.com.floatsolutions.model.Fabricante_Veiculo;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.floatsolutions.model.dao.implement.FabricanteDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class FabricanteService {
    Fabricante_Veiculo provider;
    FabricanteDaoJPA providerDao = DaoFactory.createFabricanteDao();
    
    public void insertOrUpdate(Fabricante_Veiculo pProvider) {
        provider = pProvider;
        if (pProvider != null && provider != null) {
            if (pProvider.getId() == null) {
                providerDao.insert(provider);
            } else {
                providerDao.update(provider);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Fabricante_Veiculo pProvider) {
        provider = pProvider;
        if(pProvider != null && provider != null){
            providerDao.insert(pProvider);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Fabricante_Veiculo pProvider){
        provider = pProvider;
        if(pProvider != null && provider != null){
            providerDao.update(pProvider);
        }       
    }
    
    public void deleteById(Fabricante_Veiculo pProvider){
        provider = pProvider;
        if(pProvider!= null){
            providerDao.delete(provider);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Fabricante_Veiculo findById(Fabricante_Veiculo pProvider){
        if(pProvider != null && provider != null){
           Fabricante_Veiculo p = providerDao.findById(pProvider);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Fabricante_Veiculo> findAll() {
        if(providerDao != null){
        List<Fabricante_Veiculo> listPessoa = providerDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Fabricante_Veiculo> findByName(String pName){
        if(pName != null && providerDao != null){
            try{
                List<Fabricante_Veiculo> listPessoa = providerDao.findByName(pName);
                return listPessoa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(provider);
            return null;
        }
    }
}
