/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Cidade;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.CidadeDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class CidadeService {
    Cidade cidade;
    CidadeDaoJPA cidadeDao = DaoFactory.createCidadeDao();
    
    public void insertOrUpdate(Cidade obj) {
        cidade = obj;
        if (cidade != null && cidadeDao != null) {
            if (obj.getId() == null) {
                insert(cidade);
            } else {
                update(cidade);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Cidade obj) {
        cidade = obj;
        if(cidade != null && cidadeDao != null){
            cidadeDao.save(cidade);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Cidade obj){
        cidade = obj;
        if(cidade != null && cidadeDao != null){
            cidadeDao.update(cidade);
        }       
    }
    
    public void deleteById(Cidade obj){
        cidade = obj;
        if(cidade != null && cidadeDao != null){
            cidadeDao.delete(cidade);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Cidade findById(Cidade obj){
        if(obj != null && cidadeDao != null){
           Cidade p = cidadeDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Cidade> findAll() {
        if(cidadeDao != null){
        List<Cidade> listCidade = cidadeDao.findAll();
        return listCidade;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Cidade> findByName(String pName){
        if(pName != null && cidadeDao != null){
            try{
                List<Cidade> listCidade = cidadeDao.findByName(pName);
                return listCidade;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "Next Software ₢", JOptionPane.ERROR_MESSAGE);
            System.out.println(cidade);
            return null;
        }
    }
}
