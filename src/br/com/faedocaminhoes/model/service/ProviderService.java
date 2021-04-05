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

/**
 *
 * @author Poison
 */
public class ProviderService {
    Provider provider;
    ProviderDaoJPA providerDao = DaoFactory.createProviderDao();
    
    public boolean insertOrUpdate(Provider pProvider){
    	provider = pProvider;
        try{
            if(pProvider.getId() == null) {
                providerDao.insert(provider);        		
            }else {
                providerDao.update(provider);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean insert(Provider pProvider){
        provider = pProvider;
        try{
            providerDao.insert(pProvider);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update(Provider pProvider){
        provider = pProvider;
        try{
            providerDao.update(provider);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean deleteById(Provider pProvider){
        provider = pProvider;
        try{
            providerDao.delete(provider);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Provider findById(Provider pProvider){
        try{
           Provider p = providerDao.findById(pProvider);
           return p;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public List<Provider> findAll(){
        try{
            List<Provider> listPessoa = providerDao.findAll();
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
