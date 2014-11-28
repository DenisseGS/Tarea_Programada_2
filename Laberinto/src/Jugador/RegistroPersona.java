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

public class RegistroPersona extends Jugador {

    public final static int DIM = 100;

//    public RegistroPersona() {
//       super();
//    }

    public RegistroPersona(String nickname, String password, int puntuacion) {
        super(nickname, password, puntuacion);
    }
    public RegistroPersona(String nickname, String password) {
        super(nickname, password);
    }

    public void leerRegistro(RandomAccessFile file) {
        try {
            setNickname(leerString(file, 32));
            setPassword(leerString(file, 16));
            setPuntuacion(file.readInt());
        } catch (IOException e) {
            System.err.println("Error al leer del escribir");
        }
    }

    private String leerString(RandomAccessFile file, int tam) {
        char campo[] = new char[tam];
        try {
            for (int i = 0; i < tam; i++) {
                campo[i] = file.readChar();
            }
        } catch (IOException e) {
            System.err.println("Error al leer del archivo");
        }
        String hilera = new String(campo);
        hilera = hilera.trim();
        return hilera;
    }

    public void escribirRegistro(RandomAccessFile file) {
        try {
            escribirString(file, getNickname(), 32);
            escribirString(file, getPassword(), 16);
            file.writeInt(getPuntuacion());

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo");
        }
    }

    private void escribirString(RandomAccessFile file, String str, int dim) {
        StringBuilder buffer = new StringBuilder();
        if (str != null) {
            buffer.append(str);
        }
        buffer.setLength(dim);
        try {
            file.writeChars(buffer.toString()); //Escribe al archivo
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo");
        }
    }

}
