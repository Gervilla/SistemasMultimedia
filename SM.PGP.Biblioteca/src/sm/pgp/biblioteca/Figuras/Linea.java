package sm.pgp.biblioteca.Figuras;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

/**
 * Clase Linea que hereda de FiguraPro. 
 * Su funcionamiento es similar al de la clase Line2D.Float.
 * @author gervi
 */
public class Linea extends FiguraPro{
    /**
     * Constructor de la clase.
     * @param p1: punto inicial.
     * @param p2: punto final.
     * @param ct: color de trazo.
     */
    public Linea(Point p1, Point p2, Color ct){
        super();
        tipo = Tipo.LINEA;
        colorTrazo = ct;
        miShape = new Line2D.Float(p1, p2);
    }
    /**
     * Establece la linea entre dos puntos.
     * @param p1: punto inicial.
     * @param p2: punto final.
     */
    public void setLine(Point p1, Point p2){
        ((Line2D.Float)miShape).setLine(p1, p2);
    }
    /**
     * Establece el color de relleno (no hace nada ya que las lineas no tienen relleno).
     * @param color: nuevo color.
     */
    @Override
    public void setColorRelleno(Color color) {
    }
    /**
     * Devuelve el color del relleno(no hace nada ya que las lineas no tienen relleno).
     * @return el color del trazo al no tener relleno.
     */
    @Override
    public Color getColorRelleno() {
        return this.getColorTrazo();
    }
    /**
     * Establece si esta Linea tiene relleno o no(no hace nada ya que las lineas no tienen relleno).
     * @param rll: si tiene relleno o no (Spoiler: no va a tener).
     */
    @Override
    public void setRelleno(boolean rll) {
    }
    /**
     * Devuelve que esta Linea no tiene relleno.
     * @return no tiene relleno.
     */
    @Override
    public boolean getRelleno() {
        return false;
    }
    /**
     * Devuelve un Rectangle que encierra a esta Linea.
     * @return un Rectangle que encierra a esta Linea.
     */
    @Override
    public Rectangle getBounds() {
        return ((Line2D.Float)miShape).getBounds();
    }
    /**
     * Devuelve el minimo en x de esta Linea con precision de double.
     * @return el minimo en x de esta Linea con precision de double.
     */
    @Override
    public double getMinX(){
        return ((Line2D.Float)miShape).getX1();
    }
    /**
     * Devuelve el minimo en y de esta Linea con precision de double.
     * @return el minimo en y de esta Linea con precision de double.
     */
    @Override
    public double getMinY(){
        return ((Line2D.Float)miShape).getY1();
    }
    /**
     * Devuelve el maximo en x de esta Linea con precision de double.
     * @return el maximo en x de esta Linea con precision de double.
     */
    @Override
    public double getMaxX(){
        return ((Line2D.Float)miShape).getX2();
    }
    /**
     * Devuelve el maximo en y de esta Linea con precision de double.
     * @return el maximo en y de esta Linea con precision de double.
     */
    @Override
    public double getMaxY(){
        return ((Line2D.Float)miShape).getY2();
    }
    /**
     * Establece la posicion de esta Linea.
     * @param x1: Coordenada x del primer punto.
     * @param y1: Coordenada y del primer punto.
     * @param x2: Coordenada x del segundo punto.
     * @param y2: Coordenada y del segundo punto.
     */
    @Override
    public void setPosicion(double x1, double y1, double x2, double y2) {
        ((Line2D.Float)miShape).setLine(x1, y1, x2, y2);
    }
}
