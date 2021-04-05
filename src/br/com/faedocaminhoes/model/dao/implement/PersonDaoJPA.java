/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Person;
import java.util.List;
import br.com.faedocaminhoes.model.dao.PersonDao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class PersonDaoJPA implements PersonDao{

    @Override
    public void insert(Person pPerson) {
        EntityManager em = new ConnectionFactory().getConection();
        try{
            if(pPerson == null){
             throw new IllegalAccessError("Object 'pPerson' was null!/br Next impossible.");   
            }    
            em.getTransaction().begin();
            em.persist(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public void update(Person pPerson) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pPerson == null){
                throw new IllegalAccessError("Object 'pPerson' was null!/br Next impossible.");
            }
            
            em.getTransaction().begin();
            em.merge(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(em != null){
                em.close();
            }
        }
        
    }

    @Override
    public void delete(Person pPerson) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pPerson == null){
                throw new IllegalAccessError("Object 'pPerson' was null!/br Next impossible.");
            }
            
            em.getTransaction().begin();
            em.remove(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public List<Person> findAll() {
        EntityManager em = new ConnectionFactory().getConection();
        List<Person> persons = null;
        
        try{
            
            persons = em.createQuery("SELECT p FROM Person p").getResultList();
            
            if(persons.isEmpty()){
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return persons;
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return persons;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public Person findById(Person pPerson) {
        EntityManager em = new ConnectionFactory().getConection();
        Person person = null;
        if(pPerson == null){
            throw new IllegalAccessError("Object 'pPerson' was null");
        }
        
        person = em.find(Person.class, pPerson);
        /*
        Query query = em.createQuery("FROM Person WHERE Person.id = :id");
        query.setParameter("id", pPerson.getId());
        person = (Person) query.getSingleResult();
        */
        try{
            if(person == null){
                throw new IllegalAccessError("Register not found!");
            }
            return person;                
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return person;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
}
