package cierres;

public interface FuncInterface {
	void miFun(int x);
	
	default void otraFun() {
		System.out.println("otro mensaje");
	}
}
