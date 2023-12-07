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
    	
    	if (opcion==2) {
    		
    		String almacenarDatos [] = new String [3];
    		
    		System.out.println("Pon un nombre: ");
    		String datoNombre = sc.next();
    		almacenarDatos [0] = datoNombre;

    		System.out.println("Pon una contraseña: ");
    		String datoContraseña = sc.next();
    		almacenarDatos [1] = datoContraseña;

    		System.out.println("Pon un correo: ");
    		String datoCorreo = sc.next();
    		almacenarDatos [2] = datoCorreo;

    		String  crearUsuario[] = almacenarDatos;
    	
    		
    		for (int i = 0; i< crearUsuario.length; i++)
    			System.out.println(crearUsuario[i]);
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
      
   /* public static String [][] guardarDatos (int campos, int datos, Scanner sc1) {
    	Scanner sc1 = new Scanner (System.in);
     	String nombre = sc1.nextLine();
    	String matriz [][] = new String [campos] [datos];
    	for (int i = 0; i<campos; i++) {	
    */ 	
	}