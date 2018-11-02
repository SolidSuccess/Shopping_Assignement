/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.events.managment.dbservices;

import acme.events.management.model.Speaker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class PersistenceManager {

    private static List<Speaker> speakers = new ArrayList<>();

    private static Connection conn;

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //must live in a configuration file
        String connectionUrl = "jdbc:sqlserver://INSTRUCTOR\\SQLEXPRESS:1433;databaseName=events;integratedSecurity=true;";

        //whats the problem here??        
        if (conn == null) {
            conn = DriverManager.getConnection(connectionUrl);
        }
    }

    public static void saveToDb(Speaker speaker) throws SQLException, ClassNotFoundException {
        connect();
        PreparedStatement ps = conn.prepareStatement("insert into speaker(name,rate,contactNumber)values(?,?,?)");
        ps.setString(1, speaker.getName());
        ps.setDouble(2, speaker.getRate());
        ps.setString(3, speaker.getContactNumber());

        ps.execute();
    }

    //step 2
    public static Speaker findSpeakerWithLongestName() {
        return speakers
                .stream()
                .max(Comparator.comparing(Speaker::getName))
                .orElseThrow(NoSuchElementException::new);
    }

    //step 4
    public static Speaker findSpeakerWithShortestName() {
        return speakers
                .stream()
                .min(Comparator.comparing(i -> i.getName().length()))
                .orElseThrow(NoSuchElementException::new);
    }

    //step 3
    public static Speaker findSpeakerWithHighestRate() {
        return speakers
                .stream()
                .max(Comparator.comparingDouble(i -> i.getRate()))
                .orElseThrow(NoSuchElementException::new);

    }

    //Step 1 implement this 
    public static List<Speaker> getSpeakers() {
        try {
            connect();
            ResultSet rs = conn.prepareStatement("select id, name, rate, contactnumber from speaker").executeQuery();

            while (rs.next()) {
                speakers.add(new Speaker(rs.getString("name"), rs.getString("contactnumber"), rs.getDouble("rate")));
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PersistenceManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return speakers;
    }
}
