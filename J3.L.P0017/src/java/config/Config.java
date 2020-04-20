/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Administrator
 */
public class Config {

    private String databaseName, host, port, image, username, password;

    Config() {
        try {
            InitialContext init = new InitialContext();
            Context cont = (Context) init.lookup("java:/comp/env");
            databaseName = (String) cont.lookup("databaseName");
            host = (String) cont.lookup("host");
            port = (String) cont.lookup("port");
            image = (String) cont.lookup("image");
            username = (String) cont.lookup("username");
            password = (String) cont.lookup("password");
        } catch (Exception ex) {
            throw new RuntimeException("Exception: ", ex);
        }
    }

    public static Config getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
