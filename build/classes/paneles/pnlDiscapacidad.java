/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controladores.AñolectivoJpaController;
import Controladores.DiscapacidadJpaController;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static paneles.pnlSeguridad.modelo;

/**
 *
 * @author RojeruSan
 */
public class pnlDiscapacidad extends javax.swing.JPanel {

    Controladores.DiscapacidadJpaController disca = new DiscapacidadJpaController();
    int currentRow;
    boolean flag = true;

    Entidades.Añolectivo lol = new Entidades.Añolectivo();

    public pnlDiscapacidad() {
        initComponents();
       id.setText("0");
       id.setEnabled(false);
         createmodelo();
        cargar_informacion();
    }

    private void createmodelo() {
        try {
            modelo = (new DefaultTableModel(null, new String[]{"Id", "Discapacidad",}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class};

                boolean[] canEdit = new boolean[]{false, false};

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

     //  id.setText("");
        dis.setText("");
    }
 private void cargar_informacion() {
        try {
            Object[] o = null;

            List<Entidades.Discapacidad> añolectivos = disca.findDiscapacidadEntities();
            for (int i = 0; i < añolectivos.size(); i++) {
                modelo.addRow(o);

                modelo.setValueAt(añolectivos.get(i).getId(), i, 0);
                modelo.setValueAt(añolectivos.get(i).getTipodediscapacidad(), i, 1);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        guardar = new rsbuttom.RSButtonMetro();
        actualizar = new rsbuttom.RSButtonMetro();
        Eliminar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        dis = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        dis1 = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(638, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 25)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Discapacidades");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 544, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 286, 544, -1));

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
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

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
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

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
        add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 550, 210));

        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });
        dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                disKeyTyped(evt);
            }
        });
        add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 150, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Id:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 130, -1));

        dis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dis1ActionPerformed(evt);
            }
        });
        dis1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dis1KeyTyped(evt);
            }
        });
        add(dis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 150, -1));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 150, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Ingrese Discapacidad:");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        Entidades.Discapacidad obj = new Entidades.Discapacidad();
        
        

    
       obj.setId(Integer.parseInt(id.getText()));
        obj.setTipodediscapacidad(dis.getText());
 

        if (flag) {
            try {
                disca.create(obj);
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                createmodelo();
                cargar_informacion();
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error en DB", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                disca.edit(obj);
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

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
        flag = false;
        
        
        modelo = (DefaultTableModel) tabla1.getModel();
        id.setText(modelo.getValueAt(this.currentRow, 0).toString());
        dis.setText(modelo.getValueAt(this.currentRow, 1).toString());
       
    
//
      id.setEnabled(false);
      
    }//GEN-LAST:event_actualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
   try {
            disca.destroy(parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString()));
            //    ctcliente.destroy(olsito.getValueAt(olsito.getSelectedRow(), 0).toString());
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            createmodelo();
            cargar_informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
   this.currentRow = tabla1.getSelectedRow();
    }//GEN-LAST:event_tabla1MouseClicked

    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disActionPerformed

    private void disKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_disKeyTyped

    private void dis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dis1ActionPerformed

    private void dis1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dis1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dis1KeyTyped

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro Eliminar;
    private rsbuttom.RSButtonMetro actualizar;
    private javax.swing.JTextField dis;
    private javax.swing.JTextField dis1;
    private rsbuttom.RSButtonMetro guardar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
