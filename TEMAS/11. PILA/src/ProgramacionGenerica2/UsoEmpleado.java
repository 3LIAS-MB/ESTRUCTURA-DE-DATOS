package ProgramacionGenerica2;

import java.util.ArrayList;
import java.util.Iterator; // Interfaz que proporciona un mecanismo estándar para recorrer colecciones de elementos, como listas, conjuntos y mapas

public class UsoEmpleado {
	public static void main(String[] args) {
		
		//Empleado listaEmpleados[] = new Empleado[3];
		
		//listaEmpleados[0] = new Empleado("Ana", 45, 2500);
		//listaEmpleados[1] = new Empleado("Ana", 45, 2500);
		//listaEmpleados[2] = new Empleado("Ana", 45, 2500);
																		// Lista de elementos genericos
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>(); // Parametro de tipo Empleado
		
		listaEmpleados.ensureCapacity(3); // Capacidad del ArrayList. Si agregamos más que lo indicado crea una copia
		
        // Crear objetos de tipo Empleado por separado
        Empleado empleado1 = new Empleado("Anaquin", 45, 123);
        Empleado empleado2 = new Empleado("Elias", 55, 321);
        Empleado empleado3 = new Empleado("Juana", 65, 213);
        
        // Agregar los objetos a la lista
        listaEmpleados.add(empleado1);
        listaEmpleados.add(empleado2);
        listaEmpleados.add(empleado3);
        
        // Crear objetos instando dentro del metodo "add"
        
		listaEmpleados.add(new Empleado("Ana", 45, 2501)); // Podemos crear previamente el objeto de tipo Empleado que queremos 
		listaEmpleados.add(new Empleado("Eli", 55, 2502)); // agregar o lo instanciamos desde el argumento del metodo "add"
		listaEmpleados.add(new Empleado("Juan", 65, 2503));
		listaEmpleados.set(2, new Empleado("Pedro", 15, 2002));
		
		listaEmpleados.trimToSize(); // Corta el exceso de memoria para optimizarlo.
	
		/*Bucle for Each*/
		for(Empleado elemento: listaEmpleados) {
			System.out.println(elemento.dameDatos());
		}
		
		System.out.println();
		System.out.println(listaEmpleados.get(0).dameDatos());
		System.out.println();
		
		/*Bucle for convensional*/
		for(int i=0;i<listaEmpleados.size();i++) { // size da el tamaño real -> 3
			Empleado e = listaEmpleados.get(i);
			System.out.println(e.dameDatos());
		}
		
		System.out.println();
		
		/*Copiamos el tamaño del arraylist al array*/
		Empleado arrayEmpleado[] = new Empleado[listaEmpleados.size()];
		listaEmpleados.toArray(arrayEmpleado); // El metodo toArray se usa comunmente para pasar de una lista
											   // LinkedList o ArrayList a un array estatico
		for(int i=0; i<arrayEmpleado.length; i++) {
			System.out.println(arrayEmpleado[i].dameDatos());
		}
		
		System.out.println();
		
		/*Iterator*/
		
		Iterator<Empleado> mi_iterador = listaEmpleados.iterator(); // obtiene un iterador de la lista usando el método iterator()
																	// generalmente se usa en bucles while o for
		while(mi_iterador.hasNext()) {
			Empleado element = mi_iterador.next();
			System.out.println(element.dameDatos());
		}
		
		/* En Java, el método iterator() se llama en una instancia de una clase que implementa la interfaz Iterable.
		 * En general, se utiliza en estructuras de datos como listas (ArrayList, LinkedList),
		 * conjuntos (HashSet, TreeSet), colas (Queue, LinkedList) y otras colecciones.*/
		
		// hasNext(): Este método verifica si todavía hay elementos por recorrer en la colección.
		// Devuelve true si hay más elementos y false cuando se llega al final.
		
		// next() -> Devuelve el siguiente elemento en la secuencia de la colección y avanza al siguiente elemento.
		// 'NoSuchElementException' - if the iteration has no more elements
		
		// remove() -> El método remove() se utiliza para eliminar el elemento actual que
		// ha sido devuelto por la llamada anterior al método next() del iterador. 
		// En otras palabras, después de llamar a next() para obtener un elemento,
		// puedes usar remove() para eliminar ese elemento de la colección
	}
}
