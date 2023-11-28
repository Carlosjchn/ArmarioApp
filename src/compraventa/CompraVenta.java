package compraventa;

import java.util.Random;
import java.util.Scanner;

public class CompraVenta {

    // ------------------- FUNCIONES BACKGROUND -----------------------

    // ============= FUNCION PARA LIMPIAR CMD ==============
    public static final String LIMPIAR_CMD_WINDOW = "\033[H\033[2J";
    public static final String LIMPIAR_CMD_MACOS = "\u001b[2J";

    public static void limpiarPantalla() {
        System.out.println(LIMPIAR_CMD_MACOS);
        System.out.println(LIMPIAR_CMD_WINDOW);
    }
    // ======================================================

    // ================= FUNCION +1 FILA ARRAY ====================
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
            for (int k = 0; k < dato.length; k++) {
                dinamico[dinamico.length - 1][k] = dato[k];
            }
            return dinamico;
        }
    }
    // ===============================================================

    // =================== FUNCION -1 FILA ARRAY ============================
    public static String[][] restarPrenda(String[][] array, String dato[]) {
        if (array.length == 1) {
            for (int i = 0; i < dato.length; i++) {
                array[0][i] = null;
            }
            return array;
        } else {
            String dinamico[][] = new String[array.length - 1][array[0].length];
            boolean coincide = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (dato[0] == array[i][j]) {
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
    }
    // ======================================================================

    // ---------------- FUNCIONES PARA OPCIONES APLICACIÓN. -----------------

    // ================ FUNCION IMPRIMIR MENU =============
    public static String menu(Scanner sc) {
        System.out.println("Opciones: \n \t 1 - Armario. \n\t 2 - Vender \n\t 3 - Comprar. \n\t 4 - Salir.");
        String opcion = sc.nextLine();
        return opcion;
    }
    // =====================================================

    // ========== FUNCION IMPRIMIR ARRAYS ROPA =============
    public static void verRopa(String ropaUser[][], int[] saldo) {
        if (ropaUser[0][0] == null) {
            System.out.println("No tienes ropa registrada.");
        } else {
            if (ropaUser[0].length == 4) {
                System.out.println(
                        "Tu ropa: \n  Prenda \t Color \t Talla \t Precio(euros) \t Tú saldo:" + saldo[0] + " euros");
            } else {
                System.out.println("Tu ropa: \n  Prenda \t Color \t Talla \t Tú saldo:" + saldo[0] + " euros");
            }
            for (int i = 0; i < ropaUser.length; i++) {
                System.out.print("\n" + (i + 1) + " ");
                for (int j = 0; j < ropaUser[0].length; j++) {
                    System.out.print(ropaUser[i][j] + "\t ");
                }
            }
            System.out.println("");
        }
    }
    // =====================================================

    // ============== FUNCIONES VENTA ===================
    public static String[] reconPrenda(String prendaVender[], String ropaUser[][], Scanner sc, int[] saldo) {
        boolean num=false;
        do{
        limpiarPantalla();
        System.out.println("¿Que articulo quieres elegir?");
        verRopa(ropaUser, saldo);
        if(sc.hasNextInt()){
        num=true;
        int articulo = sc.nextInt();
        if (articulo <= ropaUser.length) {
            for (int i = 0; i < prendaVender.length; i++) {
                prendaVender[i] = ropaUser[articulo - 1][i];
            }
        }
        }
        }while(num==false);
        return prendaVender;
    }

    public static String[][] venderRopa(Scanner sc, String ropaUser[][], String ventaUser[][], String prendaVender[]) {
        System.out.println("¿Que precio quieres ponerle a tu " + prendaVender[0] + " "
                + prendaVender[1] + "?");
        String precio = sc.next();
        ventaUser = sumarPrenda(ventaUser, prendaVender);
        ventaUser[ventaUser.length - 1][ventaUser[0].length - 1] = precio;
        return ventaUser;
    }

    // ====================================================

    // =============== FUNCIONES COMPRA =====================
    public static String[][] menuCompra(Scanner sc, String[] usuarios, String prendaVender[], String[][] ropaJuan,
            String[][] ropaManuel,
            String[][] ropaAlberto, int[] saldo, String[] opcion) {
        boolean done = false;
        while (done == false) {
            limpiarPantalla();
            System.out.println("Elige un usuario para ver su Armario:\n");
            for (int i = 0; i < usuarios.length; i++) {
                System.err.print("\t " + (i + 1) + ". " + usuarios[i]);
            }
            opcion[0] = sc.next();
            switch (opcion[0]) {
                case "1", "Juan", "juan":
                    done = true;
                    limpiarPantalla();
                    reconPrenda(prendaVender, ropaJuan, sc, saldo);
                    return ropaJuan;
                case "2", "Manuel", "manuel":
                    done = true;
                    limpiarPantalla();
                    reconPrenda(prendaVender, ropaManuel, sc, saldo);
                    return ropaManuel;
                case "3", "Alberto", "alberto":
                    done = true;
                    limpiarPantalla();
                    reconPrenda(prendaVender, ropaAlberto, sc, saldo);
                    return ropaAlberto;
                default:
                    System.out.println("Elige una opcion.");
                    sc.next();
            }
        }
        return ropaJuan;
    }

    public static int precio(String ropaCompra[][], String prendaVender[]) {
        int precio = 0;
        String num = "";
        for (int i = 0; i < ropaCompra.length; i++) {
            if (prendaVender[0] == ropaCompra[i][0]) {
                num = ropaCompra[i][3];
            }
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) > '0' && num.charAt(i) < '9') {
                precio = (precio * 10) + ((num.charAt(i) - '0'));
            }
        }
        return precio;
    }

    public static String[][] comprar(String prendaVender[], String ropaUser[][], String ropaCompra[][], int saldo[],
            int precio) {
        saldo[0] = saldo[0] - precio;
        if (saldo[0] >= 0) {
            ropaCompra = restarPrenda(ropaCompra, prendaVender);
            return ropaCompra;
        } else {
            System.out.println("No tienes suficiente saldo.");
            return ropaCompra;
        }
    }
    // ==================================================================

    // ======= Generar precios random ========
    public static int cami(Random r) {
        int cami = r.nextInt(25 - 10) + 10;
        return cami;
    }

    public static int suda(Random r) {
        int suda = r.nextInt(40 - 20) + 20;
        return suda;
    }

    public static int pant(Random r) {
        int pant = r.nextInt(40 - 25) + 25;
        return pant;
    }
    // ========================================

    // ------------------------------------------------- PROGRAMA MAIN
    // ------------------------------------------------------------
    public static void main(String[] args) {
        /*
         * Necesito que Login==true, RopaUser[][]
         * Funcion para ver la ropa del user. HECHO
         * Funcion para poner RopaUser a la venta con precio. HECHO
         * Funcion para ver RopaUser a la venta. HECHO
         * Funcion para ver ropa que puedes comprar. HECHO
         * Funcion para comprar y que se añada a RopaUser.
         * Funcion para mensajes con vendedor/comprador.
         * Funcion para favoritos/carrito compra.
         */
        Random r = new Random();
        // defino el saldo como un array para poder actualizarlo en las funcione usando
        // la misma memoria.
        int saldo[] = { 200 };
        Scanner sc = new Scanner(System.in);
        String ropaUser[][] = { { "Sudadera", "Roja", "M" },
                { "Camiseta", "Blanca", "M" },
                { "Camiseta", "Negra", "L" },
                { "Pant Cargo", "Negro", "L" },
                { "Sudadera", "Negra", "L" } };

        String[] usuarios = { "Juan", "Manuel", "Alberto" };
        String ropaJuan[][] = { { "Pant  Chino", "Beige", "M", pant(r) + "" },
                { "Sudadera", "Negra", "L", suda(r) + "" },
                { "Camiseta", "Blanca", "L", cami(r) + "" },
                { "Sudadera", "Blanca", "M", suda(r) + "" },
                { "Pant Cargo", "Verde", "L", pant(r) + "" } };

        String ropaManuel[][] = { { "Sudadera", "Negra", "S", suda(r) + "" },
                { "Camiseta", "Blanca", "M", cami(r) + "" },
                { "Camiseta", "Azul", "S", cami(r) + "" },
                { "Pant Vaquero", "Azul", "L", pant(r) + "" } };

        String ropaAlberto[][] = { { "Camisa", "Blanca", "L", cami(r) + "" },
                { "Camiseta", "Azul", "L", cami(r) + "" },
                { "Pant Vaquero", "Negro", "XL", pant(r) + "" },
                { "Sudadera", "Azul", "XL", suda(r) + "" } };

        String ropaVenta[][] = new String[1][4];
        String prendaVender[] = new String[3];
        boolean salir = false;
        String opcion;

        do {
            limpiarPantalla();
            switch (menu(sc)) {
                case "1", "Armario", "armario":
                    limpiarPantalla();
                    verRopa(ropaUser, saldo);
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
                                reconPrenda(prendaVender, ropaUser, sc, saldo);
                                ropaVenta = venderRopa(sc, ropaUser, ropaVenta, prendaVender);
                                ropaUser = restarPrenda(ropaUser, prendaVender);
                                System.out.println("¿Quieres seguir vendiendo? (Si/No)");
                                opcion = sc.next();
                                if (opcion.equals("si") || opcion.equals("Si") || opcion.equals("SI")) {
                                    vender = false;
                                } else {
                                    vender = true;
                                }
                            }
                            break;
                        case "2":
                            limpiarPantalla();
                            verRopa(ropaVenta, saldo);
                            System.out.println("\n¿Quieres retirar alguna prenda? (Si/No)");
                            opcion = sc.next();
                            if (opcion.equals("si") || opcion.equals("Si") || opcion.equals("SI")) {
                                limpiarPantalla();
                                reconPrenda(prendaVender, ropaVenta, sc, saldo);
                                ropaVenta = restarPrenda(ropaVenta, prendaVender);
                                ropaUser = sumarPrenda(ropaUser, prendaVender);
                            }
                            break;
                    }
                    break;
                case "3", "Comprar", "comprar":
                    limpiarPantalla();
                    // vuelvo a definir otra opcion como array para que se actualize en la funcion.
                    String opcion1[] = { "" };
                    String[][] ropaCompra = menuCompra(sc, usuarios, prendaVender, ropaJuan, ropaManuel, ropaAlberto,
                            saldo, opcion1);
                    int precio = precio(ropaCompra, prendaVender);
                    switch (opcion1[0]) {
                        case "1", "Juan", "juan":
                            ropaJuan = comprar(prendaVender, ropaUser, ropaCompra, saldo, precio);
                            break;
                        case "2", "Manuel", "manuel":
                            ropaManuel = comprar(prendaVender, ropaUser, ropaCompra, saldo, precio);
                            break;
                        case "3", "Alberto", "alberto":
                            ropaAlberto = comprar(prendaVender, ropaUser, ropaCompra, saldo, precio);
                            break;
                    }
                    if (saldo[0] >= 0) {
                        ropaUser = sumarPrenda(ropaUser, prendaVender);
                    } else {
                        saldo[0] = saldo[0] + precio;
                    }
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
