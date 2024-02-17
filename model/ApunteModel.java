/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yulia
 */
public class ApunteModel{
    private int idApunte;
    private String titulo;
    private String fecha;
    private String tema;
    
    public ApunteModel(){
        //...
    }

    public int getIdApunte() {
        return idApunte;
    }

    public void setIdApunte(int idApunte) {
        this.idApunte = idApunte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    
    
    public String obtenerQuery(String tema, String titulo){
        String sql = "SELECT id_apunte, titulo,fecha,tema_\n" +
                      "FROM apunte LEFT OUTER JOIN tema USING(id_tema)\n" +
                      "WHERE tema_ = '"+tema+"' ";
        if(!titulo.isEmpty()){
            sql += "AND titulo LIKE '%"+titulo+"%' ";
        } 
        sql += " ORDER BY id_apunte DESC LIMIT 20;";
        return sql;
    }
}
