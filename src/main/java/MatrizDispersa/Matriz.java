/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatrizDispersa;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Matriz {

    private int noCol;
    private int noFil;
    private int menorCol;
    private int menorFil;
    private boolean vacia;
    private Nodo inicio;
    public String inicioGraph = "digraph G{\n"
            + "rankdir=TB; graph [fontsize=10 fontname=\"Verdana\"];\n"
            + "node [shape=box fontsize=10 fontname=\"Verdana\"];";

    public Matriz(int noCol, int noFil) {
        this.noCol = noCol;
        this.noFil = noFil;
        this.vacia = true;
    }

    public Matriz() {
        this.vacia = true;
        this.noCol = 0;
        this.noFil = 0;
        this.menorCol = 300;
        this.menorFil = 300;
        Nodo ne = new Nodo();
        ne.setY(-1);
        ne.setX(-1);
        ne.setAntCol(null);
        ne.setAntFil(null);
        ne.setSigFil(null);
        ne.setSigCol(null);
        this.inicio = ne;
    }

    public void agregar_nodo(String color, int col, int fila) {
        Nodo nuevo = new Nodo(col, fila, color);
        nuevo.setY(fila);
        nuevo.setX(col);
        //valida si la matriz esta completamente vacia
        if (vacia) {
            Nodo row_header = new Nodo("", fila, -1, nuevo, null);
            Nodo col_header = new Nodo("", -1, col, null, nuevo);
            col_header.setAntFil(null);
            col_header.setAntCol(inicio);
            row_header.setAntFil(inicio);
            row_header.setAntCol(null);
            nuevo.setAntCol(row_header);
            nuevo.setAntFil(col_header);
            nuevo.setSigCol(null);
            nuevo.setSigFil(null);
            inicio.setSigCol(col_header);
            inicio.setSigFil(row_header);
            this.vacia = false;
        } else {
            //Valida si la fila que se envia ya tiene un encabezado
            if (!validar_fila(fila)) {
                Nodo temporal = inicio;
                Nodo aux;
                while (temporal.getSigFil() != null) {
                    temporal = temporal.getSigFil();
                    if ((temporal.getSigFil() == null)) {
                        if (fila > temporal.getY()) {
                            Nodo encabezado_fila = new Nodo("", fila, -1, nuevo, null);
                            nuevo.setAntCol(encabezado_fila);
                            nuevo.setSigCol(null);
                            encabezado_fila.setAntFil(temporal);
                            temporal.setSigFil(encabezado_fila);
                            break;
                        } else {
                            aux = temporal.getAntFil();
                            Nodo encabezado_fila = new Nodo();
                            aux.setSigFil(encabezado_fila);
                            encabezado_fila.setY(fila);
                            encabezado_fila.setX(-1);
                            encabezado_fila.setAntFil(aux);
                            encabezado_fila.setAntCol(null);
                            nuevo.setAntCol(encabezado_fila);
                            nuevo.setSigCol(null);
                            encabezado_fila.setSigCol(nuevo);
                            temporal.setAntFil(encabezado_fila);
                            encabezado_fila.setSigFil(temporal);
                            break;
                        }
                    } else {
                        if ((temporal.getY() < fila) && (temporal.getSigFil().getY() > fila)) {
                            Nodo encabezado_fila = new Nodo();
                            aux = temporal.getSigFil();
                            temporal.setSigFil(encabezado_fila);
                            nuevo.setAntCol(encabezado_fila);
                            nuevo.setSigCol(null);
                            aux.setAntFil(encabezado_fila);
                            encabezado_fila.setY(fila);
                            encabezado_fila.setX(-1);
                            encabezado_fila.setAntFil(temporal);
                            encabezado_fila.setAntCol(null);
                            encabezado_fila.setSigFil(aux);
                            encabezado_fila.setSigCol(nuevo);
                            break;
                        }
                    }
                }
            } //Si la fila ya tiene un encabezado ejecuta el siguiente codigo
            else {
                Nodo temporal = inicio;
                //Recorre todas las filas que hay
                while (temporal.getSigFil() != null) {
                    temporal = temporal.getSigFil();
                    if (temporal.getY() == fila) {
                        Nodo temp_columna = temporal;
                        //Si la primera columna que tiene la matriz tiene un id más grande que el enviado
                        if (temp_columna.getSigCol().getX() > col) {
                            nuevo.setSigCol(temp_columna.getSigCol());
                            nuevo.setAntCol(temp_columna);
                            temp_columna.getSigCol().setAntCol(nuevo);
                            temp_columna.setSigCol(nuevo);
                        } else {
                            //Si la siguiente columna del nodo en el que encontramos la posicion es menor o igual
                            while (temp_columna.getSigCol() != null) {
                                if (temp_columna.getX() == col) {
                                    temp_columna.setColor(color);
                                    break;
                                }
                                if ((temp_columna.getX() < col) && ((temp_columna.getSigCol().getX() > col)
                                        || (temp_columna.getSigCol() == null))) {
                                    nuevo.setSigCol(temp_columna.getSigCol());
                                    temp_columna.getSigCol().setAntCol(nuevo);
                                    temp_columna.setSigCol(nuevo);
                                    break;
                                }
                                temp_columna = temp_columna.getSigCol();
                            }
                        }
                    }
                }
            }
            if (!validar_columna(col)) {
                Nodo temp_columna = inicio;
                Nodo aux;
                while (temp_columna.getSigCol() != null) {
                    temp_columna = temp_columna.getSigCol();
                    if (temp_columna.getSigCol() == null) {
                        if (col > temp_columna.getX()) {
                            Nodo columna = new Nodo("", -1, col, null, nuevo);
                            columna.setAntCol(temp_columna);
                            temp_columna.setSigCol(columna);
                            nuevo.setSigFil(null);
                            nuevo.setAntFil(columna);
                            break;
                        } else {
                            aux = temp_columna.getAntCol();
                            Nodo cabeza_columna = new Nodo();
                            aux.setSigCol(cabeza_columna);
                            cabeza_columna.setX(col);
                            cabeza_columna.setY(-1);
                            cabeza_columna.setAntCol(aux);
                            cabeza_columna.setAntFil(null);
                            nuevo.setAntFil(cabeza_columna);
                            nuevo.setSigFil(null);
                            cabeza_columna.setSigFil(nuevo);
                            temp_columna.setAntCol(cabeza_columna);
                            cabeza_columna.setSigCol(temp_columna);
                            break;
                        }
                    } else {
                        if ((temp_columna.getX() < col) && (temp_columna.getSigCol().getX() > col)) {
                            Nodo cabeza_columna = new Nodo();
                            aux = temp_columna.getSigCol();
                            temp_columna.setSigCol(cabeza_columna);
                            nuevo.setAntFil(cabeza_columna);
                            nuevo.setSigFil(null);
                            aux.setAntCol(cabeza_columna);
                            cabeza_columna.setX(col);
                            cabeza_columna.setY(-1);
                            cabeza_columna.setAntCol(temp_columna);
                            cabeza_columna.setAntFil(null);
                            cabeza_columna.setSigCol(aux);
                            cabeza_columna.setSigFil(nuevo);
                            break;
                        }
                    }
                }
            } else {
                Nodo temp_columna = inicio;
                while (temp_columna.getSigCol() != null) {
                    temp_columna = temp_columna.getSigCol();
                    if (temp_columna.getX() == col) {
                        Nodo temp_fila = temp_columna;
                        if (temp_fila.getSigFil().getY() > fila) {
                            nuevo.setSigFil(temp_fila.getSigFil());
                            nuevo.getSigFil().setAntFil(nuevo);
                            nuevo.setAntFil(temp_fila);
                            temp_fila.setSigFil(nuevo);
                        } else {
                            while (temp_fila.getSigFil() != null) {
                                if (temp_fila.getY() == fila) {
                                    temp_fila.setColor(color);
                                    break;
                                }
                                if ((temp_fila.getY() < fila) && ((temp_fila.getSigFil().getY() > fila)
                                        || (temp_fila.getSigFil() == null))) {
                                    nuevo.setSigFil(temp_fila.getSigFil());
                                    nuevo.getSigFil().setAntFil(nuevo);
                                    nuevo.setAntFil(temp_fila);
                                    temp_fila.setSigFil(nuevo);
                                    break;
                                }
                                temp_fila = temp_fila.getSigFil();
                            }
                        }
                    }
                }
            }
        }
    }

    public void agregarNodo(String color, int columna, int fila) {
        Nodo nuevo = new Nodo();
        nuevo.setX(columna);
        nuevo.setY(fila);
        nuevo.setColor(color);
        if (noCol < columna) {
            noCol = columna;
        }
        if (noFil < fila) {
            noFil = fila;
        }
        if (menorCol > columna) {
            menorCol = columna;
        }
        if (menorFil > fila) {
            menorFil = fila;
        }
        if (vacia) {
            Nodo encabezado_columna = new Nodo(columna, -1, "", nuevo, null, null, inicio);
            Nodo encabezado_fila = new Nodo(-1, fila, "", null, inicio, nuevo, null);
            inicio.setSigCol(encabezado_columna);
            inicio.setSigFil(encabezado_fila);
            nuevo.setAntCol(encabezado_fila);
            nuevo.setAntFil(encabezado_columna);
            nuevo.setSigCol(null);
            nuevo.setSigFil(null);
            this.vacia = false;
        } else {
            if (!validar_fila(fila)) {
                Nodo temporal = inicio;
                temporal = temporal.getSigFil();
                while (temporal != null) {
                    if (temporal.getSigFil() != null) {
                        if (temporal.getAntFil() == inicio) {
                            if (temporal.getY() > fila) {
                                Nodo encabezado_fila = new Nodo(-1, fila, "", temporal, temporal.getAntFil(), nuevo, null);
                                temporal.getAntFil().setSigFil(encabezado_fila);
                                temporal.setAntFil(encabezado_fila);
                                nuevo.setAntCol(encabezado_fila);
                                nuevo.setSigCol(null);
                                break;
                            }
                        } else {
                            if (temporal.getY() < fila && temporal.getSigFil().getY() > fila) {
                                Nodo encabezado_fila = new Nodo(-1, fila, "", temporal.getSigFil(), temporal, nuevo, null);
                                temporal.getSigFil().setAntFil(encabezado_fila);
                                temporal.setSigFil(encabezado_fila);
                                nuevo.setAntCol(encabezado_fila);
                                nuevo.setSigCol(null);
                                break;
                            }
                        }
                    } else {
                        if (temporal.getY() > fila) {
                            Nodo encabezado_fila = new Nodo(-1, fila, "", temporal, temporal.getAntFil(), nuevo, null);
                            temporal.getAntFil().setSigFil(encabezado_fila);
                            temporal.setAntFil(encabezado_fila);
                            nuevo.setAntCol(encabezado_fila);
                            nuevo.setSigCol(null);
                        } else {
                            Nodo encabezado_fila = new Nodo(-1, fila, "", null, temporal, nuevo, null);
                            temporal.setSigFil(encabezado_fila);
                            nuevo.setAntCol(encabezado_fila);
                            nuevo.setSigCol(null);
                        }
                        break;
                    }
                    temporal = temporal.getSigFil();
                }
            } else {
                Nodo temporal = inicio;
                temporal = temporal.getSigFil();
                //Recorre todas las filas que hay
                while (temporal != null) {
                    if (temporal.getY() == fila) {
                        Nodo temp_columna = temporal.getSigCol();
                        while (temp_columna != null) {
                            if (temp_columna.getSigCol() != null) {
                                if (temp_columna.getAntCol().getX() == -1) {
                                    if (temp_columna.getX() > columna){
                                        temp_columna.getAntCol().setSigCol(nuevo);
                                        nuevo.setSigCol(temp_columna);
                                        nuevo.setAntCol(temp_columna.getAntCol());
                                        temp_columna.setAntCol(nuevo);
                                        break;
                                    } else if (temp_columna.getX() == columna){
                                        temp_columna.setColor(color);
                                        break;
                                    }
                                } else {
                                    if (temp_columna.getX() < columna && temp_columna.getSigCol().getX() > columna) {
                                        temp_columna.getSigCol().setAntCol(nuevo);
                                        nuevo.setSigCol(temp_columna.getSigCol());
                                        nuevo.setAntCol(temp_columna);
                                        temp_columna.setSigCol(nuevo);
                                        break;
                                    } else if (temp_columna.getX() == columna) {
                                        temp_columna.setColor(color);
                                        break;
                                    }
                                }
                            } else {
                                if (temp_columna.getX() == columna) {
                                    temp_columna.setColor(color);
                                } else {
                                    if (temp_columna.getX() > columna) {
                                        nuevo.setSigCol(temp_columna);
                                        nuevo.setAntCol(temp_columna.getAntCol());
                                        temp_columna.getAntCol().setSigCol(nuevo);
                                        temp_columna.setAntCol(nuevo);
                                    } else {
                                        temp_columna.setSigCol(nuevo);
                                        nuevo.setAntCol(temp_columna);
                                        nuevo.setSigCol(null);
                                    }
                                }
                                break;
                            }
                            temp_columna = temp_columna.getSigCol();
                        }
                        break;
                    } else {
                        temporal = temporal.getSigFil();
                    }
                }
            }

            if (!validar_columna(columna)) {
                Nodo temporal = inicio;
                temporal = temporal.getSigCol();
                while (temporal != null) {
                    if (temporal.getSigCol() != null) {
                        if (temporal.getAntCol() == inicio) {
                            if (temporal.getX() > columna) {
                                Nodo encabezado_columna = new Nodo(columna, -1, "", nuevo, null, temporal, temporal.getAntCol());
                                temporal.getAntCol().setSigCol(encabezado_columna);
                                temporal.setAntCol(encabezado_columna);
                                nuevo.setAntFil(encabezado_columna);
                                nuevo.setSigFil(null);
                                break;
                            }
                        } else {
                            if (temporal.getX() < columna && temporal.getSigCol().getX() > columna) {
                                Nodo encabezado_columna = new Nodo(columna, -1, "", nuevo, null, temporal.getSigCol(), temporal);
                                temporal.getSigCol().setAntCol(encabezado_columna);
                                temporal.setSigCol(encabezado_columna);
                                nuevo.setAntFil(encabezado_columna);
                                nuevo.setSigFil(null);
                                break;
                            }
                        }
                    } else {
                        if (temporal.getX() > columna) {
                            Nodo encabezado_columna = new Nodo(columna, -1, "", nuevo, null, temporal, temporal.getAntCol());
                            temporal.getAntCol().setSigCol(encabezado_columna);
                            temporal.setAntCol(encabezado_columna);
                            nuevo.setAntFil(encabezado_columna);
                            nuevo.setSigFil(null);
                        } else {
                            Nodo encabezado_columna = new Nodo(columna, -1, "", nuevo, null, null, temporal);
                            temporal.setSigCol(encabezado_columna);
                            nuevo.setAntFil(encabezado_columna);
                            nuevo.setSigFil(null);
                        }
                        break;
                    }
                    temporal = temporal.getSigCol();
                }
            } else {
                Nodo temporal = inicio;
                temporal = temporal.getSigCol();
                //Recorre todas las filas que hay
                while (temporal != null) {
                    if (temporal.getX() == columna) {
                        Nodo temp_fila = temporal.getSigFil();
                        while (temp_fila != null) {
                            if (temp_fila.getSigFil() != null) {
                                if (temp_fila.getAntFil().getY() == -1) {
                                    if (temp_fila.getY() > fila) {
                                        nuevo.setAntFil(temp_fila.getAntFil());
                                        nuevo.setSigFil(temp_fila);
                                        temp_fila.getAntFil().setSigFil(nuevo);
                                        temp_fila.setAntFil(nuevo);
                                        break;
                                    } else if (temp_fila.getY() == fila){
                                        temp_fila.setColor(color);
                                        break;
                                    }
                                } else {
                                    if (temp_fila.getY() < fila && temp_fila.getSigFil().getY() > fila) {
                                        nuevo.setAntFil(temp_fila);
                                        nuevo.setSigFil(temp_fila.getSigFil());
                                        temp_fila.getSigFil().setAntFil(nuevo);
                                        temp_fila.setSigFil(nuevo);
                                        break;
                                    } else if (temp_fila.getY() == fila) {
                                        temp_fila.setColor(color);
                                        break;
                                    }
                                }
                            } else {
                                if (temp_fila.getY() == fila) {
                                    temp_fila.setColor(color);
                                    break;
                                } else {
                                    if (temp_fila.getY() > fila) {
                                        nuevo.setSigFil(temp_fila);
                                        nuevo.setAntFil(temp_fila.getAntFil());
                                        temp_fila.getAntFil().setSigFil(nuevo);
                                        temp_fila.setAntFil(nuevo);
                                    } else {
                                        nuevo.setSigFil(null);
                                        nuevo.setAntFil(temp_fila);
                                        temp_fila.setSigFil(nuevo);
                                    }
                                    break;
                                }
                            }
                            temp_fila = temp_fila.getSigFil();
                        }
                        break;
                    } else {
                        temporal = temporal.getSigCol();
                    }
                }
            }
        }
    }

    public String obtener_color(int columna, int fila) {
        String color = "null";
        Nodo temporal_fila = inicio;
        while (temporal_fila.getSigFil() != null) {
            temporal_fila = temporal_fila.getSigFil();
            if (temporal_fila.getY() == fila) {
                Nodo temporal_columna = temporal_fila;
                while (temporal_columna.getSigCol() != null) {
                    temporal_columna = temporal_columna.getSigCol();
                    if (temporal_columna.getX() == columna) {
                        color = temporal_columna.getColor();
                        break;
                    }
                }
                break;
            }
        }
        return color;
    }

    public boolean validar_fila(int fila) {
        if (vacia) {
            return false;
        }
        Nodo temporal = inicio;
        while (temporal.getSigFil() != null) {
            temporal = temporal.getSigFil();
            if (temporal.getY() == fila) {
                return true;
            }
        }
        return false;
    }

    public boolean validar_columna(int col) {
        if (vacia) {
            return false;
        }
        Nodo temporal = inicio;
        while ((temporal.getSigCol() != null)) {
            temporal = temporal.getSigCol();
            if (temporal.getX() == col) {
                return true;
            }
        }
        return false;

    }

    public void printShort() {
        Nodo temporal_fila = inicio;
        while (temporal_fila.getSigFil() != null) {
            temporal_fila = temporal_fila.getSigFil();
            printRowValues(temporal_fila.getY());
            System.out.println("");
        }
    }

    public String escribir_todos() {
        ArrayList<ArrayList<String>> coleccion_filas = new ArrayList<>();
        ArrayList<ArrayList<String>> coleccion_columnas = new ArrayList<>();
        ArrayList<String> first = new ArrayList<>();
        String texto = inicioGraph + "\n";
        texto += "nodeMatriz[label = \"MATRIZ\"];\n";
        first.add("nodeMatriz");
        Nodo columnas = inicio;
        while (columnas.getSigCol() != null) {
            columnas = columnas.getSigCol();
            if (columnas.getY() == -1) {
                texto += "nodeC" + columnas.getX() + "[label = \"" + columnas.getX() + "\"];\n";
                first.add("nodeC" + columnas.getX());
            }
        }
        coleccion_filas.add(first);
        Nodo filas = inicio.getSigFil();
        while (filas != null) {
            ArrayList<String> tp = new ArrayList<>();
            Nodo fil_col = filas;
            while (fil_col != null) {
                if (fil_col.getX() == -1) {
                    texto += "nodeF" + fil_col.getY() + "[label = \"" + fil_col.getY() + "\"];\n";
                    tp.add("nodeF" + fil_col.getY());
                } else {
                    texto += "node" + fil_col.getX() + "_" + fil_col.getY() + "[label = \"" + fil_col.getColor() + "\"];\n";
                    tp.add("node" + fil_col.getX() + "_" + fil_col.getY());
                }
                fil_col = fil_col.getSigCol();
            }
            filas = filas.getSigFil();
            coleccion_filas.add(tp);
        }
        Nodo cols = inicio;
        while (cols != null) {
            ArrayList<String> tp = new ArrayList<>();
            Nodo co = cols;
            while (co != null) {
                if (co.getX() == -1 && co.getY() == -1) {
                    tp.add("nodeMatriz");
                } else {
                    if (co.getX() == -1) {
                        tp.add("nodeF" + co.getY());
                    } else if (co.getY() == -1) {
                        tp.add("nodeC" + co.getX());
                    } else {
                        tp.add("node" + co.getX() + "_" + co.getY());
                    }
                }
                co = co.getSigFil();
            }
            cols = cols.getSigCol();
            coleccion_columnas.add(tp);
        }
        for (int i = 0; i < coleccion_filas.size(); i++) {
            texto += relaciones(coleccion_filas.get(i), true);
        }
        for (int i = 0; i < coleccion_columnas.size(); i++) {
            texto += relaciones(coleccion_columnas.get(i), false);
        }
        texto += "}";
        return texto;
    }

    public String relaciones(ArrayList<String> first, boolean fil) {
        String retorno = "";
        for (int i = 0; i < first.size(); i++) {
            if ((i + 1) == first.size()) {
                retorno += first.get(i) + ";\n";
            } else {
                retorno += first.get(i) + " -> ";
            }
        }
        for (int i = (first.size() - 1); i >= 0; i--) {
            if (i == 0) {
                if (first.get(i).equalsIgnoreCase("nodeMatriz")) {
                    retorno = retorno.substring(0, retorno.length() - 2) + ";\n";
                } else {
                    retorno += first.get(i) + ";\n";
                }
            } else {
                retorno += first.get(i) + "->";
            }
        }
        if (fil) {
            retorno += "{rank = same; ";
            for (int i = 0; i < first.size(); i++) {
                if ((i + 1) == first.size()) {
                    retorno += first.get(i) + ";}\n";
                } else {
                    retorno += first.get(i) + "; ";
                }
            }
        }
        return retorno;
    }

    //Display, in short form, values represented by nodes from one row.
    public void printRowValues(int fila) {
        //if there is no row of that value there is nothing to return
        if (!validar_fila(fila)) {
            return;
        }
        Nodo temporal_fila = inicio;
        while (temporal_fila.getY() != fila) {
            temporal_fila = temporal_fila.getSigFil();
        }
        Nodo temporal_columna = temporal_fila;
        while (temporal_columna.getSigCol() != null) {
            temporal_columna = temporal_columna.getSigCol();
            System.out.print("   (" + temporal_columna.getX() + ", "
                    + temporal_columna.getY() + "):"
                    + temporal_columna.getColor() + "\t\t");
        }
    }

    public int getNoCol() {
        return noCol;
    }

    public void setNoCol(int noCol) {
        this.noCol = noCol;
    }

    public int getNoFil() {
        return noFil;
    }

    public void setNoFil(int noFil) {
        this.noFil = noFil;
    }
    
    public Matriz obtener(){
        Matriz retorno = new Matriz();
        Nodo nueva_matriz = inicio;
        while(nueva_matriz.getSigFil()!=null){
            nueva_matriz = nueva_matriz.getSigFil();
            Nodo columna = nueva_matriz;
            while (columna.getSigCol()!=null){
                columna = columna.getSigCol();
                retorno.agregarNodo(columna.getColor(),columna.getX(),columna.getY());
            }
        }
        return retorno;
    }
    
    public void sumar_matriz(Matriz m){
        Nodo nueva_matriz = m.inicio;
        while(nueva_matriz.getSigFil()!=null){
            nueva_matriz = nueva_matriz.getSigFil();
            Nodo columna = nueva_matriz;
            while (columna.getSigCol()!=null){
                columna = columna.getSigCol();
                agregarNodo(columna.getColor(),columna.getX(),columna.getY());
            }
        }
    }

    public int getMenorCol() {
        return menorCol;
    }

    public void setMenorCol(int menorCol) {
        this.menorCol = menorCol;
    }

    public int getMenorFil() {
        return menorFil;
    }

    public void setMenorFil(int menorFil) {
        this.menorFil = menorFil;
    }

    
}