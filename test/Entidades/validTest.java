/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
public class validTest {
    
    public validTest() {
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
     * Test of validadorDeCedula method, of class valid.
     */
    @Test
    public void testValidadorDeCedula() {
        System.out.println("validadorDeCedula");
        String cedula = "0105885537";
        boolean expResult = true;
        boolean result = valid.validadorDeCedula(cedula);
        assertEquals(expResult, result);
        
        
    }
    
}
