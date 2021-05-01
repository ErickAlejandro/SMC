/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.ResultSet;
import javax.swing.JTable;
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
public class cls_conexionTest {
    
    public cls_conexionTest() {
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
     * Test of conexion method, of class cls_conexion.
     */
    @Test
    public void testConexion() {
        System.out.println("conexion");
        cls_conexion instance = new cls_conexion();
        boolean expResult = false;
        boolean result = instance.conexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of Consulta method, of class cls_conexion.
     */
    @Test
    public void testConsulta() {
        System.out.println("Consulta");
        String sql = "";
        cls_conexion instance = new cls_conexion();
        ResultSet expResult = null;
        ResultSet result = instance.Consulta(sql);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of CargarTabla method, of class cls_conexion.
     */
    @Test
    public void testCargarTabla() {
        System.out.println("CargarTabla");
        String instruccionSQL = "";
        JTable jTable = null;
        cls_conexion instance = new cls_conexion();
        instance.CargarTabla(instruccionSQL, jTable);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
