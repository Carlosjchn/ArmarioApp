package registrouser;
import java.util.Scanner;
public class RegistroUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
    	System.out.println("Bienvenido a tu ArmarioApp, registre sus datos e inicie sesión: \n" +
    					   " 1. Crear cuenta \n" +
    					   " 2. Inicio de sesión \n ");
    	
    	int opcion = sc.nextInt();    	
    	String datos [] = new String [3];
    		if (opcion==1) {		   		        
    			System.out.println("Introduzca su nombre: ");
                	String nombre = sc.next();
                	datos [0] = nombre;
            
                System.out.println("Introduzca su contraseña: ");
                	String contraseña = sc.next();
                	datos [1] = contraseña;
        
                System.out.println("Introduzca su correo electrónico: ");
                	String correo = sc.next();
                	datos [2] = correo;		  		
              	}

    		for (int i =0; i< datos.length;i++) {
    		System.out.println(datos[i]);
    		}
    	
    	
    		if (opcion==2) {
    			String matriz [] [] = new String [2] [2];
    			for (int i=0; i<matriz.length; i++){
          
                 System.out.println("Introduzca nombre de Usuario: ");
                 String nombre = sc.nextLine();
                 System.out.println("Introduzca Contraseña: ");
                 String edad = sc.nextLine();
           
                 matriz [i] [0] = nombre;
                 matriz [i] [1] = edad;
                 
                 if (matriz [i][0]==matriz [i][1]){
                     System.out.println("enhorabuena has iniciado sesion");
	
                 }
    			}
    	   }
	}
	public static String [] rellenarDatos (Scanner sc) {

        String datos [] = new String [3];
      
        System.out.println("Introduzca su nombre: ");
            String nombre = sc.next();
            datos [0] = nombre;
        
        System.out.println("Introduzca su contraseña: ");
            String contraseña = sc.next();
            datos [1] = contraseña;
    
        System.out.println("Introduzca su correo electrónico: ");
            String correo = sc.next();
            datos [2] = correo;
        return datos;
		}
	
	
	public static String obtenerDatoString(String texto, Scanner sc) {
    	System.out.println(texto);
    	String dato = sc.next();
    	return dato;
    }
             }
             
 