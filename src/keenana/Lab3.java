/*
 * Course: CSC 1120
 * Term: Spring 2023
 * Assignment: Lab3
 * Name: Andrew Keenan
 * Created: 1-31-24
 */
package keenana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * driver class for lab 3
 */
public class Lab3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mean Image Median");
        FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("lab3.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
