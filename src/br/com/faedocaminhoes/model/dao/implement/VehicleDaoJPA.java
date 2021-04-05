/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Vehicle;
import java.util.List;
import br.com.faedocaminhoes.model.dao.VehicleDao;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class VehicleDaoJPA implements VehicleDao{

    @Override
    public void insert(Vehicle pVeiculo) {
        EntityManager em = new ConnectionFactory().getConection();
        try{
            if(pVeiculo == null){
             throw new IllegalAccessError("Object 'pVehicle' was null!/br Next impossible.");   
            }    
            em.getTransaction().begin();
            em.persist(pVeiculo);
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
    public void update(Vehicle pVeiculo) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pVeiculo == null){
                throw new IllegalAccessError("Object 'pVehicle' was null!/br Next impossible.");
            }
            
            em.getTransaction().begin();
            em.merge(pVeiculo);
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
    public void delete(Vehicle pVeiculo) {
        EntityManager em = new ConnectionFactory().getConection();
        
        try{
            if(pVeiculo == null){
                throw new IllegalAccessError("Object 'pVehicle' was null!/br Next impossible.");
            }
            
            em.getTransaction().begin();
            em.remove(pVeiculo);
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
    public List<Vehicle> findAll() {
       EntityManager em = new ConnectionFactory().getConection();
        List<Vehicle> vehicle = null;
        
        try{
            
            vehicle = em.createQuery("SELECT v FROM Vehicle v").getResultList();
            
            if(vehicle.isEmpty()){
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return vehicle;
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return vehicle;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    @Override
    public Vehicle findById(Vehicle pVehicle) {
       EntityManager em = new ConnectionFactory().getConection();
        Vehicle vehicle = null;
        if(pVehicle == null){
            throw new IllegalAccessError("Object 'pVehicle' was null");
        }
        
        vehicle = em.find(Vehicle.class, pVehicle);
        /*
        Query query = em.createQuery("FROM Person WHERE Person.id = :id");
        query.setParameter("id", pPerson.getId());
        person = (Person) query.getSingleResult();
        */
        try{
            if(vehicle == null){
                throw new IllegalAccessError("Register not found!");
            }
            return vehicle;                
        }catch(Exception e){
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return vehicle;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
}
