/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doe.john.supermarket.testharness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Supermarkettestharness {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //connect to db
        String connectionUrl = "";
        try {
            Class.forName("mySQL.jdbc.driver"); //what
            Connection conn = DriverManager.getConnection(connectionUrl); //what
            //display dara in producttable
            PreparedStatement ps = conn.prepareStatement("SELECT ProductId, ProductName FROM PRODUCTS");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String name = rs.getString("ProductName");
                System.out.println(name);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Supermarkettestharness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
