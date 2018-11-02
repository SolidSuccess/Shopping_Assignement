/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.events.management.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author Administrator
 */
public class SpeakerUIController implements Initializable {

    @FXML
    TextField speakerName;
    @FXML
    TextField speakerRate;
    @FXML
    TextField speakerContactNumber;

    @FXML
    private void createSpeaker(ActionEvent event) {
        //get data from controls
    
        //save to db

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
