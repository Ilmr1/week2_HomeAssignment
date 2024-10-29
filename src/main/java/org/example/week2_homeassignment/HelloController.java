package org.example.week2_homeassignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    public Button button1;
    public Button button2;
    public Button button3;

    @FXML
    private Label welcomeText;

    @FXML
    private Label infoLabel;

    public void initialize() {
        //ResourceBundle bundle = ResourceBundle.getBundle("bundle2");
        //button1.setText(bundle.getString("button1.text"));
        //button2.setText(bundle.getString("button2.text"));
        //button3.setText(bundle.getString("button3.text"));
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void setEN(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("EN");
        loadView(l);
    }

    public void setIR(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("IR");
        loadView(l);
    }

    public void setJP(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("JP");
        loadView(l);
    }

    public void loadView(Locale locale) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundle", locale));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) button1.getScene().getWindow();
            s.setScene(new Scene(root));
            s.show();
            HelloController controller = fxmlLoader.getController();
            controller.updateInfoLabel(locale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateInfoLabel(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String currentTime = dateFormat.format(new Date());
        infoLabel.setText("Ilmari Elomaa - " + currentTime);
    }
}