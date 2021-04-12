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
public class ArbolAVLu {
    private NodoArbolAVLu raiz;
    private String FORMATO_INORDEN="\"AVL\";\n";
    private String FORMATO_POSTORDEN="\"AVL\";\n";
    private String FORMATO_PREORDEN="\"AVL\";\n";
    
    public ArbolAVLu() {
        raiz=null;
    }
    public NodoArbolAVLu obtenerRaiz(){
        return raiz;
    }
    
    //buscar
    public NodoArbolAVLu buscar(int d, NodoArbolAVLu r){
        if(raiz==null){
            return null;
        } else if(r.dato==d){
            return r;
            
        } else if(r.dato<d){
            return buscar(d,r.hijoDerecho);
        } else{
            return buscar(d,r.hijoIzquierdo);
        }
       
        
    }
     //obtener factor equilibrio
    public int obtenerFE(NodoArbolAVLu x){
        
        
        if(x==null){
            return-1;
        } else{
            return x.fe;
        }
 
    }
    /**
     * ROTACION IZQUIERDA
     * @param c
     * @return 
     */
    public NodoArbolAVLu rotacionIzquierda(NodoArbolAVLu c){
        NodoArbolAVLu auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
    
        return auxiliar;
    
    }
    
    public NodoArbolAVLu rotacionDerecha(NodoArbolAVLu c){
        //cambio los punteros
        NodoArbolAVLu auxiliar=c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
    
        return auxiliar;
    
    }
    /**
     * ROTACION DOBLE IZQUIERDA
     * @param c
     * @return 
     */
    public NodoArbolAVLu rotacionDobleIzquierda(NodoArbolAVLu c){
        NodoArbolAVLu temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    /**
     * ROTACION DOBLE DERECHA
     * @param c
     * @return 
     */
    public NodoArbolAVLu rotacionDobleDerecha(NodoArbolAVLu c){
        NodoArbolAVLu temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    
    public NodoArbolAVLu insertarAVL(NodoArbolAVLu nuevo,NodoArbolAVLu subAr ){
        NodoArbolAVLu nuevoPadre=subAr;
        
        if(nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
                
            }else{
                
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2)){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }

                }

            }
          

        } else if(nuevo.dato>subAr.dato){
            
            
            if(subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
                
            }else{
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
                    
                    if(nuevo.dato>subAr.hijoDerecho.dato){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                    
                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }
        
        //actualiza la altura
        if((subAr.hijoIzquierdo==null)&& (subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        } else if((subAr.hijoDerecho==null)&& (subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        } else{
            subAr.fe=Math.max( obtenerFE(subAr.hijoIzquierdo),obtenerFE(subAr.hijoDerecho))+1;
        }
        
        return nuevoPadre;
    }
    /**
     * METODO PARAINSERTAR
     */
    public void insertar(int d, String nombre){
        
        NodoArbolAVLu nuevo=new NodoArbolAVLu(d, nombre);
        //System.out.println("LLEGA "+d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
       
    }
    //recorrido
    public void inOrden(NodoArbolAVLu r){
        if(r!=null){
            inOrden(r.hijoIzquierdo);
            
            //System.out.print(""+r.dato+", ");
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                FORMATO_INORDEN+="Usuario_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                FORMATO_INORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
            }
            inOrden(r.hijoDerecho);
        }
    }
    
    public void preOrden(NodoArbolAVLu r){
        
                if(r!=null){
            
            //System.out.print(""+r.dato+", ");
            
            
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
                System.out.println(r.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
                FORMATO_PREORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
                FORMATO_PREORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                
            }
            
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }

    }
    public void postOrden(NodoArbolAVLu r){
        
        if(r!=null){
            
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                FORMATO_POSTORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                FORMATO_POSTORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
//                System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
//                System.out.println(r.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
            }
            //System.out.print(""+r.dato+", ");
        }
    }

    public NodoArbolAVLu getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolAVLu raiz) {
        this.raiz = raiz;
    }

    public String getFORMATO_INORDEN() {
        return FORMATO_INORDEN;
    }

    public void setFORMATO_INORDEN(String FORMATO_INORDEN) {
        this.FORMATO_INORDEN = FORMATO_INORDEN;
    }

    public String getFORMATO_POSTORDEN() {
        return FORMATO_POSTORDEN;
    }

    public void setFORMATO_POSTORDEN(String FORMATO_POSTORDEN) {
        this.FORMATO_POSTORDEN = FORMATO_POSTORDEN;
    }

    public String getFORMATO_PREORDEN() {
        return FORMATO_PREORDEN;
    }

    public void setFORMATO_PREORDEN(String FORMATO_PREORDEN) {
        this.FORMATO_PREORDEN = FORMATO_PREORDEN;
    }
    
    
    
    
    
    

}
