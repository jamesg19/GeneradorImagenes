/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MatrizDispersa;

import java.io.*;

public class test_driver {
	
	//these fields are stored to shorten code (avoids additional switches)
	public static SparseMatrix matriz_seleccionada;
	public static SparseMatrix matriz_dispersa_a;
	public static SparseMatrix matriz_dispersa_B;
	public static SparseMatrix matriz_dispersa_C;

	//main method contains menu options
	public static void main(String[] args) {
                //columnas |||, lineas  -
		matriz_dispersa_a = new SparseMatrix(10,8);
		matriz_dispersa_B = new SparseMatrix(10,8);
		matriz_dispersa_C = new SparseMatrix(10,8);
		int row;
		int column;
		char selection = main_menu();
                prueba();
//		while(selection != 'q'){
//			switch(selection){
//			case 'v': //agrega un valor a una matriz
//				which_matrix();
//				setvalue(matriz_seleccionada);
//				break;
//			case 'r': //muestra una fila determinada
//				which_matrix();
//				System.out.print("VALOR LINEA: ");
//				row = user_int();
//				matriz_seleccionada.imprimeValorLineas(row);
//				break;
//			case 'g': //muestra un valor en las coordenadas dadas
//				which_matrix();
//				System.out.print("VALOR LINEA:  ");
//				row = user_int();
//				System.out.print("VALOR COLUMNA: ");
//				column = user_int();
//				System.out.println(matriz_seleccionada.getValor(row, column));
//				break;
//			case 'c': //muestra una columna dada
//				which_matrix();
//				System.out.print("VALOR COLUMNA ");
//				column = user_int();
//				matriz_seleccionada.printColValues(column);
//				break;
//			case 's': //imprime una breve lista de valores en matriz
//				which_matrix();
//				matriz_seleccionada.printShort();
//				break;
//			case 'a': //suma dos matrices juntas, resultado de impresión largo
//				which_matrix();
//				SparseMatrix mat_one = matriz_seleccionada;
//				which_matrix();
//				mat_one.add(matriz_seleccionada).imprimirLargo();
//				break;
//			case 'l': //imprime una tabla de valores
//				which_matrix();
//				matriz_seleccionada.imprimirLargo();
//				break;
//			default: //se utiliza si el usuario realiza una selección no válida
//				System.out.println("This was an invalid selection.");
//				break;
//			}
//			selection = main_menu();
//		}  
	}
	
	//this method is called when input is needed form menu selection
	public static char main_menu(){
                System.out.println("***********************************");
		System.out.println("ESTABLECER VALOR:  v        MOSTRAR LINEA:     r");
		System.out.println("OBTENER VALOR:  g           MOSTAR COLUMNA:  c");
		System.out.println("MOSTRAR SHORT: s            AGREGAR MATRICES: a");
		System.out.println("mostrar long:  l            Quit q:       q");
		System.out.print("    ->");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char opt = 'z';
		try{
			opt = (br.readLine()).charAt(0);
		}
		catch(Exception e){
			System.out.println("Exception: "+ e);
			return main_menu();
		}
		return (opt);
	}
	
	//se trata de la selección de una matriz por parte del usuario
	public static void which_matrix(){
		System.out.println("Which Matrix (a,b,c): ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char opt = 'z';
		try{
			opt = (br.readLine()).charAt(0);
		}
		catch(Exception e){
			System.out.println("Exception: "+ e);
			which_matrix();
		}
		switch(opt){
		case 'a':
			matriz_seleccionada = matriz_dispersa_a;
			break;
		case 'b':
			matriz_seleccionada = matriz_dispersa_B;
			break;
		case 'c':
			matriz_seleccionada = matriz_dispersa_C;
			break;
		default:
			System.out.println("this was not a valid matrix, select again");
			which_matrix();
			break;
		}
	}
	
	//método para recopilar enteros del usuario
	public static int user_int(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opt = 0;
		try{
			String opt_s;
			opt_s = br.readLine();
			opt = Integer.parseInt(opt_s);
		}
		catch(Exception e){
			System.out.println("Exception:" + e);
			return user_int();
		}
		return (opt);
	}
        public static String user_string(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String opt = 0+"";
		try{
			String opt_s;
			opt_s = br.readLine();
			opt = opt_s.toString();
		}
		catch(Exception e){
			System.out.println("Exception:" + e);
			return user_string();
		}
		return (opt);
	}
	
	//este método se utiliza para establecer un valor en una matriz dada
	public static void setvalue(SparseMatrix SM){
            
		System.out.println("VALOR: ");
		String value = user_string();
		System.out.println("LINEA: ");
		int row = user_int();
		System.out.println("COLUMNA: ");
		int col = user_int();
		SM.setValor(value, row, col);
	}
        public static void prueba(){
            for(int a=0;a<5;a++){
                
            }
        }
        public void aa(SparseMatrix SMa){
            System.out.println("VALOR: ");
		String value = user_string();
		System.out.println("LINEA: ");
		int row = user_int();
		System.out.println("COLUMNA: ");
		int col = user_int();
		SMa.setValor(value, row, col);
        }
}