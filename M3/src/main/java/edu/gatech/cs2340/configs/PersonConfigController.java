package edu.gatech.cs2340.configs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
// import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Persong Configuration Screen Controller - works with SceneBuilder
 * @author Bilal, Myron, Shyam
 * @version 1.0
 */
public class PersonConfigController implements Initializable {

    @FXML
    private ComboBox<String> race;
    @FXML
    private ComboBox<String> color;
    @FXML
    private Button start;
    @FXML
    private TextField name;
    @FXML
    private Label welcome;

    /**
     * Initializes the fxml file
     * @param fxmlFileLocation Location of fxml file
     * @param resources Resources needed
     */
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        race.setItems(
                FXCollections.observableArrayList(
                        "Packer",
                        "Spheroid",
                        "Humanoid",
                        "Leggite",
                        "Flapper",
                        "Bonzoid",
                        "Mechtron",
                        "Gollumer"));
        race.getSelectionModel().selectFirst();
        color.setItems(
                FXCollections.observableArrayList(
                        "Red",
                        "Orange",
                        "Yellow",
                        "Green",
                        "Blue",
                        "Purple"));
        color.getSelectionModel().selectFirst();
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (name.getText() == null || name.getText().trim().isEmpty()) {
                    welcome.setText("Name must include at least one character"
                            + "\nPlease enter a valid name");
                } else {
                    welcome.setText("Welcome " + color.getValue() + " "
                            + race.getValue() + " named "
                            + name.getCharacters() + "!");
                }
            }
        });
    }
}
