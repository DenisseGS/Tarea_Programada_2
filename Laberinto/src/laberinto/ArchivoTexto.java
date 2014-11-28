/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laberinto;

/**
 *
 * @author Ale
 */
import java.io.*;
public class ArchivoTexto {
      File f;
    FileReader lectorArchivos;
    
    
     public void concatenar(String nombre, String texto){
        String temp = this.leer(nombre);
        temp = temp + texto;
        this.crearTxt(nombre, texto);
    }
        
    
     
     public void crearTxt(String nombre, String texto){
    File f;
    FileWriter escritorArchivos;
    try{
    f = new File(nombre);
    escritorArchivos = new FileWriter(f);
    BufferedWriter bw = new BufferedWriter(escritorArchivos);
    PrintWriter salida = new PrintWriter(bw);
    salida.write(texto + "\n");
    salida.close();
    bw.close();
    }catch(IOException e){
        System.out.println("Error:" + e.getMessage());
    }
    }
     
      public String leer(String nombre){//El parametro nombre indica el nombre del archivo por ejemplo "prueba.txt"
       try{
           File f;
           FileReader lectorArchivo;
           //Creamos el objeto del archivo que vamos a leer 
           f = new File(nombre);
           //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
           lectorArchivo = new FileReader(f);
           //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
           BufferedReader br = new BufferedReader(lectorArchivo);
           String l="";
           //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
           String aux="";/*variable auxiliar*/
           while(true){//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
           aux = br.readLine();
           //leemos una linea de texto y la guardamos en la variable auxiliar
            String[] vectorDatosArchivo;
            int n = 0;
//            if (aux != null) {
//                vectorDatosArchivo = aux.split(":");
//                System.out.println(vectorDatosArchivo[n++]);
//                System.out.println(vectorDatosArchivo[n++]);
//                System.out.println(vectorDatosArchivo[n++]);
//                System.out.println(vectorDatosArchivo[n++]);
//                System.out.println(vectorDatosArchivo[n++]);
//                System.out.println(vectorDatosArchivo[n++]);
////                System.out.println(vectorDatosArchivo[n++]);
////                System.out.println(vectorDatosArchivo[n++]);
////                System.out.println(vectorDatosArchivo[n++]);
//            }
//           
           
           
           
           
           if(aux!=null){
             l=l+ aux+"\n";
             /*si la variable aux tiene datos se va acumulando en la variable l,
              * en caso de ser nula quiere decir que ya nos hemos leido todo
              * el archivo de texto*/
           }else{
               break;
           }
           }
           br.close();
           lectorArchivo.close();
           return l;
       }catch(IOException e){
           System.out.println("Error:"+e.getMessage());
       }
       return null;

}
    
}
