/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.connection;

import br.com.faedocaminhoes.uteis.PropertyUtils;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Poison
 */
public class ConnectionFactory {
    
    private static final EntityManagerFactory emf = createEntityManagerFactory();
    
    public static EntityManagerFactory createEntityManagerFactory() {        
        Config conf = PropertyUtils.propertyService();
        
        Properties properties = new Properties();
        properties.put("javax.persistence.provider", "org.hibernate.ejb.HibernatePersistence");
        properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
        properties.put("hibernate.connection.username", conf.getUser());
        properties.put("hibernate.connection.password", conf.getPass());
        properties.put("hibernate.connection.driver_class", conf.getDriver());
        properties.put("hibernate.connection.url", "jdbc:postgresql://"+conf.getHost()+":"+conf.getPort()+"/"+conf.getData()+"?createDatabaseIfNotExist=true");
        properties.put("hibernate.dialect", conf.getDialect());
        properties.put("hibernate.hbm2ddl.auto", "update");
        //properties.put("hibernate.hbm2ddl.import_files", "/META-INF/sql/carrega-dados.sql");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        //
        Configuration cfg = new Configuration();
        
        cfg.addProperties(properties);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Abastecimento.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.CategoriaProd.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Fabricante.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Fornecedor.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Pessoa.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Produto.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Usuario.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Veiculo.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Empresa.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Cidade.class);
        cfg.addAnnotatedClass(br.com.faedocaminhoes.model.Estado.class);
        //
        EntityManagerFactory mf = cfg.buildSessionFactory();
        return mf;
    }
    
    public EntityManager getConection(){
        if(emf != null){
            return emf.createEntityManager();
        }
        return null;
    }
    
}
