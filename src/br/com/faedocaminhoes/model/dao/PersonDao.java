/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.Person;
import java.util.List;

/**
 *
 * @author Poison
 */
public interface PersonDao {
    
    public void insert(Person pessoa);
    public void update(Person pessoa);
    public void delete(Person pessoa);
    public List<Person> findAll();
    public Person findById(Person pessoa);
    
}
