/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import banco.ConexaoJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class Testes {

    public static void main(String[] args) {
        
     String URL = "jdbc:mysql://localhost:3306/blog";
     String USER = "root";
     String SENHA = "root";
  
        try {
          Connection c = DriverManager.getConnection(URL, USER, SENHA);
            System.out.println("COnectou!");

    }
    catch (SQLException ex ) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
    }

}

}
