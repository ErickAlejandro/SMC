/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

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
public class FormLoginTest {
    
    public FormLoginTest() {
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
     * Test of datos method, of class FormLogin.
     */
    @Test
    public void testDatos() {
        System.out.println("datos");
        String us = "";
        String pass = "";
        FormLogin instance = new FormLogin();
        instance.datos(us, pass);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class FormLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FormLogin.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
