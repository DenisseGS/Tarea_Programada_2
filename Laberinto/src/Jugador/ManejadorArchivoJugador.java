/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jugador;


import java.io.*;

/**
 *
 * @author Ale
 */
public class ManejadorArchivoJugador {
    
    
    
    // Fichero de acceso aleatorio
    private RandomAccessFile file;

    // Apertura del fichero
    public boolean abrir(String nombre) {
        try {
            file = new RandomAccessFile(nombre, "rw");
            return true;
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
            return false;
        }
    }

    // Cierre del fichero
    public void cerrar() {
        try {
            if (file != null) {
                file.close();
            }
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
    }

    // Escribir un registro en la posicion actual del cursor
    public void escribir(RegistroPersona registro) {
        if (file != null) {
            registro.escribirRegistro(file);
        }
    }

    // Escribir un registro en una posiciÃ³n cualquiera
    public void escribir(RegistroPersona registro, int pos) {
        try {
            if (file != null) {
                file.seek((pos - 1) * RegistroPersona.DIM);
                escribir(registro);
            }
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
    }

    // Leer del fichero el registro que se encuentra en la posicion actual del cursor
    public RegistroPersona leer() {
        RegistroPersona registro = null;
        if (file != null) {
            registro = new RegistroPersona();
            registro.leerRegistro(file);
        }
        return registro;
    }

    // Leer del fichero un registro cualquiera
    // (el parametro indica la posicion del registro)
    public RegistroPersona leer(int pos) {
        try {
            if (file != null) {
                file.seek((pos - 1) * RegistroPersona.DIM);
            }
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
        return leer();
    }

    
}
