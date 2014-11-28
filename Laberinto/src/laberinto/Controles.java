/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laberinto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase encargada de manejar los controles de las teclas, para el devido
 * funcionamiento del programa.
 *
 * @author Ale.
 * @autor Brando
 * @author Denisse.
 * @version v1.0.
 *
 */
public class Controles extends KeyAdapter {
    
    public static int n=1;
    
    
    /**
     * 
     * @param e 
     */
   
   public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            
            if(keyCode == e.VK_LEFT) {
                if(MatrizLogica.validarIzquierda())
                graphics.x -=30;
                System.out.println("x: "+graphics.x+" y="+graphics.y);
                
            }
            if(keyCode == e.VK_RIGHT) {
               if(MatrizLogica.validarDerecha())
                graphics.x += 30;
                System.out.println("x: "+graphics.x+" y="+graphics.y);
            }
            if(keyCode == e.VK_UP) {
                if(MatrizLogica.validarArriba())
                graphics.y -= 30;
                System.out.println("x: "+graphics.x+" y="+graphics.y);
            }
            if(keyCode == e.VK_DOWN) {
                if(MatrizLogica.validarAbajo())
                graphics.y += 30;
                System.out.println("x: "+graphics.x+" y="+graphics.y);
            }
        }
}
