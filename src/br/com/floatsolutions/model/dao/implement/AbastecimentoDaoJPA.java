/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.dao.implement;

import br.com.floatsolutions.connection.ConnectionFactory;
import br.com.floatsolutions.model.Abastecimento;
import br.com.floatsolutions.model.Empresa;
import br.com.faedocaminhoes.model.dao.AbastecimentoDao;
import java.util.List;
import br.com.floatsolutions.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class AbastecimentoDaoJPA implements AbastecimentoDao{

    private static EntityManager em;
    
    @Override
    public void insert(Abastecimento obj) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(obj);
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
    public void update(Abastecimento obj) {
        em = new ConnectionFactory().getConection();
        
        try{
            em.getTransaction().begin();
            em.merge(obj);
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
    public void delete(Abastecimento obj) {
        em = new ConnectionFactory().getConection();
        
        try{
            Abastecimento abas = em.find(Abastecimento.class, obj.getId());
            
            em.getTransaction().begin();
            em.remove(abas);
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
    public List<Abastecimento> findAll() {
        em = new ConnectionFactory().getConection();
        
        try{
            List<Abastecimento> abastecimentos = em.createQuery("SELECT u FROM Abastecimento u JOIN FETCH u.fornecedor JOIN FETCH u.pessoa JOIN FETCH u.produto JOIN FETCH u.veiculo JOIN FETCH u.usuario JOIN FETCH u.empresa ORDER BY u.id").getResultList();
            
            if(abastecimentos.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return abastecimentos;
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
    public List<Abastecimento> findAll(Empresa obj) {
        em = new ConnectionFactory().getConection();
        List<Abastecimento> abastecimentos = null;
        
        try{
            abastecimentos = em.createQuery("SELECT u FROM Abastecimento u JOIN FETCH u.fornecedor JOIN FETCH u.pessoa JOIN FETCH u.produto JOIN FETCH u.veiculo JOIN FETCH u.usuario JOIN FETCH u.empresa WHERE u.empresa = "+obj.getId()+" ORDER BY u.id").getResultList();
            
            if(abastecimentos.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return abastecimentos;
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
    public Abastecimento findById(Abastecimento obj) {
        em = new ConnectionFactory().getConection();
        Abastecimento abastecimento = null;
        
        try{
            
            String sql = "SELECT u FROM Abastecimento u JOIN FETCH u.fornecedor JOIN FETCH u.pessoa JOIN FETCH u.produto JOIN FETCH u.veiculo JOIN FETCH u.usuario JOIN FETCH u.empresa WHERE u.id = "+obj.getId()+" ORDER BY u.id";
            abastecimento = (Abastecimento) em.createQuery(sql).getSingleResult();
        
            if(abastecimento == null){
                JOptionPane.showMessageDialog(null, "Registro não encontrado!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return abastecimento;                
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
    
    public Abastecimento findByIdInteger(Integer id) {
        em = new ConnectionFactory().getConection();
        Abastecimento abastecimento = null;
        
        try{
            abastecimento = em.find(Abastecimento.class, id);
        
            if(abastecimento == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return abastecimento;                
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
    
    public List<Abastecimento> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Abastecimento> list = null;
        try{
            String query = "SELECT p FROM Abastecimento p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%' ORDER BY p.id";
           
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
