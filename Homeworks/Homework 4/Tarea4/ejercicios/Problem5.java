package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem5 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;
    public static final int VACUNA_POR_ANIMAL = 5;

    public static void main(String[] args) throws IOException {
        out.print("Cantidad de jaulas: ");
        int jaulasTotal = Integer.parseInt(br.readLine());

        out.print("Cantidad de animales por jaula: ");
        int animalesJaula = Integer.parseInt(br.readLine());

        int vacunaTotal = (jaulasTotal * animalesJaula) * VACUNA_POR_ANIMAL;
        System.out.println("Se necesitan " + vacunaTotal + "cc de vacuna.");
    }
}
