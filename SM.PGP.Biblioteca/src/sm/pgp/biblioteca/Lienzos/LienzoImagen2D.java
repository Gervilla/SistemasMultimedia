package sm.pgp.biblioteca.Lienzos;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Clase que hereda de Lienzo 2D y nos proporciona herramientas para pintary tratar imagenes.
 * @author gervi
 */
public class LienzoImagen2D extends Lienzo2D {

    private BufferedImage imagen;
    /**
     * Constructor de la clase.
     */
    public LienzoImagen2D() {
        initComponents();
    }
    /**
     * Metodo paintComponent que sobrecarga el de JComponent de manera que primero se pinte la imagen, y luego las formas de Lienzo2D.
     * @param g: objeto de la clase Graphics de Java.awt.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(imagen!=null) 
            g.drawImage(imagen,0,0,this);
    }
    /**
     * Devuelve un BufferedImage.
     * Puede devolver la imagen del lienzo o la imagen con las jiguras dibujadas en ella.
     * @param drawVector: si se dibujan o no las figuras.
     * @return 
     */
    public BufferedImage getImagen(boolean drawVector){
        if(drawVector){
            int w = this.getWidth();
            int h = this.getHeight();
            BufferedImage buffI = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = buffI.createGraphics();
            paint(g);
            return buffI;
        }
        else{
            return imagen;
        }
    }
    /**
     * Carga una imagen dentro del lienzo.
     * @param imagen: imagen a cargar.
     */
    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
        if(imagen!=null)
            setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
        //*******************************************************************************************************************************************
    }
    /**
     * initComponents generado por NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
