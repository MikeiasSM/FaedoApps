/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Usuario;
import java.util.List;
import br.com.faedocaminhoes.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import br.com.faedocaminhoes.model.dao.UsuarioDao;
import javax.persistence.NoResultException;

/**
 *
 * @author Poison
 */
public class UsuarioDaoJPA implements UsuarioDao{

    private static EntityManager em;
    
    @Override
    public void insert(Usuario pUser) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(pUser);
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
    public void update(Usuario pUser) {
        em = new ConnectionFactory().getConection();
        
        try{
            em.getTransaction().begin();
            em.merge(pUser);
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
    public void delete(Usuario pUser) {
        em = new ConnectionFactory().getConection();
        
        try{
            Usuario user = em.find(Usuario.class, pUser.getId());
            
            em.getTransaction().begin();
            em.remove(user);
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
    public List<Usuario> findAll() {
        em = new ConnectionFactory().getConection();
        List<Usuario> user = null;
        
        try{
            user = em.createQuery("SELECT u FROM Usuario u ORDER BY u.id").getResultList();
            
            if(user.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return user;
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
    public Usuario findById(Usuario pUser) {
        em = new ConnectionFactory().getConection();
        Usuario user = null;
        
        try{
            user = em.find(Usuario.class, pUser);
        
            if(user == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return user;                
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
    
    public List<Usuario> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Usuario> list = null;
        try{
            String query = "SELECT p FROM Usuario p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%' ORDER BY p.id";
           
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

    @Override
    public Usuario verifieldUser(String user, String password) {
        em = new ConnectionFactory().getConection();
        Usuario us = null;
        try{
            System.out.println(user+" - "+password);
            
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nome = '"+user+"' AND u.senha1 = '"+password+"'");
            us = (Usuario) query.getSingleResult();
                       
            return us;
        }catch(NoResultException e){
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            return null;
        }catch(Exception e){
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            System.exit(0);
            return null;
        }finally {
            if(em != null) {
                em.close();        		
            }
        }
    }
}
