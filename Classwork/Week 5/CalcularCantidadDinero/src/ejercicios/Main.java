// Comentario en una linea

/*
Comentario
en diferentes
lineas
 */

/**
 * Comentario
 * automatico
 * en diferentes
 * lineas
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.swing.*;

public class Main {

    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        double numUno = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el primer numero"));
        double numDos = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el segundo numero"));
        String userInput = JOptionPane.showInputDialog(null, "Digite el tercer numero");
        double numTres = Double.parseDouble(userInput);
        double resultado = (numUno + numDos + numTres) / 3;
        out.println("El promedio es: " + resultado);
    }

}