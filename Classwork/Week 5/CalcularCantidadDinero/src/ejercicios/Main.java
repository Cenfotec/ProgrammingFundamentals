/**
 * Nombre del Programa: Calcular la cantidad de dinero
 *                      a partir de un interes.
 *
 * Descripcion: Calcular cuánto dinero tiene una persona después de N años, dado i como
 *              tasa de interés y p como el monto inicial. (valor = p*(1+i)N).
 *
 * Fecha de Creacion: 13/2/2018
 * Autor: Pablo Bonilla G.
 *
 * Fecha de Modificacion: 13/2/2018
 * Modificado Por: Pablo Bonilla G.
 */

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    // Declaracion de los flujos de entrada y salida
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        out.print("Cantidad de años: ");
        int years = Integer.parseInt(br.readLine());

        out.print("Tasa de interes: ");
        double tasaInteres = Double.parseDouble(br.readLine());

        out.print("Monto inicial: ");
        double montoInicial = Double.parseDouble(br.readLine());

        double valor = montoInicial*Math.pow(1+tasaInteres, years);
        System.out.println("La persona tendria: " + valor);
    }
}
