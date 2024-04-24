package Ejercicio1; // COLA GENERICA

/*Codificar una implementación del tipo de dato abstracto Queue o Cola que utilice un arreglo como
contenedor de elementos, e implemente los conceptos vistos como “Cola Circular” para el caso de una cola
que prioriza memoria. Incluir el método existeEnCola(elemento) que devuelve el valor lógico verdadero
cuando elemento se encuentra en el objeto cola que llama al método, o el valor lógico falso en caso
contrario. Comprobar el correcto funcionamiento de la implementación propuesta creando una instancia
de la cola y utilizando las operaciones de la misma a pedido del operador. Para ello, puede usar un menú
de opciones*/

public class ColaCircularMemoria1 <T> { // La <T> es un tipo de parámetro genérico, lo que significa que la clase 
    private Object[] cola;	   // ColaCircular es una clase genérica que puede manejar diferentes tipos de datos
    private int capacidad; 	   // Estos tienen que estar especificados cuando se cree una instancia de la clase
    private int head;
    private int tail;
    private int tamaño;

    public ColaCircularMemoria1(int capacidad) {
        this.capacidad = capacidad; 
        this.cola = new Object[capacidad]; // Al utilizar Object, se permite que la cola contenga elementos 
        this.head = 0;				  	   // de cualquier tipo, ya que todos los tipos en Java son subtipos de Object.
        this.tail = -1;
        this.tamaño = 0;
    }

    public void encolar(T elemento) {//Object elemento			//El método metodoGenerico puede recibir parámetros de cualquier tipo, 
        if (tamaño < capacidad) {								//pero cuando se llama a este método en una instancia específica de MiClase, 
        	tail = (tail + 1) % capacidad;						//se espera que el tipo del argumento coincida con el tipo genérico especificado.
            
            cola[tail] = elemento;	/*cualquier tipo de objeto en Java es compatible con Object*/				
            tamaño++;
            System.out.println("Elemento encolado: " + elemento);
        } else {
            System.out.println("La cola está llena. No se puede encolar el elemento: " + elemento);
        }
    }

    public T desencolar() { // Para desencolar 'frente o head' se aumenta en 1 para marcar el proximo elemento
        if (!estaVacia()) {
            T elementoDesencolado = (T) cola[head];
            head = (head + 1) % capacidad;
            tamaño--;
            System.out.println("Elemento desencolado: " + elementoDesencolado);
            return elementoDesencolado;
        } else {
            System.out.println("La cola está vacía. No se puede desencolar.");
            return null;
        }
    }

    public boolean existeEnCola(T elemento) {
        for (int i = 0; i < tamaño; i++) {
            int index = (head + i) % capacidad;
            if (cola[index].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    public int tamaño() {
        return tamaño;
    }
}	

