package Ejercicio4;
import java.util.*;

/*La sucesión de Fibonacci es una secuencia de números en la cual cada número es la suma de los dos anteriores.
 * Comienza generalmente con 0 y 1. La secuencia se ve así: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, y así sucesivamente.
 * 
 * Entonces, cada término en la secuencia de Fibonacci es la suma de los dos términos anteriores. La sucesión de Fibonacci
 * tiene aplicaciones en diversas áreas, como matemáticas, informática, biología, arte y naturaleza. Se puede encontrar en
 * la disposición de pétalos de algunas flores, en la espiral de algunas conchas marinas, y en muchos otros lugares en la
 * naturaleza. Además, tiene aplicaciones en algoritmos y programación, como en la optimización de algoritmos recursivos y
 * en la generación de números pseudoaleatorios.*/

/*Escribir un programa que permita generar los términos de la serie Fibonacci y guardarlos, hasta que el
usuario decida no continuar. El programa debe calcular y mostrar la suma de los números pares, la
cantidad de los impares, el promedio de los términos generados y la cantidad de términos mayores a dicho promedio.*/
	
public class Fibonacci {
	private ArrayList<Integer> fibonacciSeries;
	Scanner scanner = new Scanner(System.in);

	/**/
	
    public Fibonacci() {
        fibonacciSeries = new ArrayList<>(); 
        fibonacciSeries.add(0);
        fibonacciSeries.add(1);
    }
    
    public void generarSerie() { // 0 1

	    while (true) {
	    	mostrarSerie();
	        String respuesta = Helper.getChar("\n¿Desea continuar generando términos de la serie Fibonacci? (S/N): ");
	        if (respuesta.equalsIgnoreCase("N")){ // devuelve un valor booleano
	        	mostrarPromedio();                
 	            break;
	        }
	
	        int ultimo = fibonacciSeries.get(fibonacciSeries.size() - 1); 
	        int penultimo = fibonacciSeries.get(fibonacciSeries.size() - 2); 
	        int siguiente = ultimo + penultimo;					  			
	        fibonacciSeries.add(siguiente); 
	    }
    }
    
    public void mostrarPromedio() {
       int pares = 0;
       int impares = 0;
       int total = 0;
       int promedio = 0;
       
       for (int i = 0; i < fibonacciSeries.size(); i++) {
    	   if(fibonacciSeries.get(i) % 2 == 0) {
    		   pares += fibonacciSeries.get(i);
    	   } else {
    		   impares += 1;
    	   } 
       }
       
       for (int i = 0; i < fibonacciSeries.size(); i++) {
    	   total += fibonacciSeries.get(i);
    	   }
       promedio = total / fibonacciSeries.size();
       
       System.out.println("SUMA DE LOS TERMINOS PARES: " + pares);
       System.out.println("CANTIDAD DE TERMINOS IMPARES " + impares);
       System.out.println("PROMEDIO DE LOS TERMINOS GENERADOS: " + promedio);
       
       int contadorValoresMayorAlPromedio = 0;
       for (int numero : fibonacciSeries) {
           if(numero > promedio) {
        	   contadorValoresMayorAlPromedio += 1;
           }
       }
       System.out.println("CANTIDAD DE TERMINOS MAYOR AL PROMEDIO: " + contadorValoresMayorAlPromedio);
    }
    
 
    public void mostrarSerie() {
        System.out.println("Serie de Fibonacci:");
        for (int numero : fibonacciSeries) {
            System.out.print(numero + " ");
        }
    }
}