package Velazquez;

import sm.pgp.biblioteca.Lienzos.LienzoImagen2D;

/**
 * Ventana interna al escritorio de la ventana principal, donde se aloja el lienzo.
 * @author gervi
 */
public class VentanaInterna extends javax.swing.JInternalFrame
{
    private VentanaPaint miVentana;
    /**
     * Constructor de la clase.
     * @param v: ventana principal.
     */
    public VentanaInterna(VentanaPaint v){
        initComponents();
        this.setSize(500, 400);
        miVentana = v;
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
            miVentana.vFigura.add(this.getLienzo().getFiguraActual());
            miVentana.cargarLista();
        }
    }//GEN-LAST:event_lienzoMouseReleased
    /**
     * Limpia la lista de figuras de la ventana principal si se cierra esta ventana.
     * @param evt: Objeto de evento de tipo PropertyChangeEvent.
     */
    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        if(evt.getPropertyName().equals("closed")){
            miVentana.vFigura.clear();
            miVentana.cargarLista();
        }
    }//GEN-LAST:event_formPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane;
    private sm.pgp.biblioteca.Lienzos.LienzoImagen2D lienzo;
    // End of variables declaration//GEN-END:variables



}
