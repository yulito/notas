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
import model.ApunteModel;
import model.Model;
import model.NotaModel;
import model.TemaModel;

/**
 *
 * @author yulia
 */
public class ApunteControlador extends Model{
    
    private ApunteModel am;
    
    public ArrayList<ApunteModel> mostrarApuntes(String param1,String param2){
        
        am = new ApunteModel();
        String Qy = am.obtenerQuery(param1,param2);
        
        ArrayList<ApunteModel> objArray = new ArrayList();
        
        try{
            this.pstm = this.con.prepareStatement(Qy);
            this.rs = this.pstm.executeQuery();
            
            while(this.rs.next()){
                am = new ApunteModel();
                
                am.setIdApunte(this.rs.getInt("id_apunte"));
                am.setTema(this.rs.getString("tema_"));
                am.setFecha(this.rs.getString("fecha"));
                am.setTitulo(this.rs.getString("titulo"));
                objArray.add(am);
            }            
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex);
        }finally{
            try {
                this.pstm.close();
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ApunteControlador.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        
        return objArray;
    }
    
    public boolean guardarApunte(String apunte, String tema){        
        String sql = "INSERT INTO apunte (titulo,id_tema)VALUE(?,(SELECT id_tema FROM tema WHERE tema_ = ?))";
        boolean bool = false;         
        try{    
                pstm = con.prepareStatement(sql);
                pstm.setString(1, apunte);
                pstm.setString(2, tema);
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
    
    public boolean eliminarApunte(String apunte) throws SQLException{
        boolean bool = false;
        
        String sql1 = "DELETE FROM notas WHERE id_apunte = "
                + "(SELECT id_apunte FROM apunte WHERE titulo ='"+apunte+"')";
        String sql2 = "DELETE FROM apunte WHERE titulo = '"+apunte+"' ";
        
        try{
            this.pstm = this.con.prepareStatement(sql1);
            this.pstm.executeUpdate();
            
            this.pstm = this.con.prepareStatement(sql2);
            this.pstm.executeUpdate();
                        
            bool = true;       
        }catch(SQLException ex){
            this.con.rollback();
            System.out.println("ERROR: "+ ex);
        }finally{
            try {
                this.pstm.close();                
            } catch (SQLException ex) {
                Logger.getLogger(NotaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        return bool;
    }
}
