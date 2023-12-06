package cierres;

public class App1 {

	public static void miMetodo(FuncInterface parametro) {
		// me gustaria pasar una función e imprimir el resulatado
		parametro.miFun(4);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		miMetodo((int x)->System.out.println("El resultado de la funcion es : "+ x));
	}
	
}
