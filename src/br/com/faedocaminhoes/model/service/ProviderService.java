/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Provider;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.ProviderDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class ProviderService {
    Provider provider;
    ProviderDaoJPA providerDao = DaoFactory.createProviderDao();
    
    public void insertOrUpdate(Provider pProvider) {
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
    
    public void insert(Provider pProvider) {
        provider = pProvider;
        if(pProvider != null && provider != null){
            providerDao.insert(pProvider);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Provider pProvider){
        provider = pProvider;
        if(pProvider != null && provider != null){
            providerDao.update(pProvider);
        }       
    }
    
    public void deleteById(Provider pProvider){
        provider = pProvider;
        if(pProvider!= null){
            providerDao.delete(provider);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Provider findById(Provider pProvider){
        if(pProvider != null && provider != null){
           Provider p = providerDao.findById(pProvider);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Provider> findAll() {
        if(providerDao != null){
        List<Provider> listPessoa = providerDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Provider> findByName(String pName){
        if(pName != null && providerDao != null){
            try{
                List<Provider> listPessoa = providerDao.findByName(pName);
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
