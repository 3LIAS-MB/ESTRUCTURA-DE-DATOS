package Ejercicio1;

public class Pila {
	
	public void Push(int[] pila) {
		 if(pila.length > 0) {
			 int[] nuevaPila = new int[pila.length + 1];

			 int i = 0;
			 for(int elemento : pila) {
				 nuevaPila[i] = elemento;
				 i++;
			 }
		 } else {
			 System.out.println("La pila está vacia");
		 }
	}
	
	public void Pop(int[] pila, int delete) {
	    if (pila.length == 0) {
	        throw new IllegalStateException("El array está vacío, no se puede realizar pop.");
	    }
	    int ultimoElemento = pila[pila.length - 1]; // Obtener el último elemento
	    int[] nuevoArray = new int[pila.length - 1];  // Crear un nuevo array con un elemento menos
	    
	    for (int i = 0; i < nuevoArray.length; i++) {
	        nuevoArray[i] = pila[i];
	    }
	    
	    pila = nuevoArray;
	}
	
	
	public void Peek() {
		
	}
}

// push
// pop
// peek
// search	




// listas simplemente enlazadas
// orden lineal
// orden constante

// lista enlazada
// lista doblemente enlazada