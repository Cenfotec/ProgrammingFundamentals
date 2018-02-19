package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem6 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Monto total de colones: ");
        int colones = Integer.parseInt(br.readLine());

        int[] m = new int[4];
        for (int i = 0, j; i <= 3; i++) {
            j = (i == 0) ? 50 : (i == 1) ? 20 : (i == 2) ? 10 : 5;
            m[i] = colones / j;
            colones -= j * m[i];
        }

        out.println("Monedas de 50: " + m[0] +
                  "\nMonedas de 20: " + m[1] +
                  "\nMonedas de 10: " + m[2] +
                  "\nMonedas de 5: " + m[3] +
                  "\nSobran: " + colones + " colones");

    }
}