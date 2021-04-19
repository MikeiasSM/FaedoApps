/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.model.dao;

import br.com.faedocaminhoes.model.dao.implement.AbastecimentoDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.CategoriaDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.ProdutoDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.PessoaDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.FabricanteDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.FornecedorDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.UsuarioDaoJPA;
import br.com.faedocaminhoes.model.dao.implement.VeiculoDaoJPA;

/**
 *
 * @author Poison
 */
public class DaoFactory {
    
    public static PessoaDaoJPA createPessoaDao(){
        return new PessoaDaoJPA();
    }
    
    public static VeiculoDaoJPA createVeiculoDao(){
        return new VeiculoDaoJPA();
    }
    
    public static FabricanteDaoJPA createFabricanteDao(){
        return new FabricanteDaoJPA();
    }
    
    public static FornecedorDaoJPA createFornecedorDao(){
        return new FornecedorDaoJPA();
    }
    
    public static UsuarioDaoJPA createUsuarioDao(){
        return new UsuarioDaoJPA();
    }
    
    public static ProdutoDaoJPA createProdutoDao(){
        return new ProdutoDaoJPA();
    }
    
    public static CategoriaDaoJPA createCategoriaDao(){
        return new CategoriaDaoJPA();
    }
    
    public static AbastecimentoDaoJPA createAbastecimentoDao(){
        return new AbastecimentoDaoJPA();
    }
    
}
