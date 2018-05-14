package org.bonilla.bingo;

public class Rutinas {
    private static String cartones[][][] = new String[2][5][5]; // Declaración de la matriz para almacenar los dos cartones
    private static String numSacados[] = new String[76]; // Declaración del arreglo para almacenar los números ya jugados
    private static String numPosibles[] = new String[76];

    static int cantNumSacados = 0; // Inicialización para determinar la cantidad de números ya jugados
    static int opcionJuego = 0; // Inicialización para determinar la opción de juego
    static boolean bingoStatus = false; // Inicialización para determinar si el juego empezó o no
    static boolean cartonGen = false; // Inicialización para determinar si los cartones ya fueron generados o no
    static int cartonGanador = 0; // Inicialización para determinar el número del cartón que ganó

    /*****************************************************************
     * Rutina: generarCartones
     * Propósito: Generar los dos cartones, cada uno con números
     *            diferentes, ordenados por columna
     * Parámetros:
     *
     * Retorna:
     *****************************************************************/

    public static void generarCartones() {
        cartonGen = true;

        numPosibles = new String[76];
        for (int cont = 0; cont < 75; cont++) {
            numPosibles[cont] = String.format("%02d", cont+1);
        }


        for (int i = 0; i < 2; i++) {
            int numGenIndice = 0;
            int randMax, randMin;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    boolean noDiferente = true;
                    while (noDiferente) {
                        // Si k es 0, entonces randMax = 15, sino...
                        randMax = (k == 0) ? 15 : (k == 1) ? 30 : (k == 2) ? 45 : (k == 3) ? 60 : 74;

                        // Si k es 0, entonces randMin = 1, sino...
                        randMin = (k == 0) ? 1 : (k == 1) ? 15 : (k == 2) ? 30 : (k == 3) ? 45 : 60;

                        // Generador de un número aleatorio
                        numGenIndice = (int) (Math.random() * ((randMax - randMin) + 1)) + randMin;

                        //Otra manera » numGenIndice = ThreadLocalRandom.current().nextInt(randMin, randMax);

                        if (!numPosibles[numGenIndice].equals("")) {
                            noDiferente = false;
                        }
                        cartones[i][j][k] = numPosibles[numGenIndice];
                        numPosibles[numGenIndice] = "";
                    }
                }
            }
            cartones[i][2][2] = "  "; // Abrir el espacio en el medio del cartón
        }
        UIBingo.verCarton(cartones[0]);
        UIBingo.verCarton(cartones[1]);
    }

    /*****************************************************************
     * Rutina: getOpcionJuego
     * Propósito: Obtener la opción del juego
     * Parámetros:
     *
     * Retorna: int » Opción del juego
     *****************************************************************/

    public static int getOpcionJuego() {
        return opcionJuego;
    }

    /*****************************************************************
     * Rutina: getCarton
     * Propósito: Obtener el cartón completo del usuario definido
     * Parámetros:
     *
     * Retorna: String[][] (Matriz/Arreglo 2D) » Cartón completo del
     *                                           jugador definido
     *****************************************************************/

    public static String[][] getCarton(int numCarton) {
        String carton[][] = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                carton[i][j] = cartones[numCarton][i][j];
            }
        }
        return carton;
    }

    /*****************************************************************
     * Rutina: verificarGanador
     * Propósito: Verificar si el usuario ganó el juego basado
     *            en la opción del juego previamente seleccionado
     * Parámetros: carton
     *             El arreglo del cartón que se quiere verficar
     *
     * Retorna: boolean » Estado si el usuario ganó o no
     *****************************************************************/

    public static boolean verificarGanador(String[][] carton) {
        boolean ganador = false;

        // 1. Opción de juego: cuatro esquinas
        if (getOpcionJuego() == 1) {
            for (int i = 0; i < 4; i++) {
                if (carton[0][0].equals("X ") && carton[0][4].equals("X ") && carton[4][0].equals("X ") && carton[4][4].equals("X ")) {
                    ganador = true;
                }
            }
        }

        // 2. Opción de juego: cartón lleno
        if (getOpcionJuego() == 2) {
            int numValidos = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (carton[i][j].equals("X ")) {
                        numValidos++;
                    }
                }
            }
            if (numValidos == 24) {
                ganador = true;
            }
        }
        return ganador;
    }

    /*****************************************************************
     * Rutina: sacarNumero
     * Propósito: Sacar un número aleatorio para que se juege
     * Parámetros:
     *
     * Retorna:
     *****************************************************************/

    public static void sacarNumero() {
        boolean yaExiste = true;
        int numSacar = 0;
        do {
            boolean estaAdentro = false;
            numSacar = (int) (Math.random() * 75) + 1;
            for (int i = 0; i < numSacados.length; i++) {
                if (String.valueOf(numSacar).equals(numSacados[i])) {
                    estaAdentro = true;
                }
            }
            if (!estaAdentro) {
                yaExiste = false;
            }
        } while (yaExiste);
        numSacados[cantNumSacados] = String.valueOf(numSacar);
        cantNumSacados++;

        String fila = (numSacar <= 15) ? "B" : (numSacar <= 30) ? "I" : (numSacar <= 45) ? "N" : (numSacar <= 60) ? "G" : "O";
        System.out.println("\n[!] Salió el número: " + fila + numSacar + "\n");

        String numCantado = (numSacar <= 9) ? "0"+numSacar : String.valueOf(numSacar);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (cartones[i][j][k].equals(String.valueOf(numCantado))) {
                        cartones[i][j][k] = "X ";
                        if (verificarGanador(cartones[i])) {
                            cartonGanador = i+1;
                        }
                    }
                }
            }
        }
        UIBingo.verCarton(cartones[0]);
        UIBingo.verCarton(cartones[1]);
    }

    /*****************************************************************
     * Rutina: iniciarBingo
     * Propósito: Inicializar el juego
     * Parámetros: opcionJuego
     *             La opción del juego con la que se quiere jugar
     *
     * Retorna:
     *****************************************************************/

    static void iniciarBingo(int opcionJuego) {
        Rutinas.opcionJuego = opcionJuego;
        Rutinas.bingoStatus = true;
    }

    /*****************************************************************
     * Rutina: terminarBingo
     * Propósito: Terminar el juego
     * Parámetros:
     *
     * Retorna:
     *****************************************************************/

    static void terminarBingo() {
        Rutinas.bingoStatus = false;
    }

}