    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import java.util.logging.Level;
import java.util.logging.Logger;
import static laberinto.MatrizLogica.gane;
//import static laberinto.graphics.tiempo;

/**
 *
 * @author Ale
 */
public class Cronometro implements Runnable {

    public static String tiempo = " ";
    public static boolean gano ;


    Thread miThread;

    public Cronometro() {
        miThread = new Thread(this);
        miThread.start();
 

    }

  
    
   

    @Override
    public void run() {
        int cont = 0;
        int minutos;
        int segundos;
           gano= gane();

        while (gano == false) {
            
        
            
                for (minutos = 0; minutos < 60 ; minutos++) {
                   

                    for (segundos = 0; segundos < 60 ; segundos++) {
                       
                        tiempo = " 0" + minutos + ":" + segundos;
                        System.out.println("tiempo" + tiempo);
                        try {
                            System.out.println(" gane() " + gane());
                            miThread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }

            }

        }

    }

