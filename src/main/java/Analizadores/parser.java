
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analizadores;

import java_cup.runtime.Symbol;
import java_cup.runtime.XMLElement;
import java.util.ArrayList;
import DatosEntrada.*;
import java.util.ArrayList;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\003\000\002\002" +
    "\003\000\002\006\004\000\002\006\003\000\002\007\006" +
    "\000\002\007\005\000\002\015\003\000\002\010\005\000" +
    "\002\010\003\000\002\014\003\000\002\011\004\000\002" +
    "\011\003\000\002\012\006\000\002\012\005\000\002\013" +
    "\005\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\006\010\007\011\010\001\002\000\004\002" +
    "\uffff\001\002\000\004\002\035\001\002\000\004\002\000" +
    "\001\002\000\004\013\026\001\002\000\004\004\ufffa\001" +
    "\002\000\004\004\016\001\002\000\006\002\ufffd\011\010" +
    "\001\002\000\006\002\ufff5\010\007\001\002\000\004\002" +
    "\ufff6\001\002\000\004\002\ufffe\001\002\000\006\005\021" +
    "\011\022\001\002\000\006\005\ufff8\006\024\001\002\000" +
    "\004\005\023\001\002\000\006\002\ufffb\011\ufffb\001\002" +
    "\000\006\005\ufff7\006\ufff7\001\002\000\006\002\ufffc\011" +
    "\ufffc\001\002\000\004\011\022\001\002\000\004\005\ufff9" +
    "\001\002\000\006\007\031\011\030\001\002\000\004\007" +
    "\034\001\002\000\006\006\032\007\ufff1\001\002\000\006" +
    "\002\ufff3\010\ufff3\001\002\000\004\011\030\001\002\000" +
    "\004\007\ufff2\001\002\000\006\002\ufff4\010\ufff4\001\002" +
    "\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\016\002\004\006\005\007\011\011\003\012" +
    "\012\015\010\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\006\014\007\011\015\010\001\001" +
    "\000\006\011\013\012\012\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\010\017\014\016\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\006\010\024\014\016\001\001" +
    "\000\002\001\001\000\004\013\026\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\013\032" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


	
	private Symbol sym;
    
    ListaImagenCD lstImagen= new ListaImagenCD();
	ListaImagenCD arrayObjetos[]=new ListaImagenCD[300];
    ListaCapaCD lstCapa= new ListaCapaCD();
	ListaCapaCD arrayObjetosC[]=new ListaCapaCD[300];
    //CapaCD objCapa= new CapaDC();
    int ContIMG=-1;
    int ContCAP=-1;
    public Symbol getS(){
        return this.sym;
    }
	public parser( LexerCup lex){
	 super(lex);
	}
	public void report_error(String message, Object info){ 
		System.out.println("\nREPORT ERROR");
	}
	public void report_fatal_error(String message, Object info){
		System.out.println("\nREPORT FATAL");
	}
	
	public void syntax_error(Symbol cur_token) {

	System.out.println("...SE ESPERABA: "+symbl_name_from_id(expected_token_ids().get(0)));
        System.out.println("syntaxerr: " + symbl_name_from_id(cur_token.sym) +" Columna: "+cur_token.right+" Linea: "+cur_token.left+" Valor:"+cur_token.value);
    }
	protected int error_sync_size() {
        return 1;
    }
    public ListaImagenCD getLstImagen() {
        return lstImagen;
    }
    public ListaImagenCD[] getArrayImagen() {
        return arrayObjetos;
    }
    public ListaCapaCD[] getArrayCapa() {
        return arrayObjetosC;
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= ESTADO_INICIAL EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // ESTADO_INICIAL ::= IMAGEN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ESTADO_INICIAL",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // ESTADO_INICIAL ::= USUARIO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ESTADO_INICIAL",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // IMAGEN ::= BLOQUE_IMAGEN IMAGEN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("IMAGEN",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // IMAGEN ::= BLOQUE_IMAGEN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("IMAGEN",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // BLOQUE_IMAGEN ::= ID_IMG Llave_Abre PARAMETRO_IMG Llave_Cierra 
            {
              Object RESULT =null;
		  arrayObjetos[ContIMG]=lstImagen; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("BLOQUE_IMAGEN",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // BLOQUE_IMAGEN ::= ID_IMG Llave_Abre Llave_Cierra 
            {
              Object RESULT =null;
		  arrayObjetos[ContIMG]=lstImagen; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("BLOQUE_IMAGEN",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ID_IMG ::= Numeros 
            {
              Object RESULT =null;
		int idImagennleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idImagennright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object idImagenn = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		ContIMG++; lstImagen= new ListaImagenCD(); lstImagen.setIdImagen(Integer.parseInt(idImagenn.toString().trim()));
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ID_IMG",11, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // PARAMETRO_IMG ::= NUM Coma PARAMETRO_IMG 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PARAMETRO_IMG",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // PARAMETRO_IMG ::= NUM 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PARAMETRO_IMG",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // NUM ::= Numeros 
            {
              Object RESULT =null;
		int Idccapaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int Idccaparight = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Object Idccapa = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		lstImagen.insertarNodo(Integer.parseInt(Idccapa.toString().trim()));   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("NUM",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // USUARIO ::= BLOQUE_USUARIO USUARIO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("USUARIO",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // USUARIO ::= BLOQUE_USUARIO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("USUARIO",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // BLOQUE_USUARIO ::= Usuario DosPuntos PARAMETRO_USUARIO Punto_Coma 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("BLOQUE_USUARIO",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // BLOQUE_USUARIO ::= Usuario DosPuntos Punto_Coma 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("BLOQUE_USUARIO",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // PARAMETRO_USUARIO ::= Numeros Coma PARAMETRO_USUARIO 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PARAMETRO_USUARIO",9, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // PARAMETRO_USUARIO ::= Numeros 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("PARAMETRO_USUARIO",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
