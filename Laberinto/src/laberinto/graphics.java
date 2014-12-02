/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 * @author Brando
 * @author Ale.
 * @author Denisse.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static laberinto.Cronometro.tiempo;

public class graphics extends JDialog {

//    public static final int CANTIDAD_COLUMNAS = 10;x
//    private static final int CANTIDAD_FILAS = 10;x
//    public static final int TAMANO_PIEZA = 0;x
//    public static final int ANCHO_PANEL = 310;xx
//    public static final int ALTO_PANEL = 310;xx
//    public static final int ANCHO_SOMBRA = 4;x
    public static int x, y;
    private Image dbImage;
    private Graphics dbg;
    public static graphics g;
    public MatrizLogica ml;

    public static graphics nuevaIntancia() {
        return g = new graphics();
    }

    public static graphics getInstance() {

        if (g == null) {
            return g = new graphics();
        }
        return g;
    }

    public static int anchoPanel;
    public static int altoPanel;
    private static int cantidadColumnas;
    private static int cantidadFilas;
    private static int tamanoPieza;
    private static int anchoSombra;

    private graphics() {
        x = 10;
        y = 180;

    }

    public void setAltoAncho(int alto, int ancho) {
        anchoPanel = ancho;
        altoPanel = alto;
    }

    public void paint(Graphics g) {
        ml = new MatrizLogica();
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();

        try {
            paintComponent(dbg);
        } catch (InterruptedException ex) {
            Logger.getLogger(graphics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) throws InterruptedException, Exception {

        repaint();
        for (int x = 0; x <= cantidadColumnas; x++) {
            for (int y = 0; y <= cantidadFilas; y++) {
                g.drawLine(10, y * tamanoPieza, cantidadColumnas * tamanoPieza + 10, y * tamanoPieza);
                g.drawLine(x * tamanoPieza + 10, 0 + 30, x * tamanoPieza + 10, cantidadFilas * tamanoPieza);
                g.drawString(tiempo, 8, 60);
            }
        }
        dibujarl(g);
    }

    public void dibujarl(Graphics g) throws Exception {

        g.setColor(new Color(255, 128, 0));
        g.fillRect(x, y, 30, 30);
        dibujarLaberinto(g, ml.getMatriz());

    }

    public void dibujarLaberinto(Graphics g, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    g.setColor(new Color(14, 85, 165));
                    g.fillRect(10 + (j * 30), 30 + (i * 30), 30, 30);
                }

            }

        }
    }

//    public void metodo(int cantidadColumnas, int cantidadFilas, int tamanoPieza, int anchoPanel, int altoPanel, int anchoSombra) {
//
//    }
    public void go() {

        addKeyListener(new Controles());
        setVisible(true);
        setBackground(new Color(192, 192, 192));
        setTitle("Laberinto");
        setSize(graphics.anchoPanel * 31, altoPanel * 32);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
