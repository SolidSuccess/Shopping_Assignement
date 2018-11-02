/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextArea selectedEvent;
    
    @FXML
    private ComboBox<String> eventTypes;

    private ObservableList<String> eventTypeList;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    private ObservableList<String> getEventTypes() {
        if (eventTypeList == null) {
            eventTypeList = FXCollections.observableArrayList();
            eventTypeList.add("Wedding");
            eventTypeList.add("Motor Show");
            eventTypeList.add("Flower Show");
        }
        return eventTypeList;
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventTypes.setItems(getEventTypes());

    }

}
