package DatosEntrada;


import java.util.ArrayList;

/**
 * 
 * @author James Gramajo 
 */
public class ListaCapaCD {
    nodoCapaCD primero;
    nodoCapaCD ultimo;
    int IdCapa;
    int filas;
    int columnas;
    String colors;
    String FORMATO="";                                                                                                                                                                                                                                                          ArrayList<Integer> filaa = new ArrayList<Integer>();

    ArrayList<Integer> columnaa = new ArrayList<Integer>();
    ArrayList<String> colorr = new ArrayList<String>();
    public ListaCapaCD() {
        primero=null;
        ultimo=null;
    }
    public void insertarNodo(int fila, int columna, String color){
        nodoCapaCD nuevo= new nodoCapaCD();
        nuevo.fila=fila;
        nuevo.columna=columna;
        nuevo.color=color;
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
        nodoCapaCD actual= new nodoCapaCD();
        actual=ultimo;
        do{
            if(actual.id==idBuscado){
                
            }
            actual=actual.anterior;
        }while(actual!=ultimo);
        
    }
    public void modificarNodo(int Id_modificar, int newId){
        nodoCapaCD actual= new nodoCapaCD();
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
        nodoCapaCD actual= new nodoCapaCD();
        nodoCapaCD anterior= new nodoCapaCD();
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
        nodoCapaCD actual= new nodoCapaCD();
        actual=primero;
        do{
            
            filas=actual.fila; 
            filaa.add(filas);
            columnas=actual.columna;
            columnaa.add(columnas);
            colors=actual.color;
            colorr.add(colors);
            System.out.println("Capa Id: "+IdCapa+" Linea: "+actual.fila+" Columna: "+actual.columna+" Color: "+actual.color);
            actual=actual.siguiente;
        }while(actual!= primero);
        
    }
    
    public int getIdCapa() {
        return IdCapa;
    }

    public void setIdCapa(int IdCapa) {
        this.IdCapa = IdCapa;
    }

    public int getFila() {
        return filas;
    }

    public void setFila(int fila) {
        this.filas = fila;
    }

    public int getColumna() {
        return columnas;
    }

    public void setColumna(int columna) {
        this.columnas = columna;
    }

    public String getColor() {
        return colors;
    }

    public void setColor(String color) {
        this.colors = color;
    }

    public String getFORMATO() {
        return FORMATO;
    }

    public void setFORMATO(String FORMATO) {
        this.FORMATO = FORMATO;
    }

    public ArrayList<Integer> getFilaa() {
        return filaa;
    }

    public void setFilaa(ArrayList<Integer> filaa) {
        this.filaa = filaa;
    }

    public ArrayList<Integer> getColumnaa() {
        return columnaa;
    }

    public void setColumnaa(ArrayList<Integer> columnaa) {
        this.columnaa = columnaa;
    }

    public ArrayList<String> getColorr() {
        return colorr;
    }

    public void setColorr(ArrayList<String> colorr) {
        this.colorr = colorr;
    }
    
    
    

}
