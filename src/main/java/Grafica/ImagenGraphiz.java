/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Grafica;

/**
 * 
 * @author James Gramajo 
 */
public class ImagenGraphiz {
    String inicio="digraph G { \n" +
"  subgraph cluster1 {fillcolor=\"white\" style=\"filled\"\n" +
"		 \n" +
"		a0 [label=<\n" +
" <TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"15\" style=\"rounded\" >";
    String fin="</TABLE>>];\n" +
"\n" +
"}\n" +
"\n" +
"} ";

    public ImagenGraphiz() {
    }

    
    public String getInicio() {
        return inicio;
    }


    public String getFin() {
        return fin;
    }


    

    

}
