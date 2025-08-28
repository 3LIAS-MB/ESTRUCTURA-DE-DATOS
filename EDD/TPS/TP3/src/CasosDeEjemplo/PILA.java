package CasosDeEjemplo;

public class PILA {
	private int[] contenedor;
	private int cuenta;
	private int capacidad;
	
	public PILA() {
		this.cuenta = 0;
		this.capacidad = 10;
		this.contenedor = new int[capacidad];
	}
	
	public PILA(int capacidad) {
		this.cuenta = 0;
		this.capacidad = 10;
		this.contenedor = new int[capacidad];
	}
	
	public boolean estaLlena() { // empty
		return this.cuenta >= capacidad;
	}
	
	public boolean estaVacia() { // 
		return this.cuenta <= 0;
	}
	
	public void push(int numero) {
		if(this.estaLlena()) {	
			throw new RuntimeException("Error la pila esta llena");
		}
		this.contenedor[cuenta] = numero;
		++this.cuenta;
	}
	
	public int pop() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error la pila esta llena");
		}
		--cuenta;
		return this.contenedor[cuenta]; // [--cuenta]
	}
	
	public int peek() {
		if(this.estaVacia()) {
			throw new RuntimeException("Error la pila esta llena");
		}
		return this.contenedor[cuenta -1];
	}
}
