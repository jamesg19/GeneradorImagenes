package MatrizDispersa;

import Grafica.ImagenGraphiz;
import Objetos.Imagen;

/**
 * 
 * @author James Gramajo 
 */
public class SparseMatrix {
	
	private int NoFila;
	private int NoColumna;
	Node enter;
	boolean empty_matrix;

    //Constructor: the new matrix should have rowCount rows and colCount columns.
    public SparseMatrix(int NoFila, int NoColumna){
    	this.NoFila = NoFila;
    	this.NoColumna = NoColumna;
    	this.enter = new Node(-1+"");
    	this.enter.setLinea(-1);
    	this.enter.setColumna(-1);///
    	this.enter.setAbajo(enter);
    	this.enter.setDerecho(enter);
    	this.empty_matrix = true;
    	setValor("0",0,0);
    }
    
    //Devuelve el valor en esta posición en la matriz.
    //Devuelve 0 si no hay ningún nodo en esta posición.
    public String getValor(int linea, int columna){
    	Node iterador_columna = enter;
    	while(iterador_columna.getDerecho() != enter){
    		iterador_columna = iterador_columna.getDerecho();
    		if (iterador_columna.getColumna() == columna){
    			Node iterador_linea = iterador_columna;
                        
    			while (iterador_linea.getAbajo() != iterador_columna){
    				iterador_linea = iterador_linea.getAbajo();
    				if(iterador_linea.getLinea()==linea){
    	    			return iterador_linea.getValor();
    	    		}
    			}
                        
                        
    		}
    	}
    	return "0";
    }
    
    
    //Pone el valor en la matriz
    //Si ya hay un nodo en esta posición, sobrescriba el valor almacenado allí.
    //Si no hay ningún nodo, cree uno.
    public void setValor(String valor, int linea, int columna){
    	Node new_node = new Node(valor);
    	new_node.setLinea(linea);
    	new_node.setColumna(columna);
    	
    	//busca y llena una matriz dispersa totalmente vacía
    	if(empty_matrix){
    		Node row_header = new Node(-2+"", linea, -1, new_node, enter);
    		Node col_header = new Node(-2+"", -1, columna, enter, new_node);
    		new_node.setDerecho(row_header);
    		new_node.setAbajo(col_header);
    		enter.setDerecho(col_header);
    		enter.setAbajo(row_header);
    		this.empty_matrix = false;
    		return;
    	}else{
    	
    	//busca y llena una matriz dispersa que aún no tiene un encabezado de fila
    	if(!row_check(linea)){
    		//iterates through row_headers
    		Node row_iterator = enter;
    		while(row_iterator.getAbajo() != enter){
    			//si la fila actual es menor que el valor de la fila
    			//y la siguiente fila es mayor que el valor de la fila
    			//Hacer un nuevo row_header entre ellas
    			row_iterator = row_iterator.getAbajo();
    			if( 
    	    	(row_iterator.getLinea() < linea) && 
    	    	((row_iterator.getAbajo().getLinea() > linea) ||
    	    	(row_iterator.getAbajo() == enter))
    	    	){
    				Node row_header = 
    					new Node(linea+"", linea, -1, new_node, row_iterator.getAbajo());
    				row_iterator.setAbajo(row_header);
    				new_node.setDerecho(row_header);
    			}
    		}
    	}
    	//si la fila ya existe, se ejecuta este código:
    	else{
    		Node iterador_linea = enter;
    		while( iterador_linea.getAbajo() != enter){
    			//si la fila del encabezado de la fila coincide con la fila del nuevo nodo
    			iterador_linea = iterador_linea.getAbajo();
    			if(iterador_linea.getLinea()==linea){
    				//el código a continuación se asegura de que esté en el medio
    				Node iterador_columna = iterador_linea;
    				//declaración if cuando el nuevo valor es
    				//entre el principio y el primer nodo
    				if(iterador_columna.getDerecho().getColumna() > columna){
    					new_node.setDerecho(iterador_columna.getDerecho());
	    				iterador_columna.setDerecho(new_node);
    				}
    				else{
    				while( iterador_columna.getDerecho() != iterador_linea){
    					iterador_columna = iterador_columna.getDerecho();
    					if(iterador_columna.getColumna()==columna){
    						iterador_columna.setValor(valor);
    					}
    					if(
    					(iterador_columna.getColumna() < columna) &&
    					((iterador_columna.getDerecho().getColumna() > columna)||
    					(iterador_columna.getDerecho() == iterador_linea))
    					){
    						//una vez que esté en el medio, establezca los nuevos punteros
    						new_node.setDerecho(iterador_columna.getDerecho());
    	    				iterador_columna.setDerecho(new_node);
    					}
    				}
    				}
    			}
    		}
    	}
    	
    	
    	//el código de valor de conjunto de columnas debería funcionar igual que el código de valor de conjunto de filas
    	if(!column_check(columna)){
    		Node column_iterator = enter;
    		while( column_iterator.getDerecho() != enter){
    			column_iterator = column_iterator.getDerecho();
    			if( 
    	    	(column_iterator.getColumna() < columna) && 
    	    	((column_iterator.getDerecho().getColumna() > columna) ||
    	    	(column_iterator.getDerecho() == enter))
    	    	){
    				Node column_header = 
    					new Node(columna+"", -1, columna, column_iterator.getDerecho(), new_node);
    				column_iterator.setDerecho(column_header);
    				new_node.setAbajo(column_header);
    			}
    		}
    	}
    	else{
    		Node column_iterator = enter;
    		while( column_iterator.getDerecho() != enter){
    			//si la fila del encabezado de la fila coincide con la fila del nuevo nodo
    			column_iterator = column_iterator.getDerecho();
    			if(column_iterator.getColumna()==columna){
    				//el código a continuación se asegura de que esté en el medio
    				Node row_iterator = column_iterator;
    				//declaración if cuando el nuevo valor es
    				//entre el principio y el primer nodo
    				if(row_iterator.getAbajo().getLinea() > columna){
    					new_node.setAbajo(row_iterator.getAbajo());
	    				row_iterator.setAbajo(new_node);
    				}
    				else{
    				while( row_iterator.getAbajo() != column_iterator){
    					row_iterator = row_iterator.getAbajo();
    					if(row_iterator.getLinea()==linea){
    						row_iterator.setValor(valor);
    					}
    					if(
    					(row_iterator.getLinea() < linea) &&
    					((row_iterator.getAbajo().getLinea() > linea)||
    					(row_iterator.getAbajo() == column_iterator))
    					){
    						//una vez que esté en el medio, establezca los nuevos punteros
    						new_node.setAbajo(row_iterator.getAbajo());
    	    				row_iterator.setAbajo(new_node);
    					}
    				}
    				}
    			}
    		}
    	}
    	}
    	
    	
    	
    }
    
