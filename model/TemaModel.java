/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author yulia
 */
public class TemaModel {
    private int idTema;
    private String tema;
    
    public TemaModel(){
        //--
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String QueryTema(){    
        String sql = "SELECT * FROM tema";        
        return sql;
    }
}
