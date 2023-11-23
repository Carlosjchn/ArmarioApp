package recursos;

public class Recursos {

    public static int[] arrayInt1D(int[] array, int dato) {
        int dinamico[] = new int[array.length + 1];
        int i;
        for (i = 0; i < array.length; i++) {
            dinamico[i] = array[i];
        }
        dinamico[i + 1] = dato;
        return dinamico;
    }

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

    public static String[] arrayString1D(String[] array) {
        String dinamico[] = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            dinamico[i] = array[i];
        }
        return dinamico;
    }

    public static String[][] arrayString2D(String[][] array, String dato[]) {
        String dinamico[][] = new String[array.length + 1][array[0].length];
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

}
