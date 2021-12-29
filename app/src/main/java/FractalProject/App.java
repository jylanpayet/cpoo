package FractalProject;

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

public class App extends Application {
    @FXML
    public Stage stage;
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
    public TextField maxIt;
    @FXML
    public Button topng;
    @FXML
    public ImageView image;

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
    public static void Terminal (){
        try{
            String data= "";
            File test = new File("src/main/resources/Parametres.txt");
            Scanner sc = new Scanner(test);
            if (sc.hasNextLine()){
                sc.nextLine();
                data = sc.nextLine();
            }
            sc.close();
            String [] t = data.split(";");
            Julia fractal = new JuliaBuilder().
                            setMaxIt(Integer.parseInt(t[0])).
                            setRadius(Integer.parseInt(t[1])).
                            setConstant(new Complex(Double.parseDouble(t[2]),Double.parseDouble(t[3]))).
                            setStep(Double.parseDouble(t[4])).
                            setxMax(Double.parseDouble(t[5])).
                            setxMin(Double.parseDouble(t[6])).
                            setyMax(Double.parseDouble(t[7])).
                            setyMin(Double.parseDouble(t[8])).build();
                    fractal.drawFractal(t[9]);
        } catch (Exception e) {
            System.out.println("Le fichier n'a pas été bien paramétré.");
        }
    }
    public static void main(String[] args) {
        //Terminal();
        launch(args);
    }
}
