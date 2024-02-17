/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ApunteModel;
import model.Model;
import model.TemaModel;

/**
 *
 * @author yulia
 */
public class TemaControlador extends Model{
    private TemaModel t;
    ArrayList<TemaModel> arrTema;
    
    public ArrayList<TemaModel> obtenerTemas(){
        t = new TemaModel();
        String Qtm = t.QueryTema();
        arrTema = new ArrayList();
        
        try{
            this.pstm = this.con.prepareStatement(Qtm);
            this.rs = this.pstm.executeQuery();
            
            while(this.rs.next()){
                t = new TemaModel();
                
                t.setIdTema(this.rs.getInt("id_tema"));
                t.setTema(this.rs.getString("tema_"));                
                arrTema.add(t);
            }            
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex);
        }finally{
            try {
                this.pstm.close();
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(TemaModel.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        
        return arrTema;
    }
    
    public boolean guardarTema(String tema){
        String sql = "INSERT INTO tema (tema_)VALUE(?)";
        boolean bool = false;
        try{    
                pstm = con.prepareStatement(sql);
                pstm.setString(1, tema);
                pstm.executeUpdate(); 
                pstm.close();   
                bool = true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.err.print(ex.getErrorCode());
        }finally{
           try{
               pstm.close();               
           }catch(SQLException ex){
               System.out.println("Error en el cierre: " + ex.getMessage());
           }
        }
        return bool;
    }
}
