package cierres;

import java.util.ArrayList;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crea un ArrayList con estos elementos
		// {1, 2, 3, 4}
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		arrL.add(1);
		arrL.add(2);
		arrL.add(3);
		arrL.add(4);
		
		arrL.forEach(n -> System.out.println(n));

		arrL.forEach(n -> {
			if (n % 2 == 0)
				System.out.println(n);
		});

	}

}
