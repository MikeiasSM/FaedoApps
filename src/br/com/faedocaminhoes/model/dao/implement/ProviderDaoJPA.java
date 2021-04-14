/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Provider;
import java.util.List;
import br.com.faedocaminhoes.model.dao.ProviderDao;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class ProviderDaoJPA implements ProviderDao{

    @Override
    public void insert(Provider pProvider) {
        EntityManager em = new ConnectionFactory().getConection();
        try{
            if(pProvider == null){
             throw new IllegalAccessError("Object 'pProvider' was null!/br Next impossible.");   
            }    
            em.getTransaction().begin();
            em.persist(pProvider);
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
    public void update(Provider pProvider) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pProvider == null){
                throw new IllegalAccessError("Object 'pProvider' was null!/br Next impossible.");
            }
            
            em.getTransaction().begin();
            em.merge(pProvider);
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
    public void delete(Provider pProvider) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pProvider == null){
                throw new IllegalAccessError("Object 'pProvider' was null!/br Next impossible.");
            }
            
            Provider provider = em.find(Provider.class, pProvider.getId());
            
            em.getTransaction().begin();
            em.remove(provider);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public List<Provider> findAll() {
        EntityManager em = new ConnectionFactory().getConection();
        List<Provider> providers = null;
        
        try{
            
            providers = em.createQuery("SELECT p FROM Provider p").getResultList();
            
            if(providers.isEmpty()){
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return providers;
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return providers;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public Provider findById(Provider pProvider) {
        EntityManager em = new ConnectionFactory().getConection();
        Provider provider = null;
        if(pProvider == null){
            throw new IllegalAccessError("Object 'pProvider' was null");
        }
        
        provider = em.find(Provider.class, pProvider);
        /*
        Query query = em.createQuery("FROM Person WHERE Person.id = :id");
        query.setParameter("id", pPerson.getId());
        person = (Person) query.getSingleResult();
        */
        try{
            if(provider == null){
                throw new IllegalAccessError("Register not found!");
            }
            return provider;                
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return provider;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public List<Provider> findByName(String pName){
        EntityManager em = new ConnectionFactory().getConection();
        List<Provider> list = null;
        try{
            String query = "SELECT p FROM Provider p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%'";
           
            list = em.createQuery(query).getResultList();

            return list;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
}
