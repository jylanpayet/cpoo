package FractalProject.vue;

import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.math3.complex.Complex;

import FractalProject.modele.Julia;
import FractalProject.modele.Julia.JuliaBuilder;

public class Vue extends Application {
    @FXML
    public Stage stage;
    @FXML
    public TextField maxIt;
    @FXML
    public TextField re;
    @FXML
    public TextField im;
    @FXML
    public TextField step;
    @FXML
    public TextField radius;
    @FXML
    public TextField xMin;
    @FXML
    public TextField xMax;
    @FXML
    public TextField yMin;
    @FXML
    public TextField yMax;
    @FXML
    public TextField filename;
    @FXML
    public Button topng;
    @FXML
    public Button generate;
    @FXML
    public ImageView image;

    /*@FXML
    public void generate (){
        
        String a = re.getText();
        String b = im.getText();
        String c = step.getText();
        String d = radius.getText();
        String e = xMax.getText();
        String f = xMin.getText();
        String g = yMax.getText();
        String h = yMin.getText();
        String i = maxIt.getText();
        String j = filename.getText();
        Julia fractal = new JuliaBuilder().
                setMaxIt(i).
                setRadius(Integer.parseInt(d)).
                setConstant(new Complex(Double.parseDouble(a),Double.parseDouble(b))).
                setStep(Double.parseDouble(c)).
                setxMax(Double.parseDouble(e)).
                setxMin(Double.parseDouble(f)).
                setyMax(Double.parseDouble(g)).
                setyMin(Double.parseDouble(h)).build();

        try {
            fractal.drawFractal(j);
        } catch (Exception e) {

        }
        
    }*/

    @Override
    public void start(Stage stage) {
        try {
            stage = FXMLLoader.load(getClass().getResource("/interface.fxml"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
