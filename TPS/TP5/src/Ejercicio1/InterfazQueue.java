package Ejercicio1;

public interface InterfazQueue<ELEMENT> extends Iterable<ELEMENT> {
	
		// Agrega el elemento especificado al final de la cola. Devuelve verdadero
		// si el elemento se agregó a esta cola; de lo contrario, falso
		public abstract boolean offer(ELEMENT element);
		// Elimina y devuelve el elemento en la parte frontal de la cola. Si la cola
		// esta vacia devuelve null, no genera exception, este metodo es más seguro
		public abstract ELEMENT poll();
		// Devuelve el elemento en la parte frontal de la cola sin eliminarlo.
		// Devuelve null si la cola está vacía.
		public abstract ELEMENT peek();	
		
		
		// Agrega un elemento al final de la cola. Devuelve verdadero en caso de 
		// éxito y arroja una "IllegalStateException" si no hay espacio disponible
		public abstract boolean add(ELEMENT element);
		// Elimina y devuelve el elemento en la parte frontal (cabeza) de la cola
		// Si la cola esta vacia devuelve una exception "NoSuchElementException"
		public abstract ELEMENT remove();
		// Devuelve el elemento en la parte frontal de la cola sin eliminarlo.
		// Si no, Lanza una excepción 'NoSuchElementException'
		public abstract ELEMENT element();
		
		// Verifica si la colección está vacía. -> Devuelve booleano
		public abstract boolean empty();
		// Devuelve el número de elementos real en la colección.
		public abstract int size();
}
