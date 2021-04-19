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
public interface UsuarioDao {
    
    public void insert(Usuario obj);
    public void update(Usuario obj);
    public void delete(Usuario obj);
    public Usuario findById(Usuario obj);
    public List<Usuario> findAll();
    public Usuario verifieldUser(String user, String password);
    
}
