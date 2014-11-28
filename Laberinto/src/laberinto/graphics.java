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

public class graphics extends JDialog {

//    public static final int CANTIDAD_COLUMNAS = 10;
//    private static final int CANTIDAD_FILAS = 10;
//    public static final int TAMANO_PIEZA = 0;
//    public static final int ANCHO_PANEL = 310;
//    public static final int ALTO_PANEL = 310;
//    public static final int ANCHO_SOMBRA = 4;
    public static int x, y;
    private Image dbImage;
    private Graphics dbg;
    public static graphics g;
    public MatrizLogica ml;

    public static graphics nuevaIntancia() {
        return g = new graphics(cantidadColumnas, cantidadFilas, tamanoPieza, anchoPanel, altoPanel, anchoSombra);
    }

    public static graphics getInstance(int cantidadColumnas, int cantidadFilas, int tamanoPieza, int anchoPanel, int altoPanel, int anchoSombra) {

        if (g == null) {
            return g = new graphics(cantidadColumnas, cantidadFilas, tamanoPieza, anchoPanel, altoPanel, anchoSombra);
        }
        return g;
    }

    public static int anchoPanel;
    public static int altoPanel;
    private static int cantidadColumnas;
    private static int cantidadFilas;
    private static int tamanoPieza;
    private static int anchoSombra;

    private graphics(int cantidadColumnas, int cantidadFilas, int tamanoPieza, int anchoPanel, int altoPanel, int anchoSombra) {

        this.cantidadColumnas = cantidadColumnas;
        this.cantidadFilas = cantidadFilas;
        this.tamanoPieza = tamanoPieza;
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
        addKeyListener(new Controles());
        setVisible(true);
        setBackground(Color.CYAN);
        setTitle("Laberinto");
        setSize(graphics.anchoPanel + 10, altoPanel + 30);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        x = 10;
        y = 180;
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
            }
        }
        dibujarl(g);
    }

    public void dibujarl(Graphics g) throws Exception {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 30, 30);
        dibujarLaberinto(g, ml.getMatriz());

    }

    public void dibujarLaberinto(Graphics g, int[][] matriz) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    g.fillRect(10 + (j * 30), 30 + (i * 30), 30, 30);
                }
            }

        }
    }

}
