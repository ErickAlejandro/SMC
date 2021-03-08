/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import Controladores.AñolectivoJpaController;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static paneles.pnlSeguridad.modelo;

/**
 *
 * @author RojeruSan
 */
public class pnlAño extends javax.swing.JPanel {

    Controladores.AñolectivoJpaController añoss = new AñolectivoJpaController();
    int currentRow;
    boolean flag = true;

    Entidades.Añolectivo lol = new Entidades.Añolectivo();

    public pnlAño() {
        initComponents();
        id.setText("0");
        id.setEnabled(false);
         createmodelo();
        cargar_informacion();
        
        año.setNextFocusableComponent(estado);
        estado.setNextFocusableComponent(guardar);
        guardar.setNextFocusableComponent(actualizar);
        actualizar.setNextFocusableComponent(Eliminar);
    }

    private void createmodelo() {
        try {
            modelo = (new DefaultTableModel(null, new String[]{"Id", "Año Lectivo","Estado"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class};

                boolean[] canEdit = new boolean[]{false, false,false};

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

      // id.setText("");
        año.setText("");
        estado.setText("");
        
    }
 private void cargar_informacion() {
        try {
            Object[] o = null;

            List<Entidades.Añolectivo> añolectivos = añoss.findAñolectivoEntities();
            for (int i = 0; i < añolectivos.size(); i++) {
                modelo.addRow(o);

                modelo.setValueAt(añolectivos.get(i).getId(), i, 0);
                modelo.setValueAt(añolectivos.get(i).getAño(), i, 1);
                modelo.setValueAt(añolectivos.get(i).getEstado(), i, 2);

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
        año = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        guardar = new rsbuttom.RSButtonMetro();
        actualizar = new rsbuttom.RSButtonMetro();
        Eliminar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        estado = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(638, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 25)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Año Lectivo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 544, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 286, 544, -1));

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
        add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 150, -1));
        año.getAccessibleContext().setAccessibleName("año lectivo");
        año.getAccessibleContext().setAccessibleDescription("año lectivo");

        jLabel29.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel29.setText("Ingrese Año lectivo:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 130, -1));

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
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));
        guardar.getAccessibleContext().setAccessibleDescription("boton guardar");

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
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));
        actualizar.getAccessibleContext().setAccessibleDescription("boton editar");

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
        add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, -1));
        Eliminar.getAccessibleContext().setAccessibleDescription("boton eliminar");

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 550, 210));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 150, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Id:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 130, -1));

        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                estadoKeyTyped(evt);
            }
        });
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 150, -1));
        estado.getAccessibleContext().setAccessibleName("estado");
        estado.getAccessibleContext().setAccessibleDescription("estado");

        jLabel31.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Estado:");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void añoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_añoActionPerformed

    private void añoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_añoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_añoKeyTyped

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        Entidades.Añolectivo obj = new Entidades.Añolectivo();
    
       obj.setId(Integer.parseInt(id.getText()));
       obj.setAño(año.getText());
       obj.setEstado(estado.getText());
 

        if (flag) {
            try {
                añoss.create(obj);
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                createmodelo();
                cargar_informacion();
                clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error en DB", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                añoss.edit(obj);
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
        modelo = (DefaultTableModel) tabla1.getModel();
        id.setText(modelo.getValueAt(this.currentRow, 0).toString());
        año.setText(modelo.getValueAt(this.currentRow, 1).toString());
        estado.setText(modelo.getValueAt(this.currentRow, 2).toString());
       
    
//
        id.setEnabled(false);
        flag=false;
    }//GEN-LAST:event_actualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
   try {
            añoss.destroy(parseInt(tabla1.getValueAt(tabla1.getSelectedRow(), 0).toString()));
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

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_idKeyTyped

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro Eliminar;
    private rsbuttom.RSButtonMetro actualizar;
    private javax.swing.JTextField año;
    private javax.swing.JTextField estado;
    private rsbuttom.RSButtonMetro guardar;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla1;
    // End of variables declaration//GEN-END:variables
}
