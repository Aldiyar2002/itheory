package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class openAll_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button entropy_b;

    @FXML
    private Button hd_b;

    @FXML
    private Button he_b;

    @FXML
    private Button sfhd_b;

    @FXML
    Button sfhe_b;
     public void handleBtn() throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("/sample/fxml_files/sfhe_window.fxml"));

         Stage window = (Stage) sfhe_b.getScene().getWindow();
         window.setScene(new Scene(root, 1080, 720));
     }


//    @FXML
//    private void handleButtonAction(ActionEvent event) throws IOException{
//
//    }

    @FXML
    void initialize() {
//        sfhe_b.setOnAction(event -> {
//
//
//            sfhe_b.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/sample/fxml_files/sfhe_window.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//
//        });
//        sfhe_b.setOnAction(e -> primaryStage.setScene("/sample/fxml_files/sfhe_window.fxml"));
    }

}

