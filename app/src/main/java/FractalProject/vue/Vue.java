package FractalProject.vue;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    public Julia modele;
    @FXML
    public Label errorMsg;

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
    public void toPngAction () throws IOException {
        if(this.modele != null && filename.getText().length() != 0) {
        Julia.createFile(filename.getText(), this.modele.getImg());
        errorMsg.setVisible(false);
        } else {
            errorMsg.setText("Veuillez renseigner le nom du fichier.");
            errorMsg.setVisible(true);
        }
    }

    @FXML
    public void generateAction (){
        errorMsg.setVisible(false);
        try {
        this.modele = new JuliaBuilder().
                setMaxIt(Integer.parseInt(maxIt.getText())).
                setRadius(Integer.parseInt(radius.getText())).
                setConstant(new Complex(Double.parseDouble(re.getText()),Double.parseDouble(im.getText()))).
                setStep(Double.parseDouble(step.getText())).
                setxMax(Double.parseDouble(xMax.getText())).
                setxMin(Double.parseDouble(xMin.getText())).
                setyMax(Double.parseDouble(yMax.getText())).
                setyMin(Double.parseDouble(yMin.getText())).build();
            this.modele.drawFractal();    
            Image frac = convertToFxImage(this.modele.getImg()).getImage();
            image.setImage(frac);
        } catch (Exception e) {
            errorMsg.setText("Veuillez remplir correctement tous les champs.");
            errorMsg.setVisible(true);
        }
    }

    @Override
    public void start(Stage stage) {
        try {
            stage = FXMLLoader.load(getClass().getResource("/interface.fxml"));
            /*generate = new Button();
            generate.setOnAction(a -> generate());*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
