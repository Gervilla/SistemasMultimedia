package sm.pgp.biblioteca.Lienzos;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import sm.pgp.biblioteca.Figuras.Tipo;
import sm.pgp.biblioteca.Figuras.FiguraPro;
import sm.pgp.biblioteca.Figuras.Linea;
import sm.pgp.biblioteca.Figuras.Ovalo;
import sm.pgp.biblioteca.Figuras.Rectangulo;
import sm.pgp.biblioteca.Figuras.Trazo;

/**
 * Clase que nos proporciona herramientas para dibujar con Graphics2D.
 * @author gervi
 */
public class Lienzo2D extends javax.swing.JPanel {
    
    // Atributos de dibujo
    private Color colorTrazoAct;
    private Color colorRellenoAct;
    private Color colorRellenoAct2;
    /**
     * tipo de figura.
     */
    private Tipo tipo;
    private boolean rellenar;
    private boolean degradado;
    private char tipoDegradado;
    private boolean continuo;
    private float grosor;
    private boolean renderizar;
    private boolean transparencia;
    private float nivelTransp;
    // Atributos del lienzo
    private Point p1, p2, puntoAnterior;
    private FiguraPro actualShape;
    private ArrayList<FiguraPro> vShape;
    private Shape clipArea;
    private int figuraSelec;
    private boolean editar;
    /**
     * Constructor de la clase
     */
    public Lienzo2D() {
        colorTrazoAct = Color.BLACK;
        colorRellenoAct = Color.BLACK;
        colorRellenoAct2 = Color.BLACK;
        tipo = Tipo.TRAZO;
        grosor = 1;
        vShape = new ArrayList();
        editar = false;
        renderizar = false;
        transparencia = false;
        nivelTransp = 0.5f;
        continuo = true;
        clipArea = null;
        figuraSelec = -1;
        actualShape = new Trazo(colorTrazoAct, grosor, renderizar, transparencia, continuo, nivelTransp);
        
        initComponents();
    }
    /**
     * Metodo paint que sobrecarga el de JComponent añadiendo mas funciones de dibujo.
     * @param g: objeto de la clase Graphics de Java.awt.
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setClip(clipArea);
        for (FiguraPro f:vShape){
            f.paint(g);
        }
    }
    /**
     * Establece cual es el indice de la figura seleccionada en vShape.
     * @param i: indice de la figura.
     */
    public void setFiguraSelec(int i){
        if (i == -1){
            vShape.get(figuraSelec).setSelected(false);
            figuraSelec = i;
        }
        else{
            if (figuraSelec >= 0)
                vShape.get(figuraSelec).setSelected(false);
            
            figuraSelec = i;
            vShape.get(figuraSelec).setSelected(true);
        }
        repaint();
    }
    /**
     * Devuelve cual es el indice de la figura seleccionada en vShape.
     * @return el indice de la figura seleccionada en vShape.
     */
    public int getIndexFiguraSelec(){
        return figuraSelec;
    }
    /**
     * Devuelve la FiguraPro con el indice indicado.
     * @param i: indice.
     * @return la FiguraPro con el indice indicado.
     */
    public FiguraPro getFiguraSelec(int i){
        return vShape.get(i);
    }
    /**
     * Establece como figura actual la seleccionada.
     * @param i: indice de la digura.
     */
    public void setActualShape(int i){
        actualShape = vShape.get(i);
    }
    /**
     * Devuelve la figura actual.
     * @return la figura actual.
     */
    public FiguraPro getFiguraActual(){
        return actualShape;
    }
    /**
     * Borra la figura seleccionada.
     * @param i: indice de la figura seleccionada.
     */
    public void borrarFiguraSelec(int i){
        actualShape = vShape.get(/*vShape.size()*/-1);
        //System.out.println(getIndexFiguraSelec());
        //actualShape = new Trazo(colorTrazoAct, grosor, renderizar, transparencia, continuo, nivelTransp);
        //vShape.remove(i);
    }
    /**
     * Establece si el trazo es continuo o discontinuo en el lienzo y a en la figura.
     * @param c 
     */
    public void setContinuidad(boolean c){
        continuo = c;
        this.actualShape.setContinuidad(c);
    }
    /**
     * Establece el color del trazo en el lienzo y en la figura actual.
     * @param color: nuevo color.
     */
    public void setColorTrazo(Color color){
        colorTrazoAct = color;
        this.actualShape.setColorTrazo(color);
        
    }
    /**
     * Devuelve el color de trazo activo o la figura.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return el color de trazo activo o de la figura.
     */
    public Color getColorTrazo(boolean getFigura){
        if(getFigura){
            return actualShape.getColorTrazo();
        }
        else
            return colorTrazoAct;
    }
    /**
     * Establece el color del relleno en el lienzo y en la figura actual.
     * @param color: nuevo color.
     */
    public void setColorRelleno(Color color){
        this.actualShape.setColorRelleno(color);
        this.colorRellenoAct = color;
        repaint();
    }
    /**
     * Establece el color del relleno secundario en el lienzo y en la figura actual.
     * @param color: nuevo color.
     */
    public void setColorRelleno2(Color color){
        this.actualShape.setColorRelleno2(color);
        this.colorRellenoAct2 = color;
        repaint();
    }
    /**
     * Devuelve el color de relleno activo o la figura.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return el color de relleno activo o de la figura.
     */
    public Color getColorRelleno(boolean getFigura){
        if(getFigura){
            return actualShape.getColorRelleno();
        }
        else
            return colorRellenoAct;
    }
    /**
     * Devuelve el color de relleno secundario activo o la figura.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return el color de relleno activo o de la figura.
     */
    public Color getColorRelleno2(boolean getFigura){
        if(getFigura){
            return actualShape.getColorRelleno2();
        }
        else
            return colorRellenoAct2;
    }
    /**
     * Establece si la figura actual y el lienzo tienen relleno o no.
     * @param rll: si la figura actual tiene relleno o no.
     */
    public void setRelleno(boolean rll){
        this.actualShape.setRelleno(rll);
        this.rellenar = rll;
        repaint();
    }
    /**
     * Establece si la figura actual y el lienzo tienen relleno con degradado o no.
     * @param rld: si la figura actual tiene relleno con degradado o no.
     */
    public void setDegradado(boolean rld){
        this.actualShape.setRelleno(rld);
        this.degradado = rld;
        repaint();
    }
    /**
     * Establece la orientacion del degradado
     * @param tpd: tipo de degradado.
     */
    public void setTipoDegradado(char tpd){
        this.actualShape.setTipoDegradado(tpd);
        this.tipoDegradado = tpd;
        repaint();
    }
    /**
     * Devuelve si el lienzo o la figura tiene habilitado el relleno.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return si el lienzo o la figura tiene habilitado el relleno.
     */
    public boolean getRelleno(boolean getFigura){
        if(getFigura){
            return actualShape.getRelleno();
        }
        else
            return rellenar;
    }
    /**
     * Establece el grosor del trazo en el lienzo y de la figura actual.
     * @param trazo: grosor de la figura.
     */
    public void setTrazo(float trazo){
        this.actualShape.setTrazo(trazo);
        this.grosor = trazo;
        repaint();
    }
    /**
     * Devuelve el tamaño de trazo del lienzo o la figura.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return el tamaño de trazo del lienzo o la figura.
     */
    public float getTrazo(boolean getFigura){
        if(getFigura){
            return actualShape.getTrazo();
        }
        else
            return grosor;
    }
    /**
     * Establece tipo de la figuraactual.
     * @param tipo: Devuelve el tipo de la figura actual.
     */
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    /**
     * Establece si la figura o el lienzo actual tiene transparencia o no.
     * @param t: si es o no transparente.
     */
    public void setTransparencia(boolean t){
        this.actualShape.setTransparencia(t);
        this.transparencia = t;
        repaint();
    }
    /**
     * Establece el nivel de transparencia a aplicar a la figura.
     * @param n: nivel de transparencia a aplicar.
     */
    public void setNivelTransparencia(float n){
        this.actualShape.setNivelTransparencia(n);
        this.nivelTransp = n;
        repaint();
    }
    /**
     * Devuelve si el lienzo o la figura tiene habilitado la transparencia.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return si el lienzo o la figura tiene habilitado la transparencia.
     */
    public boolean getTransparencia(boolean getFigura){
        if(getFigura){
            return actualShape.getTransparencia();
        }
        else
            return transparencia;
    }
    /**
     * Establece si la figura actual o el lienzo se renderiza o no.
     * @param r: si se renderiza o no.
     */
    public void setRenderizado(boolean r){
        this.actualShape.setRenderizado(r);
        this.renderizar = r;
        repaint();
    }
    /**
     * Devuelve si el lienzo o la figura tiene habilitado la renderizacion.
     * @param getFigura: si devuelve el valor de la figura o el del lienzo.
     * @return si el lienzo o la figura tiene habilitado la renderizacion.
     */
    public boolean getRenderizado(boolean getFigura){
        if(getFigura){
            return actualShape.getRenderizado();
        }
        else
            return renderizar;
    }
    /**
     * Establece si se cambia al modo edicion.
     * @param edt: si se cambia al modo edicion.
     */
    public void setEdicion(boolean edt){
        this.editar = edt;
    }
    /**
     * Devuelve si el lienzo esta en modo edicion.
     * @return si el lienzo esta en modo edicion.
     */
    public boolean isEditable(){
         return this.editar;
    }
    /**
     * Establece el area de dibujo del lienzo(un Rectangle).
     * @param x: tamaño en x del area.
     * @param y: tamaño en y del area.
     */
    public void setClipArea(int x, int y){
        this.clipArea = new Rectangle(0, 0, x, y);
        repaint();
    }
    /**
     * Devuelve el punto donde se situa la figura actual.
     * @return el punto donde se situa la figura actual.
     */
    public Point getPosicion(){
        return actualShape.getPosicion();
    }
    /**
     * Establece la figura actual en la posicion especificada.
     * @param x: componente en X de la posicion de la figura.
     * @param y: componente en Y de la posicion de la figura.
     */
    public void setPosicion(double x, double y){
        double nX1 = vShape.get(figuraSelec).getMinX() + (x - actualShape.getPosicion().x);
        double nY1 = vShape.get(figuraSelec).getMinY() + (y - actualShape.getPosicion().y);
        double nX2 = vShape.get(figuraSelec).getMaxX() + (x - actualShape.getPosicion().x);
        double nY2 = vShape.get(figuraSelec).getMaxY() + (y - actualShape.getPosicion().y);
        vShape.get(figuraSelec).setPosicion(nX1, nY1, nX2, nY2);
        repaint();
    }
    /**
     * initComponents generado por NetBeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Genera una nueva figura conforme a la posicion del raton y la añade al vector de figuras.
     * Si esta en modo edicion, prepara la figura seleccionada para moverla.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        p1 = evt.getPoint();
        if(!this.editar){
            switch (tipo){
                case TRAZO:
                    actualShape = new Trazo(colorTrazoAct, grosor, renderizar, transparencia, continuo, nivelTransp);
                    ((Trazo)actualShape).moveOrigin(p1.x, p1.y);
                    vShape.add(actualShape);
                    break;

                case LINEA:
                    actualShape = new Linea(p1, p1, colorTrazoAct, grosor, renderizar, transparencia, continuo, nivelTransp);
                    vShape.add(actualShape);
                    break;

                case RECTANGULO:
                    actualShape = new Rectangulo(p1, colorTrazoAct, colorRellenoAct, colorRellenoAct2, grosor, rellenar, degradado, tipoDegradado, transparencia, renderizar, continuo, nivelTransp);
                    vShape.add(actualShape);
                    break;

                case OVALO:
                    actualShape = new Ovalo(p1.x, p1.y, 0, 0, colorTrazoAct, colorRellenoAct, colorRellenoAct2, grosor, rellenar, degradado, tipoDegradado, transparencia, renderizar, continuo, nivelTransp);
                    vShape.add(actualShape);
                    break;

                case ABANICO:
                    //vShape.add(new Line2D.Float(p1, p1));
                    break;
            }
        }
        else{
            puntoAnterior = p1;
        }
    }//GEN-LAST:event_formMousePressed
    /**
     * Lanza el evento de arrastrado de raton.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased
    /**
     * Actualiza la forma de la figura que se esta pintando conforme a la posicion del raton.
     * Si esta en modo edicion, cambia la figura actual de posicion imitando el movimiento del raton.
     * @param evt: Objeto de evento de tipo MouseEvent. 
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        p2 = evt.getPoint();
        if(!this.editar){
            switch (tipo){
                case TRAZO:
                    ((Trazo)actualShape).lineToPoint(p2.x, p2.y);
                    break;

                case LINEA:
                    ((Linea)actualShape).setLine(p1, p2);
                    break;

                case RECTANGULO:
                    ((Rectangulo)actualShape).setFrameFromDiagonal(p1, evt.getPoint());
                    break;

                case OVALO:
                    ((Ovalo)actualShape).setFrameFromDiagonal(p1, evt.getPoint());
                    break;

                case ABANICO:
                    //vShape.add(new Line2D.Float(p1, p2));
                    break;
            }
        }
        else{
            double nX1 = vShape.get(figuraSelec).getMinX() + (p2.x - puntoAnterior.x);
            double nY1 = vShape.get(figuraSelec).getMinY() + (p2.y - puntoAnterior.y);
            double nX2 = vShape.get(figuraSelec).getMaxX() + (p2.x - puntoAnterior.x);
            double nY2 = vShape.get(figuraSelec).getMaxY() + (p2.y - puntoAnterior.y);
            vShape.get(figuraSelec).setPosicion(nX1, nY1, nX2, nY2);
            puntoAnterior = p2;
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
