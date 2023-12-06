package POO;

public class Persona {
	
	// Atributos
	private String nombre, dni, descripcion;
	private int edad;

	
	// Constructor
	public Persona (String nom, int e) {
		nombre = nom;
		edad = e;
	}

//	public Persona () {
//		nombre = "pepe";
//		edad =20;
//	}

	// Metodos
	public void IntroducirDNI (String d) {
		dni = d;
	}

	public void IntroducirDescripcion (String des) {
		descripcion = des;
	}
	
	public void CambiarEdad (int num) {
		edad = num;
	}
	
	public void MostrarDatos () {
		System.out.println("Nombre: " + nombre);
		System.out.println("DNI: " + dni);
		System.out.println("Edad: " + edad);
		System.out.println("Descripcion: " + descripcion);
	}

}
