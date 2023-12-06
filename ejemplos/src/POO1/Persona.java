package POO1;

public class Persona {
	
	// Atributos
	private String nombre, dni, descripcion;
	private int edad;
	private Vehiculo v;

	
	// Constructor
	// sin vehiculo
	public Persona (String nom, int e) {
		nombre = nom;
		edad = e;
	}

	// con bici
	public Persona (String nom, int e, String modelo, double precio) {
		nombre = nom;
		edad = e;
		v = new Bici(modelo, precio);
//		v = new Vehiculo();
	}

	// con moto
	public Persona(String nom, int e, String marca, int cc) {
		nombre = nom;
		edad = e;
		v = new Moto(marca, cc);
	}
		
	// Metodos
	public void introducirDNI (String d) {
		dni = d;
	}

	public void introducirDescripcion (String des) {
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
	
	public Vehiculo ObtenerMiVehiculo() {
		return v;
	}
	
	

}
