/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author yulia
 */
public class Model {
    //objeto conexion de la clase Conection
    private DataBase obj = new DataBase();
    protected Connection con;
    //para las queries
    protected PreparedStatement pstm;
    protected ResultSet rs;
    
    //constructor
    public Model(){        
        this.con = this.obj.getConnection();        
    }
}
