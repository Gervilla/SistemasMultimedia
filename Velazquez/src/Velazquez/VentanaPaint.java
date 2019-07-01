/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Velazquez;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.DataBuffer;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sm.image.BlendOp;
import sm.pgp.biblioteca.ColorRender;
import sm.pgp.biblioteca.Figuras.Tipo;
import sm.pgp.biblioteca.Lienzos.Lienzo2D;
import sm.pgp.biblioteca.Filtros.SenoOp;
import sm.pgp.biblioteca.Filtros.SepiaOp;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.image.TintOp;
import sm.image.EqualizationOp;
import sm.image.SubtractionOp;
import sm.pgp.biblioteca.Figuras.FiguraPro;
import sm.pgp.biblioteca.FileFilterExtension;
import sm.pgp.biblioteca.Filtros.TempMixOp;
import sm.pgp.biblioteca.Filtros.ColorizacionOp;
import sm.pgp.biblioteca.Filtros.NegativoOp;
import sm.pgp.biblioteca.Filtros.TritanOp;
import sm.pgp.biblioteca.Filtros.UmbralizacionOp;
import sm.pgp.biblioteca.LayerRender;
import sm.sound.SMRecorder;
import sm.sound.SMSoundRecorder;
//import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
//import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
//import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
//import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 * Ventana principal del programa donde se aloja el escritorio y toda la interfaz de usuario.
 * @author gervi
 */
public class VentanaPaint extends javax.swing.JFrame {

