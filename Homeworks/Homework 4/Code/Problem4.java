import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem4 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static final int IMPUESTO = 15;

    public static void main(String[] args) throws IOException {
        // "t" equivale a "Trabajadores"

        out.print("El precio de cada hora (colones): ");
        float precioPorHora = Float.parseFloat(br.readLine());


        out.print("Primer Trabajador: ");
        String tUno = br.readLine();

        System.out.println("Trabajador 1 trabajó (horas):");
        int tUnoHoras = Integer.parseInt(br.readLine());


        out.print("Segundo Trabajador: ");
        String tDos = br.readLine();

        System.out.println("Trabajador 2 trabajó (horas):");
        int tDosHoras = Integer.parseInt(br.readLine());


        float salario = precioPorHora * tUnoHoras;
        float tDosSalario = salario - (IMPUESTO*salario)/100;

        out.println("Salario Trabajador Uno: " + salario);
        out.println("Salario Trabajador Dos: " + tDosSalario);
    }
}
