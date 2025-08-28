package YTListaSimplementeEnlazada;

public class Lista {
	protected Nodo inicio; // -> Punteros para saber donde | Como es de tipo Nodo, asumo que tiene como
	protected Nodo fin;	   //    está el inicio y el final | atributos 'dato' y 'siguiente' que apunta a algo
	
	public Lista() {
		inicio = null;
		fin = null;
	}
	
	// Metodo para saber si la lista está vacia
	public boolean estaVacia() {
		if(inicio == null) {
			return true; 
		} else {
			return false;
		}
	}
	
	// Metodo para agregar un nodo al inicio
	public void agregarInicio(int element) {
		inicio = new Nodo(element, inicio); // cada vez que se instancia dato y siguiente tienen valores por defecto 0 y null
		if(fin == null) {
			fin = inicio; // fin e inicio apuntan al mismo lugar
		}				  // al parecer solo se itera una unica vez 
	}					  // para que fin apunte al primer elemento
	
	// Metodo para insertar un nodo al final
	public void agregarFinal(int element) {
		if(!estaVacia()) {
			fin.siguiente = new Nodo(element); // se está creando un nuevo nodo con el valor element y estableciendo 
			fin = fin.siguiente;			   // este nuevo nodo como el siguiente nodo después de fin
		} else {							   // -> asigna el nuevo nodo al atributo siguiente
			inicio = fin = new Nodo(element);
		}	
	}
	
	// Metodo para eliminar un nodo del inicio
	public int borrarInicio() {
		int elemento = inicio.dato;
		if(inicio == fin) { 	 // Si son iguales quiere decir que solo hay un elemento
			inicio = fin = null; // por ende se inicializan en null para eliminarlo
		} else {
			inicio = inicio.siguiente; // Si no, a inicio se le hace a puntar a su siguiente
		}							   // y automaticamente se elimina
		return elemento;
	}
	
	// Metodo para eliminar un nodo del final
	public int borrarFinal() {
		int elemento = fin.dato;
		if(inicio == fin) {
			inicio = fin = null;
		} else {
			Nodo temp = inicio;
			while(temp.siguiente != fin) { // Cuando el siguiente de 'temp' sea igual a 'fin'
				temp = temp.siguiente;     // quiere decir que estamos en el penultimo nodo
			}
			fin = temp; 			// Asignamos el penultimo y el ultimo nodo 'fin'
			fin.siguiente = null;	// y apuntamos el 'siguiente' de 'fin' a null
		}							// para eliminar el ultimo nodo de la lista
		return elemento;
	}
	
	// Metodo para eliminar un nodo en especifico
	public boolean borrarEspecifico(int element) {
		if(!estaVacia()) {
			if(inicio == fin && element == inicio.dato) { // Verifica que la lista tenga un solo nodo y
				inicio = fin = null;					  // si es igual a 'element' se vacia la lista
				return true;
			}
			else if(element == inicio.dato) { // Verifica que 'element' sea el primer nodo y si
				inicio = inicio.siguiente;	  // coincide: 'inicio' apunta a siguiente y, por ende,
				return true;                  // se elimina el primer nodo (pero la lista no está vacia)
// El elemento a eliminar no es el
// unico ni el primero de la lista			
			} else {
				Nodo anterior = inicio; 	  // Apunta al primer nodo
				Nodo temp = inicio.siguiente; // Apunta al siguiente nodo -> el que queremos eliminar
				while(temp != null && temp.dato != element) {
					anterior = anterior.siguiente; 
					temp = temp.siguiente; 		   
				}
				if(temp != null) { // -> Si temp no es nulo significa que lo encontró
					anterior.siguiente = temp.siguiente; // Esta línea actualiza el puntero 'siguiente' del nodo
/*Si es el ultimo*/ if(temp == fin) {					 // 'anterior' para que apunte al nodo 'siguiente' al nodo 'temp'
/*se le asigna el*/	fin = anterior;					 	 // y asi, saltearse el elemento que se quiere eliminar
/*anteiror*/		}
					return true;
				}	
			}
		}
		return false;
	}
	
	// Metodo para buscar un elemento
	public boolean buscarElemento(int element) {
		Nodo temp = inicio;
		while(temp != null && temp.dato != element) {
			temp = temp.siguiente;	
		}
		return temp != null;
	}
	
	// Metodo para mostrar los datos
	public void mostrarLista() {
		Nodo recorrer = inicio;
		System.out.println("");
		while(recorrer != null) {
			System.out.print("["+recorrer.dato+"]"+"-->");
			recorrer = recorrer.siguiente;
		}
	}
	
	
	// Metodo para ordenar la lista
	
}

