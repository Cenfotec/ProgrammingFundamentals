/**
 * Nombre del Programa: Ejemplo de arreglos
 * <p>
 * Descripcion: Sea crea un arreglo del tamaño definido por el
 * usuario, luego se agregan valores a ese arreglo
 * para mostrarlos y obtener la suma y el promedio
 * de los datos.
 * <p>
 * Fecha de Creacion: 13/3/2018
 * Autor: Pablo Bonilla G.
 * <p>
 * Fecha de Modificacion: 15/3/2018
 * Modificado Por: Pablo Bonilla G.
 **/

package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {

        int[] arreglo = {0}; // Se inicializa el arreglo
        int size;
        out.println("Digite el tamaño del arreglo");
        size = Integer.parseInt(br.readLine());
        arreglo = new int[size];

        // Se llenara el arreglo con los datos del usuario
        llenarArreglo(arreglo);

        // Mostar el contenido del arreglo
        mostrarArreglo(arreglo);

        int suma = sumaArreglo(arreglo);
        out.println("Suma total: " + suma);

        int promedio = promedioArreglo(arreglo);
        out.println("Promedio: " + promedio);

        ordenamientoBurbuja(arreglo);
    }

    // Llenar el arreglo
    static void llenarArreglo(int[] pArreglo) throws IOException {
        for (int i = 0; i < pArreglo.length; i++) {
            out.println("Digite el dato numero " + (i + 1));
            pArreglo[i] = Integer.parseInt(br.readLine());
        }
    }

    // Mostrar arreglo
    static void mostrarArreglo(int[] pArreglo) {
        out.println("Los datos del arreglo son:");
        for (int i = 0; i < pArreglo.length; i++) {
            out.print(pArreglo[i] + " - ");
        }
        out.println("Fin");
    }

    // Suma del arreglo
    static int sumaArreglo(int[] pArreglo) {
        int suma = 0;
        for (int i = 0; i < pArreglo.length; i++) {
            suma += pArreglo[i];
        }
        return suma;
    }

    // Promedio del arreglo
    static int promedioArreglo(int[] pArreglo) {
        int promedio = sumaArreglo(pArreglo);
        promedio /= pArreglo.length;
        return promedio;
    }

    static void ordenamientoBurbuja(int[] pArreglo) {
        int i, k, temporal;
        for (i = pArreglo.length - 1; i > 0; i--) {
            for (k = 0; k < i; k++) {
                if (pArreglo[k] > pArreglo[k + 1]) {
                    temporal = pArreglo[k];
                    pArreglo[k] = pArreglo[k + 1];
                    pArreglo[k + 1] = temporal;
                }
            }
        }
        for (int l = 0; i < pArreglo.length; i++) {
            out.println(pArreglo[i]);
        }
//      for (int j : pArreglo) {
//          out.print(j);
//      }
    }
}
