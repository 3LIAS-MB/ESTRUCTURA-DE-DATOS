package CasoEjemplo_c;

import CasoEjemplo_a.Helper;
import CasoEjemplo_a.ILinkedList;
import CasoEjemplo_a.SimpleLinkedList;

/*Escriba un programa que genere aleatoriamente N números naturales entre 1 y “Límite” y los
almacene en una lista. A partir de esa lista obtenga una lista de números pares y otra lista de números
impares. Los valores N y “Límite” deben ser ingresados por el usuario. Agregue todos los controles que
considere necesarios.*/

public class CasoEjemplo_c {
	public static void main(String[] args) {
		CasoEjemplo_c start = new CasoEjemplo_c();
		start.Run();
	}
	
 public void Run() {
     ILinkedList<Integer> orignalList = getData(); // devuelve una lista de nodos
     											   // del mismo tipo.
     System.out.println("Lista original..........:" + orignalList.toString());

     ILinkedList<Integer> pairsList = new SimpleLinkedList<Integer>();
     ILinkedList<Integer> nonesList = new SimpleLinkedList<Integer>();

     for (Integer number; orignalList.size() > 0; ) {
         number = orignalList.removeFirst();
         if (number % 2 == 0) {
             pairsList.addLast(number);
         } else {
             nonesList.addLast(number);
         }
     }

     System.out.println("Lista de números pares..:" + pairsList.toString());
     System.out.println("Lista de números impares:" + nonesList.toString());

 }


 private ILinkedList<Integer> getData() {

     int numbersCount;
     int numbersLimit;

     while (true) {
         numbersCount = Helper.getInteger("Ingrese cantidad de números a generar.......: ");
         if (numbersCount > 0) {
             break;
         }
         System.out.println("Ingrese un número natural válido...");
     }
     /**/
     while (true) {
         numbersLimit = Helper.getInteger("Ingrese límite superior de números a generar: ");
         if (numbersLimit > 1) {
             break;
         }
         System.out.println("Ingrese un límite para los números naturales válido...");
     }

     ILinkedList<Integer> list = new SimpleLinkedList<Integer>();
     // Lo disminuye en la primera iteracion
     while (numbersCount-- > 0) {
         list.addLast(Helper.random.nextInt(numbersLimit));
     }

     return list; // retorna la lista encadeanda
 }
}