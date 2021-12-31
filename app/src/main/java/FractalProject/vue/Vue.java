package FractalProject.vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
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

    private static ImageView convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr);
    }

    @FXML
    public void generate (){
        try {
        String j = filename.getText();
        Julia fractal = new JuliaBuilder().
                setMaxIt(Integer.parseInt(maxIt.getText())).
                setRadius(Integer.parseInt(radius.getText())).
                setConstant(new Complex(Double.parseDouble(re.getText()),Double.parseDouble(im.getText()))).
                setStep(Double.parseDouble(step.getText())).
                setxMax(Double.parseDouble(xMax.getText())).
                setxMin(Double.parseDouble(xMin.getText())).
                setyMax(Double.parseDouble(yMax.getText())).
                setyMin(Double.parseDouble(yMin.getText())).build();
            var test = fractal.drawFractal();    
            image=convertToFxImage(test);
            Julia.createFile("Test", test);
        } catch (Exception e) {
            System.out.println("Une erreur est survenu.");
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            stage = FXMLLoader.load(getClass().getResource("/interface.fxml"));
            generate = new Button();
            generate.setOnAction(a -> generate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
