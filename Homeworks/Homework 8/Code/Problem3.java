import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem3 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("[Triangulo] 1ra longitud: ");
        double primerLado = Double.parseDouble(br.readLine());

        out.print("[Triangulo] 2da longtiud: ");
        double segundoLado = Double.parseDouble(br.readLine());

        double resultado = calcularHipotenusa(primerLado, segundoLado);
        out.println("La hipotenusa del triangulo de lados " + primerLado + " y " + segundoLado + " es: " + resultado);
    }
    static double calcularHipotenusa(double lado1, double lado2) {
        return Math.sqrt(Math.pow(lado1, 2) + Math.pow(lado2, 2));
    }
}
