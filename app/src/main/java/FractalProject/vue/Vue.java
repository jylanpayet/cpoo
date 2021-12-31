package FractalProject.vue;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import org.apache.commons.math3.complex.Complex;
import FractalProject.modele.Fractal;
import FractalProject.modele.Fractal.FractalBuilder;

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
    @FXML
    public Label errorMsg;
    public Fractal modele;
    @FXML
    public Button switchButton;

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
    public void switchMode () {
        if (switchButton.getId().equals("1"))
                {
                    switchButton.setText("Mandelbrot");
                    switchButton.setStyle("-fx-background-color: grey;-fx-text-fill:black;");
                    switchButton.setId("2");
                }
                else
                {
                    switchButton.setText("Julia");
                    switchButton.setStyle("-fx-background-color: green;-fx-text-fill:white;");
                    switchButton.setId("1");
                }
    }

    @FXML
    public void toPngAction () throws IOException {
        if(this.modele != null && filename.getText().length() != 0) {
            Fractal.createFile(filename.getText(), this.modele.getImg());
            errorMsg.setVisible(false);
        } else {
            errorMsg.setText("Veuillez renseigner le nom du fichier.");
            errorMsg.setVisible(true);
        }
    }

    @FXML
    public void generateAction (){
        try {
            errorMsg.setVisible(false);
            this.modele = new FractalBuilder().
                    setMaxIt(Integer.parseInt(maxIt.getText())).
                    setRadius(Integer.parseInt(radius.getText())).
                    setConstant(new Complex(Double.parseDouble(re.getText()),Double.parseDouble(im.getText()))).
                    setStep(Double.parseDouble(step.getText())).
                    setxMax(Double.parseDouble(xMax.getText())).
                    setxMin(Double.parseDouble(xMin.getText())).
                    setyMax(Double.parseDouble(yMax.getText())).
                    setyMin(Double.parseDouble(yMin.getText())).
                    setMode(switchButton.getId().equals("1") ? true : false).build();
            this.modele.drawFractal();
            image.setImage(convertToFxImage(this.modele.getImg()).getImage());
        } catch (Exception e) {
            errorMsg.setText("Veuillez remplir correctement tous les champs.");
            errorMsg.setVisible(true);
        }
    }

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
