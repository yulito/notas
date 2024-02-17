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
public class NotaModel {
    private String nota;
    private String apunte;
    
    public NotaModel(){
        //--
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getApunte() {
        return apunte;
    }

    public void setApunte(String apunte) {
        this.apunte = apunte;
    }
    
    public String obtenerQuery(String apunte){
        String sql = "SELECT notas_ FROM notas "
                + "WHERE id_apunte = (SELECT id_apunte FROM apunte WHERE titulo = '"+apunte+"') ORDER BY id_notas DESC";        
        return sql;
    }
}
