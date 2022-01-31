/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.dao.implement;

import br.com.floatsolutions.connection.ConnectionFactory;
import br.com.floatsolutions.model.Pessoa;
import java.util.List;
import br.com.floatsolutions.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import br.com.faedocaminhoes.model.dao.PessoaDao;

/**
 *
 * @author Poison
 */
public class PessoaDaoJPA implements PessoaDao{

    private static EntityManager em;
    
    @Override
    public void insert(Pessoa pPerson) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(pPerson);
            em.getTransaction().commit();
            
            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
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
            
            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(Exception e){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
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
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(RollbackException ex){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Next Software ₢", ex);
            ex.printStackTrace();
        }catch(Exception e){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Next Software ₢", e);
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
        List<Pessoa> pessoa = null;
        
        try{                                                
            pessoa = em.createQuery("SELECT p FROM Pessoa p JOIN FETCH p.veiculos ORDER BY p.id").getResultList();
            
            if(pessoa.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return pessoa;
        }catch(Exception e){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
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
            String sql = "SELECT u FROM Pessoa u WHERE u.id = "+pPerson.getId();
            person = (Pessoa) em.createQuery(sql).getSingleResult();
        
            if(person == null){
                JOptionPane.showMessageDialog(null, "Registro não encontrado!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return person;                
        }catch(Exception e){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
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
            String query = "SELECT p FROM Pessoa p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%' ORDER BY p.id";
           
            list = em.createQuery(query).getResultList();
            if (!list.isEmpty()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }catch(Exception e){
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
}
