/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vusal
 */
public class PropertyManager {
    public static void setProperty(String host,String port,String username,String password){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/resources/config.properties"));
            String url = "jdbc:mysql://"+host+":"+port+"/";
            bw.write("db.url="+url);
            bw.write("\n");
            bw.write("db.username="+username);
            bw.write("\n");
            bw.write("db.password="+password);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void discoverProperty(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/resources/config.properties"));
            bw.write("");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(PropertyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
