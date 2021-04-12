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
public class ArbolAVL {
    private NodoArbolAVL raiz;
    private String FORMATO_INORDEN="\"AVL\";\n";
    private String FORMATO_POSTORDEN="\"AVL\";\n";
    private String FORMATO_PREORDEN="\"AVL\";\n";
    
    public ArbolAVL() {
        raiz=null;
    }
    public NodoArbolAVL obtenerRaiz(){
        return raiz;
    }
    
    //buscar
    public NodoArbolAVL buscar(int d, NodoArbolAVL r){
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
    public int obtenerFE(NodoArbolAVL x){
        
        
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
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
        NodoArbolAVL auxiliar=c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
    
        return auxiliar;
    
    }
    
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
        //cambio los punteros
        NodoArbolAVL auxiliar=c.hijoDerecho;
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
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
        NodoArbolAVL temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    /**
     * ROTACION DOBLE DERECHA
     * @param c
     * @return 
     */
    public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
        NodoArbolAVL temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    
    public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo,NodoArbolAVL subAr ){
        NodoArbolAVL nuevoPadre=subAr;
        
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
    public void insertar(int d){
        NodoArbolAVL nuevo=new NodoArbolAVL(d);
        //System.out.println("LLEGA "+d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
       
    }
    //recorrido
    public void inOrden(NodoArbolAVL r){
        if(r!=null){
            inOrden(r.hijoIzquierdo);
            
            //System.out.print(""+r.dato+", ");
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                FORMATO_INORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
                FORMATO_INORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
            }
            inOrden(r.hijoDerecho);
        }
    }
    
    public void preOrden(NodoArbolAVL r){
        
                if(r!=null){
            
            //System.out.print(""+r.dato+", ");
            
            
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
                System.out.println(r.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
                FORMATO_PREORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                FORMATO_PREORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
                
                
            }
            
            preOrden(r.hijoIzquierdo);
            preOrden(r.hijoDerecho);
        }

    }
    public void postOrden(NodoArbolAVL r){
        
        if(r!=null){
            
            postOrden(r.hijoIzquierdo);
            postOrden(r.hijoDerecho);
            
            if(r.hijoIzquierdo!=null && r.hijoDerecho!=null ){
                FORMATO_POSTORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoIzquierdo.dato+";\n";
                FORMATO_POSTORDEN+="Capa_"+r.dato+"->"+"Capa_"+r.hijoDerecho.dato+";\n";
                
//                System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
//                System.out.println(r.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.hijoIzquierdo.dato+"->"+r.hijoDerecho.dato+";");
                //System.out.println(r.dato+"->"+r.hijoIzquierdo.dato+";");
            }
            //System.out.print(""+r.dato+", ");
        }
    }

    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolAVL raiz) {
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
