package FractalProject;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.math3.complex.Complex;

import FractalProject.modele.Julia;
import FractalProject.modele.Julia.JuliaBuilder;
import FractalProject.vue.Vue;
import javafx.application.Application;

public class App {

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
                fractal.drawFractal();
            Julia.createFile(t[9],fractal.getImg());
        } catch (Exception e) {
            System.out.println("Le fichier n'a pas été bien paramétré.");
        }
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Tapez 1 pour le terminal et 2 pour le graphics :");
            int str = sc.nextInt();
            switch (str) {
                case 1 -> Terminal();
                case 2 -> Application.launch(Vue.class, args);
                default -> System.out.println("Choix incorrect.");
            }
        }catch(Exception e){
            System.out.println("Une erreur s'est produite.");
        }
    }
}
