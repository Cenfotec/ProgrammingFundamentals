import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem4 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Digite el primer número: ");
        double num1 = Double.parseDouble(br.readLine());

        out.print("Digite el segundo número: ");
        double num2 = Double.parseDouble(br.readLine());

        out.print("Digite el tercer número: ");
        double num3 = Double.parseDouble(br.readLine());

        double resultado = calcularMinimo(num1, num2, num3);
        out.println("El número más pequeño es: " + resultado);
    }
    static double calcularMinimo(double num1, double num2, double num3) {
        return (num1 < num2 && num1 < num3) ? num1 : (num2 < num3) ? num2 : num3;

    }
}
