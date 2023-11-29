package registrouser;
import java.util.Scanner;
public class RegistroUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
    	System.out.println("Bienvenido a tu ArmarioApp \n" +
    			"1. Iniciar Sesion \n" +
    			"2. Crear cuenta \n " +
    			"Elija 1 si ya tiene una cuenta de ArmarioApp o 2 si desea crear una nueva cuenta: ");
    	
    	int opcion = sc.nextInt();
   
    	if (opcion==1) {
    		obtenerDatoString ("Introduzca nombre de Usuario: ", sc);
    		obtenerDatoString ("Introduzca Contraseña: ", sc);
    	} 
    	
    	if(opcion==2) {
    		obtenerDatoString ("Te damos la bienvenida al proceso de creacion de cuenta de tu ArmarioApp, rellene los siguientes datos para su alta: \n" +
    					       "Nombre: ", sc);
    		obtenerDatoString ("Contraseña", sc);
    		obtenerDatoString ("Correo electrónico: ", sc);
    		obtenerDatoint ("Fecha de Nacimiento: ", sc);
    		obtenerDatoString ("Sexo: ", sc);
       	}
	
	}
       
    public static String obtenerDatoString(String texto, Scanner sc) {
    	System.out.println(texto);
    	String dato = sc.next();
    	return dato;
    }
    
    public static int obtenerDatoint (String texto, Scanner sc) {
    	System.out.println(texto);
    	int dato = sc.nextInt();
    	return dato;
    }
    
    
}
