import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Nick on 9/10/2015.
 */
public class GameConfigController implements Initializable{

    @FXML
    private ChoiceBox difficultyChoiceBox;
    @FXML
    private ChoiceBox numPlayersBox;
    @FXML
    private ChoiceBox mapBox;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        difficultyChoiceBox.setItems(FXCollections.observableArrayList("Easy", "Medium", "Hard"));
        numPlayersBox.setItems(FXCollections.observableArrayList(1,2,3,4));
        mapBox.setItems(FXCollections.observableArrayList("Map1","Map2","Map3"));
    }
}