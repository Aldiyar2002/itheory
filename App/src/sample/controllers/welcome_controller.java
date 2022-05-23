package sample.controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class welcome_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button start_b;

    @FXML
    private Button exit_b;

    @FXML
    void initialize() {
        start_b.setOnAction(event -> {

//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("src/sample/fxml_files/enterText_window.fxml"));
//                Parent root1 = fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root1));
//                stage.show();
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//            start_b.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/fxml_files/enterText_window.fxml"));
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
        exit_b.setOnAction(event -> {


            exit_b.getScene().getWindow().hide();
        });
    }

}

