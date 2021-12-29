import modele.Julia;
import org.apache.commons.math3.complex.Complex;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Julia j = new Julia.JuliaBuilder(1000, 2,new Complex (-0.7269, 0.1889), 0.01,1000,1,-1,1,-1).build();
        j.drawFractal();
    }
}
