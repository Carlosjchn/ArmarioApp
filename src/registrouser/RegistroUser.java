package registrouser;
import java.util.Scanner;
public class RegistroUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
    	System.out.println("Bienvenido a tu ArmarioApp, registre sus datos e inicie sesión: \n" +
    					   " Crear cuenta: ");
    	     
    	
    	String usuariosRegistrados [][]= new String [1][4];
    	String datos [] = new String [4];
    	
    	
    	
    	int a = 0;
    	while (a<1) {		
    		
    		usuariosRegistrados = almacenarDatos (usuariosRegistrados, datos, sc);
    		
    		int b=1;
    		while (b==1) {
    			System.out.println("\n Desea resgistrar mas usuarios: S/N ");
    		
    			char opcion = sc.next().charAt(0);
    			switch (opcion) {
    				case 'S', 's':
    					b=2;
    					break;
    				case 'N', 'n':
    					a = 2;
    					b=3;
    					break;
    				default:
    					System.out.println("Error, no has seleccionado una opción valida.");
    			}
    		}
    	}
    	    	
    	System.out.println("Iniciemos sesion: ");
    	boolean ok = true;
    	do {
    
    		System.out.println("Introduzca nombre de Usuario ya creado: ");
    		
    		String introduceUsuario = sc.next();
    		
    		for (int i = 0; i<usuariosRegistrados.length; i++) {
    			if (introduceUsuario.equals(datos [0])) {
    				System.out.println("Introduzca contraseña: ");
    				String introduceContraseña = sc.next();
    				
    				if (introduceContraseña.equals(usuariosRegistrados [i][2])) {
    					System.out.println("Has iniciado correctamente sesion.");
    					ok=false;
    				
    				} else {
    					System.out.println("Contraseña incorrecta, intentelo de nuevo: ");
    				}
    				
    			}else {
    				System.out.println("Error, introduzca de nuevo su nombre de Usuario: ");
    			}
    		}
    	} while (ok==true);
    	
    	}

	
	
	
	public static String[] rellenarDatos (Scanner sc) {
	String datos [] = new String [4];
    				   		        
    			System.out.println("\nIntroduzca su nombre de Usuario: ");
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
                System.out.println("    ");
              
                return datos;
    }
    		
	
	
	
	
	public static String[][] almacenarDatos (String[][] usuarioRegistrado, String datos[], Scanner sc) {
		datos = rellenarDatos(sc);
		
		if (usuarioRegistrado[0][0] == null) {
            System.out.print("Primer usuario:   ");
			for (int k = 0; k < datos.length; k++) {
            	 System.out.print( usuarioRegistrado[0][k] = datos[k] + "   ");
            }
           
            return usuarioRegistrado;
        
		} else {
			String usuarioNuevo[][] = new String [usuarioRegistrado.length + 1] [usuarioRegistrado[0].length];
			
						
			for (int i = 0; i < usuarioRegistrado.length; i++) {
                System.out.print("Usuario numero " + (i+1) + "   ");
				for (int j = 0; j < usuarioRegistrado[0].length; j++) {
                   
                	System.out.print(usuarioNuevo[i][j] = usuarioRegistrado [i] [j]);
                	
               }
				System.out.println("   ");
			}
            System.out.print("\nNuevo usuario:   ");
			for (int k = 0 ; k < usuarioNuevo[0].length ; k++) {
                System.out.print( usuarioNuevo [usuarioNuevo.length - 1] [k] = datos[k] + "   ");
            }
            return usuarioNuevo;
        }
	}






}

   