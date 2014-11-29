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
import java.util.ArrayList;

public class ArchivoTexto {

    File f;
    FileReader lectorArchivos;
    private static int[] vector;

//    public void concatenar(String nombre, String texto) {
//        String temp = this.leer(nombre);
//        temp = temp + texto;
//        this.crearTxt(nombre, texto);
//    }

    public void crearTxt(String nombre, String texto) {
        File f;
        FileWriter escritorArchivos;
        try {
            f = new File(nombre);
            escritorArchivos = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritorArchivos);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(texto + "\n");
            salida.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public int[][] leer(String nombre) {//El parametro nombre indica el nombre del archivo por ejemplo "prueba.txt"
        try {
            File f;
            FileReader lectorArchivo;
            //Creamos el objeto del archivo que vamos a leer 
            f = new File(nombre);
            //Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
            lectorArchivo = new FileReader(f);
            //Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
            BufferedReader br = new BufferedReader(lectorArchivo);
            String  l = "";
            //Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
            String aux = br.readLine();/*variable auxiliar*/
            
            ArrayList<ArrayList> matriz = new ArrayList<>();
            while (aux != null) {//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
                ArrayList<Integer> fila = new ArrayList<>();
                matriz.add(fila);
//                System.out.println("aux = " + aux);
//                System.out.println("aux.length() = " + aux.length());
                for (int i = 0; i < aux.length(); i++){
                    fila.add(Integer.parseInt(aux.charAt(i) + ""));
//                    System.out.println("cahr i = " + aux.charAt(i));
                }
                aux = br.readLine();
            }
            br.close();
            lectorArchivo.close();
            int[][] matrizEntera = new int[matriz.size()][matriz.get(1).size()];
            for (int i = 0; i < matriz.size(); i++) {
                for (int j = 0; j < matriz.get(i).size(); j++) {
                   matrizEntera[i][j] = (int) matriz.get(i).get(j);
                }
            }
            return matrizEntera;
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return null;

    }
//      
//      public static void anadirAlVector(int num){
//      if(){
//          
//      }
//              vector
//         
//      }

}
