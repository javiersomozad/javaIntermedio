package POO1;

public class Bici implements Vehiculo {
	// Atributos
	String modelo;
	double precio;
	
	// constructor
	public Bici (String m, double p) {
		modelo = m;
		precio = p;
	}
	
	// metodos
	public String obtenerModelo() {
		return modelo;
	}
	
	public double obtenerPrecio( ) {
		return precio;
	}

	@Override
	public String obtenerVehiculo() {
		// TODO Auto-generated method stub
		return "Bici Modelo : " + modelo + "\n" + "precio : " + precio;
		//return super.obtenerVehiculo();
	}
	
	
}
