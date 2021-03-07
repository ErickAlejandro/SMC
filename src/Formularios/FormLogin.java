/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Scanner;
import org.apache.commons.codec.digest.DigestUtils;
//import net.sf.jasperreports.engine.util.DigestUtils;

/**
 *
 * @author Who I am
 */
public class FormLogin extends javax.swing.JFrame {

    int x, y;

    private String usuario, password;

    public FormLogin() {
        initComponents();
        txt_usuario.setFocusable(true);

    }

    public void datos(String us, String pass) {
        usuario = "user";
        password = "admin";

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_password = new LIB.FSPasswordFieldMD();
        txt_usuario = new LIB.FSTexFieldMD();
        guardar = new LIB.FSButtonMD();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoNegroLogin.jpg"))); // NOI18N

        txt_password.setForeground(new java.awt.Color(51, 51, 51));
        txt_password.setBordeColorFocus(new java.awt.Color(51, 51, 51));
        txt_password.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        txt_password.setFocusCycleRoot(true);
        txt_password.setMaterialDesing(true);
        txt_password.setNextFocusableComponent(guardar);
        txt_password.setPlaceholder("CONTRASEÑA");
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        txt_usuario.setForeground(new java.awt.Color(51, 51, 51));
        txt_usuario.setBordeColorFocus(new java.awt.Color(0, 0, 0));
        txt_usuario.setBordeColorNoFocus(new java.awt.Color(0, 0, 0));
        txt_usuario.setMaterialDesing(true);
        txt_usuario.setPlaceholder("NOMBRE DE USUARIO");
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });

        guardar.setText("INICIAR SESIÓN");
        guardar.setColorNormal(new java.awt.Color(102, 102, 102));
        guardar.setColorPressed(new java.awt.Color(51, 51, 51));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        guardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guardarKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("UNIDAD DE EDUCACIÓN ESPECIAL");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("\"CLAUDIO NEIRA GARZÓN\"");

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir_30px.png"))); // NOI18N
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });

        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(590, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel4)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txt_password.getAccessibleContext().setAccessibleName("Contraseña");
        txt_password.getAccessibleContext().setAccessibleDescription("Contraseña");
        txt_usuario.getAccessibleContext().setAccessibleName("usuario");
        txt_usuario.getAccessibleContext().setAccessibleDescription("Nombre de Usuario");
        guardar.getAccessibleContext().setAccessibleName("Iniciar Sesion");
        guardar.getAccessibleContext().setAccessibleDescription("Iniciar Sesion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMouseClicked

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:

        datos(usuario, password);
        if (usuario.equals(txt_usuario.getText()) && password.equals(txt_password.getText())) {
            Principal st = new Principal();
            st.setVisible(true);
            this.dispose();
        } else if (txt_usuario.getText().equals("") && txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
            txt_usuario.setFocusable(true);
        } else if (txt_usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario está vacio\nIngrese lo por favor.");
            txt_usuario.setFocusable(true);
        } else if (txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Contraseña está vacio\nIngrese lo por favor.");
            txt_password.setFocusable(true);
        } else if (txt_usuario.getText().compareTo(usuario) != 0 && txt_password.getText().compareTo(password) != 0) {
            JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
            txt_usuario.setFocusable(true);
        } else if (txt_usuario.getText().compareTo(usuario) != 0) {
            JOptionPane.showMessageDialog(this, "Usuario no válido\nIngrese nuevamente.");
            txt_usuario.setFocusable(true);
        } else if (txt_password.getText().compareTo(password) != 0) {
            JOptionPane.showMessageDialog(this, "Contraseña no válida\nIngrese nuevamente.");
            txt_password.setFocusable(true);
        }

        String encriptMD5 = DigestUtils.md5Hex(password);
        System.out.println("Contraseña encriptada : " + encriptMD5);
    }//GEN-LAST:event_guardarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        Point mueve = MouseInfo.getPointerInfo().getLocation();
        this.setLocation(mueve.x - x, mueve.y - y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        // TODO add your handling code here:
     txt_usuario.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            txt_password.requestFocus();
            
            
        }

    }//GEN-LAST:event_txt_usuarioKeyPressed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:
   txt_password.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                java.util.Collections.EMPTY_SET);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            guardar.requestFocus();
            
              datos(usuario, password);
        if (usuario.equals(txt_usuario.getText()) && password.equals(txt_password.getText())) {
            Principal st = new Principal();
            st.setVisible(true);
            this.dispose();
        } else if (txt_usuario.getText().equals("") && txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña estan vacios\nIngrese los por favor.");
            txt_usuario.setFocusable(true);
        } else if (txt_usuario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Usuario está vacio\nIngrese lo por favor.");
            txt_usuario.setFocusable(true);
        } else if (txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Contraseña está vacio\nIngrese lo por favor.");
            txt_password.setFocusable(true);
        } else if (txt_usuario.getText().compareTo(usuario) != 0 && txt_password.getText().compareTo(password) != 0) {
            JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
            txt_usuario.setFocusable(true);
        } else if (txt_usuario.getText().compareTo(usuario) != 0) {
            JOptionPane.showMessageDialog(this, "Usuario no válido\nIngrese nuevamente.");
            txt_usuario.setFocusable(true);
        } else if (txt_password.getText().compareTo(password) != 0) {
            JOptionPane.showMessageDialog(this, "Contraseña no válida\nIngrese nuevamente.");
            txt_password.setFocusable(true);
        }

        String encriptMD5 = DigestUtils.md5Hex(password);
        System.out.println("Contraseña encriptada : " + encriptMD5);
           
        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void guardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardarKeyPressed
        // TODO add your handling code here:
       
     
    }//GEN-LAST:event_guardarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private LIB.FSButtonMD guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private LIB.FSPasswordFieldMD txt_password;
    private LIB.FSTexFieldMD txt_usuario;
    // End of variables declaration//GEN-END:variables

}
