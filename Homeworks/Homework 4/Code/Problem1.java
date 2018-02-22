import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Problem1 {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final PrintStream out = System.out;
    public static final int TELA_POR_PERSONA = 3;

    public static void main(String[] args) throws IOException {
        out.println("¿Cuantas personas quieren un vestido?");

        int personas = Integer.parseInt(br.readLine());
        int totalTela = TELA_POR_PERSONA*personas;

        out.println("Se necesitan " + totalTela + "m de tela.");
    }
}
