/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.events.management.controllers;

import acme.events.management.model.Speaker;
import acme.events.managment.dbservices.PersistenceManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class SpeakerController {

    public static void save(Speaker speaker) {
        try {
            PersistenceManager.saveToDb(speaker);
        } catch (SQLException e) {

            //report and log the exception
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpeakerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getAllSpeakers() {
        //we will need to change this to get a correctly formatted string(???)
        return PersistenceManager.getSpeakers().toString();
    }

}
