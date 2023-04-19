
import java.awt.*;
import java.applet.*;
package pkg8reinas;

/**
 *
 * @author romina
 */
public class Reina {
        // atributos
    private int fila;
    private int columna;
    private Reina vecina;
    // constructor
    Reina (int c, Reina v) {
    fila = 1; // empieza a buscar una solución desde la primera fila
    columna = c; // la columna que se le ha asignado a esta reina
    vecina = v; // referencia a la reina de la izquierda
    }
    // ...
    private boolean puedeAtacar(int testfila, int testcolumna) {
        int diferenciaColumnas = testcolumna - columna;
        if ((fila == testfila) || // en la misma fila
        (fila + diferenciaColumnas == testfila) || // o en una diagonal
        (fila - diferenciaColumnas == testfila))
        return true;
        if (vecina != null) // mira si es atacable por las reinas a la izda.
        return vecina.puedeAtacar(testfila, testcolumna);
        return false; // la posición no es atacable
    }
    public boolean buscaSolución() {
        // si nadie la puede atacar ya es una solución:
        if ( vecina == null || !vecina.puedeAtacar(fila, columna) )
        return true;
        // si no, intenta avanzar a donde no la puedan atacar:
        if ( avanzar() ) return true;
        return false; // no se ha encontrado una solución
    }
    public boolean avanzar() {
        if ( fila < 8 ) { // avanzar una posición y mirar si hay solución
        fila++;
        return buscaSolución();
        }
        // si no puede avanzar, intentar que lo hagan las vecinas:
        if ( vecina != null && !vecina.avanzar() ) return false;
        // habiendo avanzado la vecina,
        // vuelve a la primera fila para encontrar una nueva solución:
        fila = 1;
        return buscaSolución();
    } 

    public void pintaReinas (Graphics g) {
        // primero pinta las vecinas
        if (vecina != null) vecina.pintaReinas(g);
        // y luego a sí misma
        // x, y es la esquina superior izquierda
        int x = (fila - 1) * 50;
        int y = (columna - 1) * 50;
        g.drawLine(x+5, y+45, x+45, y+45);
        g.drawLine(x+5, y+45, x+5, y+5);
        g.drawLine(x+45, y+45, x+45, y+5);
        g.drawLine(x+5, y+35, x+45, y+35);
        g.drawLine(x+5, y+5, x+15, y+20);
        g.drawLine(x+15, y+20, x+25, y+5);
        g.drawLine(x+25, y+5, x+35, y+20);
        g.drawLine(x+35, y+20, x+45, y+5);
        g.drawOval(x+20, y+20, 10, 10);
    }
    
    public class OchoReinasApplet extends Applet {
        private Reina últimaReina;
        public void init() {
        últimaReina = null;
        for (int i = 1; i <= 8; i++) {
        // crea una reina
        últimaReina = new Reina(i, últimaReina);
        // e intenta colocarla sin que nadie le ataque
        últimaReina.buscaSolución();
        }
    }
        // ...
        //...
        public void paint(Graphics g) {
        // pinta el tablero
        for (int i = 0; i <= 8; i++) {
        g.drawLine(50 * i, 0, 50*i, 400);
        g.drawLine(0, 50 * i, 400, 50*i);
        }
        // pinta las reinas
        últimaReina.pintaReinas(g);
        }
        public boolean mouseDown(java.awt.Event evt, int x, int y) {
        últimaReina.avanzar(); // busca otra solución
        repaint();
        return true;
        }
        }
    public static void main(String[] args) {
        
    }
}
