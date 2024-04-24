package YTListaDoblementeEnlazada;

public class NodoDoble {
	public int dato;
	NodoDoble siguiente, anterior;
	
	// Constructor para cuando aun no hay nodos
	public NodoDoble(int element) {
		this(element, null, null);
	}
	
	// Constructor para cuando ya no hay nodos
	public NodoDoble(int element, NodoDoble siguiente, NodoDoble anterior) {
		this.dato = element;
		this.siguiente = siguiente; // inicio, head
		this.anterior = anterior;   // anterior, tail
	}	
	
	
}
