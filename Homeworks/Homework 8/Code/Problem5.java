import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Problem5 {

    public static Random rand = new Random();

    public static void main(String[] args) throws IOException {

        int numeroRandom[] = {2, 4, 6, 8};

        boolean gameover = false;

        for (int i = 1; i <= 11; i++) {
            int picas, fijas;
            picas = fijas = 0;
            if(!gameover) {
                System.out.print("#" + i + " Digite un numero: ");
                String read = new BufferedReader(new InputStreamReader(System.in)).readLine();
                String[] readArray = read.split("");

                for (int j = 0; j < 4; j++) {
                    System.out.println(numeroRandom[j] + " " + readArray[j]);
                    if (String.valueOf(numeroRandom[j]).equals(readArray[j])) {
                        fijas++;
                    }
                }
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if (readArray[k].equals(String.valueOf(numeroRandom[l]))) {
                            if (!readArray[l].equals(String.valueOf(numeroRandom[l]))) {
                                picas++;
                            }
                        }
                    }
                }

                System.out.println("#" + i + " P: " + picas + " F: " + fijas);

                if (fijas == 4 && picas == 0) {
                    gameover = true;
                    System.out.println("\nGanó! \nNumero de intentos: " + i);
                        break;
                }
                if (i == 10) {
                    gameover = true;
                    String num = "";
                    for (int m : numeroRandom) {
                        num += m;
                    }
                    System.out.println("\nPerdió! \nEl número era: " + num);
                    break;
                }
            }
        }
    }
}
