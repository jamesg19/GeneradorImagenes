/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MatrizDispersa;

/**
 * 
 * @author James Gramajo 
 */

public class Node {
	
	private Node derecho;
	private Node izquierdo;
	private int linea;
	private int columna;
        private String valor;
	
	//basic constructor for a node
	public Node(String valor){
		this.valor = valor;
	}
        public Node(){
            
        }
	
	//more complex constructor if it makes sense to have it
	public Node(String color, int row, int column, Node right, Node down){
		this.valor = color;
		this.linea = row;
		this.columna = column;
		this.derecho = right;
		this.izquierdo = down;
	}
	
	//getter and setter for the node pointer 'right'
	public Node getDerecho(){
		return derecho;
	}
	public void setDerecho(Node right){
		this.derecho = right;
	}
	
	//getter y setter para el puntero de nodo 'abajo'
	public Node getAbajo(){
		return izquierdo;
	}
	public void setAbajo(Node down){
		this.izquierdo = down;
	}
	
	//getter and setter for the value
	public String getValor(){
            return valor;
        }
        public void setValor(String valor){
            this.valor=valor;
        }
	
	//getter and setter for row
	public int getLinea(){
		return linea;
	}
	public void setLinea(int row){
		this.linea = row;
	}
	
	//getter and setter for row
	public int getColumna(){
		return columna;
	}
	public void setColumna(int column){
		this.columna = column;
	}	
}