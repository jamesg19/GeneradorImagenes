/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AVLcapa;

/**
 * 
 * @author James Gramajo 
 */
public class NodoArbolAVL {
    int dato;
    int fe;
    NodoArbolAVL hijoIzquierdo;
    NodoArbolAVL hijoDerecho;

    public NodoArbolAVL(int dato) {
        this.dato=dato;
        this.fe=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
    

}
