/*Codificar una implementación del tipo de dato abstracto Stack o Pila que utilice un arreglo como
contenedor de elementos. Comprobar el correcto funcionamiento de la implementación propuesta
creando una instancia de la pila y utilizando las operaciones de la misma a pedido del operador. Para ello,
puede usar un menú de opciones. Además, hacer uso de Stack para determinar si una palabra dada por el
usuario es o no palíndromo. Una palabra es palíndromo cuando se lee igual de izquierda a derecha que de
derecha a izquierda. Ejemplos de palíndromos: oso, somos, reconocer.

Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
El ejercicio debe implementar un mecanismo para seleccionar el ingreso de valores por consola o
generados aleatoriamente.*/

package Ejercicio1; // Last-In, First-Out -> LIFO -> EL ULTIMO EN ENTRAR ES EL PRIMERO EN SALR

import java.util.Scanner;
import java.util.Stack;

public class Ejercicio1 {
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("\t**Menu** \n1. Agregar elemento \n2. Quitar elemento \n3. Devolver el elemento superior"
    						+ "\n4. Buscar elemento \n");
    }
}