    //devuelve booleano verdadero si el valor de la fila ya existe
    //se mueve hacia abajo a través de las referencias buscando
    public boolean row_check(int row){
    	if(empty_matrix){
    		return false;
    	}
    	Node iterator_node = enter;
    	while (iterator_node.getAbajo() != enter){
    		iterator_node = iterator_node.getAbajo();
    		if(iterator_node.getLinea()==row){
    			return true;
    		}
    	}
    	return false;
    }
    
    //devuelve booleano verdadero si el valor de la columna ya existe
    public boolean column_check(int col){
    	if(empty_matrix){
    		return false;
    	}
    	Node iterator_node = enter;
    	while ( (iterator_node.getDerecho() != enter)){
    		iterator_node = iterator_node.getDerecho();
    		if(iterator_node.getColumna()==col){
    			return true;
    		}
    	}
    	return false;
    	
    }
    
    //devuelve verdadero si hay un valor en la fila y columna dadas
    public boolean spot_check(int row, int column){
    	if (!row_check(row)){
    		return false;
    	}
    	
    	if (!column_check(column)){
    		return false;
    	}
    	
    	Node column_iterator = enter;
    	while(column_iterator.getDerecho().getColumna() != column){
    		column_iterator = column_iterator.getDerecho();
    	}
    	Node row_iterator = column_iterator;
    	while(row_iterator.getAbajo()!=column_iterator){
    		row_iterator = row_iterator.getAbajo();
    		if(row_iterator.getLinea()==row){
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
    
    //Muestra los valores de las posiciones representadas por nodos.
    //Los valores mostrados están en "forma abreviada": (fila, columna): valor.
    public void printShort(){
    	Node row_iterator = enter;
    	while(row_iterator.getAbajo() != enter){
    		row_iterator = row_iterator.getAbajo();
    		imprimeValorLineas(row_iterator.getLinea());
    	}
    }
    
    //Muestra, en forma abreviada, valores representados por nodos de una fila.
    public void imprimeValorLineas(int rowNumber){
    	//si no hay una fila de ese valor, no hay nada que devolver
    	if(!row_check(rowNumber)){
    		return;
    	}
    	Node row_iterator = enter;
    	while(row_iterator.getLinea() != rowNumber){
    		row_iterator = row_iterator.getAbajo();
    	}
    	Node column_iterator = row_iterator;
    	while(column_iterator.getDerecho() != row_iterator){
    		column_iterator = column_iterator.getDerecho();
    		System.out.print("   ("+column_iterator.getLinea()+", "
    							+column_iterator.getColumna()+"):"
    							+column_iterator.getValor());
    	}
    }
    
    //Muestra, en forma abreviada, valores representados por nodos de una columna.
    public void printColValues(int colNumber){
    	//si no hay una columna de ese valor no hay nada que devolver
    	if(!column_check(colNumber)){
    		return;
    	}
    	
    	Node column_iterator = enter;
    	while(column_iterator.getColumna() != colNumber){
    		column_iterator = column_iterator.getDerecho();
    	}
    	Node row_iterator = column_iterator;
    	while(row_iterator.getAbajo() != column_iterator){
    		row_iterator = row_iterator.getAbajo();
    		System.out.print("   ("+row_iterator.getLinea()+", "
    							+row_iterator.getColumna()+"):"
    							+row_iterator.getValor());
    	}
    }
    
    //Muestre la matriz completa con un punto para las posiciones no representadas por un nodo.
    //La pantalla está organizada en filas y columnas con etiquetas de fila y encabezados de columna.
    //Los valores se imprimirán justificados a la derecha con un ancho de campo de 6.
    //Este método solo se utilizará para matrices con un pequeño número de columnas.
    public void imprimirLargo(){
        
//    	for(int row=0; row<NoFila; row++ ){
//            
//            
//    		for(int col=0; col<NoColumna; col++){
//    			String val = getValor(row, col);
//                        
//    			if(val.equals("0")){
//                            cont++;
//    				System.out.print("   .   ");
//    			}
//    			else{
//                            cont++;
//    				System.out.print(""+val+"");
//    			}
//    		}
//                
//    		System.out.println("");
//    	}
    	imprimirImagenJPG();
            
            
////////    		for(int col=0; col<NoColumna; col++){
////////                    int cont=0;
////////                    for(int row=0; row<NoFila; row++ ){
////////                    
////////    			String val = getValor(row, col);
////////                        
////////    			if(val.equals("0")){
////////                            cont++;
////////    				System.out.print("   .   "+cont);
////////    			}
////////    			else{
////////                            cont++;
////////    				System.out.print(""+val+""+cont);
////////    			}
////////                        
////////                        
////////                    }  
////////                    System.out.println("");
////////    		}
////////                
////////               
////////    		System.out.println("");
    	
    }
        public void imprimirImagenJPG(){
            
        String[ ] nombre = null;
        ImagenGraphiz imgG=new ImagenGraphiz();
   

        String FORMATO="";
        FORMATO+=imgG.getInicio();
        
    	for(int row=0; row<NoFila; row++ ){
            
                FORMATO+="<TR>\n";
    		for(int col=0; col<NoColumna; col++){
    			String val = getValor(row, col);
                        
    			if(val.equals("0")){
                        FORMATO+="<TD border=\"1\"  bgcolor=\"#FFFFFF\"> </TD>\n";    
    				System.out.print("   .   ");
    			}
    			else{
                            FORMATO+="<TD border=\"1\"  bgcolor=\""+val.trim()+"\"> </TD>\n"; 
    				System.out.print(""+val+"");
    			}
                        
    		}
                FORMATO+="</TR> \n";
                
                
    		System.out.println("");
    	}
                
               FORMATO+=imgG.getFin();
               System.out.println("CODIGO james \n\n");
               System.out.println(FORMATO);
    		System.out.println("");
    	
    }
    
    
    
    
    //Agregue la matriz this y la matriz m devolviendo la matriz de suma.
    public SparseMatrix add(SparseMatrix matriz){
    	SparseMatrix m = new SparseMatrix(NoFila, NoColumna);
    	String valor;
    	int linea;
    	int col;
    	Node linea_iterada = enter;
    	Node column_iterator;
    	while (linea_iterada.getAbajo() != enter){
    		linea_iterada = linea_iterada.getAbajo();
    		column_iterator = linea_iterada;
    		while(column_iterator.getDerecho() != linea_iterada){
    			column_iterator = column_iterator.getDerecho();
    			linea = column_iterator.getLinea();
    			col = column_iterator.getColumna();
    			int tempINT = Integer.parseInt(column_iterator.getValor()) + 
    					Integer.parseInt(matriz.getValor(linea, col));
                        valor= tempINT+" ";
                        
    			m.setValor(valor.trim(), linea, col);
    		}
    	}
    	return m;
    }

}