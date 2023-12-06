package misApp;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner leer = new Scanner(System.in);
		
		n = 0;
		while (true) {

			System.out.println("Escribe un numero del 1 al 10");
			n = leer.nextInt();

			switch (n) {
				case 1:
					System.out.println("has elegiodo la opoción 1");
					break;
				case 2:
					System.out.println("has elegiodo la opoción 2");
					break;
				case 3:
					System.out.println("has elegiodo la opoción 3");
					break;
				default:
					System.out.println("no has elegido ninguna opcion");
			}
			break;
		}
//		if (n <= 10) {
//			System.out.println("El valor es correcto :" + n);
//		}
//		else  {
//			System.out.println("El valor no es correcto :" + n);			
//		}
//		
//		System.out.println("Escribe un numero del 1 al 10");
//		
		
//		System.out.println("la longitud de la cadena es :" +cadena.replace('o','O'));
	}

}
