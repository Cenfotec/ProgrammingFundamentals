import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Distancia en metros: ");
        float distancia = Float.parseFloat(br.readLine());

        out.print("Tiempo en segundos: ");
        float tiempo = Float.parseFloat(br.readLine());

        float velocidad = distancia/tiempo;
        out.printf("El vehículo viaja a %.1f m/s", velocidad);
    }
}
