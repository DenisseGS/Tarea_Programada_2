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
import java.util.ArrayList;

public class ArchivoBinario {

    private File file; //Variable de tipo File

    public ArchivoBinario() {
    }

    public void createFiles() {
        try {
            file = new File("Records.obj"); // Para crear un nuevo archivo
        } catch (Exception ex) { //Manejo de excepciones
            System.err.println("Error: " + ex.getMessage()); // Muestra el error o la excepcion
        }
    }

    public void writeFiles(Records records) {
        ArrayList<Records> listaRecords = new ArrayList<>(); // Lista de objetos Personas en un arrayList, puede ser serializada
        listaRecords.add(records); //Los objetos de la lista tambien pueden ser serializados

        try {
            FileOutputStream fos = new FileOutputStream(file); //Permite escribir diferentes tipos de datos, bytes.
            ObjectOutputStream oos = new ObjectOutputStream(fos); //Tipo de dato que vamos a escribir, en este caso un objeto
            oos.writeObject(records);

            oos.close();
            fos.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage()); // Muestra el error o la excepcion
        }
    }

    public String readFiles() {
        ArrayList<Records> listaRecords = null;

        try {
            String msj = "";
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listaRecords = (ArrayList<Records>) ois.readObject();
            if (listaRecords != null) {
                for (Records p : listaRecords) { //Recorre la lista y mete en cada objeto p el contenido actual
                    msj += p.getNombre() + " " + p.getTiempo() + "\n";
                }
            }
            ois.close();
            fis.close();
            return msj;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage()); // Muestra el error o la excepcion
        }
        return "";
    }

}
