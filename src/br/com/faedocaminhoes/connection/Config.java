/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faedocaminhoes.connection;

/**
 *
 * @author Poison
 */
public class Config {
    
    private String driver;
    private String dialect;
    private String patch;
    private String user;
    private String pass;

    public Config() {
    }

    public Config(String driver, String dialect, String patch, String user, String pass) {
        this.driver = driver;
        this.dialect = dialect;
        this.patch = patch;
        this.user = user;
        this.pass = pass;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    @Override
    public String toString() {
        return "Config{" + "driver=" + driver + ", dialect=" + dialect + ", patch=" + patch + ", user=" + user + ", pass=" + pass + '}';
    }
    
}
