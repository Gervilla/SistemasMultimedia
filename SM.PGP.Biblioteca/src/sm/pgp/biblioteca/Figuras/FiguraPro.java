package sm.pgp.biblioteca.Figuras;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;


/**
 * Clase abstracta que contiene un objeto de tipo Shape, y hace de padre a formas mas especificas.
 * @author gervi
 */
public abstract class FiguraPro{
    /**
     * Color de trazo.
     */
    protected Color colorTrazo;
    /**
     * Tipo de subfigura.
     */
    protected Tipo tipo;
    /**
     * Grosor del trazo.
     */
    protected float grosor;
    /**
     * Si la figura se renderiza.
     */
    protected boolean renderizar;
    /**
     * Si la figura tiene transparencia.
     */
    protected boolean transparencia;
    /**
     * Si el trazo es continuo.
     */
    protected boolean continuo;
    /**
     * Grado de transparencia, desde invisible hasta opaco.
     */
    protected float nivelTransp;
    /**
     * Variable de control del trazo.
     */
    protected Stroke trazo;
    /**
     * Variable de control de la transparencia.
     */
    protected Composite composicion;
    /**
     * Variable de control del renderizado.
     */
    protected RenderingHints render;
    /**
     * Si la figura esta seleccionada.
     */
    protected boolean imSelected;
    /**
     * Objeto Shape de la figura.
     */
    protected Shape miShape = null;
    /**
     * Marco de seleccion de la figura.
     */
    private Rectangle marco;
    
    /**
     * Constructor de la clase.
     */
    public FiguraPro(){
        this.colorTrazo = null;
        this.grosor = 1;
        this.renderizar = false;
        this.transparencia = false;
        this.continuo = true;
        this.nivelTransp = 0.5f;
        
        this.trazo = new BasicStroke(grosor, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f);
        this.composicion = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        this.render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        this.miShape = null;
        marco = new Rectangle();
    }
    /**
     * Metodo que pinta la figura.
     * @param g: objeto de la clase Graphics de Java.awt.
     */
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        if(imSelected){
            pintarMarco(g2d);
        }
        setAtributos(this, g2d);
        g2d.draw(miShape);
    }
    /**
     * Metodo que aplica los atributos de la figura.
     * @param f: figura a la que aplicarle los atributos.
     * @param g2d: objeto de la clase Graphics2D de Java.awt.
     */
    protected void setAtributos(FiguraPro f, Graphics2D g2d){
        
        g2d.setColor(colorTrazo);
        if (continuo){
            this.trazo = new BasicStroke(grosor, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f);
        }
        else{
            float patronDiscontinuidad[] = {5.0f, 5.0f};
            this.trazo = new BasicStroke(grosor, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);
        }
        g2d.setStroke(trazo);
        
        if (transparencia){
            composicion = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, nivelTransp);
            g2d.setComposite(composicion);
        }
        if (renderizar){
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(render);
        }
    }
    /**
     * Pinta el marco como un rectangulo rojo discontinuo.
     * @param g2d: objeto de la clase Graphics2D de Java.awt.
     */
    public void pintarMarco(Graphics2D g2d){
        g2d.setColor(Color.RED);
        
        Stroke trazoM;
        float patronDiscontinuidad[] = {5.0f, 5.0f};
        trazoM = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);
        g2d.setStroke(trazoM);
        g2d.draw(marco);
    }
    
    //Gets y Sets
    /**
     * Establece si la figura ha sido seleccionada y establece su marco.
     * @param s: si la figura ha sido seleccionada.
     */
    public void setSelected(boolean s){
        imSelected = s;
        marco = this.getBounds();
    }
    /**
     * Establece si el trazo es continuo o discontinuo en la figura.
     * @param c 
     */
    public void setContinuidad(boolean c){
        this.continuo = c;
    }
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
        this.grosor = trazo;
    }
    /**
     * Devuelve el grosor del trazo.
     * @return el grosor del trazo.
     */
    public float getTrazo(){
        return grosor;
    }
    /**
     * Establece si esta FiguraPro tiene transparencia o no.
     * @param t: si es o no transparente.
     */
    public void setTransparencia(boolean t){
        this.transparencia = t;
    }
    /**
     * Establece el nivel de transparencia a aplicar a la figura.
     * @param n: nivel de transparencia a aplicar.
     */
    public void setNivelTransparencia(float n){
        this.nivelTransp = n;
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
     * Devuelve el punto donde se situa la figura.
     * @return el punto donde se situa la figura.
     */
    public Point getPosicion(){
        return miShape.getBounds().getLocation();
    }
    /**
     * Establece el color de relleno.
     * @param color: nuevo color.
     */
    public abstract void setColorRelleno(Color color);
    /**
     * Establece el color de relleno secundario.
     * @param color: nuevo color.
     */
    public abstract void setColorRelleno2(Color color);
    /**
     * Devuelve el color del relleno.
     * @return el color del relleno.
     */
    public abstract Color getColorRelleno();
    /**
     * Devuelve el color del relleno secundario.
     * @return el color del relleno secundario.
     */
    public abstract Color getColorRelleno2();
    /**
     * Establece si esta FiguraPro tiene relleno o no.
     * @param rll: si tiene relleno o no.
     */
    public abstract void setRelleno(boolean rll);
    /**
     * Establece si esta FiguraPro tiene relleno con degradado o no.
     * @param rld: si tiene relleno con degradado o no.
     */
    public abstract void setDegradado(boolean rld);
    /**
     * Establece la orientacion del degradado
     * @param tpd: tipo de degradado.
     */
    public abstract void setTipoDegradado(char tpd);
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
    public void setPosicion(double x1, double y1, double x2, double y2){
        marco.setFrameFromDiagonal(x1, y1, x2, y2);
    }
}
