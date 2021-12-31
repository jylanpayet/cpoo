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
    public void generate (){
        /*
        traiter les données
         */
        /*
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
        */
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
            var image = fractal.drawFractal();
            Julia.createFile(t[9],image);
        } catch (Exception e) {
            System.out.println("Le fichier n'a pas été bien paramétré.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tapez 1 pour le terminal et 2 pour le graphics :");
        int str = sc.nextInt();
        switch(str){
            case 1: Terminal();
                break;
            case 2: launch(args);
                break;
            default: System.out.println("Choix incorrect.");
        }
    }
}
