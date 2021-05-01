/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controladores.MatriculacionJpaController;
import Entidades.cls_conexion;
import Entidades.valid;
import groovyjarjarasm.asm.util.Printer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static paneles.pnlSeguridad.modelo;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author RojeruSan
 */
public class pnlRegistro extends javax.swing.JPanel {

    int x, y;
    Controladores.MatriculacionJpaController matricula = new MatriculacionJpaController();
    int currentRow;
    boolean flag = true;
    String[] botones = {"Si", "No"};
    int idlec;

    Entidades.Matriculacion lol = new Entidades.Matriculacion();

    public pnlRegistro() {
        initComponents();
     //   this.sett
        comboañolectivo();
        combodiscapacidad();
        combobuscar();
        cls_conexion obj = new cls_conexion();
        
        createmodelo();
        cargar_informacion();
        id.setText("0");
        id.setEnabled(false);
        txt_fecha.setText(Dates);
        txt_fecha.setEnabled(false);
        lolsito();
        getALectivo();

    }
    
    private void getALectivo() {
        //pnlconfig config = new pnlconfig();
        idlec = pnlconfig.idalectivo;
        System.err.println("idlec " + idlec);
    }

    
    
    public void comboañolectivo() {
        this.añolectivo.removeAllItems();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistemamatriculacioncng", "root", "");
            Statement Sent = con.createStatement();
            ResultSet rs = Sent.executeQuery("select * from añolectivo ");
            while (rs.next()) {
                
                this.añolectivo.addItem(rs.getString("año"));
                 
            }
        } catch (Exception e) {

        }
        
        
        
    }
    
   
 public void combobuscar() {
        this.buscarr.removeAllItems();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistemamatriculacioncng", "root", "");
            Statement Sent = con.createStatement();
            ResultSet rs = Sent.executeQuery("select * from añolectivo");
            while (rs.next()) {
                
                this.buscarr.addItem(rs.getString("año"));
                 
            }
        } catch (Exception e) {

        }
        
        
        
    }
    public void combodiscapacidad() {
        this.dis.removeAllItems();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sistemamatriculacioncng", "root", "");
            Statement Sent = con.createStatement();
            ResultSet rs = Sent.executeQuery("select * from discapacidad");
            while (rs.next()) {
                this.dis.addItem(rs.getString("tipodediscapacidad"));
            }
        } catch (Exception e) {

        }
    }

    public void lolsito() {

        int i = JOptionPane.showOptionDialog(this, "¿Se llevo a cabo el registro del la seguridad del estudiante?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);

        if (i == 0) {

        } else if (i == 1) {
            cedest.setEnabled(false);
            apeest.setEnabled(false);
            nomest.setEnabled(false);
            añoest.setEnabled(false);
            carn.setEnabled(false);
            dir.setEnabled(false);
            dis.setEnabled(false);
            por.setEnabled(false);
            dis.setEnabled(false);
            cedrep.setEnabled(false);
            aperep.setEnabled(false);
            nomrep.setEnabled(false);
            con.setEnabled(false);
            cel.setEnabled(false);
            cor.setEnabled(false);
            cod.setEnabled(false);
            añolectivo.setEnabled(false);
            guardar.setEnabled(false);
            actualizar.setEnabled(false);
         //   config.setEnabled(false);
            tabla1.setEnabled(false);
            jLabel7.setEnabled(false);
        }

    }

    private void createmodelo() {
        try {
            modelo = (new DefaultTableModel(null, new String[]{"Matricula", "Fecha", "Cédula Estudiante", "Apellidos Estudiante", "Nombres Estudiante ", "Año de basica", "Carnet",
                "Discapacidad", "Porcentaje", "Año Lectivo", "Cedula Representante", "Apellidos Representante", "Nombres Representante", "Direccion", "Telefono Convencional",
                "Telefono Celular ", "Correo", "Codigo Luz"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class};

                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

                @Override
                public Class getColumnClass(int columnindex) {
                    return types[columnindex];
                }

                public boolean isCellEdittable(int rowindex, int colindex) {
                    return canEdit[colindex];
                }

            });
            tabla1.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "Error");

        }
    }

    private void clear() {
        txt_fecha.setText("");
        id.setText("");
        cedest.setText("");
        apeest.setText("");
        nomest.setText("");
        añoest.setText("");
        carn.setText("");
        dir.setText("");
        //     dis.setText("");
        por.setText("");
        cedrep.setText("");
        aperep.setText("");
        nomrep.setText("");
        con.setText("");
        cel.setText("");
        cor.setText("");
        cod.setText("");
        

    }

    private void cargar_informacion() {
        try {
            Object[] o = null;

            List<Entidades.Matriculacion> matriculacions = matricula.findMatriculacionEntities();
            for (int i = 0; i < matriculacions.size(); i++) {
                modelo.addRow(o);

                modelo.setValueAt(matriculacions.get(i).getNMatricula(), i, 0);
                modelo.setValueAt(matriculacions.get(i).getFecha(), i, 1);
                modelo.setValueAt(matriculacions.get(i).getCedEst(), i, 2);
                modelo.setValueAt(matriculacions.get(i).getApeEst(), i, 3);
                modelo.setValueAt(matriculacions.get(i).getNomEst(), i, 4);
                modelo.setValueAt(matriculacions.get(i).getAñoBas(), i, 5);
                modelo.setValueAt(matriculacions.get(i).getCarnet(), i, 6);
                modelo.setValueAt(matriculacions.get(i).getDiscapacidad(), i, 7);
                modelo.setValueAt(matriculacions.get(i).getPorcentaje(), i, 8);
                modelo.setValueAt(matriculacions.get(i).getAñolectivo(), i, 9);
                modelo.setValueAt(matriculacions.get(i).getCedRep(), i, 10);
                modelo.setValueAt(matriculacions.get(i).getApeRep(), i, 11);
                modelo.setValueAt(matriculacions.get(i).getNomRep(), i, 12);
                modelo.setValueAt(matriculacions.get(i).getDirRep(), i, 13);
                modelo.setValueAt(matriculacions.get(i).getTelCon(), i, 14);
                modelo.setValueAt(matriculacions.get(i).getTelCelular(), i, 15);
                modelo.setValueAt(matriculacions.get(i).getCorreo(), i, 16);
                modelo.setValueAt(matriculacions.get(i).getCodigodeluz(), i, 17);
             
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooserBeanInfo1 = new com.toedter.calendar.JDayChooserBeanInfo();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cedrep = new javax.swing.JTextField();
        apeest = new javax.swing.JTextField();
        nomest = new javax.swing.JTextField();
        añoest = new javax.swing.JTextField();
        cedest = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        con = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        nomrep = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cel = new javax.swing.JTextField();
        cor = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        por = new javax.swing.JTextField();
        carn = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        aperep = new javax.swing.JTextField();
        guardar = new rsbuttom.RSButtonMetro();
        actualizar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        dis = new javax.swing.JComboBox<>();
        añolectivo = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        buscarr = new javax.swing.JComboBox<>();
        Eliminar1 = new rsbuttom.RSButtonMetro();
        Buscar1 = new rsbuttom.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(638, 530));
        setPreferredSize(new java.awt.Dimension(638, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, 723, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registroseguridad_30px.png"))); // NOI18N
        jLabel7.setText("Ficha de Matrícula");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 280, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("N° de Matricula");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 130, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel23.setText("Fecha:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 40, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("N° de Cédula estudiante:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));

        cedrep.setMinimumSize(new java.awt.Dimension(4, 20));
        cedrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedrepActionPerformed(evt);
            }
        });
        cedrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedrepKeyTyped(evt);
            }
        });
        add(cedrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 210, 20));

        apeest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeestActionPerformed(evt);
            }
        });
        apeest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apeestKeyTyped(evt);
            }
        });
        add(apeest, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 210, -1));

        nomest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomestActionPerformed(evt);
            }
        });
        nomest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomestKeyTyped(evt);
            }
        });
        add(nomest, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 210, -1));

        añoest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoestActionPerformed(evt);
            }
        });
        añoest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                añoestKeyTyped(evt);
            }
        });
        add(añoest, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 210, -1));

        cedest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedestActionPerformed(evt);
            }
        });
        cedest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedestKeyTyped(evt);
            }
        });
        add(cedest, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nombres del estudiante:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel27.setText("Correo Electrónico:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 110, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel28.setText("Código de Luz:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 100, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Apellidos del estudiante:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 130, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel30.setText("Nombres del  Representante:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 150, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel31.setText("Direccion del domicilio:");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 130, 20));

        jLabel32.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel32.setText("Telefono Convencional:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 150, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel18.setText("N° de Cédula Representante legal:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, 20));

        jLabel33.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel33.setText("Telefono Celular:");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 160, 20));

        cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codActionPerformed(evt);
            }
        });
        add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, 210, -1));

        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });
        con.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                conKeyTyped(evt);
            }
        });
        add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 210, -1));

        dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirActionPerformed(evt);
            }
        });
        add(dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 210, -1));

        nomrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomrepActionPerformed(evt);
            }
        });
        nomrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomrepKeyTyped(evt);
            }
        });
        add(nomrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 210, -1));

        txt_fecha.setMinimumSize(new java.awt.Dimension(4, 20));
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 220, 20));

        cel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celActionPerformed(evt);
            }
        });
        cel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                celKeyTyped(evt);
            }
        });
        add(cel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 250, 210, -1));

        cor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corActionPerformed(evt);
            }
        });
        add(cor, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 210, -1));

        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 210, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Año de E.G.B:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 130, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel34.setText("Discapacidad:");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 110, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel35.setText("Porcentaje de discapacidad:");
        jLabel35.setToolTipText("");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 150, -1));
        jLabel35.getAccessibleContext().setAccessibleDescription("Código de Luz");

        jLabel36.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel36.setText("N° Carnet del Conadis:");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 120, 20));

        por.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                porKeyTyped(evt);
            }
        });
        add(por, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 210, -1));

        carn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                carnKeyTyped(evt);
            }
        });
        add(carn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 210, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel37.setText("Apellidos del Representante:");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 150, 20));

        aperep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aperepActionPerformed(evt);
            }
        });
        aperep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aperepKeyTyped(evt);
            }
        });
        add(aperep, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 210, -1));

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_save_30px_2.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setColorHover(new java.awt.Color(153, 153, 153));
        guardar.setColorNormal(new java.awt.Color(102, 102, 102));
        guardar.setColorPressed(new java.awt.Color(102, 102, 102));
        guardar.setColorTextPressed(new java.awt.Color(102, 102, 102));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_change_30px_2.png"))); // NOI18N
        actualizar.setText("Editar");
        actualizar.setColorHover(new java.awt.Color(153, 153, 153));
        actualizar.setColorNormal(new java.awt.Color(102, 102, 102));
        actualizar.setColorPressed(new java.awt.Color(102, 102, 102));
        actualizar.setColorTextPressed(new java.awt.Color(102, 102, 102));
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, -1, -1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla1.setAlignmentX(0.4F);
        tabla1.setAlignmentY(0.4F);
        tabla1.setRowHeight(20);
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 1010, 180));

        id.setMinimumSize(new java.awt.Dimension(4, 20));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 70, 20));

        jLabel38.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel38.setText("Año Lectivo:");
        jLabel38.setToolTipText("");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 150, -1));
        add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 210, -1));
        add(añolectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 210, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "*", "Año Lectivo", " ", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 60, 20));

        buscarr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(buscarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 180, -1));

        Eliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_bin_30px.png"))); // NOI18N
        Eliminar1.setText("Eliminar");
        Eliminar1.setColorHover(new java.awt.Color(153, 153, 153));
        Eliminar1.setColorNormal(new java.awt.Color(102, 102, 102));
        Eliminar1.setColorPressed(new java.awt.Color(102, 102, 102));
        Eliminar1.setColorTextPressed(new java.awt.Color(102, 102, 102));
        Eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar1ActionPerformed(evt);
            }
        });
        add(Eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        Buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_25px.png"))); // NOI18N
        Buscar1.setText("Buscar");
        Buscar1.setColorHover(new java.awt.Color(153, 153, 153));
        Buscar1.setColorNormal(new java.awt.Color(102, 102, 102));
        Buscar1.setColorPressed(new java.awt.Color(102, 102, 102));
        Buscar1.setColorTextPressed(new java.awt.Color(102, 102, 102));
        Buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar1ActionPerformed(evt);
            }
        });
        add(Buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void Eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar1ActionPerformed
        // TODO add your handling code here:
           try {
            matricula.destroy(parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString()));
      //    ctcliente.destroy(olsito.getValueAt(olsito.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            createmodelo();
            cargar_informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Eliminar1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        this.currentRow = tabla1.getSelectedRow();
    }//GEN-LAST:event_tabla1MouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        flag = false;
        modelo = (DefaultTableModel) tabla1.getModel();

        id.setText(modelo.getValueAt(this.currentRow, 0).toString());
        txt_fecha.setText(modelo.getValueAt(this.currentRow, 1).toString());
        cedest.setText(modelo.getValueAt(this.currentRow, 2).toString());
        apeest.setText(modelo.getValueAt(this.currentRow, 3).toString());
        nomest.setText(modelo.getValueAt(this.currentRow, 4).toString());
        añoest.setText(modelo.getValueAt(this.currentRow, 5).toString());
        carn.setText(modelo.getValueAt(this.currentRow, 6).toString());
        dis.setSelectedItem(modelo.getValueAt(this.currentRow, 7).toString());

        por.setText(modelo.getValueAt(this.currentRow, 8).toString());
        añolectivo.setSelectedItem(modelo.getValueAt(this.currentRow, 9).toString());
        cedrep.setText(modelo.getValueAt(this.currentRow, 10).toString());
        aperep.setText(modelo.getValueAt(this.currentRow, 11).toString());
        nomrep.setText(modelo.getValueAt(this.currentRow, 12).toString());
        dir.setText(modelo.getValueAt(this.currentRow, 13).toString());
        con.setText(modelo.getValueAt(this.currentRow, 14).toString());
        cel.setText(modelo.getValueAt(this.currentRow, 15).toString());
        cor.setText(modelo.getValueAt(this.currentRow, 16).toString());
        cod.setText(modelo.getValueAt(this.currentRow, 17).toString());
         
       // idlec.(modelo.getValueAt(this.currentRow, 18).toString());
       
        //       cedest.setEnabled(false);
        txt_fecha.setEnabled(false);
        id.setEnabled(false);
    }//GEN-LAST:event_actualizarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        boolean discapacidad = false;

        Entidades.Matriculacion obj = new Entidades.Matriculacion();
        String discapacidads;
        discapacidads = dis.getItemAt(dis.getSelectedIndex());

        String cedula = (cedest.getText());

        int porcentaje = (Integer.parseInt(por.getText().toString()));

        if (porcentaje < 30) {
            JOptionPane.showMessageDialog(null, "No existe discapacidad si el estudiante no llega a un 30%", "Alerta", ERROR_MESSAGE);
        } else {
            discapacidad = true;
        }

        String Datess = fecha.get(Calendar.YEAR) + "-" + (fecha.get(Calendar.MONTH) + 1) + "-" + fecha.get(Calendar.DAY_OF_MONTH) + " " + fecha.get(Calendar.HOUR) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND);
        if (valid.validadorDeCedula(cedula) == true) {
            if ((cedest.getText().length() > 0) && discapacidad) {

                obj.setNMatricula(parseInt(id.getText()));
                obj.setFecha(Datess);
                obj.setCedEst(cedest.getText());
                obj.setApeEst(apeest.getText());
                obj.setNomEst(nomest.getText());
                obj.setAñoBas(añoest.getText());
                obj.setCarnet(carn.getText());
                obj.setDiscapacidad(dis.getSelectedItem().toString());
                obj.setPorcentaje(parseInt(por.getText()));
                obj.setAñolectivo(añolectivo.getSelectedItem().toString());
                obj.setCedRep(cedrep.getText());
                obj.setApeRep(aperep.getText());
                obj.setNomRep(nomrep.getText());
                obj.setDirRep(dir.getText());
                obj.setTelCon(con.getText());
                obj.setTelCelular(cel.getText());
                obj.setCorreo(cor.getText());
                obj.setCodigodeluz(cod.getText());
          //      obj.setIdAñolectivo(idlec);

                if (flag) {
                    try {
                        matricula.create(obj);
                        JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                        createmodelo();
                        cargar_informacion();
                        clear();
                        clear();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error en DB", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        matricula.edit(obj);
                        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
                        createmodelo();
                        cargar_informacion();
                        clear();
                        flag = true;

                        //  id.setEnabled(false);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

            } else {
                //       JOptionPane.showMessageDialog(null, "Discapacidad", "Error en cedula", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Cedula no valida", "Error en cedula", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void aperepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aperepKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aperepKeyTyped

    private void aperepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aperepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aperepActionPerformed

    private void carnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carnKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carnKeyTyped

    private void porKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }

    }//GEN-LAST:event_porKeyTyped

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void corActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corActionPerformed

    private void celKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_celKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_celKeyTyped

    private void celActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void nomrepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomrepKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nomrepKeyTyped

    private void nomrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomrepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomrepActionPerformed

    private void dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirActionPerformed

    private void conKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_conKeyTyped

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conActionPerformed

    private void codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codActionPerformed

    private void cedestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedestKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if ((caracter < '0') || (caracter > '9')) {
            evt.consume();
        }
        if (cedest.getText().length() >= 10) {
            evt.consume();
        }

    }//GEN-LAST:event_cedestKeyTyped

    private void cedestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedestActionPerformed

    private void añoestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añoestKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_añoestKeyTyped

    private void añoestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añoestActionPerformed

    private void nomestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomestKeyTyped
        // TODO add your handling code here:  char c=evt.getKeyChar();
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nomestKeyTyped

    private void nomestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomestActionPerformed

    private void apeestKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apeestKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_apeestKeyTyped

    private void apeestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeestActionPerformed

    private void cedrepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedrepKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cedrepKeyTyped

    private void cedrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedrepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedrepActionPerformed

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        // TODO add your handling code here:
             cls_conexion obj = new cls_conexion();
        if(jComboBox1.getSelectedItem().toString().equals("*"))
        {           
            obj.CargarTabla("Select  * From matriculacion" , tabla1);
        }
        if(jComboBox1.getSelectedItem().toString().equals("Año Lectivo"))
        {
            obj.CargarTabla("Select  * From matriculacion Where (añolectivo='"+buscarr.getSelectedItem().toString()+"' ) ", tabla1);
        }
        
       
    }//GEN-LAST:event_Buscar1ActionPerformed
    Calendar fecha = new GregorianCalendar();
    String Dates = fecha.get(Calendar.YEAR) + "-" + (fecha.get(Calendar.MONTH) + 1) + "-" + fecha.get(Calendar.DAY_OF_MONTH) + " " + fecha.get(Calendar.HOUR) + ":" + fecha.get(Calendar.MINUTE) + ":" + fecha.get(Calendar.SECOND);


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro Buscar1;
    private rsbuttom.RSButtonMetro Eliminar1;
    private rsbuttom.RSButtonMetro actualizar;
    private javax.swing.JTextField apeest;
    private javax.swing.JTextField aperep;
    private javax.swing.JTextField añoest;
    private javax.swing.JComboBox<String> añolectivo;
    private javax.swing.JComboBox<String> buscarr;
    private javax.swing.JTextField carn;
    private javax.swing.JTextField cedest;
    private javax.swing.JTextField cedrep;
    private javax.swing.JTextField cel;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField con;
    private javax.swing.JTextField cor;
    private javax.swing.JTextField dir;
    private javax.swing.JComboBox<String> dis;
    private rsbuttom.RSButtonMetro guardar;
    private javax.swing.JTextField id;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDayChooserBeanInfo jDayChooserBeanInfo1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField nomest;
    private javax.swing.JTextField nomrep;
    private javax.swing.JTextField por;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}
