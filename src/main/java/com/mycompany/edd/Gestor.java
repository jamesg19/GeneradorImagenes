/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.edd;

import AVLcapa.ArbolAVL;
import Analizadores.*;
import AnalizadoresCapa.parserCapa;
import AnalizadoresUsuario.LexerCupU;
import AnalizadoresUsuario.parserU;
import Archivo.Archivos;
import CircularDoble.CircularImagenTitle;
import DatosEntrada.*;
import MatrizDispersa.SparseMatrix;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 * 
 * @author James Gramajo 
 */
public class Gestor {
    ListaImagenCD lstImagen= new ListaImagenCD();
    ListaImagenCD arrayObjetos[]=new ListaImagenCD[300];
    ListaCapaCD lstCapa= new ListaCapaCD();
    ListaCapaCD arrayObjetosC[]=new ListaCapaCD[300];
    CircularImagenTitle ab= new CircularImagenTitle();
    ListaUserCD arrayObjetosU[]=new ListaUserCD[300];
    ArbolAVL arbol=new ArbolAVL();
    public static SparseMatrix matriz_capa;
    
    JTextArea a;  
        
        public void analizar(String codigo, JTextArea a){
            this.a=a;
          try {
              

            StringReader entrada= new StringReader(codigo);
            LexerCup lex= new LexerCup(entrada);
            parser parse= new parser(lex);
            parse.parse();
            //arrayObjetos=parse.getArrayImagen();
            arrayObjetosC=parse.getArrayCapa();
            //a();
            
        } catch (Exception ex) {
            a.append("HAY ERRORES ENLA GRAMATICA DE IMAGENES");
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        public void analizarCapa(String codigo, JTextArea a){
            
          try {
              

            StringReader entrada= new StringReader(codigo);
            LexerCup lex= new LexerCup(entrada);
            parserCapa parse= new parserCapa(lex);
            parse.parse();
            
            arrayObjetosC=parse.getArrayCapa();
            b();
            
        } catch (Exception ex) {
            a.append("HAY ERRORES ENLA GRAMATICA DE CAPAS");
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        public void analizarU(String codigo, JTextArea a){
            
          try {
              

            StringReader entrada= new StringReader(codigo);
            LexerCupU lex= new LexerCupU(entrada);
            parserU parse= new parserU(lex);
            parse.parse();
            
            arrayObjetosU=parse.getArrayusuario();
            
            
        } catch (Exception ex) {
            a.append("HAY ERRORES ENLA GRAMATICA DE CAPAS");
            Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
        public void a(){
            for(int i=0;i<arrayObjetos.length;i++){
                if(arrayObjetos[i]!=null){
                arrayObjetos[i].mostrarLista();
                }
            }
        }
        public void b(){
            for(int i=0;i<arrayObjetosC.length;i++){
                if(arrayObjetosC[i]!=null){
                arrayObjetosC[i].mostrarLista();
                //las capas reconcidas por el archivo de entrada son
                //agregadas las capas al arbol AVL 
                int num= arrayObjetosC[i].getIdCapa();
                    System.out.println(num);
                arbol.insertar(num);
                System.out.println("INSERTANDO CAPA "+arrayObjetosC[i].getIdCapa()+" AL AVL");
                    //a.append("INSERTANDO CAPA "+arrayObjetosC[i].getIdCapa()+" AL AVL");
                }
            }
//            arbol.preOrden(arbol.obtenerRaiz());
//            System.out.println("lee");
        }
        

        public void generarImagenes(){
            String formatoImagenTitle="digraph G { \n node [shape= record fontsize=12 ] ";
            String formato="";
            try{
            for(int i=0;i<arrayObjetos.length;i++){
                if(arrayObjetos[i]!=null){
                System.out.println(arrayObjetos[i].getIdImagen());
                ab.insertarNodo(arrayObjetos[i].getIdImagen());
                arrayObjetos[i].mostrarLista1();
                formatoImagenTitle+=arrayObjetos[i].getFORMATO_LISTA_IMG();
                
                }
            }
            
            ab.mostrarLista();
            formatoImagenTitle+=ab.getFormatoTITLEimagen();
            } catch(Exception e){
                System.out.println(e);
            }
            formatoImagenTitle+="}";
            Archivos ar= new Archivos();
            ar.GuardarArchivoDOT(formatoImagenTitle,"listaImagen.txt");
            
            ar.generar("listaImagen.txt", "listaImagen.png");
            
            
        }
        public void GenerarAvlCapa(){
            String formato="digraph G { \n node [shape= record fontsize=12 ] ";
            
            arbol.preOrden(arbol.obtenerRaiz());
            formato+=arbol.getFORMATO_PREORDEN();
            formato+="}";
            
            Archivos ar= new Archivos();
            ar.GuardarArchivoDOT(formato,"ALVcapas.txt");
            
            ar.generar("ALVcapas.txt", "AVLcapas.png");
            
            
        }
        public void GraficarCapa(int idcapaa){
            
            for(int i=0;i<arrayObjetosC.length;i++){
                if(arrayObjetosC[i]!=null){
                if(arrayObjetosC[i].getIdCapa()==idcapaa){
                    arrayObjetosC[i].mostrarLista();
                    
                    int DimensionFila=Collections.max(arrayObjetosC[i].getFilaa());
                    int DimensionColumna=Collections.max(arrayObjetosC[i].getColumnaa());
                    matriz_capa = new SparseMatrix(DimensionFila,DimensionColumna);
                    //System.out.println("VALOR: "+DimensionColumna);
                    
                    for(int j=0;j<arrayObjetosC.length;j++){
                        //lenamos la matriz de la capa
                        for(int k=0;k<arrayObjetosC[j].getColorr().size();k++){
                        matriz_capa.setValor(arrayObjetosC[k].getColorr().get(j), arrayObjetosC[k].getFilaa().get(j), arrayObjetosC[k].getColumnaa().get(j));
                    }
                    }
		
                    
                }
                }
                
                
            }
            
        }

}
