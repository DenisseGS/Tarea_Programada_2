/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import Jugador.ArchivoBinario;
import Jugador.Jugador;
import static Jugador.ListaRecords.listaRecords;
import Jugador.Records;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static laberinto.Cronometro.tiempo;

/**
 * @author Brando
 * @author Ale.
 * @author Denisse.
 */
public class MatrizLogica {


    int contarCasillas = 0;
    public static int[][] matriz;
     private static  String nombre;

   

    public MatrizLogica(int[][] matriz ) {

        this.matriz = matriz;
    }

    public MatrizLogica() {
    }
    

    public String imprimirMatriz() {
        String hilera = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                hilera += matriz[i][j];
            }
            hilera += "\n";
        }
        return hilera;
    }

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void borrar() {
        for (int i = matriz.length - 1; i >= 0; i--) {
            for (int j = matriz[i].length - 1; j >= 0; j--) {
                if (matriz[i][j] != 2) {
                    matriz[i][j] = 0;
                }
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public static void setPosition(int x, int y){
        graphics.x = x;
        graphics.y = y;
    }
    
    public static boolean validarArriba() {
        if (graphics.y > 30 && matriz[(graphics.y / 30) - 2][graphics.x / 30] != 0) {
            return true;
        }
        return false;
    }

    public static boolean validarAbajo() {
        if (graphics.y < 300 && matriz[(graphics.y / 30)][graphics.x / 30] != 0) {
            return true;
        }
        return false;
    }

    public static boolean validarIzquierda() {

        if (graphics.x >= 40 && graphics.x < 280) {
            if (matriz[(graphics.y / 31)][(graphics.x / 30) - 1] != 0) {
                return true;
            }
        }
        return false;

    }

    public static boolean validarDerecha() {
        if (graphics.x < 280) {
            if (matriz[(graphics.y / 31)][(graphics.x / 30) + 1] != 0 ) {
                return true;
            }
        }
        return false;

    }
    public static boolean gane(){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[(graphics.y / 31)][(graphics.x / 30)] == 3) {
                    listaRecords.add(new Records(nombre, tiempo));
                    ArchivoBinario ab = new ArchivoBinario();
                    ab.createFiles();
                    ///ab.writeFiles();
                    System.out.println(ab.readFiles());
                    return true;
                    
                }
            }        }  
         return false;
}
}
