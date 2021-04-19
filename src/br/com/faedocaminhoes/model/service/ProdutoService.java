/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.service;

import br.com.faedocaminhoes.model.Produto;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.faedocaminhoes.model.dao.implement.ProdutoDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class ProdutoService {
    Produto produto;
    ProdutoDaoJPA produtoDao = DaoFactory.createProdutoDao();
    
    public void insertOrUpdate(Produto obj) {
        produto = obj;
        if (produtoDao != null && produto != null) {
            if (produto.getId() == null) {
                produtoDao.insert(produto);
            } else {
                produtoDao.update(produto);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insert(Produto obj) {
        produto = obj;
        if(produtoDao != null && produto != null){
            produtoDao.insert(produto);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Produto obj){
        produto = obj;
        if(produtoDao != null && produto != null){
            produtoDao.update(produto);
        }       
    }
    
    public void delete(Produto obj){
        produto = obj;
        if(produtoDao != null && produto != null){
            produtoDao.delete(produto);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Produto findById(Produto obj){
        if(produtoDao != null && produto != null){
           Produto p = produtoDao.findById(produto);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Produto> findAll() {
        if(produtoDao != null){
        List<Produto> listPessoa = produtoDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Produto> findByName(String pName){
        if(pName != null && produtoDao != null){
            try{
                List<Produto> listPessoa = produtoDao.findByName(pName);
                return listPessoa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(produto);
            return null;
        }
    }
}
