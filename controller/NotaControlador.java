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
import model.Model;
import model.NotaModel;

/**
 *
 * @author yulia
 */
public class NotaControlador extends Model{
    
    private NotaModel nm;
    
    public boolean guardarNota(String apunte, String nota){
        String sql = "INSERT INTO notas (notas_,id_apunte)VALUE(?,(SELECT id_apunte FROM apunte WHERE titulo = ?))";
        boolean bool = false;         
        try{    
                pstm = con.prepareStatement(sql);
                pstm.setString(1, nota);
                pstm.setString(2, apunte);
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
    
    public ArrayList<NotaModel> mostrarNotas(String param1){
        
        nm = new NotaModel();
        String Qy = nm.obtenerQuery(param1);
        
        ArrayList<NotaModel> objArray = new ArrayList();
        
        try{
            this.pstm = this.con.prepareStatement(Qy);
            this.rs = this.pstm.executeQuery();
            
            while(this.rs.next()){
                nm = new NotaModel();                                
                nm.setNota(this.rs.getString("notas_"));               
                //System.out.println(this.rs.getString("notas_"));
                objArray.add(nm);
            }            
        }catch(SQLException ex){
            System.out.println("ERROR: "+ ex);
        }finally{
            try {
                this.pstm.close();
                this.rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(NotaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }
        
        return objArray;
    }
    
    public boolean eliminarNota(String nota){
    
        String sql = "DELETE FROM notas WHERE notas_ = '"+nota+"'";
        boolean bool = false;
        try{
            this.pstm = this.con.prepareStatement(sql);
            this.pstm.executeUpdate();
            bool = true;       
        }catch(SQLException ex){
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
