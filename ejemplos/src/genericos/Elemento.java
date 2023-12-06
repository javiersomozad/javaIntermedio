package genericos;

public class Elemento <K,V> {
	K clave;
	V valor;

	public Elemento(K clave, V valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}
	public K getClave() {
		return clave;
	}
	public void setClave(K clave) {
		this.clave = clave;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Elemento [clave=" + clave + ", valor=" + valor + "]";
	}
	
	public V busca( Elemento[] tabla,K clave) {
		for (Elemento ele : tabla) {
			if (ele.clave == clave)
				return (V) ele.valor;
		}
		return (V) "no lo he encontrado";
		
	}

}
