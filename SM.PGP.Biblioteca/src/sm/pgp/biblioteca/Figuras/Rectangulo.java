package sm.pgp.biblioteca.Figuras;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Clase Rectangulo que hereda de FiguraPro y añade los atributos de relleno y color del relleno
 * y sus respectivos metodos get y set. 
 * Su funcionamiento es similar al de la clase Rectangle.
 * @author gervi
 */
public class Rectangulo extends FiguraPro{
    /**
     * Si la figura tiene relleno.
     */
    private boolean rellenar;
    /**
     * Si la figura tiene degradado.
     */
    private boolean degradado;
    /**
     * Orientacion del degradado.
     */
    private char tipoDegradado;
    /**
     * Punto de relleno 1.
     */
    private Point p1;
    /**
     * Punto de relleno 2.
     */
    private Point p2;
    /**
     * Color de relleno frontal.
     */
    private Color colorRelleno;
    /**
     * Color de relleno trasero.
     */
    private Color colorRelleno2;
    /**
     * Variable de control del relleno.
     */
    private Paint relleno;
    

    /**
     * Constructor de la clase.
     * @param p1: punto inicial.
     * @param ct: colorde trazo.
     * @param cr: color de relleno.
     * @param cr2: color de relleno secundario.
     * @param gr: grosor de trazo.
     * @param rll: con relleno.
     * @param rld: con degradado.
     * @param tpd: orientacion del degradado.
     * @param r: opcion de renderizado.
     * @param tp: con transparencia
     * @param con: continuidad de trazo.
     * @param nt: nivel de transparencia.
     */
    public Rectangulo(Point p1, Color ct, Color cr, Color cr2, float gr, boolean rll, boolean rld, char tpd, boolean tp, boolean r, boolean con, float nt){
        super();
        this.tipo = Tipo.RECTANGULO;
        this.colorTrazo = ct;
        this.colorRelleno = cr;
        this.colorRelleno2 = cr2;
        this.grosor = gr;
        this.renderizar = r;
        this.transparencia = tp;
        this.rellenar = rll;
        this.degradado = rld;
        this.tipoDegradado = tpd;
        this.relleno = colorRelleno;
        this.continuo = con;
        this.nivelTransp = nt;
        
        this.miShape = new Rectangle(p1);
    }
    /**
     * Costructor de la clase.
     * @param x: componente x de la posicion.
     * @param y: componente y de la posicion.
     * @param w: anchura de la figura.
     * @param h: altura de la figura.
     * @param ct: colorde trazo.
     * @param cr: color de relleno. 
     */
    public Rectangulo(int x, int y, int w, int h, Color ct, Color cr){
        super();
        colorTrazo = ct;
        colorRelleno = cr;
        miShape = new Rectangle(x, y, w, h);
    }
    /**
     * Metodo que aplica los atributos de la figura.
     * @param f: figura a la que aplicarle los atributos.
     * @param g2d: objeto de la clase Graphics2D de Java.awt.
     */
    @Override
    protected void setAtributos(FiguraPro f, Graphics2D g2d){
        if(rellenar){
            if (degradado){
                switch (tipoDegradado){
                    case 'h':
                        p1 = new Point(((int)this.getMinX()), ((int)this.getMaxY()) - ((int)this.getMinY()));
                        p2 = new Point(((int)this.getMaxX()), ((int)this.getMaxY()) - ((int)this.getMinY()));
                        break;
                    case 'd':
                        p1 = new Point(((int)this.getMinX()), ((int)this.getMinY()));
                        p2 = new Point(((int)this.getMaxX()), ((int)this.getMaxY()));
                        break;
                    case 'i':
                        p1 = new Point(((int)this.getMinX()), ((int)this.getMaxY()));
                        p2 = new Point(((int)this.getMaxX()), ((int)this.getMinY()));
                        break;
                    case 'v':
                        p1 = new Point(((int)this.getMaxX()) - ((int)this.getMinX()), ((int)this.getMinY()));
                        p2 = new Point(((int)this.getMaxX()) - ((int)this.getMinX()), ((int)this.getMaxY()));
                        break;
                }
                relleno = new GradientPaint(p1, colorRelleno, p2, colorRelleno2);
            }
            else{
                /*p1 = new Point(((int)this.getMinX()), ((int)this.getMinY()));
                p2 = new Point(((int)this.getMaxX()), ((int)this.getMaxY()));
                relleno = new GradientPaint(p1, colorRelleno, p2, colorRelleno);*/
                relleno = colorRelleno;
            }
            
            g2d.setPaint(relleno);
            g2d.fill(f.getShape());
        }
        super.setAtributos(f, g2d);
    }
    /**
     * Establece la diagonal del Rectangulo en base a dos puntos.
     * @param p1: punto 1.
     * @param p2: punto 2.
     */
    public void setFrameFromDiagonal(Point p1, Point p2){
        ((Rectangle)miShape).setFrameFromDiagonal(p1, p2);
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
     * Establece el color de relleno secundario.
     * @param color: nuevo color.
     */
    @Override
    public void setColorRelleno2(Color color){
        this.colorRelleno2 = color;
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
     * Devuelve el color del relleno secundario.
     * @return el color del relleno secundario.
     */
    @Override
    public Color getColorRelleno2(){
        return colorRelleno2;
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
     * Establece si la figura actual y el lienzo tienen relleno con degradado o no.
     * @param rld: si la figura actual tiene relleno con degradado o no.
     */
    @Override
    public void setDegradado(boolean rld){
        this.degradado = rld;
    }
    /**
     * Establece la orientacion del degradado
     * @param tpd: tipo de degradado.
     */
    @Override
    public void setTipoDegradado(char tpd){
        this.tipoDegradado = tpd;
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
     * Devuelve un Rectangle que encierra a este Rectangulo.
     * @return un Rectangle que encierra a este Rectangulo.
     */
    @Override
    public Rectangle getBounds() {
        return ((Rectangle)miShape).getBounds();
    }
    /**
     * Devuelve el minimo en x de este Rectangulo con precision de double.
     * @return el minimo en x de este Rectangulo con precision de double.
     */
    @Override
    public double getMinX(){
        return ((Rectangle)miShape).getMinX();
    }
    /**
     * Devuelve el minimo en y de este Rectangulo con precision de double.
     * @return el minimo en y de este Rectangulo con precision de double.
     */
    @Override
    public double getMinY(){
        return ((Rectangle)miShape).getMinY();
    }
    /**
     * Devuelve el maximo en x de este Rectangulo con precision de double.
     * @return el maximo en x de este Rectangulo con precision de double.
     */
    @Override
    public double getMaxX(){
        return ((Rectangle)miShape).getMaxX();
    }
    /**
     * Devuelve el maximo en y de este Rectangulo con precision de double.
     * @return el maximo en y de este Rectangulo con precision de double.
     */
    @Override
    public double getMaxY(){
        return ((Rectangle)miShape).getMaxY();
    }
    /**
     * Establece la posicion de este Rectangulo.
     * @param x1: Coordenada x del primer punto.
     * @param y1: Coordenada y del primer punto.
     * @param x2: Coordenada x del segundo punto.
     * @param y2: Coordenada y del segundo punto.
     */
    @Override
    public void setPosicion(double x1, double y1, double x2, double y2) {
        super.setPosicion(x1, y1, x2, y2);
        ((Rectangle)miShape).setFrameFromDiagonal(x1, y1, x2, y2);
    }
}
