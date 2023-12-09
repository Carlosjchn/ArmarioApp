package registrouser;
import java.util.Scanner;
public class prueba_registroUser {
	
	public static void main(String[] args) {
	   	Scanner sc = new Scanner (System.in);
		
		// creo una matriz 1 filas 3 columnas, 3 son el nº de datos que le pides al usuario. nombre, correo y contraseña. Esta matriz es tu "base de datos"
		String registrados[][] = new String [1][3]; 
		// creo una matriz 1 dimension 3 posiciones para registrar lo que mete el usuario.
		String usuario[] = new String[3];
		//Creo un bucle infinito de EJEMPLO.
		int a=0;
		while(a<1){
			//pido el nombre.
			System.out.println("Introduce tu nombre:");
			// guardo el nombre en la posicion que quieras que este, en mi caso en la primera poscion (0).
			usuario[0] = sc.nextLine();
			//pido el correo.
			System.out.println("Introduce tu correo:");
			// guardo el correo en la posicion 1.
			usuario[1] = sc.nextLine();
			//pido la contraseña.
			System.out.println("Introduce tu contraseña:");
			// guardo el contraseña en l a ultima posicion (2).
			usuario[2] = sc.nextLine();

			// uso la funcion creada. Le paso los datos dentro del array usuario, para que se guarden en registrados.
			registrados = registroUsuarios(registrados,usuario);

			// creo dos bucles for para recorrer el array registrados e imprimirlo para ver que se guardan los datos correctamente.

			for (int i = 0; i < registrados.length; i++){ // este for recorrera todos las filas de "registrados".
				System.out.print("\n" + (i) + " \t"); // cada vez que cambie de fila se imprime la posicion de la fila
				for (int j = 0; j < registrados[i].length; j++){ // este for recorrera todos las columnas de "registrados"
					System.out.print(registrados[i][j] + "\t");  // uso print en vez de println para que se imprima todas las columnas correspondientes en la misma linea.
				}
			}
			System.out.println(""); // esto simplemente para que cuando te pida datos de nuevo se imprima en la linea de abajo.
		}
	}
	
	// Creo la función para la "base de datos"
	public static String[][] registroUsuarios (String[][] array, String dato[]) {
        // este if es para cuando la matriz esta vacía se copien los datos en la posiciones iniciales vacias.
		if (array[0][0] == null) {
            for (int k = 0; k < dato.length; k++) {
                array[0][k] = dato[k];
            }
            return array;
        } else {
			//creo un matriz igual que la introducida con 1 FILA mas.
            String dinamico[][] = new String [array.length + 1][array[0].length];
            // copio los datos de la matriz inicial en la nueva matriz, dejando la ultima fila vacía.
			for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    dinamico[i][j] = array[i][j];
                }
            }
			// copio los datos de la matriz de 1 dimension en las posiciones vacias de la matriz nueva.
            for (int k = 0; k < dinamico[0].length; k++) {
                dinamico[dinamico.length - 1][k] = dato[k];
            }
            return dinamico;
        }
    }
}
