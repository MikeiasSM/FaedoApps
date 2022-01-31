/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.floatsolutions.model.Empresa;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface EmpresaDao {
    
    public void insert(Empresa obj);
    public void update(Empresa obj);
    public void delete(Empresa obj);
    public List<Empresa> findAll();
    public Empresa findById(Empresa obj);
    
}
