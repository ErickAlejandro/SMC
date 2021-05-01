/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controladores.SeguridadJpaController;
import Entidades.Seguridad;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RojeruSan
 */
public class pnlSeguridad extends javax.swing.JPanel {

    Controladores.SeguridadJpaController seguridad = new SeguridadJpaController();
    int currentRow;
    boolean flag = true;
 
    String trasladoo= null;
    String transportee =null;
    
    public pnlSeguridad() {
        initComponents();
        panelacompañado.setVisible(false);
//    maximon();
        createmodelo();
        cargar_informacion();
         id.setText("0");
           id.setEnabled(false);
    }
    
    
  public  String getTraslado()
{
    if(SOLOS.isSelected())
    {
        return "SOLO";
    }
    else if(ACOMPAÑADO.isSelected())
    {
        return "ACOMPAÑADO";
    }
    else
    {
        return null;
    }
} 
  
   public  String getTransporte()
{
    if(ESCOLAR.isSelected())
    {
        return "ESCOLAR";
    }
    else if(PRIVADO.isSelected())
    {
        return "PRIVADO";
    }
     else if(NOUSA.isSelected())
    {
        return "NO USA";
    }
    else
    {
        return null;
    }
} 
  //  private void maximon(){
        
      //  cls_conexion cx = new cls_conexion();
        
      //  ResultSet rs = cx.Consulta("SELECT max(id_seguridad) FROM seguridad");
      //  try {
       //     int id = rs.getInt("id_seguridad");
        //    System.out.println(id);
      //  } catch (SQLException ex) {
      //      Logger.getLogger(pnlSeguridad.class.getName()).log(Level.SEVERE, null, ex);
      //  }
 //   }
            
    public static DefaultTableModel modelo;
    
