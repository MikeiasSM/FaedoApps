/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.dao.implement.PessoaDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.FabricanteDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.UsuarioDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.VeiculoDaoJPA;

/**
 *
 * @author Poison
 */
public class DaoFactory {
    
    public static PessoaDaoJPA createPersonDao(){
        return new PessoaDaoJPA();
    }
    
    public static VeiculoDaoJPA createVehicleDao(){
        return new VeiculoDaoJPA();
    }
    
    public static FabricanteDaoJPA createProviderDao(){
        return new FabricanteDaoJPA();
    }
    
    public static UsuarioDaoJPA createUserDao(){
        return new UsuarioDaoJPA();
    }
    
}
