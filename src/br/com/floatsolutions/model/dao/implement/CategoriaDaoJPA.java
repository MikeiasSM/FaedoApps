/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.dao.implement;

import br.com.floatsolutions.connection.ConnectionFactory;
import br.com.floatsolutions.model.Categoria_Produto;
import br.com.floatsolutions.model.Fornecedor;
import br.com.faedocaminhoes.model.dao.CategoriaDao;
import java.util.List;
import br.com.floatsolutions.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class CategoriaDaoJPA implements CategoriaDao{

    private static EntityManager em;
    
    @Override
    public void insert(Categoria_Produto obj) {
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
    public void update(Categoria_Produto obj) {
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
    public void delete(Categoria_Produto obj) {
        em = new ConnectionFactory().getConection();
        
        try{
            Categoria_Produto categoria = em.find(Categoria_Produto.class, obj.getId());
            
            em.getTransaction().begin();
            em.remove(categoria);
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
    public List<Categoria_Produto> findAll() {
        em = new ConnectionFactory().getConection();
        List<Categoria_Produto> categorias = null;
        
        try{
            categorias = em.createQuery("SELECT u FROM CategoriaProd u ORDER BY u.id").getResultList();
            
            if(categorias.isEmpty()){
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Date or table not found!");
            }
            
            return categorias;
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
    public Categoria_Produto findById(Categoria_Produto obj) {
        em = new ConnectionFactory().getConection();
        Categoria_Produto categoria = null;
        
        try{
            categoria = em.find(Categoria_Produto.class, obj.getId());
        
            if(categoria == null){
                JOptionPane.showMessageDialog(null, "Object not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return categoria;                
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
    
    public List<Categoria_Produto> findByName(String pName){
        em = new ConnectionFactory().getConection();
        List<Categoria_Produto> list = null;
        try{
            String query = "SELECT p FROM CategoriaProd p WHERE 1 = 1 AND p.nome LIKE '%"+pName+"%' ORDER BY p.id";
           
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
