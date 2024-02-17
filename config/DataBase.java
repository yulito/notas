/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yulia
 */
public class DataBase {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String myDB = "jdbc:mysql://localhost:3306/notadb";            
            String usuario = "root";
            String password = "";
            Connection con = DriverManager.getConnection(myDB,usuario,password);
            return con;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex){
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
