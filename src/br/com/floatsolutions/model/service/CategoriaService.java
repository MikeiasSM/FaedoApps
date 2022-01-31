/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.service;

import br.com.floatsolutions.model.Categoria_Produto;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.floatsolutions.model.dao.implement.CategoriaDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class CategoriaService {
    Categoria_Produto categoria;
    CategoriaDaoJPA categoriaDao = DaoFactory.createCategoriaDao();
    
    public void insertOrUpdate(Categoria_Produto obj) {
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
    
    public void insert(Categoria_Produto obj) {
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.insert(categoria);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Categoria_Produto obj){
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.update(categoria);
        }       
    }
    
    public void deleteById(Categoria_Produto obj){
        categoria = obj;
        if(categoria != null && categoriaDao != null){
            categoriaDao.delete(categoria);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Categoria_Produto findById(Categoria_Produto obj){
        if(obj != null && categoriaDao != null){
           Categoria_Produto p = categoriaDao.findById(obj);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Categoria_Produto> findAll() {
        if(categoriaDao != null){
        List<Categoria_Produto> listCategoria = categoriaDao.findAll();
        return listCategoria;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Categoria_Produto> findByName(String pName){
        if(pName != null && categoriaDao != null){
            try{
                List<Categoria_Produto> listCategoria = categoriaDao.findByName(pName);
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
