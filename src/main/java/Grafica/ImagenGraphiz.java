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
"  " +
"		 \n" +
"		abc [shape=none,margin=0, label=<" +
" <TABLE border=\"0\" cellspacing=\"0\" cellpadding=\"15\" style=\"rounded\" >";
    String fin="</TABLE>>"
            + "]\n" +
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
