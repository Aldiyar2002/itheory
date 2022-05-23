package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.FileOperations;

public class enterText_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button saveText_b;

    @FXML
    private TextArea userText;

    @FXML
    void initialize() {
        FileOperations oFile = new FileOperations () ;

                saveText_b.setOnAction(event -> {
                    String uText = userText.getText();
                    oFile.writeFile(uText, "src/sample/txt_files/userText.txt");

                    saveText_b.getScene().getWindow().hide();

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/fxml_files/openAll_window.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();

        });

    }

}
