/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CircularDoble;

/**
 * 
 * @author James Gramajo 
 */
public class CircularImagenTitle {
    nodoCD primero;
    nodoCD ultimo;
    String FormatoTITLEimagen="";

    public CircularImagenTitle() {
        primero=null;
        ultimo=null;
    }
    public void insertarNodo(int newId){
        nodoCD nuevo= new nodoCD();
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
    public void buscarNodo(int idBuscado){
        nodoCD actual= new nodoCD();
        actual=ultimo;
        do{
            if(actual.id==idBuscado){
                
            }
            actual=actual.anterior;
        }while(actual!=ultimo);
        
    }
    public void modificarNodo(int Id_modificar, int newId){
        nodoCD actual= new nodoCD();
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
    public void eliminarNodo(int id_eliminar){
        nodoCD actual= new nodoCD();
        nodoCD anterior= new nodoCD();
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
        nodoCD actual= new nodoCD();
        actual=primero;
        do{
            System.out.println(actual.id);
            FormatoTITLEimagen+="\n";
            FormatoTITLEimagen+="Imagen_"+actual.id+"->Imagen_"+actual.siguiente.id+"; ID=Imagen_"+actual.id+" ";
            FormatoTITLEimagen+="\n";
            FormatoTITLEimagen+="Imagen_"+actual.siguiente.id+"->Imagen_"+actual.id+"; ID=Imagen_"+actual.id+" ";
            actual=actual.siguiente;
        }while(actual!= primero);
        
    }

    public String getFormatoTITLEimagen() {
        return FormatoTITLEimagen;
    }

    public void setFormatoTITLEimagen(String FormatoTITLEimagen) {
        this.FormatoTITLEimagen = FormatoTITLEimagen;
    }
    
    
    

}
