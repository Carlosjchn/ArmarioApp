package recursos;

public class Recursos {
    // Aclaración: array[FILAS][COLUMNAS]
    // Esta función aumenta el tamaño del array cada vez que se añade 1 dato nuevo.
    public static int[] arrayInt1D(int[] array, int dato) {
        int dinamico[] = new int[array.length + 1];
        int i;
        for (i = 0; i < array.length; i++) {
            dinamico[i] = array[i];
        }
        dinamico[dinamico.length - 1] = dato;
        return dinamico;
    }

    // Esta funcion aumenta el tamaño de FILAS en 1 cada vez que se añade una serie
    // de datos nuevos, el array dato[] debe ser igual al numero de COLUMNAS de
    // array[][].
    public static int[][] arrayInt2D(int[][] array, int dato[]) {
        int dinamico[][] = new int[array.length + 1][array[0].length];
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[0].length; j++) {
                dinamico[i][j] = array[i][j];
            }
        }
        for (int k = 0; k < dinamico[0].length; k++) {
            dinamico[dinamico.length - 1][k] = dato[k];
        }
        return dinamico;
    }

    // Esta función aumenta el tamaño del array cada vez que se añade 1 dato nuevo.
    public static String[] arrayString1D(String[] array, String dato) {
        String dinamico[] = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            dinamico[i] = array[i];
        }
        dinamico[dinamico.length - 1] = dato;
        return dinamico;
    }

    // Esta funcion aumenta el tamaño de FILAS en 1 cada vez que se añade una serie
    // de datos nuevos, el array dato[] debe ser igual al numero de COLUMNAS de
    // array[][].
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
            for (int k = 0; k < dinamico[0].length; k++) {
                dinamico[dinamico.length - 1][k] = dato[k];
            }
            return dinamico;
        }
    }

}
