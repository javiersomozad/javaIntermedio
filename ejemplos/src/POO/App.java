package POO;

public class App {

	public static void main(String[] args) {
		
		Persona persona = new Persona("Javier",50);
		persona.IntroducirDNI("12345");
		persona.IntroducirDescripcion("esta es una persona");
		persona.CambiarEdad(18);
		persona.MostrarDatos();
	}

}
