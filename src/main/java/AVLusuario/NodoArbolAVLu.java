/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AVLusuario;

import AVLcapa.*;

/**
 * 
 * @author James Gramajo 
 */
public class NodoArbolAVLu {
    int dato;
    String nombre;
    int fe;
    NodoArbolAVLu hijoIzquierdo;
    NodoArbolAVLu hijoDerecho;

    public NodoArbolAVLu(int dato, String nombre) {
        this.dato=dato;
        this.nombre=nombre;
        this.fe=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
    

}
