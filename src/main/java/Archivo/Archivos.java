package Archivo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author James
 */
public class Archivos {
    private String ContenidoArchivo;
    private boolean ExisteArchivo;
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    String PathFijo="C:\\Users\\james\\Desktop\\";
    
    public Archivos() {

        //buscarFormulario();
    }
    //http://localhost/Formularios/FormGoogle?Form=aa
    public void buscarFormulario(){
        
        String fichero=PathFijo+"texto.txt";
        try{
        archivo= new File(fichero);
            if (archivo.canRead()) {
                    String documento = AbrirArchivo(archivo);
                    ContenidoArchivo=documento;
                    ExisteArchivo=true;
                    //JOptionPane.showMessageDialog(null, ContenidoArchivo);
            } else{
                //NO HAY ARCHIVO
                ExisteArchivo=false;
            }
        } catch(Exception e){
            ExisteArchivo=false;
        }
    }
    
    public String AbrirArchivo(File fichero) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int a;
            while ((a = entrada.read()) != -1) {
                char caracter = (char) a;
                documento += caracter;
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        //jTextArea.setText(documento);
        return documento;
    }
    
    
    
    public boolean GuardarArchivo( String documento) {
        String mensaje = null;
        boolean bandera=false;
        try {
            
            File fil= new File(PathFijo+"texto.txt");
            salida = new FileOutputStream(fil);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            salida.close();
            bandera=true;
            salida.close();
            
        } catch (Exception e) {

        }

        return bandera;
    }
    public boolean GuardarArchivoDOT( String documento,String nombre) {
        String mensaje = null;
        boolean bandera=false;
        try {
            
            File fil= new File(PathFijo+nombre);
            salida = new FileOutputStream(fil);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            salida.close();
            bandera=true;
            salida.close();
            
        } catch (Exception e) {

        }

        return bandera;
    }
    
    
    
    public void generar(String codigo, String img) {
        try {

            String dotPath = "C:\\Program Files\\Graphviz\\bin\\dot.exe";
            String fileInputPath = PathFijo+"\\"+codigo;
            String fileOutputPath = PathFijo+"\\"+img;
            String tParam = "-Tpng"
                    + "";
            String tOParam = "-o";
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    
    
    
    public String getContenidoArchivo() {
        return ContenidoArchivo;
    }

    public void setContenidoArchivo(String ContenidoArchivo) {
        this.ContenidoArchivo = ContenidoArchivo;
    }

    public boolean isExisteArchivo() {
        return ExisteArchivo;
    }

    public void setExisteArchivo(boolean ExisteArchivo) {
        this.ExisteArchivo = ExisteArchivo;
    }
    
}
