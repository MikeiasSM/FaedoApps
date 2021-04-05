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

/**
 *
 * @author Poison
 */
public class PersonService {
    Person pessoa;
    PersonDaoJPA pessoaDao = DaoFactory.createPersonDao();
    
    public boolean insertOrUpdate(Person pPessoa){
    	pessoa = pPessoa;
        try{
            if(pPessoa.getId() == null) {
                pessoaDao.insert(pessoa);        		
            }else {
                pessoaDao.update(pessoa);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean insert(Person pPessoa){
        pessoa = pPessoa;
        try{
            pessoaDao.insert(pPessoa);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean update(Person pPessoa){
        pessoa = pPessoa;
        try{
            pessoaDao.update(pessoa);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    public boolean deleteById(Person pPessoa){
        pessoa = pPessoa;
        try{
            pessoaDao.delete(pessoa);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }

    public Person findById(Person pPessoa){
        try{
           Person pe = pessoaDao.findById(pPessoa);
           return pe;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        
    }
    
    public List<Person> findAll(){
        try{
            List<Person> listPessoa = pessoaDao.findAll();
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
