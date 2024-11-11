/*
 * Course: CSC 1120
 * Term: Spring 2023
 * Assignment: Lab3
 * Name: Andrew Keenan
 * Created: 1-31-24
 */
package keenana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * controller class for the FXML file
 */
public class Controller {
    @FXML
    private Label label2;
    @FXML
    private Label inputs;
    @FXML
    private ImageView iv;
    private final ArrayList<Image> images = new ArrayList<>();
    private Image output;


    @FXML
    private void inputFile(ActionEvent actionEvent) {
        FileChooser choose = new FileChooser();
        File input = choose.showOpenDialog(null);
        String s = inputs.getText();
        Path path = input.toPath();
        try{
            images.add(MeanImageMedian.readImage(path));
            inputs.setText(s+input+"\n");
            label2.setText(input+" Successfully Added");
        } catch (IOException e){
            label2.setText("Error reading in Image File (IO Error)");
        } catch (NoSuchElementException e){
            label2.setText("Error reading in Image File (Bad PPM image)");
        }

    }
    @FXML
    private void calcMean(ActionEvent actionEvent) {
        Image[] images1 = new Image[images.size()];
        images.toArray(images1);
        output = MeanImageMedian.calculateMeanImage(images1);
        iv.setImage(output);
        label2.setText("Displaying Mean Image");
    }
    @FXML
    private void calcMedian(ActionEvent actionEvent) {
        Image[] images1 = new Image[images.size()];
        images.toArray(images1);
        output = MeanImageMedian.calculateMedianImage(images1);
        iv.setImage(output);
        label2.setText("Displaying Median Image");
    }
    @FXML
    private void save(ActionEvent actionEvent) {
        FileChooser choose = new FileChooser();
        File out = choose.showSaveDialog(null);
        Path path = out.toPath();
        try{
            MeanImageMedian.writeImage(path, output);
            label2.setText(out+" Successfully Saved");
        } catch (IOException e){
            label2.setText("Error in saving file");
        }
    }
}
