package compraventa;

import java.util.Scanner;
import static recursos.Recursos.*;

public class CompraVenta {
    public static final String LIMPIAR_CMD_WINDOW = "\033[H\033[2J";
    public static final String LIMPIAR_CMD_MACOS = "\u001b[2J";

    public static void limpiarPantalla() {
        System.out.println(LIMPIAR_CMD_MACOS);
        System.out.println(LIMPIAR_CMD_WINDOW);
    }

    /*
     * FUNCION ARRAY DINAMICOS.
     * Esta funcion aumenta el tamaño de FILAS en 1 cada vez que se añade una serie
     * de datos nuevos, el array dato[] debe ser igual al numero de COLUMNAS de
     * array[][].
     */
    public static String[][] arrayString2D(String[][] array, String dato[]) {
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
            for (int k = 0; k < dato.length; k++) {
                dinamico[dinamico.length - 1][k] = dato[k];
            }
            return dinamico;
        }
    }

    // funcion para eliminar una prenda cuando la pones a la venta.
    public static String[][] restarPrenda(String[][] array, String dato[]) {
        String dinamico[][] = new String[array.length - 1][array[0].length];
        boolean coincide = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (dato[j] == array[i][j]) {
                    coincide = true;
                }
                if (coincide == true && i != 0) {
                    dinamico[i - 1][j] = array[i][j];
                } else {
                    dinamico[i][j] = array[i][j];
                }
            }
        }

        return dinamico;
    }

    public static String menu(Scanner sc) {
        System.out.println("Opciones: \n \t 1 - Armario. \n\t 2 - Vender \n\t 3 - Comprar. \n\t 4 - Salir.");
        String opcion = sc.nextLine();
        return opcion;
    }

    /*
     * FUNCIONES PARA OPCIONES APLICACIÓN.
     * funcion para imprimir Ropa User y Ropa a la venta
     */
    public static void verRopa(String RopaUser[][]) {
        System.out.println("Tu ropa:");
        for (int i = 0; i < RopaUser.length; i++) {
            System.out.print("\n" + (i + 1) + " ");
            for (int j = 0; j < RopaUser[0].length; j++) {
                System.out.print(RopaUser[i][j] + " ");
            }
        }
        System.out.println("");
    }

    // Funcion para poner a la venta ropa.
    public static String[] ventaPrenda(String prendaVender[], String ropaUser[][], Scanner sc) {
        System.out.println("¿Que articulo quieres vender?");
        verRopa(ropaUser);
        int articulo = sc.nextInt();
        if (articulo <= ropaUser.length) {
            for (int i = 0; i < ropaUser[0].length; i++) {
                prendaVender[i] = ropaUser[articulo - 1][i];
            }
        }
        return prendaVender;
    }

    public static String[][] venderRopa(Scanner sc, String ropaUser[][], String ventaUser[][], String prendaVender[]) {
            System.out.println("¿Que precio quieres ponerle a tu " + prendaVender[0] + " "
                    + prendaVender[1] + "?");
            String precio = sc.next();
            ventaUser=arrayString2D(ventaUser, prendaVender);
            ventaUser[ventaUser.length - 1][ventaUser[0].length - 1] = precio;
        return ventaUser;
    }

    public static void main(String[] args) {
        /*
         * Necesito que Login==true, RopaUser[][]
         * Funcion para ver la ropa del user. HECHO
         * Funcion para poner RopaUser a la venta con precio. HECHO
         * Funcion para ver RopaUser a la venta. HECHO
         * Funcion para ver ropa que puedes comprar.
         * Funcion para comprar y que se añada a RopaUser.
         * Funcion para mensajes con vendedor/comprador.
         * Funcion para favoritos/carrito compra.
         */

        Scanner sc = new Scanner(System.in);
        String ropaUser[][] = { { "Sudadera", "Roja", "L" },
                { "Camiseta", "Blanca", "M" },
                { "Camiseta", "Negra", "L" },
                { "Pantalon", "Cargo Negro", "L" },
                { "Sudadera", "Negra", "L" } };
        String ropaVenta[][] = new String[1][4];
        String prendaVender[]= new String[3];
        boolean salir = false;
        String opcion;

        do {
            limpiarPantalla();
            switch (menu(sc)) {
                case "1", "Armario", "armario":
                    limpiarPantalla();
                    verRopa(ropaUser);
                    sc.nextLine();
                    break;
                case "2", "Vender", "vender":
                    limpiarPantalla();
                    System.out.println("MENÚ VENTAS: \n\t 1 - Vender ropa \n\t 2 - Ropa en venta.");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1", "vender", "Vender":
                            boolean vender = false;
                            while (vender == false) {
                                limpiarPantalla();
                                ventaPrenda(prendaVender, ropaUser, sc);
                                ropaVenta = venderRopa(sc, ropaUser, ropaVenta, prendaVender);
                                ropaUser = restarPrenda(ropaUser, prendaVender);
                                System.out.println("¿Quieres seguir vendiendo? (Si/No)");
                                opcion = sc.next();
                                if (opcion.equals("si") || opcion.equals("Si") || opcion.equals("SI")) {
                                    vender = false;
                                }else{
                                    vender = true;
                                }
                            }
                            break;
                        case "2":
                            limpiarPantalla();
                            verRopa(ropaVenta);
                            sc.nextLine();
                            break;
                    }
                    break;
                case "3", "Comprar", "comprar":
                    break;
                case "4", "Salir", "salir":
                    limpiarPantalla();
                    System.out.println("\t\tHas cerrado la aplicación.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no valida...");
            }
        } while (salir == false);

    }
}
