package FractalProject.modele;

import org.apache.commons.math3.complex.Complex;

public class MyThread extends Thread {
    int xMax, xMin, yMax, yMin;
    Complex[][] tabComplexs;
    int[][] tab;
    Fractal fract;

    MyThread(int xMax, int xMin, int yMax, int yMin, Complex[][] tabComplexs, int[][] tab, Fractal fract) {
        this.xMax = xMax;
        this.xMin = xMin;
        this.yMax = yMax;
        this.yMin = yMin;
        this.tabComplexs = tabComplexs;
        this.tab = tab;
        this.fract = fract;
    }

    @Override
    public void run() {
        for(int i = 0; xMax) {

        }
    }

}
