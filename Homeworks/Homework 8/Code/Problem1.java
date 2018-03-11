import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem1 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Primer numero: ");
        double a = Double.parseDouble(br.readLine());

        out.print("Segundo numero: ");
        double b = Double.parseDouble(br.readLine());

        out.println("Maximo: " + maximo(a, b));
        out.println("Minimo: " + minimo(a, b));
    }
    static double maximo(double a, double b) {
        return (a > b) ? a : b;
    }
    static double minimo(double a, double b) {
        return (a < b) ? a : b;
    }
}
