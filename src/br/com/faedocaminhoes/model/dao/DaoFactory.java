/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.dao.implement.PersonDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.ProviderDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.VehicleDaoJPA;

/**
 *
 * @author Poison
 */
public class DaoFactory {
    
    public static PersonDaoJPA createPersonDao(){
        return new PersonDaoJPA();
    }
    
    public static VehicleDaoJPA createVehicleDao(){
        return new VehicleDaoJPA();
    }
    
    public static ProviderDaoJPA createProviderDao(){
        return new ProviderDaoJPA();
    }
    
}
