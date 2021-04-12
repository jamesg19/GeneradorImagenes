/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ListaImagen;

/**
 * 
 * @author James Gramajo 
 */
public class ListaImagen {
    private int IdImagen;
    nodoImagen primero;
    nodoImagen ultimo;

    public ListaImagen() {
        primero=null;
        ultimo=null;
        
        
    }
    
    public void insertarNodoi(int dato){
        nodoImagen nuevoNodo= new nodoImagen();
        //sera el dato del nuevo noto
        nuevoNodo.dato= dato;
        if(primero == null){
                primero = nuevoNodo;
                primero.siguiente=null;
                ultimo=primero;
        } else{
            ultimo.siguiente= nuevoNodo;
            nuevoNodo.siguiente=null;
            ultimo=nuevoNodo;
        }
    
    
    }
    public void modificarNodo(int id,int newId){
        nodoImagen actual = new nodoImagen();
        actual= primero;
        while(actual!=null){
            if(actual.dato==id){
                
                actual.dato=newId;
                //return true;
            }
            actual=actual.siguiente;
            
        }
        //return false;
    }
    public void eliminarNodo(int id){
        nodoImagen actual = new nodoImagen();
        nodoImagen anterior= new nodoImagen();
        
        actual=primero;
        anterior=null;
        
        while(actual!=null){
            if(actual.dato==id){
                if(actual==primero){
                    primero=primero.siguiente;
                    
                }else{
                    anterior.siguiente=actual.siguiente;
                    
                }
                
            }
            anterior=actual;
            actual=actual.siguiente;
        }
        
        
    }
    
    public void  buscarNodo(int id){
        nodoImagen actual= new nodoImagen();
        actual=primero;
        while(actual!=null){
            if(actual.dato==id){
                System.out.println("SE ENCONTRO EL DATO : "+id);
            }
            actual=actual.siguiente;
        }
    }
    
    
    
    
    
    
    
    public void verListaImagen(){
        nodoImagen actual= new nodoImagen();
        actual=primero;
        while(actual!=null){
            System.out.println("El ID es:"+actual.dato);
            actual=actual.siguiente;
        }
    }

    public int getIdImagen() {
        return IdImagen;
    }

    public void setIdImagen(int IdImagen) {
        this.IdImagen = IdImagen;
    }
    
    
    

}
