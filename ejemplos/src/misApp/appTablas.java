package misApp;

public class appTablas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numeros = {{1,2,3,4,5},{10,20,30,40,50}};
		

		for (int i=0; i<2 ; i++) {
			System.out.println(numeros[i]);
			for (int j=0; j<5; j++) {
				System.out.print(numeros[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}

		numeros = new int[4][5];
		for (int i=0; i<numeros.length ; i++) {
			System.out.println(numeros[i]);
			for (int j=0; j< numeros[0].length; j++) {
				System.out.print(numeros[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}

		
	}

}
