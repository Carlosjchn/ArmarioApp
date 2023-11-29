package registrouser;
import java.util.Scanner;
public class prueba_registroUser {
	public static void main(String[] args) {
	   	Scanner sc = new Scanner (System.in);
		int campos=0;
    	int datos=0;
    	
    	String matriz [][] = new String [campos] [datos];
    	
    	for (int i = 0; i<campos; i++) { 
    		for (int j = 0; j<datos; j++) {
    			System.out.println (matriz [i] [j] = sc.nextLine());
    		}
    	}
	}

}
