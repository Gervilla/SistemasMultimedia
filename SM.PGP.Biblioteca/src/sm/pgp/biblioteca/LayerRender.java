package sm.pgp.biblioteca;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sm.pgp.biblioteca.Figuras.FiguraPro;

/**
 * Clase que hereda de JPanel e implementa ListCellRenderer de tipo FiguraPro.
 * Nos proporciona un componente de tipo FiguraPro.
 * @author gervi
 */
public class LayerRender extends javax.swing.JPanel implements ListCellRenderer<FiguraPro> {

    /**
     * Constructor de la clase.
     */
    public LayerRender() {
        initComponents();
    }
    

    /**
     * initComponents generado por NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imagenFigura = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        nombreFigura = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(35, 35));
        jPanel1.setMinimumSize(new java.awt.Dimension(30, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.setLayout(new java.awt.CardLayout());

        imagenFigura.setMaximumSize(new java.awt.Dimension(30, 30));
        imagenFigura.setMinimumSize(new java.awt.Dimension(30, 30));
        imagenFigura.setPreferredSize(new java.awt.Dimension(30, 30));
        jPanel1.add(imagenFigura, "card2");

        add(jPanel1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(20, 40));
        add(jSeparator1);
        add(nombreFigura);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imagenFigura;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombreFigura;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public Component getListCellRendererComponent(JList<? extends FiguraPro> list, FiguraPro value, int index, boolean isSelected, boolean cellHasFocus) {
        switch(value.getTipo()){
            case TRAZO:
                imagenFigura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Lapiz.gif")));
                nombreFigura.setText("Trazo Libre");
                break;
                
            case LINEA:
                imagenFigura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Linea.gif")));
                nombreFigura.setText("Linea");
                break;
                
            case OVALO:
                imagenFigura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Ovalo.gif")));
                nombreFigura.setText("Ovalo");
                break;
                
            case RECTANGULO:
                imagenFigura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Rectangulo.gif")));
                nombreFigura.setText("Rectangulo");
                break;
        }
        return this;
    }
}
