/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Fornecedor;
import br.com.faedocaminhoes.model.dao.FornecedorDao;
import java.util.List;
import br.com.faedocaminhoes.uteis.JOptionPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class FornecedorDaoJPA implements FornecedorDao{

    private static EntityManager em;
    
    @Override
    public void insert(Fornecedor obj) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(obj);
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
    public void update(Fornecedor obj) {
        em = new ConnectionFactory().getConection();
        
        try{
            em.getTransaction().begin();
            em.merge(obj);
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
    public void delete(Fornecedor obj) {
        em = new ConnectionFactory().getConection();
        
        try{
            Fornecedor fornecedor = em.find(Fornecedor.class, obj.getId());
            
            em.getTransaction().begin();
            em.remove(fornecedor);
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
    public List<Fornecedor> findAll() {
        em = new ConnectionFactory().getConection();
        List<Fornecedor> fornecedor = null;
        
        try{
            fornecedor = em.createQuery("SELECT u FROM Fornecedor u ORDER BY u.id").getResultList();
            
            if(fornecedor.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return fornecedor;
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
    public Fornecedor findById(Fornecedor obj) {
        em = new ConnectionFactory().getConection();
        Fornecedor fornecedor = null;
        
        try{
            fornecedor = em.find(Fornecedor.class, obj.getId());
        
            if(fornecedor == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Register not found!");
            }
            return fornecedor;                
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
    
    public Fornecedor findByIdInteger(Integer id) {
        em = new ConnectionFactory().getConection();
        Fornecedor fornecedor = null;
        
        try{
            fornecedor = (Fornecedor) em.createQuery("SELECT u FROM Fornecedor u WHERE 1=1 AND u.id = "+id+" ORDER BY u.id").getSingleResult();
            System.out.println(fornecedor);
            if(fornecedor == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Register not found!");
            }
            return fornecedor;                
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
    
    public List<Fornecedor> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Fornecedor> list = null;
        try{
            String query = "SELECT p FROM Fornecedor p WHERE 1 = 1 AND p.razao LIKE '%"+pName+"%' ORDER BY p.id";
           
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
