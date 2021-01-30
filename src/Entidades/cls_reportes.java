/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Who I am
 */
public class cls_reportes {

    private static final String URL = "jdbc:mysql://localhost/sistemamatriculacioncng?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static java.sql.Connection connection = null;

    public JasperViewer ReporteCliente(String name) {
        JasperViewer obj = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conectado");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
            }

            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src\\Reportes\\"+name);
            JasperPrint printer = JasperFillManager.fillReport(reporte, null, connection);

            obj = new JasperViewer(printer, false);
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            obj.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return obj;
    }

    public void ReporteAport(String names, String tipo) {

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conectado");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperReport reporte = null;
            Map parametros = new HashMap();
            parametros.put("tipo", tipo);
            reporte = (JasperReport) JRLoader.loadObjectFromFile("src\\Reportes\\"+names);
            JasperPrint printer = JasperFillManager.fillReport(reporte, parametros, connection);

            JasperViewer obj = new JasperViewer(printer, false);
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            obj.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

      

    }
    
    public void ReporteAport1(int id, String names) {

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("conectado");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);

            } catch (SQLException ex) {
                Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
            }
            JasperReport reporte = null;
            Map parametros = new HashMap();
            parametros.put("estado", id);
            reporte = (JasperReport) JRLoader.loadObjectFromFile("src\\Reportes\\"+names);
            JasperPrint printer = JasperFillManager.fillReport(reporte, parametros, connection);

            JasperViewer obj = new JasperViewer(printer, false);
            obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            obj.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(cls_reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
