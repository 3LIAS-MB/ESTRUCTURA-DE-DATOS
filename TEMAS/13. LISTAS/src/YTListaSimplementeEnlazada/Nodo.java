package YTListaSimplementeEnlazada; // Contendra numeros enteros

public class Nodo { // Representa 1 nodo de la lista enlazada
	public int dato;
	public Nodo siguiente; // Puntero enlace
	
	// Constructor para insertar al final
	public Nodo(int element) {
		this.dato = element;
		this.siguiente = null;
	}
	
	// Constructor para insertar al inicio
	public Nodo(int element, Nodo inicio) {
		dato = element;
		siguiente = inicio; // a siguiente se le asigna el nodo anterior
	}
	
	
}
