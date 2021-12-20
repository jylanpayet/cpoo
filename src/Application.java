import java.io.IOException;

public class Application {
    public static void main(String[] args){
        Julia j=new Julia.JuliaBuilder(1000,1,-0.7269,0.1889,1000,1000).build();
        try {
            j.drawJulia();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
