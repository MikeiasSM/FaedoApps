/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Estado;
import java.util.List;


/**
 *
 * @author Mikeias
 */
public interface EstadoDao {
    
    public void save(Estado obj);
    public void update(Estado obj);
    public void delete(Estado obj);
    public Estado findById(Estado obj);
    public List<Estado> findAll();
    
}
