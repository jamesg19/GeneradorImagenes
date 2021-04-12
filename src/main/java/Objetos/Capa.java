/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

/**
 * 
 * @author James Gramajo 
 */
public class Capa {
    private String id;
    private int fila;
    private int columna;
    private String color;

    public Capa(String id, int fila, int columna, String color) {
        this.id = id;
        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    public Capa() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
    
    
    

}
