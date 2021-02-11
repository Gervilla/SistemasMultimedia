package Velazquez;

import java.util.ArrayList;
import sm.pgp.biblioteca.Figuras.FiguraPro;
import sm.pgp.biblioteca.Lienzos.LienzoImagen2D;

/**
 * Ventana interna al escritorio de la ventana principal, donde se aloja el lienzo.
 * @author gervi
 */
public class VentanaInterna extends javax.swing.JInternalFrame
{
    /**
     * Ventana principal en la que se aloja esta ventana interna.
     */
    private VentanaPaint miVentana;
    /**
     * Copia del vector de figuras del lienzo.
     */
    protected ArrayList<FiguraPro> vFigura;
    
    /**
     * Constructor de la clase.
     * @param x: ancho.
     * @param y: alto.
     * @param v: ventana principal.
     */
    public VentanaInterna(int x, int y, VentanaPaint v){
        initComponents();
        this.setSize(x, y);
        miVentana = v;
        lienzo.setClipArea(x, y);
        vFigura = new ArrayList();
    }
    
    /*public void AsignarEscritorio(VentanaPaint v){
        miVentana = v;
    }*/
    /**
     * Devuelve el LienzoImagen2D contenido en la ventana.
     * @return el LienzoImagen2D contenido en la ventana.
     */
    public LienzoImagen2D getLienzo(){
        return this.lienzo;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        lienzo = new sm.pgp.biblioteca.Lienzos.LienzoImagen2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lienzoMouseDragged(evt);
            }
        });
        lienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lienzoMouseReleased(evt);
            }
        });
        jScrollPane.setViewportView(lienzo);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Añade la figura recien pintada al vector vFigura y carga la lista de figuras si el lienzo no es editable.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void lienzoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseReleased
        //this.getLienzo().setImagen(this.getLienzo().getImagen(true));
        
        if (!lienzo.isEditable()){
            vFigura.add(this.getLienzo().getFiguraActual());
            miVentana.cargarLista();
        }
    }//GEN-LAST:event_lienzoMouseReleased
    /**
     * Limpia la lista de figuras de la ventana actual si se cierra esta ventana o la restablece si se selecciona.
     * @param evt: Objeto de evento de tipo PropertyChangeEvent.
     */
    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        int i = 0;
        if(evt.getPropertyName().equals("closed")){
            if(i==0)//el evento de cierre se llama dos veces, con esto eliminamos el duplicado (podria y ha dado problemas).
                i++;
            else{
                i=0;
                miVentana.cargarLista();
            }
        }
        if (evt.getPropertyName().equals("selected")){
            miVentana.cargarAtributos();
            miVentana.cargarLista();
        }
        if(evt.getPropertyName().equals("ancestor")){
            lienzo.setTipo(miVentana.getHerramienta());
        }
    }//GEN-LAST:event_formPropertyChange

    private void lienzoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzoMouseDragged
        miVentana.setXY(lienzo.getFiguraActual().getPosicion());
    }//GEN-LAST:event_lienzoMouseDragged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private sm.pgp.biblioteca.Lienzos.LienzoImagen2D lienzo;
    // End of variables declaration//GEN-END:variables



}
