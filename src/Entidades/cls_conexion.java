/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Who I am
 */
public class cls_conexion 
{
    Connection conec;
    Statement St;

    public cls_conexion() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            conec = DriverManager.getConnection("jdbc:mysql://localhost/sistemamatriculacioncng", "root","");
            if (conec != null) {
                System.out.println();
                System.out.println("Successfully connected");
                System.out.println();
                System.out.println("\nDriver Information");
            }
        } catch (SQLException excepcionSql) {
            JOptionPane.showMessageDialog(null, excepcionSql.getMessage(),
                    "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(),
                    "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String Ejecutar(String sql) {
        String error = "";
        try {
            St = conec.createStatement();
            St.executeUpdate(sql);
        } catch (Exception ex) {
            error = ex.getMessage();
        }
        return (error);
    }

    public ResultSet Consulta(String sql) {
        ResultSet res = null;

        try {
            Statement s = conec.createStatement();
            res = s.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "No se encontró los Datos", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public void CargarTabla(String instruccionSQL, JTable jTable) 
    {
        try {

            DefaultTableModel modelo = new DefaultTableModel();
            jTable.setModel(modelo);
            ResultSet rs = Consulta(instruccionSQL);

            ResultSetMetaData rsMd = rs.getMetaData();

            for (int i = 1; i <= rsMd.getColumnCount(); i++) 
            {
                modelo.addColumn(rsMd.getColumnLabel(i));
            }

            while (rs.next()) 
            {
                Object[] fila = new Object[rsMd.getColumnCount()];
                for (int i = 0; i < rsMd.getColumnCount(); i++) 
                {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            rs.close();
            } 
        catch (Exception ex) 
        {

        }
    }
    
    public void cargarCombo(String instruccionSQL,JComboBox jComboBox1)
    {
      try{
          DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
          ResultSet rs = Consulta(instruccionSQL);
          while(rs.next()){
              
              modeloCombo.addElement(rs.getObject("Nombre"));
          }
          rs.close();
          jComboBox1.setModel(modeloCombo);
         
      }  
      catch(SQLException ex)
      {
          Logger.getLogger(cls_conexion.class.getName()).log(Level.SEVERE,null,ex);
      } 
        
        
    }
    
    
    public boolean verificarCedula(String cedula) {  
     int total = 0;  
     int tamanoLongitudCedula = 10;  
     int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};  
     int numeroProviancias = 24;  
     int tercerdigito = 6;  
     if (cedula.matches("[0-9]*") && cedula.length() == tamanoLongitudCedula) {  
       int provincia = Integer.parseInt(cedula.charAt(0) + "" + cedula.charAt(1));  
       int digitoTres = Integer.parseInt(cedula.charAt(2) + "");  
       if ((provincia > 0 && provincia <= numeroProviancias) && digitoTres < tercerdigito) {  
         int digitoVerificadorRecibido = Integer.parseInt(cedula.charAt(9) + "");  
         for (int i = 0; i < coeficientes.length; i++) {  
           int valor = Integer.parseInt(coeficientes[i] + "") * Integer.parseInt(cedula.charAt(i) + "");  
           total = valor >= 10 ? total + (valor - 9) : total + valor;  
         }  
         int digitoVerificadorObtenido = total >= 10 ? (total % 10) != 0 ? 10 - (total % 10) : (total % 10) : total;  
         if (digitoVerificadorObtenido == digitoVerificadorRecibido) {  
           return true;  
         }  
       }  
       return false;  
     }  
     return false;  
   } 
    
    
}
