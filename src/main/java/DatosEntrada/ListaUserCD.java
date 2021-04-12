/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatosEntrada;

import CircularDoble.*;

public class ListaUserCD {
    nodoUserCD primero;
    nodoUserCD ultimo;
    String IdUser;
    int Id;
    String FORMATO_LISTA_IMG="";

    public ListaUserCD() {
        primero=null;
        ultimo=null;
    }
    public void insertarNodo(String newId){
        nodoUserCD nuevo= new nodoUserCD();
        nuevo.id=newId;
        if(primero ==null){
            primero=nuevo;
            primero.siguiente=primero;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
            
        }else{
            ultimo.siguiente=nuevo;
            nuevo.siguiente=primero;
            nuevo.anterior=ultimo;
            ultimo=nuevo;
            primero.anterior=ultimo;
        }
    }
    public void buscarNodo(String idBuscado){
        nodoUserCD actual= new nodoUserCD();
        actual=ultimo;
        do{
            if(actual.id==idBuscado){
                
            }
            actual=actual.anterior;
        }while(actual!=ultimo);
        
    }
    public void modificarNodo(String Id_modificar, String newId){
        nodoUserCD actual= new nodoUserCD();
        actual=primero;
        do{
            if(actual.id==Id_modificar){
                System.out.println("SE ENCONTRO EL NODO "+Id_modificar);
                System.out.println("SE MODIFICO POR ID NUEVO: "+newId);
                actual.id=newId;
            }
            actual=actual.siguiente;
        }while(actual!=primero);
    }
    public void eliminarNodo(String id_eliminar){
        nodoUserCD actual= new nodoUserCD();
        nodoUserCD anterior= new nodoUserCD();
        actual=primero;
        anterior= ultimo;
        do{
            if(actual.id==id_eliminar){
                System.out.println("SE ELIMINO EL NODO: "+id_eliminar);
                if(actual==primero){
                    primero=primero.siguiente;
                    ultimo.siguiente=ultimo;
                    primero.anterior=ultimo;
                    
                }else if(actual==ultimo){
                    
                        ultimo=anterior;
                        primero.anterior=ultimo;
                        ultimo.siguiente=primero;
                        
                    
                } else{
                    anterior.siguiente=actual.siguiente;
                    actual.siguiente.anterior=anterior;
                    
                    
                }
                
            }
            anterior=actual;
            actual=actual.siguiente;
        } while(actual!=primero);
        
    }
    public void mostrarLista(){
        nodoUserCD actual= new nodoUserCD();
        actual=primero;
        //FORMATO_LISTA_IMG+="digraph G { ";
        System.out.print("ID imagen: "+IdUser+" Capas ");
        do{
            if(actual!=null){
            System.out.print(""+actual.id+", ");
            //FORMATO_LISTA_IMG+="actual.id";
            actual=actual.siguiente;
            }
        }while(actual!= primero);
        System.out.println("");
        //FORMATO_LISTA_IMG+="} ";
        
    }
    public void procesarListaImagen(){
        nodoUserCD actual= new nodoUserCD();
        actual=primero;
        do{
            if(actual!=null){
            System.out.print(""+actual.id+", ");
            FORMATO_LISTA_IMG+="Capa_"+actual.id+" ->Capa_"+actual.siguiente.id+";\n";
            actual=actual.siguiente;
            }
            
            
        }while(actual!= primero);
        
        
    }
    public void mostrarLista1(){
        nodoUserCD actual= new nodoUserCD();
        actual=primero;
        
        System.out.print("ID usuario: "+IdUser+" Imagen ");
        FORMATO_LISTA_IMG+="Imagen_"+IdUser+"->\"Capa "+actual.id+"\n Imagen_"+IdUser+"\";\n";
        do{
            System.out.print(""+actual.id+", ");
            FORMATO_LISTA_IMG+="\"Capa "+actual.id+"\n Imagen_"+IdUser+"\"->";
            FORMATO_LISTA_IMG+="\"Capa "+actual.siguiente.id+"\n Imagen_"+IdUser+"\"\n";
            actual=actual.siguiente;
        }while(actual!= primero);
        
        
    }

    public String getIdUsuario() {
        return IdUser;
    }

    public void setIdUsuario(String IdUser) {
        this.IdUser = IdUser;
    }

    public String getFORMATO_LISTA_IMG() {
        return FORMATO_LISTA_IMG;
    }

    public void setFORMATO_LISTA_IMG(String FORMATO_LISTA_IMG) {
        this.FORMATO_LISTA_IMG = FORMATO_LISTA_IMG;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

}
