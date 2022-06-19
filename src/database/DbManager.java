/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author vusal
 */
public class DbManager {
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties prop = new Properties();
            prop.load(new FileReader("src/resources/config.properties"));
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String passsword = prop.getProperty("db.password");
            Connection con = DriverManager.getConnection(url, username, passsword);
            return con;
        } catch (Exception ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Connection getConnection(String database){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties prop = new Properties();
            prop.load(new FileReader("src/resources/config.properties"));
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String passsword = prop.getProperty("db.password");
            Connection con = DriverManager.getConnection(url+database, username, passsword);
            return con;
        } catch (Exception ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Connection getConnection(String host,String port,String username,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://"+host+":"+port+"/";
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (Exception ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
