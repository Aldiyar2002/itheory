package sample.controllers;

import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.FileOperations;
import sample.Node;

public class sfhe_controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getSFE_b;

    @FXML
    private TextArea sfe_text;
    private PrintStream ps ;



    public void initialize() {
        ps = new PrintStream(new Console(sfe_text)) ;
    }

    public void button(ActionEvent event) {
        System.setOut(ps);
      //System.setErr(ps);

        sfe_class.main(null);
    }

    public class Console extends OutputStream {
        private TextArea sfe_text;

        public Console(TextArea console) {
            this.sfe_text = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> sfe_text.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char)b));
        }
    }

}

