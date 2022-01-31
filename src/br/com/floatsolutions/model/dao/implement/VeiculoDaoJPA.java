/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.dao.implement;

import br.com.floatsolutions.connection.ConnectionFactory;
import br.com.floatsolutions.model.Veiculo;
import java.util.List;
import br.com.floatsolutions.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import br.com.faedocaminhoes.model.dao.VeiculoDao;

/**
 *
 * @author Poison
 */
public class VeiculoDaoJPA implements VeiculoDao{

    private static EntityManager em;
    
    @Override
    public void insert(Veiculo pVeiculo) {
        em = new ConnectionFactory().getConection();
        try{
            em.getTransaction().begin();
            em.persist(pVeiculo);
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
    public void update(Veiculo pVeiculo) {
        em = new ConnectionFactory().getConection();
        
        try{
            em.getTransaction().begin();
            em.merge(pVeiculo);
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
    public void delete(Veiculo pVehicle) {
        em = new ConnectionFactory().getConection();
        
        try{
            Veiculo vehicle = em.find(Veiculo.class, pVehicle.getId());
            
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
    public List<Veiculo> findAll() {
        em = new ConnectionFactory().getConection();
        List<Veiculo> vehicle = null;
        
        try{
            vehicle = em.createQuery("SELECT v FROM Veiculo v JOIN FETCH v.pessoas ORDER BY v.id").getResultList();
            
            if(vehicle.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return vehicle;
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
    public Veiculo findById(Veiculo pVehicle) {
        em = new ConnectionFactory().getConection();
        Veiculo vehicle = null;
        
        try{
            String sql = "SELECT u FROM Veiculo u WHERE u.id = "+pVehicle.getId();
            vehicle = (Veiculo) em.createQuery(sql).getSingleResult();
        
            if(vehicle == null){
                JOptionPane.showMessageDialog(null, "Registro não encontrado!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return vehicle;                
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
    
    public List<Veiculo> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Veiculo> list = null;
        try{
            String query = "SELECT p FROM Veiculo p WHERE 1 = 1 AND p.modelo LIKE '%"+pName+"%' ORDER BY p.id";
           
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