package POO1;

public class Moto implements Vehiculo {
	// Atributos
	String marca;
	int cc;
	
	// constructor
	public Moto (String marca, int cc) {
		this.marca = marca;
		this.cc = cc;
	}
	
	// metodos
	public String obtenerMarca() {
		return marca;
	}
	
	public int obtenerCC( ) {
		return cc;
	}

	@Override
	public String obtenerVehiculo() {
		// TODO Auto-generated method stub
		return "Moto Marca : " + marca + "\n" + "cc : " + cc;
	}
}
