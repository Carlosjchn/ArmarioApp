package registrouser;
import java.util.Scanner;
public class RegistroUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
    	texto ("Bienvenido a tu ArmarioApp \n" +
    			"1. Iniciar Sesion \n" +
    			"2. Crear cuenta \n " +
    			"Elija 1 si ya tiene una cuenta de ArmarioApp o 2 si desea crear una nueva cuenta: ");
    	
    	int opcion = sc.nextInt();
   
    	if (opcion==1) {
    		texto ("Introduzca nombre de Usuario: ");
    		obtenerDatoString (sc);
    		texto("Introduzca Contraseña: ");
    		obtenerDatoString (sc);
    	} 
    	if(opcion==2) {
    		texto("Te damos la bienvenida al proceso de creacion de cuenta de tu ArmarioApp, rellene los siguientes datos para su alta: \n " +
    				"Nombre: ");
    		obtenerDatoString (sc);
    		texto ("Contraseña: ");
    		obtenerDatoString (sc);
    		texto ("Correo electrónico: ");
    		obtenerDatoString (sc);
    		texto ("Fecha de Nacimiento: ");
    		obtenerDatoint (sc);
    		texto ("Sexo: ");
    		
    	}
	
	
	}
    
    public static void texto(String texto) {
    	System.out.println(texto);
	}
    
    public static String obtenerDatoString(Scanner sc) {
    	String dato = sc.next();
    	return dato;
    }
    
    public static int obtenerDatoint (Scanner sc) {
    	int dato = sc.nextInt();
    	return dato;
    }

}
