package registroropa;

import java.util.Scanner;

public class RegistroRopa {

	public static String[][] sumarPrenda(String[][] array, String dato[]) {
        if (array[0][0] == null) {
            for (int k = 0; k < dato.length; k++) {
                array[0][k] = dato[k];
            }
            return array;
        } else {
            String dinamico[][] = new String[array.length + 1][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    dinamico[i][j] = array[i][j];
                }
            }
            for (int k = 0; k < dinamico[0].length; k++) {
                dinamico[dinamico.length - 1][k] = dato[k];
            }
            
            return dinamico;
        }
    }
	
	public static void verRopa (String[][] ropa) {
		if (ropa[0][0] == null) {
			System.out.println("Tu armario está vacío.");
		}else {
		for(int i = 0; i < ropa.length; i++) {
			System.out.print("\n" + (i+1) + " . ");
			for(int j = 0 ; j < ropa[0].length; j++) {
				System.out.print(ropa[i][j]+ "\t ");
			}
		}
		}
	}
	public static String[] elegirRopa(String prendas[], Scanner sc) {
		System.out.println("Elija la prenda que deseas guardar : 1. Camiseta 2. Sudadera 3. Pantalón");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		
		case 1:
			prendas[0] = "Camiseta";
			break;
			
		case 2:
			prendas[0] = "Sudadera";
			break;
			
		case 3:
			prendas[0] = "Pantalón";
			break;

		}
	return prendas;	
	}
	
	public static String[] elegirColor(String prendas[], Scanner sc) {
		System.out.println("Color de tu " + prendas[0] + " es : 1. rojo  2. azul 3. verde 4. blanco 5. negro");
		int opcion2 = sc.nextInt();

		switch (opcion2) {

		case 1:
			prendas[1] = "rojo";
			break;
			
		case 2:
			prendas[1] = "azul";
			break;
			
		case 3:
			prendas[1] = "verde";
			break;
			
		case 4:
			prendas[1] = "blanco";
			break;
			
		case 5:
			prendas[1] = "negro";
			break;

		}
		return prendas;
	}
	public static String [] elegirTalla (String prendas[], Scanner sc) {
		System.out.println("Introduzca la talla de tu " + prendas[0] + " es : 1. XS  2. S 3. M  4. L  5. XL  6.XXL ");
		int opcion3 = sc.nextInt();
		
		switch (opcion3) {
		case 1:
			prendas[2] = "XS";
			break;
			
		case 2:
			prendas[2] = "S";
			break;
			
		case 3:
			prendas[2] = "M";
			break;
			
		case 4:
			prendas[2] = "L";
			break;
			
		case 5: 
			prendas[2] = "XL";
			break;
			
		case 6:
			prendas[2] = "XXL";
			break;
	} 
		return prendas;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String ropa[][] = new String[1][3];
		String prendas[] = new String[3];

		System.out.println("Bienvenido a la aplicacion.");
		
		System.out.println("Pulse la tecla intro para continuar");
		sc.nextLine();
		
		boolean salir = false;
		do {
			System.out.println("Menú: \n\t 1. Registrar prendas \n\t 2. Ver tu ropa \n\t 3. Salir.");
			int opcion = sc.nextInt();
			switch(opcion) {
			case 1:
			elegirRopa(prendas, sc);
			elegirColor(prendas, sc);
			elegirTalla(prendas, sc);
			ropa = sumarPrenda (ropa,prendas);
			break;
			case 2:
			verRopa(ropa);
			System.out.println("\n introduzca cualquier carácter y pulse intro para continuar");
			sc.next();
			break;
			
			case 3:
			salir = true;
			System.out.println("Has salido de la aplicación");
			break;
			}
		System.out.println("");
		}while(salir == false);
		
	}

}
