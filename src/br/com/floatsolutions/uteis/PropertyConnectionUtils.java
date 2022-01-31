/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.uteis;

import br.com.floatsolutions.connection.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Poison
 */
public class PropertyConnectionUtils {
    
    
    public static Config propertyService(){
        File file = new File("C:\\Next\\config.properties");
        if (file.exists()) {
            return lerPropriedades();
        } else {
            Config config = new Config("org.postgresql.Driver", 
                                       "org.hibernate.dialect.PostgreSQLDialect", 
                                       "localhost", 
                                       "5432", 
                                       "database", 
                                       "postgres", 
                                       "postgres", 
                                       "DIA");
            criarPropriedades(config);
            
            return lerPropriedades();
        }
    }
    
    public static void criarPropriedades(Config config) {
        //Cria um objeto da classe java.util.Properties
        Properties properties = new Properties();

        //setando as propriedades(key) e os seus valores(value)
        properties.setProperty("DATA.DRIVER", config.getDriver());
        properties.setProperty("DATA.DIALECT", config.getDialect());
        properties.setProperty("DATA.HOST", config.getHost());
        properties.setProperty("DATA.PORT", config.getPort());
        properties.setProperty("DATA.BASE", config.getData());
        properties.setProperty("DATA.USER", config.getUser());
        properties.setProperty("DATA.PASSWORD", config.getPass());
        properties.setProperty("DATA.STRATEGY.BKP", config.getStrategy_bkp());

        try {
            //Criamos um objeto FileOutputStream        
            FileOutputStream fos = new FileOutputStream("C:\\Next\\config.properties");
            //grava os dados no arquivo
            properties.store(fos, "FILE CONFIGURATION PROPERTIES:");
            //fecha o arquivo
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static void alteraPropriedades(Config config) {
        //Cria um objeto da classe java.util.Properties
        Properties properties = new Properties();

        //Alterando Parametros
        try {
            //Pegando properties
            FileOutputStream out = new FileOutputStream("C:\\Next\\config.properties");
            //Alterando propriedades
            properties.setProperty("DATA.DRIVER", config.getDriver());
            properties.setProperty("DATA.DIALECT", config.getDialect());
            properties.setProperty("DATA.HOST", config.getHost());
            properties.setProperty("DATA.PORT", config.getPort());
            properties.setProperty("DATA.BASE", config.getData());
            properties.setProperty("DATA.USER", config.getUser());
            properties.setProperty("DATA.PASSWORD", config.getPass());
            properties.setProperty("DATA.STRATEGY.BKP", config.getStrategy_bkp());
            //Alterando properties
            properties.store(out, "FILE CONFIGURATION PROPERTIES:");
            //Fechando properties
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public static Config lerPropriedades() {
        //Cria um objeto da classe java.util.Properties
        Properties properties = new Properties();
        Config config = new Config();
        
        try {
            String src = "C:\\Next\\config.properties";
            File file = new File(src);
            //Setamos o arquivo que vai ser lido
            FileInputStream fis = new FileInputStream(file);
            //metodo load faz a leitura atraves do objeto fis
            properties.load(fis);
            //Captura o valor da propriedade, atraves do nome da propriedade(Key)
            config.setDriver(properties.getProperty("DATA.DRIVER"));
            config.setDialect(properties.getProperty("DATA.DIALECT"));
            config.setHost(properties.getProperty("DATA.HOST"));
            config.setPort(properties.getProperty("DATA.PORT"));
            config.setData(properties.getProperty("DATA.BASE"));
            config.setUser(properties.getProperty("DATA.USER"));
            config.setPass(properties.getProperty("DATA.PASSWORD"));
            config.setStrategy_bkp(properties.getProperty("DATA.STRATEGY.BKP"));

            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return config;
        }
    }
}
