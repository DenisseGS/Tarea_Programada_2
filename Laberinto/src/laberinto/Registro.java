/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laberinto;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Registro {
    private ArrayList<int[]> lista;
    private static Registro instance;
    
    public static Registro getInstance(){
        if(instance == null){
            instance = new Registro();
        }
        return instance;
    }
    
    private Registro(){
        lista = new ArrayList<>();
    }
    
    public void registar(int x, int y){
        int[] par = {x,y};
        lista.add(par);
    }
    
    public int[] getXPosicionesAtras(int x){
        return (x <= lista.size())?lista.get(lista.size() - x):getXPosicionesAtras(x-1);
    }
    
    public int size(){
        return lista.size();
    }
}
