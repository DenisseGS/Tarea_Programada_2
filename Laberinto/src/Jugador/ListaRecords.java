/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ale
 */
public class ListaRecords {

    public static ArrayList<Records> listaRecords = new ArrayList<>();

    private static ListaRecords unicainstancia;

    public ListaRecords() {
    }

    /**
     * Metodo que realiza una solo instacia de la clase, mediante el uso del
     * patron Singleton.
     *
     * @return instancia unica de la clase ListaRecords
     *
     */
    public static ListaRecords getInstance() {
        if (unicainstancia == null) {
            synchronized (ListaRecords.class) {
                if (unicainstancia == null) {
                    unicainstancia = new ListaRecords();
                }
            }
        }
        return unicainstancia;
    }

    /**
     * Metodo que retorna la lista de records
     *
     * @return lista de los records.
     *
     */
    public List<Records> getListaJugador() {
        return listaRecords;
    }

    /**
     * Metodo proporciona el tamaño de la lista de records.
     *
     * @return tamaño de la lista.
     *
     */
    public static int tamano() {
        return listaRecords.size();
    }

    /**
     * Metodo que se encarga de devolver un jugador de una determinada posición
     * en la lista.
     *
     * @return al jugador de la posición indicada en la lista.
     *
     */
    public Records devuelveJugador(int posicion) {
        //Collections.sort(listaRecords);
        return listaRecords.get(posicion);
    }

    public boolean consultarJugador(String seudonimo) {
        for (int i = 0; i < listaRecords.size(); i++) {
            Records j = (Records) listaRecords.get(i);
            if (j.getNombre() != null && j.getNombre().contains(seudonimo)) {
                return true;
            }
        }
        return false;
    }

    public boolean insertarJugador(Records records) {
        Records j = (Records) records;
        if (consultarJugador(j.getNombre()) != true) {
            if (listaRecords.add(records)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
