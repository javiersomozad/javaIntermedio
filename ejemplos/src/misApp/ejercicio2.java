package misApp;

import java.util.Scanner;

public class ejercicio2 {
	static Scanner leer = new Scanner(System.in);
	
	static void mostrarNumeros() {
		int n, i;
		
		System.out.println("introduce un numero :");
		n = leer.nextInt();
		
		for (i=0; i <= n; i++) {
			System.out.println(i);
		}
	}
	
	static void edad() {
		int miEdad;
		
		System.out.println("Introduce la edad : ");
		miEdad = leer.nextInt();
		
		if (miEdad >= 18) {
			System.out.println("es mayor de edad");
		}
		else {
			System.out.println("No es mayor de edad");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op = 0;

		while (op != 3) {
			System.out.println("1. Mostrar numeros");
			System.out.println("2. edad");
			System.out.println("3. salida");
			System.out.println("Elige una opcion: ");
			op = leer.nextInt();
			
			switch(op) {
				case 1:
					mostrarNumeros();
					break;
				case 2:
					edad();
					break;
				case 3:
					break;
			}
		}
		leer.close();
	}
}
