package FractalProject.modele;

import org.apache.commons.math3.complex.Complex;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Julia {
    private final int maxIt, radius;
    private final Complex constant;
    private final double xMax, xMin, yMax, yMin, step;

    public Julia(JuliaBuilder builder) {
        this.maxIt = builder.maxIt;
        this.radius = builder.radius;
        this.constant = builder.constant;
        this.step = builder.step;
        this.xMax = builder.xMax;
        this.xMin = builder.xMin;
        this.yMax = builder.yMax;
        this.yMin = builder.yMin;
    }


    public static class JuliaBuilder {
        private int maxIt;
        private int radius;
        private Complex constant;
        private double xMax, xMin, yMax, yMin, step;

        public JuliaBuilder setMaxIt(int maxIt) {
            this.maxIt = maxIt;
            return this;
        }

        public JuliaBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public JuliaBuilder setConstant(Complex constant) {
            this.constant = constant;
            return this;
        }

        public JuliaBuilder setxMax(double xMax) {
            this.xMax = xMax;
            return this;
        }

        public JuliaBuilder setxMin(double xMin) {
            this.xMin = xMin;
            return this;
        }

        public JuliaBuilder setyMax(double yMax) {
            this.yMax = yMax;
            return this;
        }

        public JuliaBuilder setyMin(double yMin) {
            this.yMin = yMin;
            return this;
        }

        public JuliaBuilder setStep(double step) {
            this.step = step;
            return this;
        }

        public Julia build() {
            Julia julia = new Julia(this);
            return julia;
        }
    }

    int divergenceIndex(Complex z0) {
        int ite = 0;
        Complex zn = z0;
        while (ite < maxIt - 1 && zn.abs() <= radius) {
            zn = zn.pow(2);
            zn = zn.add(constant);
            ite++;
        }
        return ite;
    }

    public int[][] createTabDiv() {
        int width = (int) ((Math.abs(xMax - xMin)) / this.step) + 1;
        int height = (int) ((Math.abs(yMax - yMin)) / this.step) + 1;
        int[][] res = new int[width][height];
        double realPart = xMin;
        double imaginaryPart = yMin;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                res[i][j] = divergenceIndex(new Complex(realPart, imaginaryPart));
                realPart += step;
            }
            realPart = xMin;
            imaginaryPart += this.step;
        }
        return res;
    }

    int color(int div) {
        if(div==this.maxIt) {
            return (0 << 16) + (0 << 8) + 0;
        }
        return Color.HSBtoRGB((float) div/ maxIt, 0.7f, 0.7f);
    }

    public void drawFractal(String nom) throws IOException {
        int width = (int) ((Math.abs(xMax - xMin)) / this.step) + 1;
        int height = (int) ((Math.abs(yMax - yMin)) / this.step) + 1;
        var image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int[][] divTab = createTabDiv();
        for (int i = 0; i < divTab.length; i++) {
            for (int j = 0; j < divTab[i].length; j++) {
                image.setRGB(i, j, color(divTab[i][j]));
            }
        }
        File file = new File(nom+".png");
        ImageIO.write(image, "PNG", file);
    }

}
