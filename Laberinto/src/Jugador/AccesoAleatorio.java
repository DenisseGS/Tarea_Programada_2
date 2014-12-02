/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

/**
 *
 * @author Ale
 */
import java.io.*;
import java.util.*;
import javax.imageio.IIOException;

public class AccesoAleatorio {

    private static RandomAccessFile flujo;
    private static int numeroRegistro;
    private static int tamanoRegistro = 130;

    public static void crearJugador(File archivo) throws IOException {
        if (archivo.exists() && !archivo.isFile()) {
            throw new IOException(archivo.getName() + " NO es un archivo");

        }
        flujo = new RandomAccessFile(archivo, "rw");
        numeroRegistro = (int) Math.ceil((double) flujo.length() / (double) tamanoRegistro);
    }

    public static void cerrar() throws IOException {
        flujo.close();
    }

    public static boolean setJugador(Jugador jugador, int pos) throws IOException {
        if (pos >= 0 && pos <= getNumeroRegistro()) {
            if (jugador.getTamano() > tamanoRegistro) {
                System.out.println("Tamano de registro fue excedido");
            } else {
                flujo.seek(pos * tamanoRegistro);
                flujo.writeUTF(jugador.getNickname());
                flujo.writeUTF(jugador.getPassword());
                return true;
            }
        } else {
            System.out.println("\n Nuero de registro esta fuera de llos limites ");

        }
        return false;

    }

    /// recibe un jugador  
    public static void anadirJugador(Jugador jugador) throws IOException {
        if (setJugador(jugador, numeroRegistro)) {
            numeroRegistro++;

        }

    }

    public static int getNumeroRegistro() {
        return numeroRegistro;
    }

    public static Jugador getJugador(int pos) throws IOException {
        if (pos >= 0 && pos <= getNumeroRegistro()) {
            flujo.seek(pos * tamanoRegistro);
            return new Jugador(flujo.readUTF(), flujo.readUTF());

        } else {
            System.out.println("\nNumero de registros fuera de limites  ");
            return null;
        }
    }

    public static int buscarRegistroNuevo(String nombre, String contrasena) throws IOException {
        Jugador j;
        if (nombre == null && contrasena == null) {
            return -1;
        }
        for (int i = 0; i < getNumeroRegistro(); i++) {
            flujo.seek(i * tamanoRegistro);
            j = getJugador(i);
            if (j.getNickname().equals(nombre) && j.isActivo() && j.getPassword().equals(contrasena)) {
                return -1;
            }
        }
        return 2;
    }

    public static int buscarRegistroExist(String nombre, String contrasena) throws IOException {
        Jugador j;
        if (nombre == null && contrasena == null) {
            return -1;
        }
        for (int i = 0; i < getNumeroRegistro(); i++) {
            flujo.seek(i * tamanoRegistro);
            j = getJugador(i);
            if (j.getNickname().equals(nombre) && j.isActivo() && j.getPassword().equals(contrasena)) {
                return i;
            }
        }
        return -1;
    }
}
