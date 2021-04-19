/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.CategoriaProd;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.CategoriaDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class CategoriaService {
    CategoriaProd categoria;
    CategoriaDaoJPA categoriaDao = DaoFactory.createCategoriaDao();
    
    public void insertOrUpdate(CategoriaProd obj) {
        categoria = obj;
        if (categoria != null && categoriaDao != null) {
            if (obj.getId() == null) {
                categoriaDao.insert(categoria);
            } else {
                categoriaDao.update(categoria);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(CategoriaProd obj) {
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.insert(categoria);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(CategoriaProd obj){
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.update(categoria);
        }       
    }
    
    public void deleteById(CategoriaProd obj){
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.delete(categoria);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public CategoriaProd findById(CategoriaProd obj){
        if(obj != null && categoriaDao != null){
           CategoriaProd p = categoriaDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<CategoriaProd> findAll() {
        if(categoriaDao != null){
        List<CategoriaProd> listCategoria = categoriaDao.findAll();
        return listCategoria;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<CategoriaProd> findByName(String pName){
        if(pName != null && categoriaDao != null){
            try{
                List<CategoriaProd> listCategoria = categoriaDao.findByName(pName);
                return listCategoria;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(categoria);
            return null;
        }
    }
}
