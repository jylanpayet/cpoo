package FractalProject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.math3.complex.Complex;

import modele.Julia;
import modele.Julia.JuliaBuilder;

public class App {

    public static void Terminal (String path) throws IOException {
        String data= "";
                try
                {
                        File test = new File("src/main/resources/Parametres.txt");
                        Scanner sc = new Scanner(test);
                        if (sc.hasNextLine())
                        {
                                data = sc.nextLine();
                                data = sc.nextLine();
                        }
                        sc.close();
                String [] fields = data.split(";");
                Julia fractal = new JuliaBuilder().
                        setMaxIt(Integer.parseInt(fields[5])).
                        setxMin(Double.parseDouble(fields[0])).
                        setxMax(Double.parseDouble(fields[1])).
                        setyMin(Double.parseDouble(fields[2])).
                        setyMax(Double.parseDouble(fields[3])).
                        setStep(Double.parseDouble(fields[8])).
                        setConstant(new Complex(Double.parseDouble(fields[6]),Double.parseDouble(fields[7]))).
                        setRadius(Integer.parseInt(fields[4])).build();
                fractal.drawFractal();
            } catch (Exception e) {
                System.out.println("Le fichier n'a pas été bien paramétré.");
        }
    }
    public static void main(String[] args) throws IOException {
        Terminal("/app/resources/Parametres.txt");
    }
}
