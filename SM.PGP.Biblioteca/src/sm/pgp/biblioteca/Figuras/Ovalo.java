package sm.pgp.biblioteca.Figuras;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * Clase Ovalo que hereda de FiguraPro y añade los atributos de relleno y color del relleno
 * y sus respectivos metodos get y set. 
 * Su funcionamiento es similar al de la clase Ellipse2D.Double.
 * @author gervi
 */
public class Ovalo extends FiguraPro{
    
    protected boolean rellenar = false;
    protected Color colorRelleno = Color.BLACK;
    protected double w;
    protected double h;
    /**
     * Costructor de la clase.
     * @param x: componente x de la posicion.
     * @param y: componente y de la posicion.
     * @param w: anchura de la figura.
     * @param h: altura de la figura.
     * @param ct: colorde trazo.
     * @param cr: color de relleno.
     */
    public Ovalo(double x, double y, double w, double h, Color ct, Color cr){
        super();
        tipo = Tipo.OVALO;
        colorTrazo = ct;
        colorRelleno = cr;
        this.w = w;
        this.h = h;
        miShape = new Ellipse2D.Double(x, y, w, h);
    }
    /**
     * Establece la diagonal del Ovalo en base a dos puntos.
     * @param p1: punto 1.
     * @param p2: punto 2.
     */
    public void setFrameFromDiagonal(Point p1, Point p2){
        ((Ellipse2D.Double)miShape).setFrameFromDiagonal(p1, p2);
    }
    
    //Gets y Sets
    /**
     * Establece el color de relleno.
     * @param color: nuevo color.
     */
    @Override
    public void setColorRelleno(Color color){
        this.colorRelleno = color;
    }
    /**
     * Devuelve el color del relleno.
     * @return el color del relleno.
     */
    @Override
    public Color getColorRelleno(){
        return colorRelleno;
    }
    /**
     * Establece si esta FiguraPro tiene relleno o no.
     * @param rll: si tiene relleno o no.
     */
    @Override
    public void setRelleno(boolean rll){
        this.rellenar = rll;
    }
    /**
     * Devuelve si esta FiguraPro tiene relleno o no.
     * @return si esta FiguraPro tiene relleno o no.
     */
    @Override
    public boolean getRelleno(){
        return rellenar;
    }
    /**
     * Devuelve un Rectangle que encierra a este Ovalo.
     * @return un Rectangle que encierra a este Ovalo.
     */
    @Override
    public Rectangle getBounds() {
        return ((Ellipse2D.Double)miShape).getBounds();
    }
    /**
     * Devuelve el minimo en x de este Ovalo con precision de double.
     * @return el minimo en x de este Ovalo con precision de double.
     */
    @Override
    public double getMinX(){
        return ((Ellipse2D.Double)miShape).getMinX();
    }
    /**
     * Devuelve el minimo en y de este Ovalo con precision de double.
     * @return el minimo en y de este Ovalo con precision de double.
     */
    @Override
    public double getMinY(){
        return ((Ellipse2D.Double)miShape).getMinY();
    }
    /**
     * Devuelve el maximo en x de este Ovalo con precision de double.
     * @return el maximo en x de este Ovalo con precision de double.
     */
    @Override
    public double getMaxX(){
        return ((Ellipse2D.Double)miShape).getMaxX();
    }
    /**
     * Devuelve el maximo en y de este Ovalo con precision de double.
     * @return el maximo en y de este Ovalo con precision de double.
     */
    @Override
    public double getMaxY(){
        return ((Ellipse2D.Double)miShape).getMaxY();
    }
    /**
     * Establece la posicion de este Ovalo.
     * @param x1: Coordenada x del primer punto.
     * @param y1: Coordenada y del primer punto.
     * @param x2: Coordenada x del segundo punto.
     * @param y2: Coordenada y del segundo punto.
     */
    @Override
    public void setPosicion(double x1, double y1, double x2, double y2) {
        ((Ellipse2D.Double)miShape).setFrameFromDiagonal(x1, y1, x2, y2);
    }
}
