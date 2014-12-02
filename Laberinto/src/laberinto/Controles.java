/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static laberinto.Cronometro.tiempo;
import static laberinto.MatrizLogica.matriz;

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

    public static String tiempoGane = " ";
    public static int n = 1;
    public static Registro registro = Registro.getInstance();

    /**
     *
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == e.VK_LEFT) {
             if (MatrizLogica.gane() == true) {
                 Cronometro.gano=true;
                 tiempoGane = tiempo;
                 
                 JOptionPane.showMessageDialog(null,"Felicidades ganó"+"\nSu tiempo es de:" + tiempoGane);
            }
             if (MatrizLogica.validarIzquierda()) {
                graphics.x -= 30;
                verificarIncognitas();
             }
        }


           
            
        
        if (keyCode == e.VK_RIGHT) {
            if (MatrizLogica.gane() == true) {
               tiempoGane = tiempo;
                 JOptionPane.showMessageDialog(null,"Felicidades ganó"+"\nSu tiempo es de:" + tiempoGane);
            }
            if (MatrizLogica.validarDerecha()) {
                graphics.x += 30;
                verificarIncognitas();
            }


        }
        if (keyCode == e.VK_UP) {
            if (MatrizLogica.gane() == true) {
                 tiempoGane = tiempo;
                 JOptionPane.showMessageDialog(null,"Felicidades ganó"+"\nSu tiempo es de:" + tiempoGane);
            }
            if (MatrizLogica.validarArriba()) {
                graphics.y -= 30;
                verificarIncognitas();
            }
        }
          if (keyCode == e.VK_DOWN) {

            if (MatrizLogica.gane() == true) {
                 tiempoGane = tiempo;
                 JOptionPane.showMessageDialog(null,"Felicidades ganó"+"\nSu tiempo es de:" + tiempoGane);
            }
            if (MatrizLogica.validarAbajo()) {
                graphics.y += 30;
                verificarIncognitas();
            }
            }
    
        if(registro.size() == 0){
            registro.registar(10, 180);
        }
        if(registro.getXPosicionesAtras(1)[0] != graphics.x || registro.getXPosicionesAtras(1)[1] != graphics.y){
            registro.registar(graphics.x, graphics.y);
        }
    }
    
    
    public void verificarIncognitas(){
        int valor = MatrizLogica.matriz[(graphics.y / 30) - 1][graphics.x / 30];
        if(valor == 5){
            //hace lo que se hace para los cosos buenos
        }else if(valor == 6){
            int random = (int) (Math.random()*(15-5)+5);
            System.out.println("Math.random() = " + Math.random());
            System.out.println("random = " + random);
            int[] registros = registro.getXPosicionesAtras(random);
            System.out.println("registros = " + registros[0] + ", " + registros[1]);
            MatrizLogica.setPosition(registros[0], registros[1]);
        }
    }

}
