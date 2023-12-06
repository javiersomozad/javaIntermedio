package genericos;

public class Genericos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elemento[] miTabla = new Elemento[5];
		miTabla[0] = new Elemento("0","clave 0");
		miTabla[1] = new Elemento("1","clave 1");
		miTabla[2] = new Elemento("2","clave 2");
		miTabla[3] = new Elemento("tres","3");
		miTabla[4] = new Elemento("4","clave 4");
		for (Elemento ele : miTabla) {
			System.out.println(ele.toString());
		}

		System.out.println(miTabla[2].busca(miTabla,"tres"));

	}

}