    /**
     * Constructor de la clase.
     */
    public VentanaPaint() {
        initComponents();
        //this.setMaximumSize(this.getMaximumSize());
        this.setSize(1350, 720);
        this.setLocationRelativeTo(null);
        this.setTitle("Velazquez");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/Gervilla.png")));
        
        OK.setVisible(false);
        
        panelEscala.setVisible(false);
        panelRotacion.setVisible(false);
        Separador2.setVisible(false);
        
        panelBrillo.setVisible(false);
        panelContraste.setVisible(false);
        
        panelTransp.setVisible(false);
        
        panelRelleno.setVisible(false);
        
        panelRgb.setVisible(false);
        RActionPerformed(null);
        
        Separador6.setVisible(false);
        panelDegradado.setVisible(false);
        herramienta = Tipo.TRAZO;
    }
    /**
     * initComponents generado por NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Herramientas = new javax.swing.ButtonGroup();
        ContinuidadTrazo = new javax.swing.ButtonGroup();
        ColorizarG = new javax.swing.ButtonGroup();
        TipoRelleno = new javax.swing.ButtonGroup();
        TipoDegradado = new javax.swing.ButtonGroup();
        SeleccionarTam = new javax.swing.JFrame();
        SeleccionarTam.setSize(400, 200);
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Ancho = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Alto = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Defecto = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        BHerram = new javax.swing.JToolBar();
        Nuevo = new javax.swing.JButton();
        Abrir = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Separador1 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        Color c[] = {Color.BLACK, Color.GREEN, Color.YELLOW, Color.BLUE, Color.RED, Color.WHITE};
        ListaColores = new javax.swing.JComboBox<>(c);
        Grosor = new javax.swing.JSpinner();
        TrazoC = new javax.swing.JToggleButton();
        TrazoD = new javax.swing.JToggleButton();
        Separador2 = new javax.swing.JToolBar.Separator();
        panelRotacion = new javax.swing.JPanel();
        Rotacion = new javax.swing.JSlider();
        Rotar90 = new javax.swing.JButton();
        Rotar180 = new javax.swing.JButton();
        Rotar270 = new javax.swing.JButton();
        panelEscala = new javax.swing.JPanel();
        Incrementar = new javax.swing.JButton();
        Decrementar = new javax.swing.JButton();
        Separador3 = new javax.swing.JToolBar.Separator();
        Relleno = new javax.swing.JToggleButton();
        Renderizado = new javax.swing.JToggleButton();
        Transparencia = new javax.swing.JToggleButton();
        Separador4 = new javax.swing.JToolBar.Separator();
        ReproductorAudio = new javax.swing.JPanel();
        PlayPause = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Grabar = new javax.swing.JButton();
        PlayList = new javax.swing.JComboBox<>();
        Separador7 = new javax.swing.JToolBar.Separator();
        ReproductorVideo = new javax.swing.JPanel();
        PlayPauseV = new javax.swing.JButton();
        StopV = new javax.swing.JButton();
        Camara = new javax.swing.JButton();
        Captura = new javax.swing.JButton();
        OK = new javax.swing.JButton();
        panelInferior = new javax.swing.JPanel();
        panelEstado = new javax.swing.JPanel();
        HerramientaAct = new javax.swing.JLabel();
        panelAjustes = new javax.swing.JPanel();
        panelBrillo = new javax.swing.JPanel();
        brillo = new javax.swing.JSlider();
        panelContraste = new javax.swing.JPanel();
        Contraste = new javax.swing.JButton();
        Iluminar = new javax.swing.JButton();
        Oscurecer = new javax.swing.JButton();
        panelEfectos = new javax.swing.JPanel();
        Efectos = new javax.swing.JComboBox<>();
        panelSeno = new javax.swing.JPanel();
        FuncionSeno = new javax.swing.JButton();
        TempMix = new javax.swing.JButton();
        Tritanopia = new javax.swing.JButton();
        Sepia = new javax.swing.JButton();
        Tintar = new javax.swing.JButton();
        Ecualizar = new javax.swing.JButton();
        Ecualizar1 = new javax.swing.JButton();
        Negativo = new javax.swing.JButton();
        Colorizar = new javax.swing.JButton();
        espColor = new javax.swing.JPanel();
        SplitBands = new javax.swing.JButton();
        EspacioColor = new javax.swing.JComboBox<>();
        panelBinario = new javax.swing.JPanel();
        Mas = new javax.swing.JButton();
        Menos = new javax.swing.JButton();
        Alfa = new javax.swing.JSpinner();
        panelUmbral = new javax.swing.JPanel();
        Umbral = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        FiguraPro vf[] = {};
        ListaFiguras = new javax.swing.JList<FiguraPro>(vf);
        panelDibujo = new javax.swing.JPanel();
        Lapiz = new javax.swing.JToggleButton();
        Linea = new javax.swing.JToggleButton();
        Rectangulo = new javax.swing.JToggleButton();
        Ovalo = new javax.swing.JToggleButton();
        Abanico = new javax.swing.JToggleButton();
        Separador5 = new javax.swing.JSeparator();
        xLbl = new javax.swing.JLabel();
        xTxt = new javax.swing.JTextField();
        yLbl = new javax.swing.JLabel();
        yTxt = new javax.swing.JTextField();
        trazolbl = new javax.swing.JLabel();
        ColorTrazo = new javax.swing.JButton();
        rellenolbl = new javax.swing.JLabel();
        ColorRelleno = new javax.swing.JButton();
        ColorRelleno2 = new javax.swing.JButton();
        Escritorio = new javax.swing.JDesktopPane();
        panelRelleno = new javax.swing.JPanel();
        Rnormal = new javax.swing.JToggleButton();
        Rdegradado = new javax.swing.JToggleButton();
        Separador6 = new javax.swing.JSeparator();
        panelDegradado = new javax.swing.JPanel();
        DegHor = new javax.swing.JToggleButton();
        DegDig2 = new javax.swing.JToggleButton();
        DegVer = new javax.swing.JToggleButton();
        DegDig1 = new javax.swing.JToggleButton();
        panelTransp = new javax.swing.JPanel();
        NivelTransp = new javax.swing.JSlider();
        panelRgb = new javax.swing.JPanel();
        R = new javax.swing.JRadioButton();
        G = new javax.swing.JRadioButton();
        B = new javax.swing.JRadioButton();
        BarraMenu = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        BNuevo = new javax.swing.JMenuItem();
        BAbrir = new javax.swing.JMenuItem();
        BGuardar = new javax.swing.JMenuItem();
        Editar = new javax.swing.JMenu();
        Copiar = new javax.swing.JMenuItem();
        Transformar = new javax.swing.JCheckBoxMenuItem();
        BrilloContraste = new javax.swing.JCheckBoxMenuItem();
        Deseleccionar = new javax.swing.JMenuItem();
        Ver = new javax.swing.JMenu();
        VerBGeneral = new javax.swing.JCheckBoxMenuItem();
        VerBProcesado = new javax.swing.JCheckBoxMenuItem();
        VerBEstado = new javax.swing.JCheckBoxMenuItem();
        VerAudio = new javax.swing.JCheckBoxMenuItem();
        VerVideo = new javax.swing.JCheckBoxMenuItem();
        Ayuda = new javax.swing.JMenu();
        AcercaD = new javax.swing.JMenuItem();
        ComoFunciona = new javax.swing.JMenuItem();

        SeleccionarTam.setAlwaysOnTop(true);
        SeleccionarTam.setResizable(false);

        jPanel7.setMaximumSize(new java.awt.Dimension(50, 50));
        jPanel7.setMinimumSize(new java.awt.Dimension(50, 40));
        jPanel7.setPreferredSize(new java.awt.Dimension(50, 40));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("        Introduce las dimensiones del nuevo lienzo:");
        jPanel7.add(jLabel3, java.awt.BorderLayout.CENTER);

        SeleccionarTam.getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_START);

        jPanel3.setMaximumSize(new java.awt.Dimension(500, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("                                            Ancho");
        jPanel3.add(jLabel1);

        Ancho.setToolTipText("Introduce el ancho de la ventana");
        Ancho.setMaximumSize(new java.awt.Dimension(500, 30));
        Ancho.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(Ancho);

        jLabel2.setText("                                               Alto");
        jPanel3.add(jLabel2);

        Alto.setToolTipText("Introduce el alto de la ventana");
        Alto.setPreferredSize(new java.awt.Dimension(200, 25));
        jPanel3.add(Alto);

        SeleccionarTam.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        Defecto.setText("Por defecto");
        Defecto.setToolTipText("Ventana por defecto (600 x 500)");
        Defecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefectoActionPerformed(evt);
            }
        });
        jPanel5.add(Defecto);

        Aceptar.setText("Aceptar");
        Aceptar.setToolTipText("Aceptar la creacion de la ventana");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel5.add(Aceptar);

        Cancelar.setText("Cancelar");
        Cancelar.setToolTipText("Cancelar la creacion de la ventana");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel5.add(Cancelar);

        SeleccionarTam.getContentPane().add(jPanel5, java.awt.BorderLayout.PAGE_END);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);

        BHerram.setRollover(true);
        BHerram.setBorderPainted(false);

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        Nuevo.setToolTipText("Nueva imagen");
        Nuevo.setFocusable(false);
        Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Nuevo.setPreferredSize(new java.awt.Dimension(35, 35));
        Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        BHerram.add(Nuevo);

        Abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abrir.png"))); // NOI18N
        Abrir.setToolTipText("Abrir imagen/audio");
        Abrir.setFocusable(false);
        Abrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Abrir.setPreferredSize(new java.awt.Dimension(35, 35));
        Abrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        BHerram.add(Abrir);

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        Guardar.setToolTipText("Guardar imagen");
        Guardar.setFocusable(false);
        Guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Guardar.setPreferredSize(new java.awt.Dimension(35, 35));
        Guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        BHerram.add(Guardar);
        BHerram.add(Separador1);

        jPanel1.setMaximumSize(new java.awt.Dimension(170, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(170, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(170, 40));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        ListaColores.setToolTipText("Color activo");
        ListaColores.setRenderer(new ColorRender());
        ListaColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaColoresActionPerformed(evt);
            }
        });
        jPanel1.add(ListaColores);

        Grosor.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        Grosor.setToolTipText("Tamaño de trazo");
        Grosor.setMinimumSize(new java.awt.Dimension(50, 30));
        Grosor.setPreferredSize(new java.awt.Dimension(50, 30));
        Grosor.setRequestFocusEnabled(false);
        Grosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GrosorStateChanged(evt);
            }
        });
        jPanel1.add(Grosor);

        ContinuidadTrazo.add(TrazoC);
        TrazoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/trazoC.png"))); // NOI18N
        TrazoC.setSelected(true);
        TrazoC.setToolTipText("Trazo continuo");
        TrazoC.setMaximumSize(new java.awt.Dimension(10, 30));
        TrazoC.setMinimumSize(new java.awt.Dimension(10, 30));
        TrazoC.setPreferredSize(new java.awt.Dimension(10, 30));
        TrazoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrazoCActionPerformed(evt);
            }
        });
        jPanel1.add(TrazoC);

        ContinuidadTrazo.add(TrazoD);
        TrazoD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/trazoD.png"))); // NOI18N
        TrazoD.setToolTipText("Trazo discontinuo");
        TrazoD.setMaximumSize(new java.awt.Dimension(10, 30));
        TrazoD.setMinimumSize(new java.awt.Dimension(10, 30));
        TrazoD.setPreferredSize(new java.awt.Dimension(10, 30));
        TrazoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrazoDActionPerformed(evt);
            }
        });
        jPanel1.add(TrazoD);

        BHerram.add(jPanel1);
        BHerram.add(Separador2);

        panelRotacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Rotacion"));
        panelRotacion.setMaximumSize(new java.awt.Dimension(250, 50));
        panelRotacion.setMinimumSize(new java.awt.Dimension(250, 50));
        panelRotacion.setPreferredSize(new java.awt.Dimension(250, 50));
        panelRotacion.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -4));

        Rotacion.setMaximum(360);
        Rotacion.setToolTipText("Rotacion manual");
        Rotacion.setValue(0);
        Rotacion.setPreferredSize(new java.awt.Dimension(100, 26));
        Rotacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RotacionStateChanged(evt);
            }
        });
        Rotacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RotacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                RotacionFocusLost(evt);
            }
        });
        panelRotacion.add(Rotacion);

        Rotar90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion90.png"))); // NOI18N
        Rotar90.setToolTipText("Rotar 90º");
        Rotar90.setPreferredSize(new java.awt.Dimension(30, 30));
        Rotar90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rotar90ActionPerformed(evt);
            }
        });
        panelRotacion.add(Rotar90);

        Rotar180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion180.png"))); // NOI18N
        Rotar180.setToolTipText("Rotar 180º");
        Rotar180.setPreferredSize(new java.awt.Dimension(30, 30));
        Rotar180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rotar180ActionPerformed(evt);
            }
        });
        panelRotacion.add(Rotar180);

        Rotar270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rotacion270.png"))); // NOI18N
        Rotar270.setToolTipText("Rotar 270º");
        Rotar270.setPreferredSize(new java.awt.Dimension(30, 30));
        Rotar270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rotar270ActionPerformed(evt);
            }
        });
        panelRotacion.add(Rotar270);

        BHerram.add(panelRotacion);

        panelEscala.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Escala"));
        panelEscala.setMaximumSize(new java.awt.Dimension(89, 50));
        panelEscala.setMinimumSize(new java.awt.Dimension(89, 50));
        panelEscala.setName(""); // NOI18N
        panelEscala.setPreferredSize(new java.awt.Dimension(89, 50));
        panelEscala.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -4));

        Incrementar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/aumentar.png"))); // NOI18N
        Incrementar.setToolTipText("Aumentar");
        Incrementar.setPreferredSize(new java.awt.Dimension(30, 30));
        Incrementar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncrementarActionPerformed(evt);
            }
        });
        panelEscala.add(Incrementar);

        Decrementar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/disminuir.png"))); // NOI18N
        Decrementar.setToolTipText("Recucir");
        Decrementar.setPreferredSize(new java.awt.Dimension(30, 30));
        Decrementar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecrementarActionPerformed(evt);
            }
        });
        panelEscala.add(Decrementar);

        BHerram.add(panelEscala);
        BHerram.add(Separador3);

        Relleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png"))); // NOI18N
        Relleno.setToolTipText("Rellenar");
        Relleno.setFocusable(false);
        Relleno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Relleno.setPreferredSize(new java.awt.Dimension(35, 35));
        Relleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Relleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RellenoActionPerformed(evt);
            }
        });
        BHerram.add(Relleno);

        Renderizado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/alisar.png"))); // NOI18N
        Renderizado.setToolTipText("Renderizar");
        Renderizado.setFocusable(false);
        Renderizado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Renderizado.setPreferredSize(new java.awt.Dimension(35, 35));
        Renderizado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Renderizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenderizadoActionPerformed(evt);
            }
        });
        BHerram.add(Renderizado);

        Transparencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/transparencia.png"))); // NOI18N
        Transparencia.setToolTipText("Aplicar transparencia");
        Transparencia.setFocusable(false);
        Transparencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Transparencia.setPreferredSize(new java.awt.Dimension(35, 35));
        Transparencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Transparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransparenciaActionPerformed(evt);
            }
        });
        BHerram.add(Transparencia);

        Separador4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Separador4.setPreferredSize(new java.awt.Dimension(6, 40));
        BHerram.add(Separador4);

        ReproductorAudio.setMaximumSize(new java.awt.Dimension(200, 32767));
        ReproductorAudio.setMinimumSize(new java.awt.Dimension(200, 43));
        ReproductorAudio.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play24x24.png"))); // NOI18N
        PlayPause.setToolTipText("Reproducir/Pausar");
        PlayPause.setEnabled(false);
        PlayPause.setFocusable(false);
        PlayPause.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PlayPause.setPreferredSize(new java.awt.Dimension(35, 35));
        PlayPause.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PlayPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseActionPerformed(evt);
            }
        });
        ReproductorAudio.add(PlayPause);

        Stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stop24x24.png"))); // NOI18N
        Stop.setToolTipText("Detener");
        Stop.setEnabled(false);
        Stop.setFocusable(false);
        Stop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Stop.setPreferredSize(new java.awt.Dimension(35, 35));
        Stop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        ReproductorAudio.add(Stop);

        Grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/record24x24.png"))); // NOI18N
        Grabar.setToolTipText("Grabar");
        Grabar.setFocusable(false);
        Grabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Grabar.setPreferredSize(new java.awt.Dimension(35, 35));
        Grabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrabarActionPerformed(evt);
            }
        });
        ReproductorAudio.add(Grabar);

        PlayList.setToolTipText("Lista de reproduccion");
        PlayList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PlayList.setMaximumSize(new java.awt.Dimension(100, 100));
        PlayList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PlayListItemStateChanged(evt);
            }
        });
        PlayList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PlayListKeyPressed(evt);
            }
        });
        ReproductorAudio.add(PlayList);

        BHerram.add(ReproductorAudio);

        Separador7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        Separador7.setPreferredSize(new java.awt.Dimension(6, 40));
        BHerram.add(Separador7);

        ReproductorVideo.setMaximumSize(new java.awt.Dimension(200, 32767));
        ReproductorVideo.setMinimumSize(new java.awt.Dimension(200, 43));
        ReproductorVideo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PlayPauseV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play24x24.png"))); // NOI18N
        PlayPauseV.setToolTipText("Reproducir/Pausar");
        PlayPauseV.setEnabled(false);
        PlayPauseV.setFocusable(false);
        PlayPauseV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PlayPauseV.setPreferredSize(new java.awt.Dimension(35, 35));
        PlayPauseV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PlayPauseV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseVActionPerformed(evt);
            }
        });
        ReproductorVideo.add(PlayPauseV);

        StopV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stop24x24.png"))); // NOI18N
        StopV.setToolTipText("Detener");
        StopV.setEnabled(false);
        StopV.setFocusable(false);
        StopV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        StopV.setPreferredSize(new java.awt.Dimension(35, 35));
        StopV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        StopV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopVActionPerformed(evt);
            }
        });
        ReproductorVideo.add(StopV);

        Camara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Camara.png"))); // NOI18N
        Camara.setToolTipText("Activar Webcam");
        Camara.setFocusable(false);
        Camara.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Camara.setPreferredSize(new java.awt.Dimension(35, 35));
        Camara.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Camara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamaraActionPerformed(evt);
            }
        });
        ReproductorVideo.add(Camara);

        Captura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Capturar.png"))); // NOI18N
        Captura.setToolTipText("Captura de video");
        Captura.setFocusable(false);
        Captura.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Captura.setPreferredSize(new java.awt.Dimension(35, 35));
        Captura.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Captura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapturaActionPerformed(evt);
            }
        });
        ReproductorVideo.add(Captura);

        BHerram.add(ReproductorVideo);

        OK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/OK.png"))); // NOI18N
        OK.setToolTipText("Da como terminados las modificaciones");
        OK.setFocusable(false);
        OK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        OK.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });
        BHerram.add(OK);

        getContentPane().add(BHerram, java.awt.BorderLayout.PAGE_START);

        panelInferior.setLayout(new java.awt.BorderLayout());

        panelEstado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        HerramientaAct.setText("Trazo libre ");
        HerramientaAct.setToolTipText("Forma de dibujo activa");
        panelEstado.add(HerramientaAct);

        panelInferior.add(panelEstado, java.awt.BorderLayout.CENTER);

        panelAjustes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        panelBrillo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Brillo"));
        panelBrillo.setMaximumSize(new java.awt.Dimension(124, 50));
        panelBrillo.setMinimumSize(new java.awt.Dimension(60, 50));
        panelBrillo.setPreferredSize(new java.awt.Dimension(124, 50));
        panelBrillo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));

        brillo.setMaximum(250);
        brillo.setMinimum(-250);
        brillo.setToolTipText("Brillo");
        brillo.setValue(0);
        brillo.setPreferredSize(new java.awt.Dimension(100, 26));
        brillo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brilloStateChanged(evt);
            }
        });
        brillo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brilloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brilloFocusLost(evt);
            }
        });
        panelBrillo.add(brillo);

        panelAjustes.add(panelBrillo);

        panelContraste.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Contraste"));
        panelContraste.setMinimumSize(new java.awt.Dimension(181, 50));
        panelContraste.setPreferredSize(new java.awt.Dimension(124, 50));
        panelContraste.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -4));

        Contraste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/contraste.png"))); // NOI18N
        Contraste.setToolTipText("Contraste");
        Contraste.setPreferredSize(new java.awt.Dimension(30, 30));
        Contraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrasteActionPerformed(evt);
            }
        });
        panelContraste.add(Contraste);

        Iluminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/iluminar.png"))); // NOI18N
        Iluminar.setToolTipText("Iluminar");
        Iluminar.setPreferredSize(new java.awt.Dimension(30, 30));
        Iluminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IluminarActionPerformed(evt);
            }
        });
        panelContraste.add(Iluminar);

        Oscurecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/oscurecer.png"))); // NOI18N
        Oscurecer.setToolTipText("Oscurecer");
        Oscurecer.setPreferredSize(new java.awt.Dimension(30, 30));
        Oscurecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OscurecerActionPerformed(evt);
            }
        });
        panelContraste.add(Oscurecer);

        panelAjustes.add(panelContraste);

        panelEfectos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Efectos"));
        panelEfectos.setMinimumSize(new java.awt.Dimension(104, 50));
        panelEfectos.setPreferredSize(new java.awt.Dimension(104, 50));
        panelEfectos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));

        Efectos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano" }));
        Efectos.setToolTipText("Efectos de procesamiento");
        Efectos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EfectosItemStateChanged(evt);
            }
        });
        panelEfectos.add(Efectos);

        panelAjustes.add(panelEfectos);

        panelSeno.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Filtros"));
        panelSeno.setMinimumSize(new java.awt.Dimension(400, 50));
        panelSeno.setPreferredSize(new java.awt.Dimension(430, 50));
        panelSeno.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, -4));

        FuncionSeno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sinusoidal.png"))); // NOI18N
        FuncionSeno.setToolTipText("Funcion seno");
        FuncionSeno.setPreferredSize(new java.awt.Dimension(40, 30));
        FuncionSeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionSenoActionPerformed(evt);
            }
        });
        panelSeno.add(FuncionSeno);

        TempMix.setText("T");
        TempMix.setToolTipText("Mezcla temperatura");
        TempMix.setPreferredSize(new java.awt.Dimension(40, 30));
        TempMix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TempMixMousePressed(evt);
            }
        });
        panelSeno.add(TempMix);

        Tritanopia.setToolTipText("Tritanopia");
        Tritanopia.setPreferredSize(new java.awt.Dimension(40, 30));
        Tritanopia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TritanopiaMousePressed(evt);
            }
        });
        Tritanopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TritanopiaActionPerformed(evt);
            }
        });
        panelSeno.add(Tritanopia);

        Sepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sepia.png"))); // NOI18N
        Sepia.setToolTipText("Sepia");
        Sepia.setPreferredSize(new java.awt.Dimension(40, 30));
        Sepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SepiaActionPerformed(evt);
            }
        });
        panelSeno.add(Sepia);

        Tintar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/tintar.png"))); // NOI18N
        Tintar.setToolTipText("Tintar");
        Tintar.setPreferredSize(new java.awt.Dimension(40, 30));
        Tintar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TintarActionPerformed(evt);
            }
        });
        panelSeno.add(Tintar);

        Ecualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ecualizar.png"))); // NOI18N
        Ecualizar.setToolTipText("Ecualizar");
        Ecualizar.setPreferredSize(new java.awt.Dimension(40, 30));
        Ecualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EcualizarActionPerformed(evt);
            }
        });
        panelSeno.add(Ecualizar);

        Ecualizar1.setText("G");
        Ecualizar1.setToolTipText("Gradiente");
        Ecualizar1.setPreferredSize(new java.awt.Dimension(40, 30));
        Ecualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ecualizar1ActionPerformed(evt);
            }
        });
        panelSeno.add(Ecualizar1);

        Negativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/negativo_24x24.png"))); // NOI18N
        Negativo.setToolTipText("Negativo");
        Negativo.setPreferredSize(new java.awt.Dimension(40, 30));
        Negativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegativoActionPerformed(evt);
            }
        });
        panelSeno.add(Negativo);

        Colorizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/colorizar.png"))); // NOI18N
        Colorizar.setToolTipText("Colorizar");
        Colorizar.setPreferredSize(new java.awt.Dimension(40, 30));
        Colorizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColorizarMousePressed(evt);
            }
        });
        panelSeno.add(Colorizar);

        panelAjustes.add(panelSeno);

        espColor.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Color"));
        espColor.setMinimumSize(new java.awt.Dimension(137, 50));
        espColor.setPreferredSize(new java.awt.Dimension(137, 50));
        espColor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -4));

        SplitBands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/bandas.png"))); // NOI18N
        SplitBands.setToolTipText("Separar en bandas");
        SplitBands.setPreferredSize(new java.awt.Dimension(40, 30));
        SplitBands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SplitBandsActionPerformed(evt);
            }
        });
        espColor.add(SplitBands);

        EspacioColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RGB", "YCC", "GREY" }));
        EspacioColor.setToolTipText("Cambiar espacio de color");
        EspacioColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EspacioColorItemStateChanged(evt);
            }
        });
        espColor.add(EspacioColor);

        panelAjustes.add(espColor);

        panelBinario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Binarias"));
        panelBinario.setMinimumSize(new java.awt.Dimension(58, 50));
        panelBinario.setPreferredSize(new java.awt.Dimension(150, 50));
        panelBinario.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));

        Mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/mas.png"))); // NOI18N
        Mas.setToolTipText("Mas");
        Mas.setPreferredSize(new java.awt.Dimension(30, 30));
        Mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasActionPerformed(evt);
            }
        });
        panelBinario.add(Mas);

        Menos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/menos.png"))); // NOI18N
        Menos.setToolTipText("Menos");
        Menos.setPreferredSize(new java.awt.Dimension(30, 30));
        Menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenosActionPerformed(evt);
            }
        });
        panelBinario.add(Menos);

        Alfa.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        Alfa.setToolTipText("Alfa de mezcla");
        Alfa.setMinimumSize(new java.awt.Dimension(50, 30));
        Alfa.setPreferredSize(new java.awt.Dimension(50, 30));
        Alfa.setRequestFocusEnabled(false);
        Alfa.setValue(50);
        Alfa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AlfaStateChanged(evt);
            }
        });
        panelBinario.add(Alfa);

        panelAjustes.add(panelBinario);

        panelUmbral.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Umbralizacion"));
        panelUmbral.setMinimumSize(new java.awt.Dimension(58, 50));
        panelUmbral.setPreferredSize(new java.awt.Dimension(124, 50));
        panelUmbral.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, -2));

        Umbral.setMaximum(255);
        Umbral.setToolTipText("Umbralizar");
        Umbral.setValue(127);
        Umbral.setPreferredSize(new java.awt.Dimension(100, 26));
        Umbral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                UmbralStateChanged(evt);
            }
        });
        Umbral.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UmbralFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UmbralFocusLost(evt);
            }
        });
        panelUmbral.add(Umbral);

        panelAjustes.add(panelUmbral);

        panelInferior.add(panelAjustes, java.awt.BorderLayout.NORTH);

        getContentPane().add(panelInferior, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setToolTipText("");
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 130));

        ListaFiguras.setCellRenderer(new LayerRender());
        ListaFiguras.setBackground(new java.awt.Color(240, 240, 240));
        ListaFiguras.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Figuras"));
        ListaFiguras.setToolTipText("Figuras dibujadas");
        ListaFiguras.setSelectionForeground(new java.awt.Color(240, 240, 240));
        ListaFiguras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaFigurasMousePressed(evt);
            }
        });
        ListaFiguras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaFigurasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(ListaFiguras);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_END);

        panelDibujo.setMaximumSize(new java.awt.Dimension(50, 32767));
        panelDibujo.setMinimumSize(new java.awt.Dimension(50, 33));
        panelDibujo.setPreferredSize(new java.awt.Dimension(50, 100));

        Herramientas.add(Lapiz);
        Lapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Lapiz.gif"))); // NOI18N
        Lapiz.setSelected(true);
        Lapiz.setToolTipText("Trazo libre");
        Lapiz.setFocusable(false);
        Lapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Lapiz.setPreferredSize(new java.awt.Dimension(35, 35));
        Lapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Lapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LapizActionPerformed(evt);
            }
        });
        panelDibujo.add(Lapiz);

        Herramientas.add(Linea);
        Linea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/linea.png"))); // NOI18N
        Linea.setToolTipText("Linea");
        Linea.setFocusable(false);
        Linea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Linea.setPreferredSize(new java.awt.Dimension(35, 35));
        Linea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Linea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineaActionPerformed(evt);
            }
        });
        panelDibujo.add(Linea);

        Herramientas.add(Rectangulo);
        Rectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rectangulo.png"))); // NOI18N
        Rectangulo.setToolTipText("Rectangulo");
        Rectangulo.setFocusable(false);
        Rectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Rectangulo.setPreferredSize(new java.awt.Dimension(35, 35));
        Rectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Rectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RectanguloActionPerformed(evt);
            }
        });
        panelDibujo.add(Rectangulo);

        Herramientas.add(Ovalo);
        Ovalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elipse.png"))); // NOI18N
        Ovalo.setToolTipText("Ovalo");
        Ovalo.setFocusable(false);
        Ovalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Ovalo.setPreferredSize(new java.awt.Dimension(35, 35));
        Ovalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Ovalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OvaloActionPerformed(evt);
            }
        });
        panelDibujo.add(Ovalo);

        Herramientas.add(Abanico);
        Abanico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/abanico.png"))); // NOI18N
        Abanico.setToolTipText("Abanico");
        Abanico.setFocusable(false);
        Abanico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Abanico.setPreferredSize(new java.awt.Dimension(35, 35));
        Abanico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Abanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbanicoActionPerformed(evt);
            }
        });
        panelDibujo.add(Abanico);

        Separador5.setMaximumSize(new java.awt.Dimension(50, 10));
        Separador5.setMinimumSize(new java.awt.Dimension(50, 10));
        Separador5.setPreferredSize(new java.awt.Dimension(50, 10));
        panelDibujo.add(Separador5);

        xLbl.setText("x:");
        panelDibujo.add(xLbl);

        xTxt.setEditable(false);
        xTxt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        xTxt.setToolTipText("Posicion de la figura seleccionada en x");
        xTxt.setMaximumSize(new java.awt.Dimension(31, 25));
        xTxt.setMinimumSize(new java.awt.Dimension(31, 25));
        xTxt.setPreferredSize(new java.awt.Dimension(31, 25));
        xTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xTxtKeyPressed(evt);
            }
        });
        panelDibujo.add(xTxt);

        yLbl.setText("y:");
        panelDibujo.add(yLbl);

        yTxt.setEditable(false);
        yTxt.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        yTxt.setToolTipText("Posicion de la figura seleccionada en y");
        yTxt.setMaximumSize(new java.awt.Dimension(31, 25));
        yTxt.setMinimumSize(new java.awt.Dimension(31, 25));
        yTxt.setPreferredSize(new java.awt.Dimension(31, 25));
        yTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yTxtKeyPressed(evt);
            }
        });
        panelDibujo.add(yTxt);

        trazolbl.setText(" Trazo");
        trazolbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        trazolbl.setMaximumSize(new java.awt.Dimension(37, 30));
        trazolbl.setMinimumSize(new java.awt.Dimension(37, 30));
        trazolbl.setPreferredSize(new java.awt.Dimension(37, 30));
        panelDibujo.add(trazolbl);

        ColorTrazo.setBackground(new java.awt.Color(0, 0, 0));
        ColorTrazo.setToolTipText("Color de trazo");
        ColorTrazo.setPreferredSize(new java.awt.Dimension(30, 30));
        ColorTrazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColorTrazoMousePressed(evt);
            }
        });
        panelDibujo.add(ColorTrazo);

        rellenolbl.setText("Relleno");
        panelDibujo.add(rellenolbl);

        ColorRelleno.setBackground(new java.awt.Color(0, 0, 0));
        ColorRelleno.setToolTipText("Color de relleno");
        ColorRelleno.setPreferredSize(new java.awt.Dimension(30, 30));
        ColorRelleno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColorRellenoMousePressed(evt);
            }
        });
        panelDibujo.add(ColorRelleno);

        ColorRelleno2.setBackground(new java.awt.Color(0, 0, 0));
        ColorRelleno2.setToolTipText("Color de relleno secundario");
        ColorRelleno2.setPreferredSize(new java.awt.Dimension(30, 30));
        ColorRelleno2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ColorRelleno2MousePressed(evt);
            }
        });
        panelDibujo.add(ColorRelleno2);

        getContentPane().add(panelDibujo, java.awt.BorderLayout.WEST);

        TipoRelleno.add(Rnormal);
        Rnormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png"))); // NOI18N
        Rnormal.setPreferredSize(new java.awt.Dimension(35, 35));
        Rnormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RnormalActionPerformed(evt);
            }
        });
        panelRelleno.add(Rnormal);

        TipoRelleno.add(Rdegradado);
        Rdegradado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/degradado.png"))); // NOI18N
        Rdegradado.setPreferredSize(new java.awt.Dimension(35, 35));
        Rdegradado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RdegradadoActionPerformed(evt);
            }
        });
        panelRelleno.add(Rdegradado);

        Separador6.setMaximumSize(new java.awt.Dimension(130, 10));
        Separador6.setMinimumSize(new java.awt.Dimension(130, 10));
        Separador6.setPreferredSize(new java.awt.Dimension(130, 10));
        panelRelleno.add(Separador6);

        panelDegradado.setMaximumSize(new java.awt.Dimension(100, 100));
        panelDegradado.setMinimumSize(new java.awt.Dimension(100, 100));
        panelDegradado.setLayout(new java.awt.BorderLayout());

        TipoDegradado.add(DegHor);
        DegHor.setText("Horizontal");
        DegHor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegHorActionPerformed(evt);
            }
        });
        panelDegradado.add(DegHor, java.awt.BorderLayout.PAGE_START);

        TipoDegradado.add(DegDig2);
        DegDig2.setText("Diagonal 2");
        DegDig2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegDig2ActionPerformed(evt);
            }
        });
        panelDegradado.add(DegDig2, java.awt.BorderLayout.LINE_END);

        TipoDegradado.add(DegVer);
        DegVer.setText("Vertical");
        DegVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegVerActionPerformed(evt);
            }
        });
        panelDegradado.add(DegVer, java.awt.BorderLayout.PAGE_END);

        TipoDegradado.add(DegDig1);
        DegDig1.setText("Diagonal 1");
        DegDig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DegDig1ActionPerformed(evt);
            }
        });
        panelDegradado.add(DegDig1, java.awt.BorderLayout.CENTER);

        panelRelleno.add(panelDegradado);

        Escritorio.setLayer(panelRelleno, javax.swing.JLayeredPane.POPUP_LAYER);
        Escritorio.add(panelRelleno);
        panelRelleno.setBounds(520, 0, 150, 130);

        panelTransp.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        NivelTransp.setToolTipText("Nivel de transparencia");
        NivelTransp.setPreferredSize(new java.awt.Dimension(140, 25));
        NivelTransp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                NivelTranspStateChanged(evt);
            }
        });
        NivelTransp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NivelTranspFocusLost(evt);
            }
        });
        panelTransp.add(NivelTransp);

        Escritorio.setLayer(panelTransp, javax.swing.JLayeredPane.POPUP_LAYER);
        Escritorio.add(panelTransp);
        panelTransp.setBounds(580, 0, 150, 30);

        ColorizarG.add(R);
        R.setSelected(true);
        R.setText("R:");
        R.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        R.setMaximumSize(new java.awt.Dimension(40, 23));
        R.setMinimumSize(new java.awt.Dimension(40, 23));
        R.setPreferredSize(new java.awt.Dimension(40, 23));
        R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RActionPerformed(evt);
            }
        });
        panelRgb.add(R);

        ColorizarG.add(G);
        G.setText("G:");
        G.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        G.setMaximumSize(new java.awt.Dimension(40, 23));
        G.setMinimumSize(new java.awt.Dimension(40, 23));
        G.setPreferredSize(new java.awt.Dimension(40, 23));
        G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GActionPerformed(evt);
            }
        });
        panelRgb.add(G);

        ColorizarG.add(B);
        B.setText("B:");
        B.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        B.setMaximumSize(new java.awt.Dimension(40, 23));
        B.setMinimumSize(new java.awt.Dimension(40, 23));
        B.setPreferredSize(new java.awt.Dimension(40, 23));
        B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BActionPerformed(evt);
            }
        });
        panelRgb.add(B);

        Escritorio.setLayer(panelRgb, javax.swing.JLayeredPane.POPUP_LAYER);
        Escritorio.add(panelRgb);
        panelRgb.setBounds(610, 430, 160, 40);

        getContentPane().add(Escritorio, java.awt.BorderLayout.CENTER);

        Archivo.setText("Archivo");
        Archivo.setToolTipText("Opciones de archivo");

        BNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        BNuevo.setText("Nuevo");
        BNuevo.setToolTipText("Nuava imagen");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        Archivo.add(BNuevo);

        BAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        BAbrir.setText("Abrir");
        BAbrir.setToolTipText("Abrir imagen/audio");
        BAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAbrirActionPerformed(evt);
            }
        });
        Archivo.add(BAbrir);

        BGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        BGuardar.setText("Guardar");
        BGuardar.setToolTipText("Guarda la imagen");
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        Archivo.add(BGuardar);

        BarraMenu.add(Archivo);

        Editar.setText("Editar");
        Editar.setToolTipText("Opciones de edicion");

        Copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        Copiar.setText("Copiar");
        Copiar.setToolTipText("Copia la imagen en una ventana nueva");
        Copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarActionPerformed(evt);
            }
        });
        Editar.add(Copiar);

        Transformar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        Transformar.setText("Transformar");
        Transformar.setToolTipText("Muestra las opciones de transformacion");
        Transformar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransformarActionPerformed(evt);
            }
        });
        Editar.add(Transformar);

        BrilloContraste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        BrilloContraste.setText("Brillo y contraste");
        BrilloContraste.setToolTipText("Muestra las opciones de brillo y contraste");
        BrilloContraste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrilloContrasteActionPerformed(evt);
            }
        });
        Editar.add(BrilloContraste);

        Deseleccionar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Deseleccionar.setText("Deseleccionar");
        Deseleccionar.setToolTipText("Deselecciona la figura activa");
        Deseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseleccionarActionPerformed(evt);
            }
        });
        Editar.add(Deseleccionar);

        BarraMenu.add(Editar);

        Ver.setText("Ver");
        Ver.setToolTipText("Opciones de visualizacion");

        VerBGeneral.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        VerBGeneral.setSelected(true);
        VerBGeneral.setText("Barra general");
        VerBGeneral.setToolTipText("Muestra/Oculta la barra general");
        VerBGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerBGeneralActionPerformed(evt);
            }
        });
        Ver.add(VerBGeneral);

        VerBProcesado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        VerBProcesado.setSelected(true);
        VerBProcesado.setText("Barra de procesamiento");
        VerBProcesado.setToolTipText("Muestra/Oculta la barra de procesamiento");
        VerBProcesado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerBProcesadoActionPerformed(evt);
            }
        });
        Ver.add(VerBProcesado);

        VerBEstado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        VerBEstado.setSelected(true);
        VerBEstado.setText("Barra de estado");
        VerBEstado.setToolTipText("Muestra/Oculta la barra de estado");
        VerBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerBEstadoActionPerformed(evt);
            }
        });
        Ver.add(VerBEstado);

        VerAudio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        VerAudio.setSelected(true);
        VerAudio.setText("Reproductor de audio");
        VerAudio.setToolTipText("Muestra/Oculta el reproductor de audio");
        VerAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerAudioActionPerformed(evt);
            }
        });
        Ver.add(VerAudio);

        VerVideo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        VerVideo.setSelected(true);
        VerVideo.setText("Reproductor de video");
        VerVideo.setToolTipText("Muestra/Oculta el reproductor de audio");
        VerVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerVideoActionPerformed(evt);
            }
        });
        Ver.add(VerVideo);

        BarraMenu.add(Ver);

        Ayuda.setText("Ayuda");
        Ayuda.setToolTipText("Opciones de ayuda");

        AcercaD.setText("Acerca de");
        AcercaD.setToolTipText("Acerca del programa");
        AcercaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaDActionPerformed(evt);
            }
        });
        Ayuda.add(AcercaD);

        ComoFunciona.setText("Como funciona");
        ComoFunciona.setToolTipText("Completo y extenso manual de funcionamiento del programa");
        ComoFunciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComoFuncionaActionPerformed(evt);
            }
        });
        Ayuda.add(ComoFunciona);

        BarraMenu.add(Ayuda);

        setJMenuBar(BarraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Establece el tipo de figura del lienzo como trazo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void LapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LapizActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTipo(Tipo.TRAZO);
            this.HerramientaAct.setText("Trazo libre ");
        }
        herramienta = Tipo.TRAZO;
    }//GEN-LAST:event_LapizActionPerformed
    /**
     * Establece el tipo de figura del lienzo como linea.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void LineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineaActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTipo(Tipo.LINEA);
            this.HerramientaAct.setText("Línea ");
        }
        herramienta = Tipo.LINEA;
    }//GEN-LAST:event_LineaActionPerformed
    /**
     * Establece el tipo de figura del lienzo como Rectangulo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RectanguloActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTipo(Tipo.RECTANGULO);
            this.HerramientaAct.setText("Rectángulo ");
        }
        herramienta = Tipo.RECTANGULO;
    }//GEN-LAST:event_RectanguloActionPerformed
    /**
     * Establece el tipo de figura del lienzo como ovalo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void OvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OvaloActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTipo(Tipo.OVALO);
            this.HerramientaAct.setText("Óvalo ");
        }
        herramienta = Tipo.OVALO;
    }//GEN-LAST:event_OvaloActionPerformed
    /**
     * Lanza el evento de NuevoActionPerformed.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        this.NuevoActionPerformed(evt);
    }//GEN-LAST:event_BNuevoActionPerformed
    /**
     * Establece el tipo de figura del lienzo como abanico.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void AbanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbanicoActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTipo(Tipo.ABANICO);
            this.HerramientaAct.setText("Abanica tu vida ");
        }
    }//GEN-LAST:event_AbanicoActionPerformed
    /**
     * Establece el color de la figura del lienzo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void ListaColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaColoresActionPerformed
        switch(ListaColores.getSelectedIndex()){
            case 0:
                selectedColor = Color.black;
                break;
            case 1:
                selectedColor = Color.green;
                break;
            case 2:
                selectedColor = Color.yellow;
                break;
            case 3:
                selectedColor = Color.blue;
                break;
            case 4:
                selectedColor = Color.red;
                break;
            case 5:
                selectedColor = Color.white;
                break;
        }
    }//GEN-LAST:event_ListaColoresActionPerformed
    /**
     * Establece si la figura del lienzo tiene transparencia.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void TransparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransparenciaActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setTransparencia(Transparencia.isSelected());
            panelTransp.setBounds(Transparencia.getX()-110, 0, 150, 30);
            panelTransp.setVisible(Transparencia.isSelected());
        }
        else
            Transparencia.setSelected(false);
    }//GEN-LAST:event_TransparenciaActionPerformed
    /**
     * Establece si la figura del lienzo tiene relleno.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RellenoActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setRelleno(Relleno.isSelected());
            panelRelleno.setBounds(Relleno.getX()-110, 0, 150, 130);
            panelRelleno.setVisible(true);
            OK.setVisible(true);
        }
        else
            Relleno.setSelected(false);
        if(Relleno.isSelected() == false){
            panelRelleno.setVisible(false);
            OK.setVisible(false);
        }
    }//GEN-LAST:event_RellenoActionPerformed
    /**
     * Establece si la figura del lienzo tiene opcion de renderizado.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RenderizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenderizadoActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setRenderizado(Renderizado.isSelected());
        }
        else
            Renderizado.setSelected(false);
    }//GEN-LAST:event_RenderizadoActionPerformed
    /**
     * Establece el grosor de la figura del lienzo.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void GrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GrosorStateChanged
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            Lienzo2D lienzo = ventana.getLienzo();
            float trazo = Float.parseFloat(this.Grosor.getValue().toString());
            lienzo.setTrazo(trazo);
        }
    }//GEN-LAST:event_GrosorStateChanged
    /**
     * Crea una nueva ventana interna con una imagen en blanco.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        SeleccionarTam.setTitle("Nueva ventana");
        SeleccionarTam.setLocation(this.getLocation());
        SeleccionarTam.setVisible(true);
        
        /*BufferedImage imagen;
        imagen = new BufferedImage(300,300,BufferedImage.TYPE_INT_ARGB);
        ventana.getLienzo().setImagen(imagen);*/
    }//GEN-LAST:event_NuevoActionPerformed
    /**
     * Carga en el buffer una nueva imagen.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void brilloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloFocusGained
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if(ventana!=null){
            ColorModel cm = ventana.getLienzo().getImagen(false).getColorModel();
            WritableRaster raster = ventana.getLienzo().getImagen(false).copyData(null);
            boolean alfaPre = ventana.getLienzo().getImagen(false).isAlphaPremultiplied();
            imagen = new BufferedImage(cm,raster,alfaPre,null);
        }
    }//GEN-LAST:event_brilloFocusGained
    /**
     * Elimina del buffer la imagen existente.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void brilloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brilloFocusLost
        imagen = null;
    }//GEN-LAST:event_brilloFocusLost
    /**
     * Crea una nueva ventana interna con una imagen seleccionada de un JFileChooser.
     * Tambien puede abrir archivos de audio en wav.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        JFileChooser dlg = new JFileChooser();
        
        dlg.addChoosableFileFilter(new FileFilterExtension(".wav", "WAVE form audio file format"));
        
        dlg.addChoosableFileFilter(new FileFilterExtension(".jpg", "Joint Photographic Expert Group"));
        dlg.addChoosableFileFilter(new FileFilterExtension(".png", "Portable Network Graphics"));
        
        dlg.addChoosableFileFilter(new FileFilterExtension(".avi", "Audio Video Interleave"));
        dlg.addChoosableFileFilter(new FileFilterExtension(".mpg", "Video from Moving Picture Experts Group"));
        
        int resp = dlg.showOpenDialog(this);
        if( resp == JFileChooser.APPROVE_OPTION) {
            File f = new File(dlg.getSelectedFile().getAbsolutePath()){
                @Override
                public String toString(){
                    return this.getName();
                }
            };
            if (f.getName().endsWith(".wav")){
                PlayList.addItem(f);
            }
            else{
                if(f.getName().endsWith(".jpg") || f.getName().endsWith(".png")){
                    try{
                        BufferedImage img = ImageIO.read(f);
                        VentanaInterna ventana = new VentanaInterna(img.getWidth(), img.getHeight(), this);
                        ventana.getLienzo().setImagen(img);
                        this.Escritorio.add(ventana);
                        ventana.setTitle(f.getName() + " [RGB]");
                        ventana.setVisible(true);
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(this, "Error al leer la imagen", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    if (f.getName().endsWith(".avi") || f.getName().endsWith(".mpg")){
                        VentanaInternaVideo video = new VentanaInternaVideo(f);
                        Escritorio.add(video);
                        video.setVisible(true);
                        video.play();
                        /*System.out.println("a");
                        mediaComponent = new EmbeddedMediaPlayerComponent();
                        System.out.println("b");
                        VentanaInternaCamara video = new VentanaInternaCamara();
                        System.out.println("c");
                        video.setContentPane(mediaComponent);
                        System.out.println("d");
                        Escritorio.add(video);
                        System.out.println("e");
                        video.setVisible(true);
                        System.out.println("f");
                        mediaComponent.mediaPlayer().media().play(dlg.getSelectedFile().getAbsolutePath());
                        System.out.println("g");*/
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Tipo de archivo no reconocido", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_AbrirActionPerformed
    /**
     * Guarda la imagen y las figuras pintadas en unnuevo archivo de imagen.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        VentanaInterna ventana=(VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null) {
            JFileChooser dlg = new JFileChooser();
            dlg.addChoosableFileFilter(new FileFilterExtension(".jpg", "Joint Photographic Expert Group"));
            dlg.addChoosableFileFilter(new FileFilterExtension(".png", "Portable Network Graphics"));
            
            int resp = dlg.showSaveDialog(this);
            if (resp == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage img = ventana.getLienzo().getImagen(true);
                    if (img != null) {
                        File f = dlg.getSelectedFile();
                        
                        switch(((FileFilterExtension)dlg.getFileFilter()).getExtension()){//********************************************************************************
                            case ".jpg":
                                ImageIO.write(img, "jpg", f);
                                break;
                            case ".png":
                                ImageIO.write(img, "png", f);
                                break;
                            default:
                                throw new Exception();
                        }
                        ventana.setTitle(f.getName());
                    }
                }catch (Exception ex) {
                    System.err.println("Error al guardar la imagen");
                }
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed
    /**
     * Lanza el evento AbrirActionPerformed.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void BAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAbrirActionPerformed
        this.AbrirActionPerformed(evt);
    }//GEN-LAST:event_BAbrirActionPerformed
    /**
     * Lanza el evento GuardarActionPerformed.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        this.GuardarActionPerformed(evt);
    }//GEN-LAST:event_BGuardarActionPerformed
    /**
     * Establece un nuevo valor de brillo a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void brilloStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brilloStateChanged
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            if(imagen!=null){
                    try{
                        RescaleOp rop;
                        float brilliBrilli = brillo.getValue();
                        
                        if (this.imagen.getColorModel().hasAlpha()){//RGB
                            float[] escala = new float[] {1.0f, 1.0f, 1.0f, 1.0f};
                            float[] offsets = new float[] {brilliBrilli, brilliBrilli, brilliBrilli, 0.0f};
                            rop = new RescaleOp(escala, offsets, null);
                        }
                        else if(!imagen.getColorModel().getColorSpace().isCS_sRGB() && imagen.getRaster().getNumBands() > 1){//YCC
                            float[] escala = new float[]{1.0f, 1.0f, 1.0f};
                            float[] offsets = new float[]{brilliBrilli, 0.0f, 0.0f};
                            rop = new RescaleOp(escala, offsets, null);
                        }
                        else
                            rop = new RescaleOp(1.0f, this.brillo.getValue(), null);

                        rop.filter(imagen, ventana.getLienzo().getImagen(false));
                        repaint();
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_brilloStateChanged
    /**
     * Aplica el filtro ConvolveOp seleccionado a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ItemEvent.
     */
    private void EfectosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EfectosItemStateChanged
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        Kernel k = KernelProducer.createKernel(0);
        ConvolveOp cop;
        
        if(ventana!=null){
            imagen = ventana.getLienzo().getImagen(false);
            if(imagen!=null){
                switch(Efectos.getSelectedIndex())
                {
                    case 0:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
                        break;
                    case 1:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
                        break;
                    case 2:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_ENFOQUE_3x3);
                        break;
                    case 3:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_RELIEVE_3x3);
                        break;
                    case 4:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_LAPLACIANA_3x3);
                }

                cop = new ConvolveOp(k, ConvolveOp.EDGE_NO_OP, null);
                BufferedImage imgEdit = cop.filter(imagen, null);
                ventana.getLienzo().setImagen(imgEdit);
                repaint();
            }
        }
    }//GEN-LAST:event_EfectosItemStateChanged
    /**
     * Llama al metodo FiltroContraste con el tipo TYPE_SFUNCION.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void ContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrasteActionPerformed
        FiltroContraste(LookupTableProducer.TYPE_SFUNCION);
    }//GEN-LAST:event_ContrasteActionPerformed
    /**
     * Llama al metodo FiltroContraste con el tipo TYPE_LOGARITHM.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void IluminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IluminarActionPerformed
        FiltroContraste(LookupTableProducer.TYPE_LOGARITHM);
    }//GEN-LAST:event_IluminarActionPerformed
    /**
     * Llama al metodo FiltroContraste con el tipo TYPE_POWER.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void OscurecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OscurecerActionPerformed
        FiltroContraste(LookupTableProducer.TYPE_POWER);
    }//GEN-LAST:event_OscurecerActionPerformed
    /**
     * Aplica un filtro LookupOp usando una funcion seno a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void FuncionSenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuncionSenoActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
            BufferedImage imgSource = ventana.getLienzo().getImagen(false);
            if (imgSource != null){
                try{
                    LookupOp lop = new LookupOp(SenoOp.filtroSeno(180.0), null);
                    lop.filter(imgSource, imgSource);
                    repaint();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_FuncionSenoActionPerformed
    /**
     * Lama al metodo rotarImagen pasando como argumento 90 grados.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void Rotar90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rotar90ActionPerformed
        rotarImagen(90);
    }//GEN-LAST:event_Rotar90ActionPerformed
    /**
     * Lama al metodo rotarImagen pasando como argumento 180 grados.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void Rotar180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rotar180ActionPerformed
        rotarImagen(180);
    }//GEN-LAST:event_Rotar180ActionPerformed
    /**
     * Lama al metodo rotarImagen pasando como argumento 270 grados.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void Rotar270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rotar270ActionPerformed
        rotarImagen(270);
    }//GEN-LAST:event_Rotar270ActionPerformed
    /**
     * Lama al metodo rotar pasando como argumento el valor en grados del slider.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void RotacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RotacionStateChanged
        rotar(Rotacion.getValue(), imagen);
    }//GEN-LAST:event_RotacionStateChanged
    /**
     * Carga en el buffer la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void RotacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RotacionFocusGained
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
        if(ventana != null)
            imagen = ventana.getLienzo().getImagen(false);
    }//GEN-LAST:event_RotacionFocusGained
    /**
     * Borra del buffer la imagen y pone el valor del slider a 0.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void RotacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RotacionFocusLost
        imagen = null;
        Rotacion.setValue(0);
    }//GEN-LAST:event_RotacionFocusLost
    /**
     * Llama al metodo escalar aumentando un 25% la imagen.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void IncrementarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncrementarActionPerformed
        escalar(1.25);
    }//GEN-LAST:event_IncrementarActionPerformed
    /**
     * Llama al metodo escalar disminuyendo un 25% la imagen.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DecrementarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecrementarActionPerformed
        escalar(0.75);
    }//GEN-LAST:event_DecrementarActionPerformed
    /**
     * Aplica un filtro TintOp tiñendo del color seleccionado la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void TintarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TintarActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
           BufferedImage imgSource = ventana.getLienzo().getImagen(false);
           if(imgSource!= null){
               TintOp tintado = new TintOp(selectedColor,0.5f);
               tintado.filter(imgSource, imgSource);
               repaint();
           }
        }
    }//GEN-LAST:event_TintarActionPerformed
    /**
     * Aplica un filtro SepiaOp a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void SepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SepiaActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
           BufferedImage imgSource = ventana.getLienzo().getImagen(false);
           if(imgSource!= null){
               SepiaOp sepia = new SepiaOp();
               sepia.filter(imgSource, imgSource);
               repaint();
           }
        }
    }//GEN-LAST:event_SepiaActionPerformed
    /**
     * Aplica un filtro EqualizationOp a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void EcualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EcualizarActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
           BufferedImage imgSource = ventana.getLienzo().getImagen(false);
           if(imgSource!= null){
               EqualizationOp ecualizacion = new EqualizationOp();
               ecualizacion.filter(imgSource, imgSource);
               repaint();
           }
        }
    }//GEN-LAST:event_EcualizarActionPerformed
    /**
     * Reproduce o pausa el audio del archivo cargado en la PlayList.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void PlayPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseActionPerformed
        if (player != null && player.isRunning()) {
            clipTime = player.getMicrosecondPosition();
            player.stop();
        }
        else {
            if (sonando != PlayList.getSelectedIndex() || clipTime == 0){
                try {
                    sonando = PlayList.getSelectedIndex();
                    File f = (File)PlayList.getSelectedItem();
                    player = AudioSystem.getClip();
                    player.open(AudioSystem.getAudioInputStream(f));
                    player.addLineListener(new ManejadorAudio());
                    player.start();
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(this, "Error al reproducir el archivo de audio", "Error", JOptionPane.ERROR_MESSAGE);;}
            }
            else{
                player.setMicrosecondPosition(clipTime);
                player.start();
            }
        }
    }//GEN-LAST:event_PlayPauseActionPerformed
    /**
     * Detiene el audio del archivo cargado en la PlayList.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        if (player != null) {
            player.stop();
            clipTime = 0;
            
            Stop.setEnabled(false);
        }
    }//GEN-LAST:event_StopActionPerformed
    /**
     * Graba por el microfono un audio, guarda el archivo y lo carga en la PlayList.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void GrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrabarActionPerformed
    if (recorder == null){
        JFileChooser dlg = new JFileChooser();
        dlg.addChoosableFileFilter(new FileFilterExtension(".wav", "WAVE form audio file format"));

        int resp = dlg.showSaveDialog(this);
        if (resp == JFileChooser.APPROVE_OPTION) {
            recorded = dlg.getSelectedFile();
            try{
                recorded.createNewFile();
                recorder = new SMSoundRecorder(recorded);
                //((SMSoundRecorder)recorder).addLineListener(new ManejadorAudio());
                recorder.record();
                Grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stopRecord24x24.png")));
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Error al grabar", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(VentanaPaint.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }
    else{
        recorder.stop();
        PlayList.addItem(recorded);
        Grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/record24x24.png")));
        recorder = null;
    }
        
        
        /*if (recorder == null){
            recorded = new File("grabacion.wav");
            try{
                recorded.createNewFile();
                recorder = new SMSoundRecorder(recorded);
                //((SMSoundRecorder)recorder).addLineListener(new ManejadorAudio());
                recorder.record();
                Grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/stopRecord24x24.png")));
            }catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Error al grabar", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(VentanaPaint.class.getName()).log(Level.SEVERE, null, ex);}
        }
        else{
            recorder.stop();
            PlayList.addItem(recorded);
            Grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/record24x24.png")));
            recorder = null;
        }*/
    }//GEN-LAST:event_GrabarActionPerformed
    /**
     * Establece un filtro de UmbralizacionOp a la imagen de la ventana seleccionada.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void UmbralStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_UmbralStateChanged
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            if(imagen!=null){
                try{
                    UmbralizacionOp umbralizar = new UmbralizacionOp(Umbral.getValue());
                    umbralizar.filter(imagen, ventana.getLienzo().getImagen(false));
                    repaint();
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_UmbralStateChanged
    /**
     * Separa la imagen de la ventana seleccionada en sus bandas dependiendo del espacio de color de la imagen.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void SplitBandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SplitBandsActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
           imagen = ventana.getLienzo().getImagen(false);
           if(imagen!= null){
                //Creamos el modelo de color de la nueva imagen basado en un espcio de color GRAY
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                ComponentColorModel cm = new ComponentColorModel(cs, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
                
                for(int i=0; i < imagen.getRaster().getNumBands(); i++){
                    int bandaActual[] = {i}; 
                    WritableRaster bandRaster = (WritableRaster)imagen.getRaster().createWritableChild(0, 0, imagen.getWidth(), imagen.getHeight(), 0, 0, bandaActual);
                    BufferedImage imgBanda = new BufferedImage(cm, bandRaster, false, null);
                    
                    VentanaInterna VentanaBanda = new VentanaInterna(imgBanda.getWidth(), imgBanda.getHeight(), this);
                    VentanaBanda.setTitle(ventana.getTitle() + " [Banda " + i + "]");
                    VentanaBanda.getLienzo().setImagen(imgBanda);
                    Escritorio.add(VentanaBanda);
                    VentanaBanda.setVisible(true);
                }
                repaint();
           }
        }
    }//GEN-LAST:event_SplitBandsActionPerformed
    /**
     * Cambia la imagen de la ventana seleccionada a un nuevo espacio de color.
     * @param evt: Objeto de evento de tipo ItemEvent.
     */
    private void EspacioColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EspacioColorItemStateChanged
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if(ventana != null){
            imagen = ventana.getLienzo().getImagen(false);
            
            if(imagen != null){
                ColorSpace cs = null;
                String espacioColor = "";
                String nombreV = ventana.getTitle() + " [RGB]";
                switch(EspacioColor.getSelectedIndex()){
                    case 0:
                        if (!imagen.getColorModel().getColorSpace().isCS_sRGB() && imagen.getRaster().getNumBands() > 1){   
                            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                            espacioColor = "[RGB]";
                        }
                        break;
                    case 1:
                        if (imagen.getColorModel().getColorSpace().isCS_sRGB()){
                            cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                            espacioColor = "[YCC]";
                        }
                        break;
                    case 2:
                        if (imagen.getRaster().getNumBands() > 1){   
                            cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                            espacioColor = "[GRAY]";
                        }
                        break;
                }
                if(cs != null){
                    ColorConvertOp cop = new ColorConvertOp(cs, null);
                    BufferedImage imgdest = cop.filter(imagen, null);
                    VentanaInterna ventanaEC = new VentanaInterna(imgdest.getWidth(), imgdest.getHeight(), this);
                    ventanaEC.setTitle(nombreV.substring(0, nombreV.indexOf("[")) + espacioColor);
                    
                    ventanaEC.getLienzo().setImagen(imgdest);
                    Escritorio.add(ventanaEC);
                    ventanaEC.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_EspacioColorItemStateChanged
    /**
     * Muestra la barra de herramientas general.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void VerBGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerBGeneralActionPerformed
        BHerram.setVisible(VerBGeneral.isSelected());
    }//GEN-LAST:event_VerBGeneralActionPerformed
    /**
     * Muestra la barra de procesado.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void VerBProcesadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerBProcesadoActionPerformed
        panelAjustes.setVisible(VerBProcesado.isSelected());
    }//GEN-LAST:event_VerBProcesadoActionPerformed
    /**
     * Muestra la barra de estado.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void VerBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerBEstadoActionPerformed
        panelEstado.setVisible(VerBEstado.isSelected());
    }//GEN-LAST:event_VerBEstadoActionPerformed
    /**
     * Carga en el buffer una nueva imagen.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void UmbralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UmbralFocusGained
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
        if(ventana!=null){
           ColorModel cm = ventana.getLienzo().getImagen(false).getColorModel();
           WritableRaster raster = ventana.getLienzo().getImagen(false).copyData(null);
           boolean alfaPre = ventana.getLienzo().getImagen(false).isAlphaPremultiplied();
           imagen = new BufferedImage(cm,raster,alfaPre,null);
        }
    }//GEN-LAST:event_UmbralFocusGained
    /**
     * borra del buffer la imagen y establece el valor del slider en 128.
     * @param evt: Objeto de evento de tipo FocusEvent.
     */
    private void UmbralFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UmbralFocusLost
        imagen = null;
        Umbral.setValue(128);
    }//GEN-LAST:event_UmbralFocusLost
    /**
     * Muestra una ventana de informacion sobre el programa.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void AcercaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaDActionPerformed
        JOptionPane.showMessageDialog(this, "Velazquez: dibujo, procesado y sonido\nVersion: 1.0\nAutor: Pablo Gervilla Palomar", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AcercaDActionPerformed
    /**
     * Activa el boton de PlayPause.
     * @param evt: Objeto de evento de tipo ItemEvent.
     */
    private void PlayListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PlayListItemStateChanged
        if (!PlayPause.isEnabled()){
            PlayPause.setEnabled(true);
        }   
    }//GEN-LAST:event_PlayListItemStateChanged
    /**
     * Borra el elemento seleccionado de la PlayList pulsando la tecla supr.
     * @param evt: Objeto de evento de tipo KeyEvent.
     */
    private void PlayListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlayListKeyPressed
        if(evt.getKeyCode() == 127){
            PlayList.removeItemAt(PlayList.getSelectedIndex());
        }
    }//GEN-LAST:event_PlayListKeyPressed
    /**
     * Aplica un filtroNegativoOp a la imagen de la ventana seleccionada.
     * Tambien podria llamarse al metodo FiltroContraste con el parametro de tipo LookupTableProducer obteniendo el mismo resultado.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void NegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegativoActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
            BufferedImage imgSource = ventana.getLienzo().getImagen(false);
            if(imgSource!= null){
                NegativoOp negativo = new NegativoOp();
                negativo.filter(imgSource, imgSource);
                ventana.repaint();
            }
        }
        //FiltroContraste(LookupTableProducer.TYPE_NEGATIVE);
    }//GEN-LAST:event_NegativoActionPerformed
    /**
     * Copia la imagen de la ventana seleccionada y la abre e una ventana nueva.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarActionPerformed
        VentanaInterna ventana=(VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null) {
            BufferedImage img = ventana.getLienzo().getImagen(false);
            BufferedImage copiaImagen;
            copiaImagen = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
            
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    copiaImagen.setRGB(x,y,img.getRGB(x, y));
                }
            }
            
            VentanaInterna nuevaVentana = new VentanaInterna(img.getWidth(), img.getHeight(), this);
            nuevaVentana.getLienzo().setImagen(copiaImagen);
            this.Escritorio.add(nuevaVentana);
            nuevaVentana.setTitle("copia_" + ventana.getTitle());
            nuevaVentana.setVisible(true);
        }
    }//GEN-LAST:event_CopiarActionPerformed
    /**
     * Muestra el reproductor de audio.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void VerAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerAudioActionPerformed
        ReproductorAudio.setVisible(VerAudio.isSelected());
    }//GEN-LAST:event_VerAudioActionPerformed
    /**
     * Muestra los paneles de rotacion y escala y un separador si hay una ventana activa.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void TransformarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransformarActionPerformed
        if (panelEscala.isVisible()){
            panelEscala.setVisible(Transformar.isSelected());
            panelRotacion.setVisible(Transformar.isSelected());
            Separador2.setVisible(Transformar.isSelected());
        }
        else{
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
            if(ventana != null){
                imagen = ventana.getLienzo().getImagen(false);
                if(imagen != null){
                    OK.setVisible(true);
                    panelEscala.setVisible(Transformar.isSelected());
                    panelRotacion.setVisible(Transformar.isSelected());
                    Separador2.setVisible(Transformar.isSelected());
                }
            }
            //else
               // Transformar.setSelected(false);
        }
    }//GEN-LAST:event_TransformarActionPerformed
    /**
     * Establece la figura seleccionada como seleccionada en el lienzo de la ventana activa y habilita la edicion en el lienzo.
     * Si el elemento ya esta activo, desmarca la seleccion del lienzo y deshabilita la edicion.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void ListaFigurasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaFigurasMousePressed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        
        if (ventana != null && !ListaFiguras.isSelectionEmpty()){
            //System.out.println("He seleccionado: " + ListaFiguras.getSelectedIndex());
            //System.out.println("Estaba seleccionado: " + ventana.getLienzo().getIndexFiguraSelec());
            if (ListaFiguras.isSelectedIndex(ventana.getLienzo().getIndexFiguraSelec()) ){
                //System.out.println("entre");
                ventana.getLienzo().setFiguraSelec(-1);
                //System.out.println("A tomar por culo: " + ventana.getLienzo().getIndexFiguraSelec());
                //ListaFiguras.getComponent(ListaFiguras.getSelectedIndex()).setBackground(Color.GRAY);
                ventana.getLienzo().setEdicion(false);
                xTxt.setText("");
                yTxt.setText("");
                xTxt.setEditable(false);
                yTxt.setEditable(false);
            }
            else{
                //System.out.println("voy a entrar");
                //System.out.println(ListaFiguras.getSelectedIndex());
                ventana.getLienzo().setFiguraSelec(ListaFiguras.getSelectedIndex());
                //System.out.println("entre");
                FiguraPro figuraSelect = ventana.getLienzo().getFiguraSelec(ListaFiguras.getSelectedIndex());
                //System.out.println("creo la figura select");
                if(figuraSelect != null){
                    xTxt.setEditable(true);
                    yTxt.setEditable(true);
                    ventana.getLienzo().setActualShape(ListaFiguras.getSelectedIndex());
                    this.setXY(ventana.getLienzo().getPosicion());
                    ventana.getLienzo().setEdicion(true);
                    this.cargarAtributos();
                }
            }
        }
    }//GEN-LAST:event_ListaFigurasMousePressed
    /**
     * Muestra un completo y extenso manual de funcionamiento del programa.
     * @param evt: Objeto de evento de tipo ActionEvent;
     */
    private void ComoFuncionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComoFuncionaActionPerformed
        JOptionPane.showMessageDialog(this, "pa k kieres saber eso jaja saludos", "Como funciona", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_ComoFuncionaActionPerformed
    /**
     * Crea una nueva ventana interna con los valores ancho y alto introducidos en la ventana.
     * @param evt: Objeto de evento de tipo ActionEvent;
     */
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        SeleccionarTam.setVisible(false);
        VentanaInterna ventana = new VentanaInterna(Integer.parseInt(Ancho.getText()), Integer.parseInt(Alto.getText()), this);
        this.Escritorio.add(ventana);
        ventana.setTitle("nueva");
        ventana.setVisible(true);
    }//GEN-LAST:event_AceptarActionPerformed
    /**
     * Cierra la ventana de seleccion de tamaño.
     * @param evt: Objeto de evento de tipo ActionEvent;
     */
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        SeleccionarTam.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed
    /**
     * Crea una nueva ventana interna con 600 de ancho y 500 de alto.
     * @param evt: Objeto de evento de tipo ActionEvent; 
     */
    private void DefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefectoActionPerformed
        SeleccionarTam.setVisible(false);
        VentanaInterna ventana = new VentanaInterna(600, 500, this);
        this.Escritorio.add(ventana);
        ventana.setTitle("nueva");
        ventana.setVisible(true);
    }//GEN-LAST:event_DefectoActionPerformed
    /**
     * Borra el elemento seleccionado de la ListaFiguras pulsando la tecla supr.
     * @param evt: Objeto de evento de tipo KeyEvent.
     */
    private void ListaFigurasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaFigurasKeyPressed
        if(evt.getKeyCode() == 127){
            VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
            if (ventana != null && ListaFiguras.getSelectedIndex() != -1){
                int selec = ListaFiguras.getSelectedIndex();
                ventana.getLienzo().setFiguraSelec(/*ListaFiguras.getLastVisibleIndex()*/-1);
                ventana.getLienzo().setEdicion(false);
                ventana.getLienzo().borrarFiguraSelec(selec);
                System.out.println(selec);
                ListaFiguras.remove(selec);
                cargarLista();
                
            }
        }
    }//GEN-LAST:event_ListaFigurasKeyPressed
    /**
     * Aplica como color de fondo del boton el color seleccionado mediante la lista de colores o un dialogo de seleccion de color.
     * Añade el color seleccionado como color de trazo al lienzo si hay una ventana activa.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void ColorTrazoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorTrazoMousePressed
        Color c;
        if(evt.getButton() == MouseEvent.BUTTON3){
            c = JColorChooser.showDialog(this, "Elige un color de trazo", selectedColor);
        }
        else{
            c = selectedColor;
        }
        
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setColorTrazo(c);
        }
        ColorTrazo.setBackground(c);
        repaint();
    }//GEN-LAST:event_ColorTrazoMousePressed
    /**
     * Aplica como color de fondo del boton el color seleccionado mediante la lista de colores o un dialogo de seleccion de color.
     * Añade el color seleccionado como color de relleno al lienzo si hay una ventana activa.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void ColorRellenoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorRellenoMousePressed
        Color c;
        if(evt.getButton() == MouseEvent.BUTTON3){
            c = JColorChooser.showDialog(this, "Elige un color de relleno", selectedColor);
        }
        else{
            c = selectedColor;
        }
        
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setColorRelleno(c);
        }
        ColorRelleno.setBackground(c);
        repaint();
    }//GEN-LAST:event_ColorRellenoMousePressed
    /**
     * Establece si el trazo es continuo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void TrazoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrazoCActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setContinuidad(true);
            repaint();
        }
    }//GEN-LAST:event_TrazoCActionPerformed
    /**
     * Establece si el trazo es discontinuo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void TrazoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrazoDActionPerformed
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setContinuidad(false);
            repaint();
        }
    }//GEN-LAST:event_TrazoDActionPerformed
    /**
     * Muestra los paneles de brillo y contraste si hay una ventana activa.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void BrilloContrasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrilloContrasteActionPerformed
        if (panelBrillo.isVisible()){
            panelBrillo.setVisible(BrilloContraste.isSelected());
            panelContraste.setVisible(BrilloContraste.isSelected());
        }
        else{
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
            if(ventana != null){
                imagen = ventana.getLienzo().getImagen(false);
                if(imagen != null){
                    OK.setVisible(true);
                    panelBrillo.setVisible(BrilloContraste.isSelected());
                    panelContraste.setVisible(BrilloContraste.isSelected());
                }
            }
            //else
                //BrilloContraste.setSelected(false);
        }
    }//GEN-LAST:event_BrilloContrasteActionPerformed
        /**
     * Confirma que se ha terminado de usar la transformacion / brillo y contraste y los cierra.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        Transformar.setSelected(false);
        this.TransformarActionPerformed(evt);
        BrilloContraste.setSelected(false);
        this.BrilloContrasteActionPerformed(evt);
        panelRelleno.setVisible(false);
        OK.setVisible(false);
    }//GEN-LAST:event_OKActionPerformed
    /**
     * Establece el nivel de transparencia que se aplica en el lienzo.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void NivelTranspStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NivelTranspStateChanged
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            try{
                ventana.getLienzo().setNivelTransparencia(NivelTransp.getValue()/100.0f);
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_NivelTranspStateChanged
    /**
     * Oculta el slider del nivel de transparencia.
     * @param evt: Objeto de evento de tipo ChangeEvent.
     */
    private void NivelTranspFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NivelTranspFocusLost
        this.panelTransp.setVisible(false);
    }//GEN-LAST:event_NivelTranspFocusLost
    /**
     * Aplica la posicion en la componente x a la figura seleccionada.
     * @param evt: Objeto de evento de tipo KeyEvent.
     */
    private void xTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xTxtKeyPressed
        if(evt.getKeyCode() == 10 && xTxt.isEditable()){
            VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
            if (ventana != null) {
                ventana.getLienzo().setPosicion(Integer.parseInt(xTxt.getText()), Integer.parseInt(yTxt.getText()));
            }
        }
    }//GEN-LAST:event_xTxtKeyPressed
    /**
     * Aplica la posicion en la componente y a la figura seleccionada.
     * @param evt: Objeto de evento de tipo KeyEvent.
     */
    private void yTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yTxtKeyPressed
        if(evt.getKeyCode() == 10 && yTxt.isEditable()){
            VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
            if (ventana != null) {
                ventana.getLienzo().setPosicion(Integer.parseInt(xTxt.getText()), Integer.parseInt(yTxt.getText()));
            }
        }
    }//GEN-LAST:event_yTxtKeyPressed
    /**
     * Establece el tipo de relleno como normal. 
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RnormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RnormalActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            this.Relleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/rellenar.png")));
            ventana.getLienzo().setDegradado(false);
            ventana.getLienzo().setRelleno(true);
            panelDegradado.setVisible(false);
        }
    }//GEN-LAST:event_RnormalActionPerformed
    /**
     * Establece el tipo de relleno como degradado.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RdegradadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RdegradadoActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            this.Relleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/degradado.png")));
            ventana.getLienzo().setDegradado(true);
            panelDegradado.setVisible(true);
            DegHor.setSelected(true);
            this.DegHorActionPerformed(evt);
        }
    }//GEN-LAST:event_RdegradadoActionPerformed
    /**
     * Establece el tipo de degradado como horizontal.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DegHorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegHorActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            ventana.getLienzo().setTipoDegradado('h');
        }
    }//GEN-LAST:event_DegHorActionPerformed
    /**
     * Establece el tipo de degradado como una diagonal de arriba a abajo.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DegDig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegDig1ActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            ventana.getLienzo().setTipoDegradado('d');
        }
    }//GEN-LAST:event_DegDig1ActionPerformed
    /**
     * Establece el tipo de degradado como una diagonal de abajo a arriba.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DegDig2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegDig2ActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            ventana.getLienzo().setTipoDegradado('i');
        }
    }//GEN-LAST:event_DegDig2ActionPerformed
    /**
     * Establece el tipo de degradado como vertical.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DegVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DegVerActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            ventana.getLienzo().setTipoDegradado('v');
        }
    }//GEN-LAST:event_DegVerActionPerformed
    /**
     * Deshabilita el modo edicion.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void DeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseleccionarActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ListaFiguras.isSelectedIndex(ventana.getLienzo().getIndexFiguraSelec())){
            ventana.getLienzo().setFiguraSelec(-1);
            ventana.getLienzo().setEdicion(false);
            xTxt.setText("");
            yTxt.setText("");
            xTxt.setEditable(false);
            yTxt.setEditable(false);
        }
    }//GEN-LAST:event_DeseleccionarActionPerformed
    /**
     * Aplica como color de fondo del boton el color seleccionado mediante la lista de colores o un dialogo de seleccion de color.
     * Añade el color seleccionado como color de relleno secundario al lienzo si hay una ventana activa.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void ColorRelleno2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorRelleno2MousePressed
        Color c;
        if(evt.getButton() == MouseEvent.BUTTON3){
            c = JColorChooser.showDialog(this, "Elige un color de relleno", selectedColor);
        }
        else{
            c = selectedColor;
        }
        
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            ventana.getLienzo().setColorRelleno2(c);
        }
        ColorRelleno2.setBackground(c);
        repaint();
    }//GEN-LAST:event_ColorRelleno2MousePressed
    /**
     * Aplica un filtro de ColorizacionOp a la imagen de la ventana activa.
     * @param evt: Objeto de evento de tipo MouseEvent.
     */
    private void ColorizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ColorizarMousePressed
        if(evt.getButton() == MouseEvent.BUTTON3){
            panelRgb.setVisible(true);
            panelRgb.setBounds(Colorizar.getX(), this.Escritorio.getHeight()-40, 160, 40);
        }
        else{
            VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
            if (ventana != null) {
               BufferedImage imgSource = ventana.getLienzo().getImagen(false);
                if(imgSource!=null){
                    try{
                        int c;
                        if(R.isSelected()){
                            c = 0;
                        }
                        else{
                            if(G.isSelected()){
                                c = 1;
                            }
                            else
                                c = 2;
                        }
                        ColorizacionOp colorizar = new ColorizacionOp(c);
                        colorizar.filter(imgSource, imgSource);
                        repaint();
                    }catch(IllegalArgumentException e){
                        JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR);
                    }
                }
            }
        }
    }//GEN-LAST:event_ColorizarMousePressed
    /**
     * Establece el color rojo como base para aplicar el filtro de colorizar.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RActionPerformed
        Colorizar.setBackground(Color.RED);
        panelRgb.setVisible(false);
    }//GEN-LAST:event_RActionPerformed
    /**
     * Establece el color verde como base para aplicar el filtro de colorizar.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GActionPerformed
        Colorizar.setBackground(Color.GREEN);
        panelRgb.setVisible(false);
    }//GEN-LAST:event_GActionPerformed
    /**
     * Establece el color azul como base para aplicar el filtro de colorizar.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActionPerformed
        Colorizar.setBackground(Color.BLUE);
        panelRgb.setVisible(false);
    }//GEN-LAST:event_BActionPerformed
    /**
     * Aplica un filtro de LookupOp de tipo mezcla termica a la imagen de la ventana activa.
     * @param evt: Objeto de evento de tipo MouseEvent. 
     */
    private void TempMixMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TempMixMousePressed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
            BufferedImage imgSource = ventana.getLienzo().getImagen(false);
            if (imgSource != null){
                try{
                    LookupOp lop;
                    if(evt.getButton() == MouseEvent.BUTTON3){
                        lop = new LookupOp(TempMixOp.filtroTempMix(true), null);
                    }
                    else{
                        lop = new LookupOp(TempMixOp.filtroTempMix(false), null);
                    }
                    lop.filter(imgSource, imgSource);
                    repaint();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_TempMixMousePressed

    private void PlayPauseVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayPauseVActionPerformed

    private void StopVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StopVActionPerformed

    private void CamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamaraActionPerformed
        VentanaInternaCamara ventanaCamara = VentanaInternaCamara.getInstance();
        if (ventanaCamara != null){
            this.Escritorio.add(ventanaCamara);
            ventanaCamara.setVisible(true);
        }
    }//GEN-LAST:event_CamaraActionPerformed

    private void CapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapturaActionPerformed
        VentanaInternaCamara ventanaCamara;
        try{
            ventanaCamara = (VentanaInternaCamara) Escritorio.getSelectedFrame();
            if (ventanaCamara != null) {
                BufferedImage captura = ventanaCamara.getImagen();
                VentanaInterna nuevaVentana = new VentanaInterna(captura.getWidth(), captura.getHeight(), this);
                BufferedImage img = new BufferedImage(captura.getWidth(), captura.getHeight(), 1);
            
                for (int x = 0; x < captura.getWidth(); x++) {
                    for (int y = 0; y < captura.getHeight(); y++) {
                        img.setRGB(x,y,captura.getRGB(x, y));
                    }
                }
                nuevaVentana.getLienzo().setImagen(img);
                this.Escritorio.add(nuevaVentana);
                nuevaVentana.setTitle("Captura de video");
                nuevaVentana.setVisible(true);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "La ventana seleccionada no es de Video,\nno se puede hacer una captura", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CapturaActionPerformed
    /**
     * Muestra el reproductor de audio.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void VerVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerVideoActionPerformed
        ReproductorVideo.setVisible(VerVideo.isSelected());
    }//GEN-LAST:event_VerVideoActionPerformed

    private void Ecualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ecualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ecualizar1ActionPerformed
    /**
     * Resta la imagen de la ventana activa a la de la ni activa.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void MenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenosActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            VentanaInterna viNext = (VentanaInterna) Escritorio.selectFrame(false);
            if (viNext != null) {
                BufferedImage imgRight = ventana.getLienzo().getImagen(false);
                BufferedImage imgLeft = viNext.getLienzo().getImagen(false);
                if (imgRight != null && imgLeft != null) {
                    try {
                        SubtractionOp op = new SubtractionOp(imgLeft);
                        BufferedImage imgdest = op.filter(imgRight, null);
                        ventana = new VentanaInterna(imgdest.getWidth(), imgdest.getHeight(), this);
                        ventana.getLienzo().setImagen(imgdest);
                        this.Escritorio.add(ventana);
                        ventana.setVisible(true);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error: "+e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_MenosActionPerformed
    /**
     * Suma la imagen de la ventana activa a la de la ni activa.
     * @param evt: Objeto de evento de tipo ActionEvent.
     */
    private void MasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasActionPerformed
        VentanaInterna ventana = (VentanaInterna) (Escritorio.getSelectedFrame());
        if (ventana != null) {
            VentanaInterna viNext = (VentanaInterna) Escritorio.selectFrame(false);
            if (viNext != null) {
                BufferedImage imgRight = ventana.getLienzo().getImagen(false);
                BufferedImage imgLeft = viNext.getLienzo().getImagen(false);
                if (imgRight != null && imgLeft != null) {
                    try {
                        float a = Float.parseFloat(Alfa.getValue().toString())/100f;
                        BlendOp op = new BlendOp(imgLeft, a);
                        BufferedImage imgdest = op.filter(imgRight, null);
                        ventana = new VentanaInterna(imgdest.getWidth(), imgdest.getHeight(), this);
                        ventana.getLienzo().setImagen(imgdest);
                        this.Escritorio.add(ventana);
                        ventana.setVisible(true);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error: "+e.getLocalizedMessage());
                    }
                }
            }
        }
    }//GEN-LAST:event_MasActionPerformed

    private void AlfaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AlfaStateChanged
        if((int)Alfa.getValue() < 0){
            Alfa.setValue(0);
        }
        else{
            if((int)Alfa.getValue() > 100){
                Alfa.setValue(100);
            }
        }
    }//GEN-LAST:event_AlfaStateChanged

    private void TritanopiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TritanopiaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TritanopiaMousePressed

    private void TritanopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TritanopiaActionPerformed
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if (ventana != null){
           BufferedImage imgSource = ventana.getLienzo().getImagen(false);
           if(imgSource!= null){
               TritanOp sepia = new TritanOp();
               sepia.filter(imgSource, imgSource);
               repaint();
           }
        }
    }//GEN-LAST:event_TritanopiaActionPerformed
    /**
     * Aplica un filtro LookupOp del tipo indicado a la imagen de la ventana activa.
     * @param tipo: tipo de filtro LookupOp.
     */
    private void FiltroContraste(int tipo){
        VentanaInterna ventana = (VentanaInterna) (this.Escritorio.getSelectedFrame());
        if (ventana != null){
           BufferedImage imgSource = ventana.getLienzo().getImagen(false);
           if(imgSource!=null){
               try{
                   LookupTable lt = LookupTableProducer.createLookupTable(tipo);
                   LookupOp lop = new LookupOp(lt, null);
                   // Imagen origen y destino iguales
                   lop.filter(imgSource , imgSource);
                   repaint();
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
               }
           }
        }
    }
    /**
     * Rota la imagen seleccionada los grados indicados.
     * @param grados: grados que va a rotar la imagen.
     * @param imagen: imagen a rotar.
     */
    private void rotar(double grados, BufferedImage imagen){
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
        double r = Math.toRadians(grados);
        Point p = new Point(imagen.getWidth()/2, imagen.getHeight()/2);
        AffineTransform at = AffineTransform.getRotateInstance(r,p.x,p.y);
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        BufferedImage imgdest = atop.filter(imagen, null);
        ventana.getLienzo().setImagen(imgdest);
        repaint();
    }
    /**
     * Rota la imagen de buffer los grados indicados.
     * @param grados: grados que va a rotar la imagen.
     */
    private void rotarImagen(double grados){
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
        imagen = ventana.getLienzo().getImagen(false);
        rotar(grados, imagen);
    }
    /**
     * Amplia o encoge la imagen en funcion de la escala indicada.
     * @param escala: escala a aplicar.
     */
    private void escalar (double escala){
        VentanaInterna ventana = (VentanaInterna) this.Escritorio.getSelectedFrame();
        imagen = ventana.getLienzo().getImagen(false);
        
        AffineTransform at = AffineTransform.getScaleInstance(escala, escala);
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        BufferedImage imgdest = atop.filter(imagen, null);
        ventana.getLienzo().setImagen(imgdest);
        repaint();
    }
    /**
     * Carga los elementos del vector de figuras del lienzo de la ventana activa en ListaFiguras.
     */
    protected void cargarLista(){
        VentanaInterna ventana = (VentanaInterna) Escritorio.getSelectedFrame();
        if (ventana != null){
            DefaultListModel dlm = new DefaultListModel();
            for (FiguraPro f:ventana.vFigura){
                dlm.addElement(f);
            }
            ListaFiguras.setModel(dlm);
        }
        else{
            DefaultListModel dlm = new DefaultListModel();
            dlm.clear();
            ListaFiguras.setModel(dlm);
        }
    }
    /**
     * Actualiza los botones de la interfaz conforme al lienzo o figura seleccionada.
     */
    protected void cargarAtributos(){
        VentanaInterna ventana = (VentanaInterna)(Escritorio.getSelectedFrame());
        if(ventana!=null){
            if(!ventana.getLienzo().isEditable()){
                this.Relleno.setSelected(ventana.getLienzo().getRelleno(false));
                this.Renderizado.setSelected(ventana.getLienzo().getRenderizado(false));
                this.Transparencia.setSelected(ventana.getLienzo().getTransparencia(false));
                this.Grosor.setValue(ventana.getLienzo().getTrazo(false));
                this.ColorTrazo.setBackground(ventana.getLienzo().getColorTrazo(false));
                this.ColorRelleno.setBackground(ventana.getLienzo().getColorRelleno(false));
                this.ColorRelleno2.setBackground(ventana.getLienzo().getColorRelleno2(false));
            }
            else{
                this.Relleno.setSelected(ventana.getLienzo().getRelleno(true));
                this.Renderizado.setSelected(ventana.getLienzo().getRenderizado(true));
                this.Transparencia.setSelected(ventana.getLienzo().getTransparencia(true));
                this.Grosor.setValue(ventana.getLienzo().getTrazo(true));
                this.ColorTrazo.setBackground(ventana.getLienzo().getColorTrazo(true));
                this.ColorRelleno.setBackground(ventana.getLienzo().getColorRelleno(true));
                this.ColorRelleno2.setBackground(ventana.getLienzo().getColorRelleno2(false));
            }
        } 
    }
    /**
     * Devuelve la herramienta seleccionada.
     * @return la herramienta seleccionada. 
     */
    public Tipo getHerramienta(){
        return herramienta;
    }
    /**
     * Muestra en los paneles de posicion la x y la y de un punto.
     * @param p: punto a mostrar.
     */
    public void setXY(Point p){
        xTxt.setText(p.x + "");
        yTxt.setText(p.y + "");
    }
    /**
     * Clase que implementa LineListener y actua como listener de audio.
     */
    class ManejadorAudio implements LineListener {
        /**
         * Habilita y establece iconos a los diferente botones de audio con respecto al boton PlayPause.
         * @param event: evento de tipo LineEvent.
         */
        @Override
        public void update(LineEvent event) {
            if (event.getType() == LineEvent.Type.START) {
                PlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pausa24x24.png")));
                Grabar.setEnabled(false);
                Stop.setEnabled(true);
            }
            if (event.getType() == LineEvent.Type.STOP) {
                PlayPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play24x24.png")));
                Grabar.setEnabled(true);
            }
            if (event.getType() == LineEvent.Type.CLOSE) {
            }
        }
    }
    
    /**
     * @param args the command line arguments.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPaint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        boolean ok = new NativeDiscovery().discover();
        System.out.println(ok);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPaint().setVisible(true);
            }
        });
    }

    
    private BufferedImage imagen;
    Color selectedColor = Color.BLACK;
    //private SMPlayer player = null;
    private Clip player = null;
    long clipTime = 0;
    int sonando;
    SMRecorder recorder = null;
    File recorded;
    Tipo herramienta;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Abanico;
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Aceptar;
    private javax.swing.JMenuItem AcercaD;
    private javax.swing.JSpinner Alfa;
    private javax.swing.JTextField Alto;
    private javax.swing.JTextField Ancho;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Ayuda;
    private javax.swing.JRadioButton B;
    private javax.swing.JMenuItem BAbrir;
    private javax.swing.JMenuItem BGuardar;
    private javax.swing.JToolBar BHerram;
    private javax.swing.JMenuItem BNuevo;
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JCheckBoxMenuItem BrilloContraste;
    private javax.swing.JButton Camara;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Captura;
    private javax.swing.JButton ColorRelleno;
    private javax.swing.JButton ColorRelleno2;
    private javax.swing.JButton ColorTrazo;
    private javax.swing.JButton Colorizar;
    private javax.swing.ButtonGroup ColorizarG;
    private javax.swing.JMenuItem ComoFunciona;
    private javax.swing.ButtonGroup ContinuidadTrazo;
    private javax.swing.JButton Contraste;
    private javax.swing.JMenuItem Copiar;
    private javax.swing.JButton Decrementar;
    private javax.swing.JButton Defecto;
    private javax.swing.JToggleButton DegDig1;
    private javax.swing.JToggleButton DegDig2;
    private javax.swing.JToggleButton DegHor;
    private javax.swing.JToggleButton DegVer;
    private javax.swing.JMenuItem Deseleccionar;
    private javax.swing.JButton Ecualizar;
    private javax.swing.JButton Ecualizar1;
    private javax.swing.JMenu Editar;
    private javax.swing.JComboBox<String> Efectos;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JComboBox<String> EspacioColor;
    private javax.swing.JButton FuncionSeno;
    private javax.swing.JRadioButton G;
    private javax.swing.JButton Grabar;
    private javax.swing.JSpinner Grosor;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel HerramientaAct;
    private javax.swing.ButtonGroup Herramientas;
    private javax.swing.JButton Iluminar;
    private javax.swing.JButton Incrementar;
    private javax.swing.JToggleButton Lapiz;
    private javax.swing.JToggleButton Linea;
    private javax.swing.JComboBox<Color> ListaColores;
    private javax.swing.JList<FiguraPro> ListaFiguras;
    private javax.swing.JButton Mas;
    private javax.swing.JButton Menos;
    private javax.swing.JButton Negativo;
    private javax.swing.JSlider NivelTransp;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton OK;
    private javax.swing.JButton Oscurecer;
    private javax.swing.JToggleButton Ovalo;
    private javax.swing.JComboBox<File> PlayList;
    private javax.swing.JButton PlayPause;
    private javax.swing.JButton PlayPauseV;
    private javax.swing.JRadioButton R;
    private javax.swing.JToggleButton Rdegradado;
    private javax.swing.JToggleButton Rectangulo;
    private javax.swing.JToggleButton Relleno;
    private javax.swing.JToggleButton Renderizado;
    private javax.swing.JPanel ReproductorAudio;
    private javax.swing.JPanel ReproductorVideo;
    private javax.swing.JToggleButton Rnormal;
    private javax.swing.JSlider Rotacion;
    private javax.swing.JButton Rotar180;
    private javax.swing.JButton Rotar270;
    private javax.swing.JButton Rotar90;
    private javax.swing.JFrame SeleccionarTam;
    private javax.swing.JToolBar.Separator Separador1;
    private javax.swing.JToolBar.Separator Separador2;
    private javax.swing.JToolBar.Separator Separador3;
    private javax.swing.JToolBar.Separator Separador4;
    private javax.swing.JSeparator Separador5;
    private javax.swing.JSeparator Separador6;
    private javax.swing.JToolBar.Separator Separador7;
    private javax.swing.JButton Sepia;
    private javax.swing.JButton SplitBands;
    private javax.swing.JButton Stop;
    private javax.swing.JButton StopV;
    private javax.swing.JButton TempMix;
    private javax.swing.JButton Tintar;
    private javax.swing.ButtonGroup TipoDegradado;
    private javax.swing.ButtonGroup TipoRelleno;
    private javax.swing.JCheckBoxMenuItem Transformar;
    private javax.swing.JToggleButton Transparencia;
    private javax.swing.JToggleButton TrazoC;
    private javax.swing.JToggleButton TrazoD;
    private javax.swing.JButton Tritanopia;
    private javax.swing.JSlider Umbral;
    private javax.swing.JMenu Ver;
    private javax.swing.JCheckBoxMenuItem VerAudio;
    private javax.swing.JCheckBoxMenuItem VerBEstado;
    private javax.swing.JCheckBoxMenuItem VerBGeneral;
    private javax.swing.JCheckBoxMenuItem VerBProcesado;
    private javax.swing.JCheckBoxMenuItem VerVideo;
    private javax.swing.JSlider brillo;
    private javax.swing.JPanel espColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAjustes;
    private javax.swing.JPanel panelBinario;
    private javax.swing.JPanel panelBrillo;
    private javax.swing.JPanel panelContraste;
    private javax.swing.JPanel panelDegradado;
    private javax.swing.JPanel panelDibujo;
    private javax.swing.JPanel panelEfectos;
    private javax.swing.JPanel panelEscala;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelRelleno;
    private javax.swing.JPanel panelRgb;
    private javax.swing.JPanel panelRotacion;
    private javax.swing.JPanel panelSeno;
    private javax.swing.JPanel panelTransp;
    private javax.swing.JPanel panelUmbral;
    private javax.swing.JLabel rellenolbl;
    private javax.swing.JLabel trazolbl;
    private javax.swing.JLabel xLbl;
    private javax.swing.JTextField xTxt;
    private javax.swing.JLabel yLbl;
    private javax.swing.JTextField yTxt;
    // End of variables declaration//GEN-END:variables
}
