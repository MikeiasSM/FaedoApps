/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Pessoa;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.PessoaDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class PersonService {
    Pessoa person;
    PessoaDaoJPA personDao = DaoFactory.createPersonDao();
    
    public boolean insertOrUpdate(Pessoa pPessoa){
    	person = pPessoa;
        try{
            if(pPessoa.getId() == null) {
                personDao.insert(person);        		
            }else {
                personDao.update(person);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean insert(Pessoa pPessoa){
        person = pPessoa;
        try{
            personDao.insert(pPessoa);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update(Pessoa pPessoa){
        person = pPessoa;
        try{
            personDao.update(person);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean deleteById(Pessoa pPessoa){
        person = pPessoa;
        try{
            personDao.delete(person);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Pessoa findById(Pessoa pPessoa){
        try{
           Pessoa pe = personDao.findById(pPessoa);
           return pe;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public List<Pessoa> findAll(){
        try{
            List<Pessoa> listPessoa = personDao.findAll();
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
    
    public List<Pessoa> findByName(String pName){
        if(pName != null){
            try{
                List<Pessoa> listPessoa = personDao.findByName(pName);
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
            JOptionPane.showMessageDialog(null, "Variable is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
