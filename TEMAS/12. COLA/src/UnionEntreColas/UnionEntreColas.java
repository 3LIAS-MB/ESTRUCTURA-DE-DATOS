package UnionEntreColas;  // COLA DE ENTEROS -> Cuando head y tail son iguales significa que la cola esta vacia

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

/*Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo como
contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de una cola
que prioriza memoria. Incluir el método existeEnCola(elemento) que devuelve el valor lógico verdadero
cuando elemento se encuentra en el objeto cola que llama al método, o el valor lógico falso en caso
contrario. Comprobar el correcto funcionamiento de la implementación propuesta creando una instancia
de la cola y utilizando las operaciones de la misma a pedido del operador. Para ello, puede usar un menú de opciones.*/

public class UnionEntreColas {
	private int tail; // Apunta a la posicion donde se va a insetar un elemento
	private int head; // Apunta a la posicion del valor que va a salir
	private int tamaño; // Me dice cuantos elementos tiene la cola
	private final int capacidad = 10; // Me dice cual es el tamaño del vector
	private int[] datos; // Es un vector o array de enteros
	
	public UnionEntreColas() { // Constuctor vacio
			this.tail = 0;
			this.head = 0;
			this.tamaño = 0;
			this.datos = new int[capacidad];
	}
	

	public UnionEntreColas(int capacidad) { // Constructor con parametro
		//this.capacidad = capacidad;
		this.tail = 0;
		this.head = 0;
		this.tamaño = 0;
		this.datos = new int[capacidad];
	}
	
	public boolean estaVacia() { // empty
		return this.tamaño <= 0;
	}
	
	public boolean estaLlena() { // empty
		return this.tamaño == this.capacidad;
	}
	
	public int siguiente(int posicion) {  // Next
		++posicion;
		if(posicion >= capacidad) { // Si llega a la posicion final del vector vuele a la posicion 0 /******>=*******/
			posicion = 0;
		}
		return posicion;
	}
	
	public void encolar(int numero) { // Enqueue
		if(estaLlena()) {
			throw new RuntimeException("Error, la cola esta llena");
		}
		datos[this.tail] = numero;
		this.tail = siguiente(this.tail); // Manda el "head" a siguiente() para que se incremente en 1
		++this.tamaño;					  // Siempre que se desencola "head" proyecta el siguiente elemento
	}
	
	public int desencolar() { // Dequeue -> Desencola empezando desde la posicion 0. No elimina, solo obtiene el elemento
		if(estaVacia()) {
			throw new RuntimeException("Error, la cola esta llena");
		}
		int numero = this.datos[this.head];
		this.head = siguiente(head); // Manda el "head" a siguiente() para que se incremente en 1
		--this.tamaño;					 // Siempre que se desencola "head" proyecta el siguiente elemento
		return numero;
	}
	
	/**/
	
    public int cantidad() {
        return this.tamaño;
    }
    
	public static UnionEntreColas unirColas(UnionEntreColas cola1, UnionEntreColas cola2) { // Algoritmo para unir las colas
		UnionEntreColas auxiliar = new UnionEntreColas();
		
		while(!cola1.estaVacia()) { // mientras no este vacia
			auxiliar.encolar(cola1.desencolar());
		}
		
		while(!cola2.estaVacia()) {
			auxiliar.encolar(cola2.desencolar());
		}
		return auxiliar;
	}
}		
