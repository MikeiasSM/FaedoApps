/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao.implement;

import br.com.faedocaminhoes.connection.ConnectionFactory;
import br.com.faedocaminhoes.model.Fabricante;
import java.util.List;
import br.com.faedocaminhoes.uteis.JOptionPaneError;
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
    public void insert(Fabricante pProvider) {
        em = new ConnectionFactory().getConection();
        try {
            em.getTransaction().begin();
            em.persist(pProvider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro adicionado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Fabricante pProvider) {
        em = new ConnectionFactory().getConection();

        try {
            em.getTransaction().begin();
            em.merge(pProvider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Fabricante pProvider) {
        em = new ConnectionFactory().getConection();

        try {
            Fabricante provider = em.find(Fabricante.class, pProvider.getId());

            em.getTransaction().begin();
            em.remove(provider);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!", "FAEDO CAMINHÕES ©", JOptionPane.INFORMATION_MESSAGE);

        }catch(RollbackException ex){
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", ex);
            ex.printStackTrace();
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Fabricante> findAll() {
        em = new ConnectionFactory().getConection();
        List<Fabricante> providers = null;

        try {
            providers = em.createQuery("SELECT p FROM Fabricante p").getResultList();

            if (providers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Anyone regiter not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Objects not found!");
            }

            return providers;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Fabricante findById(Fabricante pProvider) {
        em = new ConnectionFactory().getConection();
        Fabricante provider = null;
        
        try {
            provider = em.find(Fabricante.class, pProvider);
            
            if (provider == null) {
                JOptionPane.showMessageDialog(null, "Object not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                throw new IllegalAccessError("Register not found!");
            }
            return provider;
        } catch (Exception e) {
            em.getTransaction().rollback();
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fabricante> findByName(String pName) {
        em = new ConnectionFactory().getConection();
        List<Fabricante> list = null;
        try {
            String query = "SELECT p FROM Fabricante p WHERE 1 = 1 AND p.nome LIKE '%" + pName + "%'";

            list = em.createQuery(query).getResultList();
            if (!list.isEmpty()) {
                return list;
            } else {
                JOptionPane.showMessageDialog(null, "Register not found!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (Exception e) {
            JOptionPaneError.showErrorDialog(null, "Erro ao executar ação!", e);
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}