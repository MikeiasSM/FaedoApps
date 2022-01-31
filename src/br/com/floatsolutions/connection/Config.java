/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.connection;

/**
 *
 * @author Poison
 */
public class Config {
    
    private String driver;
    private String dialect;
    private String host;
    private String port;
    private String data;
    private String user;
    private String pass;
    private String strategy_bkp;

    public Config() {
    }

    public Config(String driver, String dialect, String host, String port, String data, String user, String pass, String strategy_bkp) {
        this.driver = driver;
        this.dialect = dialect;
        this.host = host;
        this.port = port;
        this.data = data;
        this.user = user;
        this.pass = pass;
        this.strategy_bkp = strategy_bkp;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getStrategy_bkp() {
        return strategy_bkp;
    }

    public void setStrategy_bkp(String strategy_bkp) {
        this.strategy_bkp = strategy_bkp;
    }

    @Override
    public String toString() {
        return "Config{" + "driver=" + driver + ", dialect=" + dialect + ", host=" + host + ", port=" + port + ", data=" + data + ", user=" + user + ", pass=" + pass + ", strategy_bkp=" + strategy_bkp + '}';
    }
    
}
