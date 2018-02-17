package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

public class Problema3 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Digite un numero entero: ");
        String numeroEntero = br.readLine();

        String[] digitos = numeroEntero.split("");
        out.println(Arrays.toString(digitos));

        int ultimoDigito = Integer.parseInt(digitos[digitos.length-1]);

        System.out.println("El último digito es: " + ultimoDigito);
    }
}
