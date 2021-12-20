import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Julia {
    private final int MAX_IT;
    private final double ZOOM;
    private final  double CX;
    private final double CY;
    private final  int w;
    private final int h;

    public Julia(JuliaBuilder builder) {
        this.MAX_IT = builder.MAX_IT;
        this.ZOOM = builder.ZOOM;
        this.CX = builder.CX;
        this.CY = builder.CY;
        this.w = builder.w;
        this.h = builder.h;
    }

    public int getMAX_ITERATIONS() {
        return MAX_IT;
    }

    public double getZOOM() {
        return ZOOM;
    }

    public double getCX() {
        return CX;
    }

    public double getCY() {
        return CY;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public static class JuliaBuilder{
        private final int MAX_IT;
        private final double ZOOM;
        private final double CX;
        private final double CY;
        private final int w;
        private final int h;

        public JuliaBuilder(int MAX_IT, double ZOOM, double CX, double CY, int w, int h) {
            this.MAX_IT = MAX_IT;
            this.ZOOM = ZOOM;
            this.CX = CX;
            this.CY = CY;
            this.w = w;
            this.h = h;
        }

        private void validJuliaObject(Julia julia) {

        }

        public Julia build(){
            Julia julia=new Julia(this);
            validJuliaObject(julia);
            return julia;
        }
    }

    void drawJulia() throws IOException {
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                double zx = 1.5 * (x - w / 2) / (0.5 * ZOOM * w);
                double zy = (y - h / 2) / (0.5 * ZOOM * h);
                float i = MAX_IT;
                while (zx * zx + zy * zy < 4 && i > 0) {
                    double tmp = zx * zx - zy * zy + CX;
                    zy = 2.0 * zx * zy + CY;
                    zx = tmp;
                    i--;
                }

                int c= Color.HSBtoRGB((i/MAX_IT), 0.7f, 0.7f);
                image.setRGB(x, y, c);
            }
        }
        File f = new File("./ressources/fractale.png");
        ImageIO.write(image, "PNG", f);
    }
}