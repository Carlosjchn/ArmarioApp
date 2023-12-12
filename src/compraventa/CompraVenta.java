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
        if (dato[0] == null) {
            return array;
        } else {
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
    }
    // ===============================================================

    // =================== FUNCION -1 FILA ARRAY ============================
    public static String[][] restarPrenda(String[][] array, String dato[]) {
        if (dato[0] == null) {
            return array;
        } else {
            if (array.length == 1) {
                for (int i = 0; i < dato.length; i++) {
                    array[0][i] = null;
                }
                return array;
            } else {
                String dinamico[][] = new String[array.length - 1][array[0].length];
                boolean coincide = false;
                for (int i = 0; i < array.length; i++) {
                    if (dato[0] == array[i][0] && dato[1] == array[i][1] && dato[2] == array[i][2]) {
                        coincide = true;
                        i++;
                    }
                    for (int j = 0; j < array[0].length; j++) {
                        if (i != array.length) {
                            if (coincide == true && i != 0) {
                                dinamico[i - 1][j] = array[i][j];
                            } else {
                                dinamico[i][j] = array[i][j];
                            }
                        }
                    }
                }
                return dinamico;
            }
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
        boolean num = false;
        do {
            limpiarPantalla();
            System.out.println("¿Que articulo quieres elegir? \t" + (ropaUser.length + 1) + ". Salir");
            verRopa(ropaUser, saldo);
            if (sc.hasNextInt()) {
                int articulo = sc.nextInt();
                if (articulo == ropaUser.length + 1) {
                    num = true;
                    for (int i = 0; i < prendaVender.length; i++) {
                        prendaVender[i] = null;
                    }
                    return prendaVender;
                } else {
                    if (articulo <= ropaUser.length) {
                        for (int i = 0; i < prendaVender.length; i++) {
                            prendaVender[i] = ropaUser[articulo - 1][i];
                        }
                        num = true;
                    }
                }
            } else {
                sc.next();
            }
        } while (num == false);
        return prendaVender;
    }

    public static String[][] venderRopa(Scanner sc, String ropaUser[][], String ventaUser[][], String prendaVender[]) {
        boolean num = false;
        do{
        System.out.println("¿Que precio quieres ponerle a tu " + prendaVender[0] + " "
                + prendaVender[1] + "?");
        if (sc.hasNextInt()){
        int valor = sc.nextInt();
        String precio = valor + "";
        ventaUser = sumarPrenda(ventaUser, prendaVender);
        ventaUser[ventaUser.length - 1][ventaUser[0].length - 1] = precio;
        num = true;
        }else{
            sc.next();
        }
    }while(num == false);
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
                System.out.print("\t " + (i + 1) + ". " + usuarios[i]);
            }
            System.out.print("\t 4. Salir \n");
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
                case "4", "salir", "Salir":
                    done = true;
                    break;
                default:
                    System.out.println("Elige una opcion.");
                    sc.next();
            }
        }
        return ropaJuan;
    }

    public static int precio(String ropaCompra[][], String prendaComprar[]) {
        int precio = 0;
        String num = "";
        for (int i = 0; i < ropaCompra.length; i++) {
            if (prendaComprar[0] == ropaCompra[i][0] && prendaComprar[1] == ropaCompra[i][1]
                    && prendaComprar[2] == ropaCompra[i][2]) {
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

    public static String[][] comprar(String prendaComprar[], String ropaUser[][], String ropaCompra[][], int saldo[],
            int precio) {
        if (prendaComprar[0] != null) {
            saldo[0] = saldo[0] - precio;
            if (saldo[0] >= 0) {
                ropaCompra = restarPrenda(ropaCompra, prendaComprar);
                return ropaCompra;
            } else {
                System.out.println("No tienes suficiente saldo.");
                return ropaCompra;
            }
        } else {
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

    // ---------------- PROGRAMA MAIN ----------------
    public static void main(String[] args) {
        /*
         * Necesito que Login==true, RopaUser[][]
         * Funcion para ver la ropa del user. HECHO
         * Funcion para poner RopaUser a la venta con precio. HECHO
         * Funcion para ver RopaUser a la venta. HECHO
         * Funcion para ver ropa que puedes comprar. HECHO
         * Funcion para comprar y que se añada a RopaUser. HECHO
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
        String prendaElegida[] = new String[3];
        boolean salir = false;
        String opcion;

        do {
            limpiarPantalla();
            switch (menu(sc)) {
                case "1", "Armario", "armario":
                    limpiarPantalla();
                    verRopa(ropaUser, saldo);
                    System.out.println("\nPresiona Intro para continuar.");
                    sc.nextLine();
                    break;
                case "2", "Vender", "vender":
                    limpiarPantalla();
                    System.out.println("MENÚ VENTAS: \n\t 1 - Vender ropa \n\t 2 - Ropa en venta. \n\t 3 - Salir.");
                    opcion = sc.nextLine();
                    switch (opcion) {
                        case "1", "vender", "Vender":
                            boolean vender = false;
                            while (vender == false) {
                                limpiarPantalla();
                                reconPrenda(prendaElegida, ropaUser, sc, saldo);
                                if (prendaElegida[0] != null) {
                                    ropaVenta = venderRopa(sc, ropaUser, ropaVenta, prendaElegida);
                                    ropaUser = restarPrenda(ropaUser, prendaElegida);
                                    System.out.println("¿Quieres seguir vendiendo? (Si/No)");
                                    opcion = sc.next();
                                    if (opcion.equals("si") || opcion.equals("Si") || opcion.equals("SI")) {
                                        vender = false;
                                    } else {
                                        vender = true;
                                    }
                                } else {
                                    vender = true;
                                }
                            }
                            break;
                        case "2", "ropa en venta", "Ropa en venta":
                            limpiarPantalla();
                            verRopa(ropaVenta, saldo);
                            System.out.println("\n¿Quieres retirar alguna prenda? (Si/No)");
                            opcion = sc.next();
                            if (opcion.equals("si") || opcion.equals("Si") || opcion.equals("SI")) {
                                limpiarPantalla();
                                reconPrenda(prendaElegida, ropaVenta, sc, saldo);
                                ropaVenta = restarPrenda(ropaVenta, prendaElegida);
                                ropaUser = sumarPrenda(ropaUser, prendaElegida);
                            }
                            break;
                        case "3", "salir":
                            break;
                    }
                    break;
                case "3", "Comprar", "comprar":
                    limpiarPantalla();
                    // vuelvo a definir otra opcion como array para que se actualize en la funcion.
                    String opcion1[] = { "" };
                    String[][] ropaCompra = menuCompra(sc, usuarios, prendaElegida, ropaJuan, ropaManuel, ropaAlberto,
                            saldo, opcion1);
                    int precio = precio(ropaCompra, prendaElegida);
                    if (precio != 0) {
                        switch (opcion1[0]) {
                            case "1", "Juan", "juan":
                                ropaJuan = comprar(prendaElegida, ropaUser, ropaCompra, saldo, precio);
                                break;
                            case "2", "Manuel", "manuel":
                                ropaManuel = comprar(prendaElegida, ropaUser, ropaCompra, saldo, precio);
                                break;
                            case "3", "Alberto", "alberto":
                                ropaAlberto = comprar(prendaElegida, ropaUser, ropaCompra, saldo, precio);
                                break;
                        }
                        if (saldo[0] >= 0 || opcion1[0] == "1" || opcion1[0] == "2" || opcion1[0] == "3") {
                            ropaUser = sumarPrenda(ropaUser, prendaElegida);
                        } else {
                            saldo[0] = saldo[0] + precio;
                            System.out.println("No tienes saldo sufiente");
                            sc.next();
                        }
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
