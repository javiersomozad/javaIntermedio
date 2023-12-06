package Enumeraciones;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demarcacion delantero = Demarcacion.DELANTERO;
		Demarcacion defensa = Demarcacion.DEFENSA;
				
		// Devuelve un String con el nombre de la constante
		System.out.println("delantero.name()= "+delantero.name());
		System.out.println("defensa.toString()= "+defensa.toString());
				
		//  Devuelve un entero con la posición de la constante según está declarada.
		System.out.println("delantero.ordinal()= "+delantero.ordinal());
				
		// Compara el enum con el parámetro según el orden en el que están declaradas las constantes. 
		System.out.println("delantero.compareTo(portero)= "+delantero.compareTo(defensa));
		System.out.println("delantero.compareTo(delantero)= "+delantero.compareTo(delantero));
				
		// Recorre todas las constantes de la enumeración
		for(Demarcacion d: Demarcacion.values()){
			System.out.println(d.toString()+" - ");
		}
	}

}
