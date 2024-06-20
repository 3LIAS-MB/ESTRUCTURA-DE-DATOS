// Metodo generico -> Es aquel que podemos utilizar con cualquier tipo de objeto
// Los metodos genericos no necesariamente necesitan estar dentro de clases genericas
// pueden construidos dentro de clases ordinarias o bien genericas

// Su caracteristica es que se adapta a diferentes tipos de objetos que pasamos por parametro

package ProgramacionGenerica4;

import ProgramacionGenerica2.Empleado;

public class MetodosGenericos {
	public static void main(String[] args) {
		// ARRAY PRIMITIVO DE TIPO STRING
		String nombres[] = {"A", "B", "C"};
		String[] nombres2 = new String[]{"Jose", "Maria", "Pepe"};
		
		//String elementos = MisMatrices.<String>getElementos(nombres);
		String elementos = MisMatrices.getElementos(nombres); 
		//System.out.println(MisMatrices.getElementos(nombres));
		System.out.println(elementos);                          
		
		// ARRAY DE OBJETOS, contiene referencias a objetos (instancias de clases) 
		Empleado listaEmpleado[] = { new Empleado("Ana", 45, 2500),			
									 new Empleado("Ana", 45, 2500),
									 new Empleado("Ana", 45, 2500),
									 new Empleado("Ana", 45, 2500)
		};
		System.out.println(MisMatrices.getElementos(listaEmpleado)); // Objeto de tipo "Empleado"
	
		System.out.println(MisMatrices.getMenor(nombres));
	}
}
		

class MisMatrices {
	
	/*<T> es una notación que indica que el método es genérico, es decir, puede trabajar con diferentes tipos de datos.*/
	public static <T> String getElementos(T[] array) {
		return "El array tiene " + array.length + " elementos.";
	}
	
	/* La notación <T extends Comparable> significa que el tipo genérico T debe ser
	 * una clase que implemente la interfaz Comparable. Esto se utiliza para garantizar
	 * que los elementos del arreglo puedan ser comparados entre sí.*/
	public static <T extends Comparable> T getMenor(T[] array) { // Todos los argumentos que le pasemos
		if(array == null || array.length == 0) {				 // tienen que ser objetos que implementen
			return null;										 // la interfaz comparable
		}
		
		/*devuelve un entero negativo si el objeto actual es menor que el objeto pasado como argumento,
		 * cero si son iguales y un entero positivo si el objeto actual es mayor*/
		T elementoMenor = array[0];
		for(int i=1; i<array.length; i++) {
			if(elementoMenor.compareTo(array[i]) > 0) { // Los objetos que utilicen "comapareTo" tienen que
				elementoMenor = array[i];				// implementar la interfaz comparable
			}
		}
		return elementoMenor;
	}
}




// Podemos ignorar <String> porque Java
// ya lo interpreta