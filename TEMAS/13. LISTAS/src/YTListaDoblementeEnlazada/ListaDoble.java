package YTListaDoblementeEnlazada;

public class ListaDoble {
	private NodoDoble inicio, fin;
	
	public ListaDoble() {
		this.inicio = null; // head -> si 'anterior' siempre será null
		this.fin = null; // tail -> su 'siguiente' siempre será null
	}
	
	// Metodo para saber cuando la lista está vacia
	public boolean estaVacia() {
		return inicio == null;
	}
	
	// Metodo para agregar al inicio
	public void agregarInicio(int element) {
		// Si no está vacia 
		if(!estaVacia()) {
			// Se crea un nuevo nodo y se hace apuntar 'inicio'
			// a este. "this.siguiente = siguiente;" el 'siguiente'
			// del nuevo nodo apunta al nodo que le sigue, o sea, el 2do
			// En otras palabras el nuevo pasa a ser el 1ro y el otro a 2do
			inicio = new NodoDoble(element, inicio, null); // element, siguiente, anterior
			// El posterior al nuevo nodo, o sea, el que ERA primero 
			// apunta al nodo anterior, que seria el nuevo.
			inicio.siguiente.anterior = inicio;
		} else {
            // Si está vacía, crea un nodo y
			// apunta inicio y fin a este nuevo nodo
			// SOLO SE EJECUTA LA PRIMERA VEZ
			inicio = fin = new NodoDoble(element); // -> Llama al constructor
		}										   // this(element, null, null);
	}
	
	// Metodo para agregar nodos al final
	public void agregarFinal(int element) {
		// Si no está vacia
		if(!estaVacia()) {
			// Se crea un nuevo nodo y su atributo interno 'anterior'
			// apunta al nodo viejo. Despues fin apunta a este nodo
			// para que sea el ultimo. El 'siguiente' siempre es null
			fin = new NodoDoble(element, null, fin); // element, siguiente, anterior
			// primero accese a fin, su anterior y su 'siguiente' interno
			// hace que 'siguiente' del nodo anterior apunte a fin
			fin.anterior.siguiente = fin;
		} else {
			// SOLO SE EJECUTA 1 VEZ SI LA LISTA ESTA VACIA
			inicio = fin = new NodoDoble(element);
		}
	}
	
	// Metodo para eliminar un nodo del inicio de la lista
	public int eliminarInicio() {
		// Se almacena el dato del primer nodo en 'elemento'
		int elemento = inicio.dato;
		// Si hay un solo nodo se asigna null
		// a 'inicio' y 'fin' para vaciarlos
		if(inicio == fin) {
			inicio = fin =  null;
		} else {
			// Si no, a inicio va a ser igual
			// a su siguiente, el 1ro se elimina automaticamente
			inicio = inicio.siguiente;
			// Se apunta su anterior a null (siempre)
			inicio.anterior = null;
		}
		return elemento;
	}
	
	// Metodo para eliminar un nodo del final de la lista
	public int eliminarFinal() {
		// Se almacena el dato del ultimo nodo en 'elemento'
		int elemento = fin.dato;
		// Si hay un solo nodo a 'inicio' y 'fin'
		// se les asigna 'null' para vaciar la lista
		if(inicio == fin) {
			inicio = fin =  null;
		} else {
			// Si no, 'fin' va a ser igual a su anterior	,
			// y este se elimina automaticamente
			fin = fin.anterior;
			// Su siguiente apunta a null (siempre)
			fin.siguiente = null;
		}
		return elemento;
	}
	
	// Metodo para mostrar la lista de inicio a fin
	public void mostrarInicio4Fin() {
		if(!estaVacia()) {
			String datos = 	"<==>";
			NodoDoble auxiliar = inicio;
			while(auxiliar != null) {
				datos = datos + "["+auxiliar.dato+"]<==>";
				auxiliar = auxiliar.siguiente;
			}
			System.out.print("\nMostrando lista de INICIO a FIN: " + datos);
		}
	}
	
	// Metodo para mostrar la lista de fin a inicio
	public void mostrarFin4Inicio() {
		if(!estaVacia()) {
			String datos = 	"<==>";
			NodoDoble auxiliar = fin;
			while(auxiliar != null) {
				datos = datos + "["+ auxiliar.dato +"]<==>";
				auxiliar = auxiliar.anterior;
			}
			System.out.print("\nMostrando lista de FIN a INICIO: " + datos);
		}
	}
	
	// Metodo para mantener la lista ordenada
}
