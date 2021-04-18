/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Pessoa;
import java.util.List;
import br.com.faedocaminhoes.model.dao.PersonDao;
import br.com.faedocaminhoes.uteis.JOptionPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class PessoaDaoJPA implements PersonDao{

    private static EntityManager em;
    
    @Override
    public void insert(Pessoa pPerson) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public void update(Pessoa pPerson) {
        em = new ConnectionFactory().getConection();
        
        try{
            em.getTransaction().begin();
            em.merge(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public void delete(Pessoa pPerson) {
        em = new ConnectionFactory().getConection();
        
        try{
            Pessoa vehicle = em.find(Pessoa.class, pPerson.getId());
            
            em.getTransaction().begin();
            em.remove(vehicle);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(RollbackException ex){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "FAEDO CAMINHÕES ©", ex);
            ex.printStackTrace();
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "FAEDO CAMINHÕES ©", e);
            e.printStackTrace();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public List<Pessoa> findAll() {
        em = new ConnectionFactory().getConection();
        List<Pessoa> vehicle = null;
        
        try{
            //"SELECT p FROM Pessoa p LEFT JOIN FETCH disc.linhas where disc.paragrafo = ?"
            vehicle = em.createQuery("SELECT p FROM Person p").getResultList();
            
            if(vehicle.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return vehicle;
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public Pessoa findById(Pessoa pPerson) {
        em = new ConnectionFactory().getConection();
        Pessoa person = null;
        
        try{
            person = em.find(Pessoa.class, pPerson);
        
            if(person == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Register not found!");
            }
            return person;                
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public List<Pessoa> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Pessoa> list = null;
        try{
            String query = "SELECT p FROM Person p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%'";
           
            list = em.createQuery(query).getResultList();
            if (!list.isEmpty()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(null, "Register not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }catch(Exception e){
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
}
