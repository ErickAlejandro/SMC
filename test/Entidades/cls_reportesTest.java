/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import net.sf.jasperreports.view.JasperViewer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Who I am
 */
public class cls_reportesTest {
    
    public cls_reportesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ReporteCliente method, of class cls_reportes.
     */
    @Test
    public void testReporteCliente() {
        System.out.println("ReporteCliente");
        String name = "";
        cls_reportes instance = new cls_reportes();
        JasperViewer expResult = null;
        JasperViewer result = instance.ReporteCliente(name);
        assertEquals(expResult, result);
        
      
    }

    /**
     * Test of ReporteAport method, of class cls_reportes.
     */
    @Test
    public void testReporteAport() {
        System.out.println("ReporteAport");
        String names = "";
        String tipo = "";
        cls_reportes instance = new cls_reportes();
        instance.ReporteAport(names, tipo);
     
      
    }

    /**
     * Test of ReporteAport1 method, of class cls_reportes.
     */
    @Test
    public void testReporteAport1() {
        System.out.println("ReporteAport1");
        int id = 0;
        String names = "";
        cls_reportes instance = new cls_reportes();
        instance.ReporteAport1(id, names);
       
        
    }
    
}
