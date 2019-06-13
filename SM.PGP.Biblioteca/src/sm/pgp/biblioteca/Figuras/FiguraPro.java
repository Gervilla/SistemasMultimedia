package sm.pgp.biblioteca.Figuras;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;


/**
 * Clase abstracta que contiene un objeto de tipo Shape, y hace de padre a formas mas especificas.
 * @author gervi
 */
public abstract class FiguraPro{
    protected Color colorTrazo;
    protected Tipo tipo;
    protected float trazo;
    protected boolean renderizar;
    protected boolean transparencia;
    
    
    protected Shape miShape = null;
    
    /**
     * Constructor de la clase.
     */
    public FiguraPro(){
        colorTrazo = null;
        tipo = Tipo.TRAZO;
        trazo = 1;
        renderizar = false;
        transparencia = false;
        
        miShape = null;
    }

    //Gets y Sets
    
    /**
     * Devuelve el objeto Tipo de la figura.
     * @return Devuelve el tipo de la figura.
     */
    public Tipo getTipo(){
        return tipo;
    }
    /**
     * Devuelve el Shape de esta FiguraPro.
     * @return el Shape de esta FiguraPro.
     */
    public Shape getShape(){
        return miShape;
    }
    /**
     * Establece el color del trazo para esta FiguraPro.
     * @param color: nuevo color.
     */
    public void setColorTrazo(Color color){
        this.colorTrazo = color;
    }
    /**
     * Devuelve el color del trazo.
     * @return el color del trazo.
     */
    public Color getColorTrazo(){
        return colorTrazo;
    }
    /**
     * Establece el grosor del trazo.
     * @param trazo: nuevo grosor de trazo.
     */
    public void setTrazo(float trazo){
        this.trazo = trazo;
    }
    /**
     * Devuelve el grosor del trazo.
     * @return el grosor del trazo.
     */
    public float getTrazo(){
        return trazo;
    }
    /**
     * Establece si esta FiguraPro tiene transparencia o no.
     * @param t: si es o no transparente.
     */
    public void setTransparencia(boolean t){
        this.transparencia = t;
    }
    /**
     * Devuelve si esta FiguraPro tiene transparencia o no.
     * @return si esta FiguraPro tiene transparencia o no.
     */
    public boolean getTransparencia(){
        return transparencia;
    }
    /**
     * Establece si a esta FiguraPro se le aplica renderizado.
     * @param r: si se renderiza o no.
     */
    public void setRenderizado(boolean r){
        this.renderizar = r;
    }
    /**
     * Devuelve si a esta FiguraPro se le aplica renderizado.
     * @return si a esta FiguraPro se le aplica renderizado.
     */
    public boolean getRenderizado(){
        return renderizar;
    }
    
    /**
     * Establece el color de relleno.
     * @param color: nuevo color.
     */
    public abstract void setColorRelleno(Color color);
    /**
     * Devuelve el color del relleno.
     * @return el color del relleno.
     */
    public abstract Color getColorRelleno();
    /**
     * Establece si esta FiguraPro tiene relleno o no.
     * @param rll: si tiene relleno o no.
     */
    public abstract void setRelleno(boolean rll);
    /**
     * Devuelve si esta FiguraPro tiene relleno o no.
     * @return si esta FiguraPro tiene relleno o no.
     */
    public abstract boolean getRelleno();
    /**
     * Devuelve un Rectangle que encierra a esta FiguraPro.
     * @return un Rectangle que encierra a esta FiguraPro.
     */
    public abstract Rectangle getBounds();
    /**
     * Devuelve el minimo en x de esta FiguraPro con precision de double.
     * @return el minimo en x de esta FiguraPro con precision de double.
     */
    public abstract double getMinX();
    /**
     * Devuelve el minimo en y de esta FiguraPro con precision de double.
     * @return el minimo en y de esta FiguraPro con precision de double.
     */
    public abstract double getMinY();
    /**
     * Devuelve el maximo en x de esta FiguraPro con precision de double.
     * @return el maximo en x de esta FiguraPro con precision de double.
     */
    public abstract double getMaxX();
    /**
     * Devuelve el maximo en y de esta FiguraPro con precision de double.
     * @return el maximo en y de esta FiguraPro con precision de double.
     */
    public abstract double getMaxY();
    /**
     * Establece la posicion de esta FiguraPro.
     * @param x1: Coordenada x del primer punto.
     * @param y1: Coordenada y del primer punto.
     * @param x2: Coordenada x del segundo punto.
     * @param y2: Coordenada y del segundo punto.
     */
    public abstract void setPosicion(double x1, double y1, double x2, double y2);
}
