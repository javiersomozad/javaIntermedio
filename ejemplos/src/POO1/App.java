package POO1;

public class App {

	public static void main(String[] args) {
		
		Persona[] listaPersonas = new Persona[3];
		
		// Persona sin vehiculo
		listaPersonas[0] = new Persona("Juan", 23);
				
		// Persona con Bici
		listaPersonas[1]  = new Persona("Manuel", 27, "Mountain Bike", 999.99);

		// Persona con Moto
		listaPersonas[2]  = new Persona("Jose", 25, "Honda", 500);

		// introduzco datos de las personas
		listaPersonas[0].introducirDNI("1234");
		listaPersonas[0].introducirDescripcion("Esta persona no tiene Vehiculo");

		listaPersonas[1].introducirDNI("1235");
		listaPersonas[1].introducirDescripcion("Esta persona tiene bici");

		listaPersonas[2].introducirDNI("1236");
		listaPersonas[2].introducirDescripcion("Esta persona tiene moto");
		
		//mostrar datos
		
		for (Persona per : listaPersonas) {
			per.MostrarDatos();
			if (per.ObtenerMiVehiculo() != null)
				System.out.println(per.ObtenerMiVehiculo().obtenerVehiculo());
			else
				System.out.println("esta persona va andando");
			System.out.println();
		}
		
	}

}
