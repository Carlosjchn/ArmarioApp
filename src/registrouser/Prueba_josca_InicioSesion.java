package registrouser;
import java.util.Scanner;
public class Prueba_josca_InicioSesion {

	public static void main(String[] args) {

				Scanner sc = new Scanner (System.in);
		    	System.out.println("Bienvenido a tu ArmarioApp, registre sus datos e inicie sesión: \n" +
		    					   " Crear cuenta: ");
		    	    	
		    	String datos[] = rellenarDatos (sc);
		    		
		    	System.out.println("\n \n" +
		    					   "Inicio de sesion: ");
		    	
		    	boolean ok = true;
		    	do {
		    		System.out.println("Introduzca nombre de Usuario: ");
		    		String introduceUsuario = sc.next();
		    		if (introduceUsuario.equals(datos[0])) {
		    			System.out.println("Introduzca contraseña: ");
		    			String introduceContraseña = sc.next();
		    			if (introduceContraseña.equals(datos[2])) {
		    				System.out.println("Has iniciado correctamente sesion.");
		    				ok=false;
		    			} else {
		    				System.out.println("Contraseña incorrecta, intentelo de nuevo: ");
		    				
		    			}
		    		}else {
		    			System.out.println("Error, introduzca de nuevo su nombre de Usuario: ");
		    		}
		    	}while (ok==true);
		    		
			}

		public static String[] rellenarDatos (Scanner sc) {
			String datos [] = new String [4];
		    				   		        
		    			System.out.println(" Introduzca su nombre de Usuario: ");
		                	String usuario = sc.next();
		                	datos [0] = usuario;
		                
		                System.out.println(" Introduzca su nombre: ");
		                	String nombre = sc.next();
		                	datos [1] = nombre;
		            
		                System.out.println(" Introduzca su Contraseña: ");
		                	String contraseña = sc.next();
		                	datos [2] = contraseña;
		        
		                System.out.println(" Introduzca su correo electrónico: ");
		                	String correo = sc.next();
		                	datos [3] = correo;
		              
		    		
		    		System.out.println("Bienvenido a su nueva cuenta " + datos[0] + ", sus datos de alta son: ");
		    		
		    		for (int i =0; i < datos.length ; i++) {
		    			System.out.print( datos[i] + " ");
		    		}
		    		return datos;
			}

			public static String[][] registroUsuarios (String[][] array, String dato[], Scanner sc) {
				String datos[] = rellenarDatos(sc);
				
				if (array[0][0] == null) {
		            for (int k = 0; k < dato.length; k++) {
		                array[0][k] = datos[k];
		            }
		            return array;
		        
				} else {
		            String dinamico[][] = new String [array.length + 1][array[0].length];
					for (int i = 0; i < array.length; i++) {
		                for (int j = 0; j < array[0].length; j++) {
		                    dinamico[i][j] = array[i][j];
		                }
		            }
		            for (int k = 0; k < dinamico[0].length; k++) {
		                dinamico[dinamico.length - 1][k] = datos[k];
		            }
		            return dinamico;
		        } 		
	}

}
