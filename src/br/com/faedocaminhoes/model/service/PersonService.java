/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Person;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.PersonDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class PersonService {
    Person person;
    PersonDaoJPA personDao = DaoFactory.createPersonDao();
    
    public boolean insertOrUpdate(Person pPessoa){
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
    
    public boolean insert(Person pPessoa){
        person = pPessoa;
        try{
            personDao.insert(pPessoa);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update(Person pPessoa){
        person = pPessoa;
        try{
            personDao.update(person);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean deleteById(Person pPessoa){
        person = pPessoa;
        try{
            personDao.delete(person);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Person findById(Person pPessoa){
        try{
           Person pe = personDao.findById(pPessoa);
           return pe;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public List<Person> findAll(){
        try{
            List<Person> listPessoa = personDao.findAll();
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
    
    public List<Person> findByName(String pName){
        if(pName != null){
            try{
                List<Person> listPessoa = personDao.findByName(pName);
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
