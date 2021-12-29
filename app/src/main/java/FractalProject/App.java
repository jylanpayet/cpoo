package FractalProject;
import mo

public class App {

    public static void main(String[] args) {
        Julia j = new Julia.JuliaBuilder(1000, 2,new Complex (-0.7269, 0.1889), 0.01,1000,1,-1,1,-1).build();
        j.drawFractal();
    }
}
