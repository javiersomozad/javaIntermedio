package Enumeraciones;
import java.util.*;

public class Iteradores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<String> ejem = new ArrayList<String>();
		
		ejem.add("Item 1");
		ejem.add("Item 2");
		ejem.add("Item 3");
		ejem.add("Item 4");
		
		Iterator<String> iterator = ejem.iterator();
		
		while (iterator.hasNext() ) {
			System.out.println("valor del Elemento = " + iterator.next());
		}
		
		for (iterator = ejem.iterator(); iterator.hasNext();) {
			  System.out.println("Element II Value= " + iterator.next());
		}
		
		for (String s : ejem) {
			  System.out.println("Element III Value= " + s);
		}
		
		List<String> words = Arrays.asList("esto","es","un","ejemplo");
		List<Integer> wordLenths = words.stream().map(String::length).toList();
		
		int z = 0;
		for (int i : wordLenths) {
			  System.out.println("la logitud es = " + i);
			  z += i;
		}
		System.out.println("la logitud total es = " + z);
		
		int sum = wordLenths.stream().reduce(0, (a,b) -> a+b);
		System.out.println("la logitud total es = " + sum);
		
		
	}

}
