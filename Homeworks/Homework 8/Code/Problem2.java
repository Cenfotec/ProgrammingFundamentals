import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem2 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Ingrese un digito: ");
        double num = Double.parseDouble(br.readLine());
        double resultado = numeroCubo(num);
        System.out.println("El cubo de " + num + " es: " + resultado);
    }
    static double numeroCubo(double num) {
        double res = 1;
        for (int i = 0; i < 3; i++ ) {
            res *= num;
        }
        return res;
    }
}
