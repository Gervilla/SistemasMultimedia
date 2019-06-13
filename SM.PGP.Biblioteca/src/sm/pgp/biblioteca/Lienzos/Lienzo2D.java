package sm.pgp.biblioteca.Lienzos;


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
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

    private Color colorTrazoAct;
    private Color colorRellenoAct;
    private Tipo tipo;
    private boolean rellenar;
    private float trazo; 
    private Point p1, p2;
    private FiguraPro actualShape;
    private ArrayList<FiguraPro> vShape;
    boolean editar;
    boolean renderizar;
    boolean transparencia;
    Shape clipArea;
    Rectangle marco;
    int figuraSelec = -1;
    double diferenciaX1 = 0;
    double diferenciaY1 = 0;
    double diferenciaX2 = 0;
    double diferenciaY2 = 0;
    /**
     * Constructor de la clase
     */
    public Lienzo2D() {
        colorTrazoAct = Color.BLACK;
        colorRellenoAct = Color.BLACK;
        tipo = Tipo.TRAZO;
        trazo = 1;
        vShape = new ArrayList();
        editar = false;
        renderizar = false;
        transparencia = false;
        clipArea = null;
        marco = new Rectangle();
        figuraSelec = -1;
        
        initComponents();
        setClipArea(500, 400);
        //System.out.println(this.editar);
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
        int i = 0;
        for (FiguraPro f:vShape){
            setAtributos(f, g2d);
            g2d.draw(f.getShape());
            if(i == figuraSelec && marco != null){
                pintarMarco(g2d);
            }
            i++;
        }
    }
    /**
     * Establece cual es el indice de la figura seleccionada en vShape.
     * @param i: indice de la figura.
     */
    public void setIndexFiguraSelec(int i){
        figuraSelec = i;
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
     * Devuelve la figura actual.
     * @return la figura actual.
     */
    public FiguraPro getFiguraActual(){
        return actualShape;
    }
    /**
     * Establece el marco de seleccion para las figuras.
     * @param m: marco de tipo Rectangle.
     */
    public void setMarco(Rectangle m){
        if (m != null)
            marco = m;
        repaint();
    }
    /**
     * Pinta el marco como un rectangulo rojo discontinuo.
     * @param g2d: objeto de la clase Graphics2D de Java.awt.
     */
    public void pintarMarco(Graphics2D g2d){
        g2d.setColor(Color.RED);
        
        Stroke trazo;
        float patronDiscontinuidad[] = {5.0f, 5.0f};
        trazo = new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, patronDiscontinuidad, 0.0f);
        g2d.setStroke(trazo);
        g2d.draw(marco);
    }
    /**
     * Aplica los atrbutos especificos de cada figura.
     * @param f: figura a la que aplicarle los atributos.
     * @param g2d: objeto de la clase Graphics2D de Java.awt.
     */
    protected void setAtributos(FiguraPro f, Graphics2D g2d){
        //Color
        g2d.setColor(f.getColorTrazo());
        
        //Trazo
        Stroke trazo;
        trazo = new BasicStroke(f.getTrazo(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f);
        g2d.setStroke(trazo);

        //Transparencia
        if(f.getTransparencia()){
            Composite composicion;
            composicion = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(composicion);
        }

        //Relleno
        if(f.getRelleno()){
            Paint relleno;
            relleno = f.getColorRelleno();
            g2d.setPaint(relleno);
            g2d.fill(f.getShape());
                
        }

        //Opciones de renderizado
        if(f.getRenderizado()){
            RenderingHints render;
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(render);
        }
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
     * Establece el color del relleno en el lienzo y en la figura actual.
     * @param color: nuevo color.
     */
    public void setColorRelleno(Color color){
        colorRellenoAct = color;
        this.actualShape.setColorRelleno(color);
    }
    /**
     * Establece si la figura actual tiene relleno o no.
     * @param rll: si la figura actual tiene relleno o no.
     */
    public void setRelleno(boolean rll){
        this.actualShape.setRelleno(rll);
        repaint();
    }
    /**
     * Establece el grosor del trazo de la figura actual.
     * @param trazo: grosor de la figura.
     */
    public void setTrazo(float trazo){
        this.actualShape.setTrazo(trazo);
        repaint();
    }
    /**
     * Establece tipo de la figuraactual.
     * @param tipo: Devuelve el tipo de la figura actual.
     */
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    /**
     * Establece si la figura actual tiene transparencia o no.
     * @param t: si es o no transparente.
     */
    public void setTransparencia(boolean t){
        this.actualShape.setTransparencia(t);
        repaint();
    }
    /**
     * Establece si la figura actual se renderiza o no.
     * @param r: si se renderiza o no.
     */
    public void setRenderizado(boolean r){
        this.actualShape.setRenderizado(r);
        repaint();
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
        if(!this.editar){
            p1 = evt.getPoint();
            switch (tipo){
                case TRAZO:
                    actualShape = new Trazo(colorTrazoAct);
                    ((Trazo)actualShape).moveOrigin(p1.x, p1.y);
                    vShape.add(actualShape);
                    break;

                case LINEA:
                    actualShape = new Linea(p1, p1, colorTrazoAct);
                    vShape.add(actualShape);
                    break;

                case RECTANGULO:
                    actualShape = new Rectangulo(p1, colorTrazoAct, colorRellenoAct);
                    vShape.add(actualShape);
                    break;

                case OVALO:
                    actualShape = new Ovalo(p1.x, p1.y, 0, 0, colorTrazoAct, colorRellenoAct);
                    vShape.add(actualShape);
                    break;

                case ABANICO:
                    //vShape.add(new Line2D.Float(p1, p1));
                    break;
            }
        }
        else{
            diferenciaX1 = evt.getX() - vShape.get(figuraSelec).getMinX();
            diferenciaY1 = evt.getY() - vShape.get(figuraSelec).getMinY();
            //diferenciaX2 = evt.getX() - vShape.get(figuraSelec).getMaxX();
            //diferenciaY2 = evt.getY() - vShape.get(figuraSelec).getMaxY();
            System.out.println(vShape.get(figuraSelec).getMinX());
            System.out.println(vShape.get(figuraSelec).getMinY() + "\n");
            //System.out.println(diferenciaX2);
            //System.out.println(diferenciaY2);
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
        if(!this.editar){
            p2 = evt.getPoint();
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
            FiguraPro f = vShape.get(figuraSelec);
            double nX1 = vShape.get(figuraSelec).getMinX() + diferenciaX1;
            double nY1 = vShape.get(figuraSelec).getMinY() + diferenciaY1;
            double nX2 = nX1;
            double nY2 = nY1;
            f.setPosicion(nX1, nY1, nX2, nY2);
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