    private void createmodelo(){
    try {
        modelo = (new DefaultTableModel(null, new String[]{"Id","Cédula","Apellidos Estudiante","Nombres Estudiante ","Año de basica",
            "Apellidos Representante","Nombres Representante","Direccion","Telefono","Forma Traslado",
            "Cedula Responsable","Apellidos Responsable","Nombres Responsables","Telefono Responsable","Modalidad Transporte"}){
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
            java.lang.String.class};
        
        
        boolean[] canEdit = new boolean[] {false, false, false,false, false, false,false, false, false,false, false, false,false, false};
        
        @Override
        public Class getColumnClass (int columnindex){
            return types[columnindex];
        }
        public boolean isCellEdittable(int rowindex, int colindex){
            return canEdit[colindex];
        }
        
    }); tabla1.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString()+"Error");
    }
}
    private void clear()
    {
        //id.setText("");
        ced.setText("");
        ape.setText("");
        nom.setText("");
        año.setText("");
        ape_rep.setText("");
        nom_rep.setText("");
        dir.setText("");
        tel.setText("");
     //   SOLO.setText("");
      //  ACOMPAÑADO.setText("");
        ced_tras.setText("");
        ape_tras.setText("");
        nom_tras.setText("");
        tel_tras.setText("");
    //    ESCOLAR.setText("");
    //    PRIVADO.setText("");
     //   NOUSA.setText("");
       
}
private void cargar_informacion(){
    try {
        Object [] o = null;

    List<Entidades.Seguridad> listaActivoses = seguridad.findSeguridadEntities();
        for (int i = 0; i< listaActivoses.size(); i++){
            modelo.addRow(o);
            modelo.setValueAt(listaActivoses.get(i).getIdSeguridad(), i, 0);            
            modelo.setValueAt(listaActivoses.get(i).getCedEst(), i, 1);
            modelo.setValueAt(listaActivoses.get(i).getApeEst(), i, 2);
            modelo.setValueAt(listaActivoses.get(i).getNomEst(), i, 3);            
            modelo.setValueAt(listaActivoses.get(i).getAñoBas(), i, 4);
            modelo.setValueAt(listaActivoses.get(i).getApeRep(), i, 5);
            modelo.setValueAt(listaActivoses.get(i).getNomRep(), i, 6);            
            modelo.setValueAt(listaActivoses.get(i).getDirEst(), i, 7);
            modelo.setValueAt(listaActivoses.get(i).getTelEst(), i, 8);
            modelo.setValueAt(listaActivoses.get(i).getFormaTraslado(), i, 9);            
            modelo.setValueAt(listaActivoses.get(i).getCedResponsable(), i, 10);
            modelo.setValueAt(listaActivoses.get(i).getApellidosResponsable(), i, 11);
            modelo.setValueAt(listaActivoses.get(i).getNombresResponsable(), i, 12);
            modelo.setValueAt(listaActivoses.get(i).getTelefonoResponsable(), i, 13);
            modelo.setValueAt(listaActivoses.get(i).getModalidadTransporte(), i, 14);
           
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trasladosgroup = new javax.swing.ButtonGroup();
        transporte = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        ape_rep = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        SOLOS = new javax.swing.JRadioButton();
        ACOMPAÑADO = new javax.swing.JRadioButton();
        panelacompañado = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tel_tras = new javax.swing.JTextField();
        ced_tras = new javax.swing.JTextField();
        ape_tras = new javax.swing.JTextField();
        nom_tras = new javax.swing.JTextField();
        NOUSA = new javax.swing.JRadioButton();
        ESCOLAR = new javax.swing.JRadioButton();
        PRIVADO = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        nom_rep = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        ape = new javax.swing.JTextField();
        Cédula = new javax.swing.JLabel();
        ced = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        año = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        Eliminar = new rsbuttom.RSButtonMetro();
        guardar = new rsbuttom.RSButtonMetro();
        actualizar = new rsbuttom.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(728, 561));
        setPreferredSize(new java.awt.Dimension(638, 364));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 311, 1161, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registroseguridad_30px.png"))); // NOI18N
        jLabel7.setText("Registro Seguridad Fisica de los Estudiantes");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 500, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel1.setText("La presente tiene como objetivo la ejecucion al Acuerdo N°.MINEDUC-MINEDUC-2018-00030-A emitido por el Ministro de Educacion Fander Falconi sobre el resguardo de");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 1000, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel2.setText("la seguridad física de los estudiantes durante la entrada y salida de la jornada escolar; para ello se pide llenar esta información.");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 840, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 680, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel4.setText("DATOS INFORMATIVOS DEL ESTUDIANTE:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel9.setText("Nombres del representante:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 163, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel10.setText("Dirección domiciliaria:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 163, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel11.setText("Teléfono:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 163, -1));

        id.setMinimumSize(new java.awt.Dimension(4, 20));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 180, 20));

        ape_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ape_repActionPerformed(evt);
            }
        });
        ape_rep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ape_repKeyTyped(evt);
            }
        });
        add(ape_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 170, 180, -1));

        tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telActionPerformed(evt);
            }
        });
        tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telKeyTyped(evt);
            }
        });
        add(tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 180, -1));

        dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirActionPerformed(evt);
            }
        });
        add(dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 180, -1));

        SOLOS.setBackground(new java.awt.Color(255, 255, 255));
        trasladosgroup.add(SOLOS);
        SOLOS.setText("SOLO");
        SOLOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SOLOSMouseClicked(evt);
            }
        });
        SOLOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SOLOSActionPerformed(evt);
            }
        });
        add(SOLOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 60, 20));

        ACOMPAÑADO.setBackground(new java.awt.Color(255, 255, 255));
        trasladosgroup.add(ACOMPAÑADO);
        ACOMPAÑADO.setText("ACOMPAÑADO");
        ACOMPAÑADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACOMPAÑADOActionPerformed(evt);
            }
        });
        add(ACOMPAÑADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 110, 20));

        panelacompañado.setBackground(new java.awt.Color(255, 255, 255));
        panelacompañado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel5.setText("Teléfono:");
        panelacompañado.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 163, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel17.setText("Cédula:");
        panelacompañado.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 163, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel18.setText("Apellidos:");
        panelacompañado.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 163, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel19.setText("Nombres:");
        panelacompañado.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 163, -1));

        tel_tras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tel_trasActionPerformed(evt);
            }
        });
        tel_tras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tel_trasKeyTyped(evt);
            }
        });
        panelacompañado.add(tel_tras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 290, -1));

        ced_tras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ced_trasActionPerformed(evt);
            }
        });
        ced_tras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ced_trasKeyTyped(evt);
            }
        });
        panelacompañado.add(ced_tras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 290, -1));

        ape_tras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ape_trasKeyTyped(evt);
            }
        });
        panelacompañado.add(ape_tras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 290, -1));

        nom_tras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nom_trasKeyTyped(evt);
            }
        });
        panelacompañado.add(nom_tras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 290, -1));

        NOUSA.setBackground(new java.awt.Color(255, 255, 255));
        transporte.add(NOUSA);
        NOUSA.setText("NO USA TRANSPORTE");
        NOUSA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOUSAActionPerformed(evt);
            }
        });
        panelacompañado.add(NOUSA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 20));

        ESCOLAR.setBackground(new java.awt.Color(255, 255, 255));
        transporte.add(ESCOLAR);
        ESCOLAR.setText("TRANSPORTE ESCOLAR");
        ESCOLAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ESCOLARActionPerformed(evt);
            }
        });
        panelacompañado.add(ESCOLAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, 20));

        PRIVADO.setBackground(new java.awt.Color(255, 255, 255));
        transporte.add(PRIVADO);
        PRIVADO.setText("TRANSPORTE PRIVADO");
        PRIVADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRIVADOActionPerformed(evt);
            }
        });
        panelacompañado.add(PRIVADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, 20));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel24.setText("MODALIDAD DE TRANSPORTE:");
        panelacompañado.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 20));

        add(panelacompañado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 1010, 150));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel14.setText("En el caso de que el estudiante se traslade solo, firma como responsable el representante. Caso contrario consta los datos del responsable del transporte, sea éste privado o escolar.");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 990, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel15.setText("Apellidos del representante:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel16.setText("Id Seguridad: ");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel23.setText("Nombres del estudiante:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 163, -1));

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });
        add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 180, -1));

        nom_rep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_repActionPerformed(evt);
            }
        });
        nom_rep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nom_repKeyTyped(evt);
            }
        });
        add(nom_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 200, 180, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        jLabel8.setText("FORMA DE TRASLADO:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 180, 20));

        jLabel28.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel28.setText("Apellidos del estudiante:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 163, -1));

        ape.setMinimumSize(new java.awt.Dimension(4, 20));
        ape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apeActionPerformed(evt);
            }
        });
        ape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apeKeyTyped(evt);
            }
        });
        add(ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 180, 20));

        Cédula.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        Cédula.setText("Cédula del estudiante:");
        add(Cédula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 163, -1));

        ced.setMinimumSize(new java.awt.Dimension(4, 20));
        ced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedActionPerformed(evt);
            }
        });
        ced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cedKeyTyped(evt);
            }
        });
        add(ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 180, 20));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel30.setText("Año de básica:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añoActionPerformed(evt);
            }
        });
        año.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                añoKeyTyped(evt);
            }
        });
        add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 180, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 1010, 120));

        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_delete_bin_30px.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.setColorHover(new java.awt.Color(153, 153, 153));
        Eliminar.setColorNormal(new java.awt.Color(102, 102, 102));
        Eliminar.setColorPressed(new java.awt.Color(102, 102, 102));
        Eliminar.setColorTextPressed(new java.awt.Color(102, 102, 102));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, -1, -1));

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
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, -1, -1));

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
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ape_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ape_repActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ape_repActionPerformed

    private void telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telActionPerformed

    private void dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirActionPerformed

    private void SOLOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SOLOSActionPerformed
        // TODO add your handling code here:
        panelacompañado.setVisible(false);
    }//GEN-LAST:event_SOLOSActionPerformed

    private void ACOMPAÑADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACOMPAÑADOActionPerformed
        //TODO add your handling code here:
         panelacompañado.setVisible(true);
    }//GEN-LAST:event_ACOMPAÑADOActionPerformed

    private void ced_trasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ced_trasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ced_trasActionPerformed

    private void tel_trasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tel_trasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tel_trasActionPerformed

    private void ESCOLARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ESCOLARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ESCOLARActionPerformed

    private void PRIVADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRIVADOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRIVADOActionPerformed

    private void NOUSAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOUSAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NOUSAActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void nom_repActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_repActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_repActionPerformed

    private void apeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apeActionPerformed

    private void cedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedActionPerformed

    private void añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añoActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        // TODO add your handling code here:
        this.currentRow = tabla1.getSelectedRow();
        
        
    }//GEN-LAST:event_tabla1MouseClicked

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        
       
        
        Entidades.Seguridad obj = new Entidades.Seguridad();

            obj.setIdSeguridad(parseInt(id.getText())); 
            obj.setCedEst(ced.getText());
            obj.setApeEst(ape.getText()); 
            obj.setNomEst(nom.getText());
            obj.setAñoBas(parseInt(año.getText())); 
            obj.setApeRep(ape_rep.getText());
            obj.setNomRep(nom_rep.getText()); 
            obj.setDirEst(dir.getText());
            obj.setTelEst(parseInt(tel.getText())); 
            
            obj.setFormaTraslado(getTraslado());
        
            obj.setCedResponsable(ced_tras.getText()); 
            obj.setApellidosResponsable(ape_tras.getText());
            obj.setNombresResponsable(nom_tras.getText());
            obj.setTelefonoResponsable(tel_tras.getText());
            
            obj.setModalidadTransporte(getTransporte());
            
        if (flag) {
                    try {
                        seguridad.create(obj);
                        JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                        createmodelo();
                        cargar_informacion();
                        clear();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error en DB", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    try {
                        seguridad.edit(obj);
                        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente");
                        createmodelo();
                        cargar_informacion();
                        clear();
                        flag = true;
                       
                        id.setEnabled(true);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
    }//GEN-LAST:event_guardarActionPerformed
   

    private void SOLOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SOLOSMouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_SOLOSMouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        flag=false;  
        modelo = (DefaultTableModel) tabla1.getModel();
        
        id.setText(modelo.getValueAt(this.currentRow, 0).toString());
        ced.setText(modelo.getValueAt(this.currentRow, 1).toString());
        ape.setText(modelo.getValueAt(this.currentRow, 2).toString());
        
        nom.setText(modelo.getValueAt(this.currentRow, 3).toString());
        año.setText(modelo.getValueAt(this.currentRow, 4).toString());
        ape_rep.setText(modelo.getValueAt(this.currentRow, 5).toString());
        nom_rep.setText(modelo.getValueAt(this.currentRow, 6).toString());
        dir.setText(modelo.getValueAt(this.currentRow, 7).toString());
        tel.setText(modelo.getValueAt(this.currentRow, 8).toString());
      
        
        this.trasladoo=modelo.getValueAt(this.currentRow, 9).toString();
       
       if(this.trasladoo.equals("SOLO")){
           SOLOS.setSelected(true);
       }
        else if (this.trasladoo.equals("ACOMPAÑADO")){
             ACOMPAÑADO.setSelected(true);
       }    
        
        ced_tras.setText(modelo.getValueAt(this.currentRow, 10).toString());
       ape_tras.setText(modelo.getValueAt(this.currentRow, 11).toString());
       nom_tras.setText(modelo.getValueAt(this.currentRow, 12).toString());
         tel_tras.setText(modelo.getValueAt(this.currentRow, 13).toString());
       
       this.transportee=modelo.getValueAt(this.currentRow, 14).toString();
        if(this.transportee.equals("ESCOLAR")){
          ESCOLAR.setSelected(true);
   }
     else if (this.transportee.equals("PRIVADO")){
             ACOMPAÑADO.setSelected(true);
        }    
    else if (this.transportee.equals("NO USA")){
             NOUSA.setSelected(true);
       }
        
        id.setEnabled(false);
       
      
    }//GEN-LAST:event_actualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
            try {
            seguridad.destroy(parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString()));
      //    ctcliente.destroy(olsito.getValueAt(olsito.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            createmodelo();
            cargar_informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void cedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cedKeyTyped
        // TODO add your handling code here:
              char c=evt.getKeyChar();
        if(Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cedKeyTyped

    private void apeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apeKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_apeKeyTyped

    private void nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nomKeyTyped

    private void añoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añoKeyTyped
        // TODO add your handling code here:
              char c=evt.getKeyChar();
        if(Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_añoKeyTyped

    private void ape_repKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ape_repKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ape_repKeyTyped

    private void nom_repKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_repKeyTyped
        // TODO add your handling code here:
              char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nom_repKeyTyped

    private void telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar();
        if(Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_telKeyTyped

    private void ced_trasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ced_trasKeyTyped
        // TODO add your handling code here:
             char c=evt.getKeyChar();
        if(Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ced_trasKeyTyped

    private void ape_trasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ape_trasKeyTyped
        // TODO add your handling code here:
           char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ape_trasKeyTyped

    private void nom_trasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_trasKeyTyped
        // TODO add your handling code here:
           char c=evt.getKeyChar();
        if(Character.isDigit(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nom_trasKeyTyped

    private void tel_trasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tel_trasKeyTyped
        // TODO add your handling code here:
          char c=evt.getKeyChar();
        if(Character.isLetter(c))
        {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros", "Alerta",ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tel_trasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ACOMPAÑADO;
    private javax.swing.JLabel Cédula;
    public static javax.swing.JRadioButton ESCOLAR;
    private rsbuttom.RSButtonMetro Eliminar;
    public static javax.swing.JRadioButton NOUSA;
    public static javax.swing.JRadioButton PRIVADO;
    private javax.swing.JRadioButton SOLOS;
    private rsbuttom.RSButtonMetro actualizar;
    private javax.swing.JTextField ape;
    private javax.swing.JTextField ape_rep;
    private javax.swing.JTextField ape_tras;
    private javax.swing.JTextField año;
    private javax.swing.JTextField ced;
    private javax.swing.JTextField ced_tras;
    private javax.swing.JTextField dir;
    private rsbuttom.RSButtonMetro guardar;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nom_rep;
    private javax.swing.JTextField nom_tras;
    private javax.swing.JPanel panelacompañado;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField tel_tras;
    private javax.swing.ButtonGroup transporte;
    public static javax.swing.ButtonGroup trasladosgroup;
    // End of variables declaration//GEN-END:variables
}
