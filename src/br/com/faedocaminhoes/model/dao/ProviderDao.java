/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Provider;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface ProviderDao {
    
    public void insert(Provider pProvider);
    public void update(Provider pProvider);
    public void delete(Provider pProvider);
    public List<Provider> findAll();
    public Provider findById(Provider pProvider);
    
}
