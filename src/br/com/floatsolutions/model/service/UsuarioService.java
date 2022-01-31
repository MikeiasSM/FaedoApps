/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.model.service;

import br.com.floatsolutions.model.Usuario;
import br.com.faedocaminhoes.model.dao.DaoFactory;
import br.com.floatsolutions.model.dao.implement.UsuarioDaoJPA;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Poison
 */
public class UsuarioService {
    Usuario user;
    UsuarioDaoJPA userDao = DaoFactory.createUsuarioDao();
    
    public void insertOrUpdate(Usuario pUser) {
        user = pUser;
        if (pUser != null && user != null) {
            if (pUser.getId() == null) {
                userDao.insert(user);
            } else {
                userDao.update(user);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void insert(Usuario pUser) {
        user = pUser;
        if(pUser != null && user != null){
            userDao.insert(pUser);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(Usuario pUser){
        user = pUser;
        if(pUser != null && user != null){
            userDao.update(pUser);
        }       
    }
    
    public void delete(Usuario pUser){
        user = pUser;
        if(pUser!= null){
            userDao.delete(user);
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Usuario findById(Usuario pUser){
        if(pUser != null){
           Usuario p = userDao.findById(pUser);
           return p;
        }else{
            JOptionPane.showMessageDialog(null, "Object or Parameter is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }                
    }
    
    public List<Usuario> findAll() {
        if(userDao != null){
        List<Usuario> listPessoa = userDao.findAll();
        return listPessoa;
        } else{
            JOptionPane.showMessageDialog(null, "Service is null!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public List<Usuario> findByName(String pName){
        if(pName != null && userDao != null){
            try{
                List<Usuario> listPessoa = userDao.findByName(pName);
                return listPessoa;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Variable or Service is null, check the informed parameter!", "FAEDO CAMINHÕES ©", JOptionPane.ERROR_MESSAGE);
            System.out.println(user);
            return null;
        }
    }
    
    public Usuario verifieldUser(String user, String password){
        if(user != null && password != null){
            return userDao.verifieldUser(user, password);
        }
        return null;
    }
}
