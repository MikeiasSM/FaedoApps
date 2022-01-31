/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.dao.implement;

import br.com.floatsolutions.connection.ConnectionFactory;
import br.com.floatsolutions.model.Fabricante_Veiculo;
import java.util.List;
import br.com.floatsolutions.uteis.JPaneError;
import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;
import br.com.faedocaminhoes.model.dao.FabricanteDao;

/**
 *
 * @author Poison
 */
public class FabricanteDaoJPA implements FabricanteDao {

    private static EntityManager em;
    
    @Override
    public void insert(Fabricante_Veiculo pProvider) {
        em = new ConnectionFactory().getConection();
        try {
            em.getTransaction().begin();
            em.persist(pProvider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Fabricante_Veiculo pProvider) {
        em = new ConnectionFactory().getConection();

        try {
            em.getTransaction().begin();
            em.merge(pProvider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Fabricante_Veiculo pProvider) {
        em = new ConnectionFactory().getConection();

        try {
            Fabricante_Veiculo provider = em.find(Fabricante_Veiculo.class, pProvider.getId());

            em.getTransaction().begin();
            em.remove(provider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "Next Software ₢", JOptionPane.INFORMATION_MESSAGE);

        }catch(RollbackException ex){
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", ex);
            ex.printStackTrace();
        } catch (Exception e) {
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Fabricante_Veiculo> findAll() {
        em = new ConnectionFactory().getConection();
        List<Fabricante_Veiculo> providers = null;

        try {
            providers = em.createQuery("SELECT p FROM Fabricante p ORDER BY p.id").getResultList();

            if (providers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Objects not found!");
            }

            return providers;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Fabricante_Veiculo findById(Fabricante_Veiculo pProvider) {
        em = new ConnectionFactory().getConection();
        Fabricante_Veiculo provider = null;
        
        try {
            provider = em.find(Fabricante_Veiculo.class, pProvider);
            
            if (provider == null) {
                JOptionPane.showMessageDialog(null, "Object not found!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Registro não encontrado!");
            }
            return provider;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fabricante_Veiculo> findByName(String pName) {
        em = new ConnectionFactory().getConection();
        List<Fabricante_Veiculo> list = null;
        try {
            String query = "SELECT p FROM Fabricante p WHERE 1 = 1 AND p.nome LIKE '%" + pName + "%' ORDER BY p.id";

            list = em.createQuery(query).getResultList();
            if (!list.isEmpty()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            JPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}