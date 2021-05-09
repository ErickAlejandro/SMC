package Controladores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estebanpalomeque
 */

import java.sql.ResultSet;

public class IntegrationTestHelper {
    
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\033[0;32m";
    public static final String RESET = "\033[0m";
 
    public void validateResulSetTest(Boolean valid, String title) {
        if(valid) {
            System.out.println("\n\n" + title  + GREEN + " Test Passed\n\n" + RESET);
        } else {
            System.out.println("\n\n" + title + RED + " Test Failed\n\n" + RESET);
        }
    }
}
