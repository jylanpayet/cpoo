package FractalProject.modele;
import org.apache.commons.math3.complex.Complex;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fractal {
    private final int maxIt, radius;
    private final Complex constant;
    private final double xMax, xMin, yMax, yMin, step;
    private BufferedImage img;
    private Boolean mode;

    public Fractal(FractalBuilder builder) {
        this.maxIt = builder.maxIt;
        this.radius = builder.radius;
        this.constant = builder.constant;
        this.step = builder.step;
        this.xMax = builder.xMax;
        this.xMin = builder.xMin;
        this.yMax = builder.yMax;
        this.yMin = builder.yMin;
        this.mode = builder.mode;
    }

    public BufferedImage getImg() {
        return this.img;
    }


    public static class FractalBuilder {
        private int maxIt;
        private int radius;
        private Complex constant;
        private double xMax, xMin, yMax, yMin, step;
        private boolean mode;

        public FractalBuilder setMaxIt(int maxIt) {
            this.maxIt = maxIt;
            return this;
        }

        public FractalBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public FractalBuilder setConstant(Complex constant) {
            this.constant = constant;
            return this;
        }

        public FractalBuilder setxMax(double xMax) {
            this.xMax = xMax;
            return this;
        }

        public FractalBuilder setxMin(double xMin) {
            this.xMin = xMin;
            return this;
        }

        public FractalBuilder setyMax(double yMax) {
            this.yMax = yMax;
            return this;
        }

        public FractalBuilder setyMin(double yMin) {
            this.yMin = yMin;
            return this;
        }

        public FractalBuilder setStep(double step) {
            this.step = step;
            return this;
        }

        public Fractal build() {
            Fractal fractal = new Fractal(this);
            return fractal;
        }

        public FractalBuilder setMode(boolean mode) {
            this.mode = mode;
            return this;
        }
    }

    int divergenceIndex(Complex z0) {
        if(mode) {
        int iteration = 0;
        Complex zn = z0;
        while (iteration < maxIt - 1 && zn.abs() <= radius) {
            zn = zn.pow(2);
            zn = zn.add(constant);
            iteration++;
        }
        return iteration;
    } else {
        double x = 0, y = 0;
        int iteration = 0;
        while (x*x+y*y <= 4 && iteration < maxIt) {
            double x_new = x*x - y*y + z0.getReal();
            y = 2*x*y + z0.getImaginary();
            x = x_new;
            iteration++;
        }
        return iteration;
    }
    }

    /*int divergenceIndexM(Complex z0){
        double x = 0, y = 0;
        int iteration = 0;
        while (x*x+y*y <= 4 && iteration < maxIt) {
            double x_new = x*x - y*y + z0.getReal();
            y = 2*x*y + z0.getImaginary();
            x = x_new;
            iteration++;
        }
        return iteration;
    }
    
    int divergenceIndexM(Complex z0){
        int ite = 0;
        Complex zm = new Complex(0,0);
        while (ite < maxIt && zm.abs() <= radius) {
            zm = zm.pow(2);
            zm = zm.add(z0);
            ite++;
        }
        return ite;
    }*/

    int color(int div) {
        if(div==this.maxIt) {
            return (0 << 16) + (0 << 8) + 0;
        }
        return Color.HSBtoRGB((float) div/ maxIt, 0.7f, 0.7f);
    }

    public void drawFractal() {
        int width = (int) ((Math.abs(xMax - xMin)) / this.step) + 1;
        int height = (int) ((Math.abs(yMax - yMin)) / this.step) + 1;
        double realPart = xMin;
        double imaginaryPart = yMin;
        var image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                image.setRGB(j, i, color(divergenceIndex(new Complex(realPart, imaginaryPart))));
                realPart += step;
            }
            realPart = xMin;
            imaginaryPart += this.step;
        }
        this.img = image;
    }
    public static void createFile(String nom,BufferedImage image) throws IOException {
        File file = new File(nom+".png");
        ImageIO.write(image, "PNG", file);
    }
}
