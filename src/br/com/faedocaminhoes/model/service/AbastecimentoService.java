/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Abastecimento;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.AbastecimentoDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class AbastecimentoService {
    Abastecimento abastecimento;
    AbastecimentoDaoJPA abastecimentoDao = DaoFactory.createAbastecimentoDao();
    
    public void insertOrUpdate(Abastecimento obj) {
        abastecimento = obj;
        if (abastecimento != null && abastecimentoDao != null) {
            if (obj.getId() == null) {
                abastecimentoDao.insert(abastecimento);
            } else {
                abastecimentoDao.update(abastecimento);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Abastecimento obj) {
        abastecimento = obj;
        if(abastecimento != null && abastecimentoDao != null){
            abastecimentoDao.insert(abastecimento);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Abastecimento obj){
        abastecimento = obj;
        if(abastecimento != null && abastecimentoDao != null){
            abastecimentoDao.update(obj);
        }       
    }
    
    public void delete(Abastecimento obj){
        abastecimento = obj;
        if(abastecimento != null && abastecimentoDao != null){
            abastecimentoDao.delete(abastecimento);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Abastecimento findById(Abastecimento obj){
        if(obj != null && abastecimentoDao != null){
           Abastecimento p = abastecimentoDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Abastecimento> findAll() {
        if(abastecimentoDao != null){
        List<Abastecimento> listPessoa = abastecimentoDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Abastecimento> findByName(String pName){
        if(pName != null && abastecimentoDao != null){
            try{
                List<Abastecimento> listPessoa = abastecimentoDao.findByName(pName);
                return listPessoa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(abastecimento);
            return null;
        }
    }
}
