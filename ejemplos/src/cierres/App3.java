package cierres;

public class App3 {

	interface FuncInter1{
		double operation(int a, int b);
	}

	interface FuncInter2 {
		void sayMessage(String message);
	}

	private static double operate(int a, int b, FuncInter1 fobj)
	{
		return fobj.operation(a, b);
	}

	public static void main(String args[])
	{
		FuncInter1 add = (int x, int y) -> x + y;

		FuncInter1 multiply = (int x, int y) -> x * y;

		FuncInter1 resta = (int x, int y) -> x - y;

		FuncInter1 div = (int x, int y) ->(double)x / y;

//		App3 tobj = new App3();

//		System.out.println("La suma es : "
//						+ tobj.operate(6, 3, add));
//
//		System.out.println("La multiplicación es : "
//						+ tobj.operate(6, 3, multiply));

		// ahora la expresión lambda con un solo parametro
		FuncInter2 fobj = m
			-> {
				System.out.println("El resultado de la operacion es : " + m);
				};
//		fobj.sayMessage("Geek");
		
//			fobj.sayMessage(""+tobj.operate(6, 3, add));
//			fobj.sayMessage(""+tobj.operate(6, 3, multiply));
//			fobj.sayMessage(""+tobj.operate(6, 3, resta));
//			fobj.sayMessage(""+tobj.operate(6, 3, div));
		
			fobj.sayMessage(""+operate(6, 3, add));
			fobj.sayMessage(""+operate(6, 3, multiply));
			fobj.sayMessage(""+operate(6, 3, resta));
			fobj.sayMessage(""+operate(5, 3, div));
		}

}
