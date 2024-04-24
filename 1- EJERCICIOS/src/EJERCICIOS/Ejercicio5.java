/*La clasificación final de un estudiante de Informatica se calcula con base a las calificaciones de cuatro aspectos de su
 * rendimiento académico: participacíón, primer examen parcial, segundo examem parcial y examen final. Sabiendo que las
 * calificaciones anteriores entran a la clasificación finalcon ponderaciones del 10%, 25%, 25% y 40%.
 * Hacer un programa que calcule la calificación final obtenida por un estudiante*/
package EJERCICIOS;

import java.util.Scanner;
	public class Ejercicio5 {
		public static void main (String[] args) {
		Scanner entrada = new Scanner (System.in);
		float participacion, primerExamen, segundoExamen, examenFinal, notaFinal;
		
		// Pedir los datos necesarios
		System. out.print ("Digite la nota de participacion: ");
		participacion = entrada.nextFloat ();
		System. out.print ("Digite la nota del primer examen parcial: ");
		primerExamen = entrada.nextFloat ();
		System. out.print ("Digite la nota del segundo examen parcial: ");
		segundoExamen = entrada.nextFloat ();
		System. out.print ("Digite la nota del primer examen final: ");
		examenFinal = entrada.nextFloat ();
		
		// Sacando los calculos
		participacion *= 0.10f;  
		primerExamen *= 0.25f;    // La f al final indica que es un valor float. Si quisieras usar un número 
		segundoExamen = 0.25f;    // decimal de tipo double, simplemente podrías escribir 0.10 sin la f, y la
		examenFinal *= 0.40f;	  // operación sería similar pero con mayor precisión, ya que double tiene más precisión que float
		
		// Sumando las notas
		notaFinal = participacion + primerExamen + segundoExamen + examenFinal;
		
		//Imprimir el resultado en pantalla
		System.out.println("\nLa nota final es: " + notaFinal);
		
		entrada.close();
		}
	}
