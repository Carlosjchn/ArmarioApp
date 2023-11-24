package registroropa;

import static recursos.Recursos.*;
import java.util.Scanner;

public class RegistroRopa {
    public static void main(String[] args) {

        // prueba registro de datos, literalmente hay que rehacerlo casi todo.
        String[][] ropa = new String[1][3];
        String[] nuevaRopa = new String[3];
        Scanner sc = new Scanner(System.in);
        int numPrendas = 0;
        boolean repetir = false;

        while (repetir == false) {
            if (numPrendas == 0) {
                for (int i = 0; i < 3; i++) {
                    ropa[0][i] = sc.nextLine();
                }
                numPrendas++;
            } else {
                // IMPORTANTE: Asi es como se usa la funcion del array dinamico.
                for (int i = 0; i < 3; i++) {
                    nuevaRopa[i] = sc.nextLine();
                    repetir = true;
                }
                ropa = arrayString2D(ropa, nuevaRopa);
            }
        }

        for (int i = 0; i < ropa.length; i++) {
            System.out.println("");
            for (int j = 0; j < ropa[0].length; j++) {
                System.out.print(ropa[i][j]+" ");
            }
        }
        sc.close();
    }
}
