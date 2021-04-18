/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Usuario;
import java.util.List;


/**
 *
 * @author Mikeias
 */
public interface UserDao {
    
    public void save(Usuario pUser);
    public void update(Usuario pUser);
    public void delete(Usuario pUser);
    public Usuario findById(Usuario pUser);
    public List<Usuario> findAll();
    public Usuario verifieldUser(String user, String password);
    
}
