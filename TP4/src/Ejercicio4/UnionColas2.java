package Ejercicio4;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/* Escribir una función, método o subprograma que reciba como parámetros dos colas y devuelva una cola
que resulte ser la unión de las otras dos, sin elementos repetidos. Para este caso el mecanismo de “unión
entre colas” es en el que sucesiva y alternadamente se toma un elemento de cada cola y se encola en una
nueva. El mecanismo de unión debe incluir las consideraciones necesarias para incorporar solo una vez
cada valor a la cola resultante de manera que no haya elementos repetidos. Considere que las colas
pueden ser de longitudes diferentes.*/

public class UnionColas2 {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //UnionColas2 xd = new UnionColas2(); Aunque el metodo sea estico igual permite instanciar un objeto y usar sus metodos
        //Queue<Integer> colaUnin = xd.unirColas(cola1, cola2);
        
        Queue<Integer> cola1 = new LinkedList<>();
        Queue<Integer> cola2 = new LinkedList<>();

        // Ingresar elementos a la primera cola
        System.out.print("Ingrese elementos para la primera cola (separados por espacios): ");
        String[] elementos1 = scanner.nextLine().split(" ");
        for (String elemento : elementos1) { /// ["1", "2", "3"]
            cola1.offer(Integer.parseInt(elemento)); // Convierte "1" a entero -> cola1 = [1, 2, 3]
        }

        // Ingresar elementos a la segunda cola
        System.out.print("Ingrese elementos para la segunda cola (separados por espacios): ");
        String[] elementos2 = scanner.nextLine().split(" "); // SPLIT ES UN METODO DE LA CLASE STRING
        for (String elemento : elementos2) { //["4", "5", "6", "7"]
            cola2.offer(Integer.parseInt(elemento)); // Convierte "4" a entero -> cola2 = [1, 2, 3, 4]
        }

        Queue<Integer> colaUnion = unirColas(cola1, cola2); // Nos manda a un metodo que toma dos colas como entrada,
        //Queue<Integer> cola3 = new LinkedList<>(cola1);   // las convina y las devuelve asignandolas a 'colaUnion'
        
        // Mostrar la cola resultante
        System.out.print("Cola resultante de la unión sin elementos repetidos: ");
        for (Integer elemento : colaUnion) {
            System.out.print(elemento + " ");	
        }
    }	
    
    public static Queue<Integer> unirColas(Queue<Integer> cola1, Queue<Integer> cola2) {
        Queue<Integer> colaUnion = new LinkedList<>();

        while (!cola1.isEmpty() && !cola2.isEmpty()) {
            colaUnion.offer(cola1.poll()); // Offer arranca agregando desde el indice 
            colaUnion.offer(cola2.poll()); // y Poll elimina el elemento frontal de la cola
        }

        // Si quedan elementos en alguna de las colas, agregarlos a la colaUnion
        while (!cola1.isEmpty()) {
            colaUnion.offer(cola1.poll());
        }
        while (!cola2.isEmpty()) {
            colaUnion.offer(cola2.poll());
        }

        // Eliminar elementos repetidos en la colaUnion
        Queue<Integer> colaUnionSinRepetir = new LinkedList<>();
        while (!colaUnion.isEmpty()) {
            int elemento = colaUnion.poll();
            if (!colaUnionSinRepetir.contains(elemento)) { // Si no contiene el elemento devuelve 'false' y
                colaUnionSinRepetir.offer(elemento);       // con la negacion hace pasar al bucle para que se añada
            }
        }

        return colaUnionSinRepetir;
    }
}


