/**
 * Nombre del Programa: Bingo
 *
 * Descripcion: La empresa BINGUITOS de Costa Rica, necesita que se haga un
 *              programa para administrar juegos de bingo que ellos utilizan.
 *
 * Fecha de Creacion: 16/4/2018
 * Autor: Pablo Bonilla y Camila Casasola
 *
 * Fecha de Modificacion: 23/4/2018
 * Modificado Por: Pablo Bonilla G.
 */

package org.pabcam.bingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class UIBingo {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    /******************************************************************
     * Modulo Principal que permite ejecutar la aplicación
     *
     *******************************************************************/

    public static void main(String[] args) throws IOException {
        String opc;
        boolean noSalir = true;

        do {
            mostrarMenu();
            opc = leerOpcion();
            noSalir = ejecutarAccion(opc);

        } while (noSalir);
    }

    /*****************************************************************
     * Rutina: mostrarMenu
     * Propósito: Presentar el menú de opciones
     * Parámetros:
     *
     * Retorna:
     *****************************************************************/

    static void mostrarMenu(){
        out.println("1. Generar cartones");
        out.println("2. Definir el tipo de juego");
        if (Rutinas.bingoStatus) {
            out.println("3. Sacar número");
        } else {
            out.println("3. Comenzar el juego");
        }
        out.println("4. Salir");
    }

    /*****************************************************************
     * Rutina: leerOpcion
     * Propósito: Obtener del usuario la opcíón escogida
     * Parámetros:
     *
     * Retorna: String » Opción del usuario
     *****************************************************************/

    static String leerOpcion() throws IOException {

        String opcion;

        out.print("\nSeleccione una opción: ");
        opcion = br.readLine();
        out.println();
        return opcion;
    }

    /*****************************************************************
     * Rutina: solicitarOpcionJuego
     * Propósito: Obtener del usuario la opcíón del juego escogido
     * Parámetros:
     *
     * Retorna: String » Opción del usuario
     *****************************************************************/

    static String solicitarOpcionJuego() throws IOException {
        out.println("Seleccione la opción de como ganar el bingo:");
        out.println("1. Cuatro esquinas");
        out.println("2. Cartón lleno");
        return br.readLine();
    }

    /*****************************************************************
     * Rutina: ejecutarAccion
     * Propósito: Ejecutar la acción que corresponde a la opcíón escogida
     * Parámetro: opcion
     *
     * Retorna: boolean
     *			Un valor que indica si se desea continuar o salir del menú
     *****************************************************************/

    static boolean ejecutarAccion(String opcion)throws java.io.IOException {
        boolean noSalir = true;

        if (opcion.equals("1")) { // Opción para generar los cartones

            if (Rutinas.bingoStatus) {
                out.println("[!] El bingo ya ha comenzado!\n");
            } else {
                out.println("[!] El cartón #1 y #2 han sido generados!\n");
                Rutinas.generarCartones();
            }
        }





        else if (opcion.equals("2")) { // Opción para seleccionar el tipo de juego
            if (Rutinas.bingoStatus) {
                out.println("[!] El bingo ya ha comenzado!\n");
            } else {
                String opcionJuego = solicitarOpcionJuego();
                while (!opcionJuego.equals("1") && !opcionJuego.equals("2")) {
                    opcionJuego = solicitarOpcionJuego();
                }
                String msg = (opcionJuego.equals("1")) ? "cuatro esquinas" : "cartón lleno";
                out.println("\n[!] Cambiando a opción de juego a: " + msg + "\n");
                Rutinas.opcionJuego = Integer.parseInt(opcionJuego);
            }
        }





        else if (opcion.equals("3")) {
            if (!Rutinas.bingoStatus) { // Opción para iniciar el juego
                if (!Rutinas.cartonGen) {
                    out.println("[!] Genere los cartones primero!(1)\n");
                } else if (Rutinas.opcionJuego == 0) {
                    out.println("[!] Seleccione una opción de juego! (2)\n");
                } else {
                    int opcionJuego = Rutinas.opcionJuego;
                    Rutinas.iniciarBingo(opcionJuego);
                    out.println("[!] El bingo ha iniciado con 2 cartones!\n");
                }
            } else { // Opción para sacar un número después de haber inicializado el juego
                Rutinas.sacarNumero();
                if (Rutinas.cartonGanador != 0) {
                    Rutinas.terminarBingo();
                    noSalir = false;
                    out.println("+----------------------------+");
                    out.println("| El cartón ganador es el #" + Rutinas.cartonGanador + " |");
                    out.println("+----------------------------+");
                }
            }
        }





        else if (opcion.equals("4")) { // Opción para cerrar la aplicación
            out.println("[!] Cerrando aplicación...");
            noSalir = false;
        }

        else { // Opción para determinar si el valor ingresado es válido o no
            out.println("[!] Opción inválida!\n");
        }
        return noSalir;
    }


    /*****************************************************************
     * Rutina: verCarton
     * Propósito: Visualizar el cartón indicado por el usuario
     * Parámetros: carton
     *             El arreglo del cartón seleccionado por el usuario
     *
     * Retorna:
     *****************************************************************/

    static void verCarton(String[][] carton) {
        String fila = "";
        String separador = "";
        for (int i = 0; i < 5; i++) {
            separador = (i == 0) ? "  B    I    N    G    O   \n"
                    + "+------------------------+" : "+----+----+----+----+----+";
            out.println(separador);
            for (int j = 0; j < 4; j++) {
                fila += "| " + carton[i][j];
                fila += (j == 3) ? " | " + carton[i][4] + " |" : " ";
            }
            out.println(fila);
            fila = "";
        }
        out.println("+------------------------+\n");

    }
}