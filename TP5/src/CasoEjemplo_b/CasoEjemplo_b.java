package CasoEjemplo_b;

import CasoEjemplo_a.Helper;
import CasoEjemplo_a.ILinkedList;
import CasoEjemplo_a.SimpleLinkedList;

/*Escribir un programa que permita ingresar caracteres en una lista a pedido del usuario. A partir de ella,
se obtiene una nueva lista en la que se almacenan las letras mayúsculas correspondientes a las
minúsculas de la lista original.*/

public class CasoEjemplo_b {
	public static void main(String[] args) {
		CasoEjemplo_b comenzar = new CasoEjemplo_b();
		comenzar.Run();
	}
	
 public void Run() {
     ILinkedList<Character> orignalList = getData(); // list

     System.out.println("Lista original.:" + orignalList.toString());
     // Lista original.:[a, b, c]

     ILinkedList<Character> uppercaseList = new SimpleLinkedList<Character>();
     Character ch;
     for (/*Sin inicializar*/ ; orignalList.size() > 0; /*accion al terminar el bucle -vacia-*/) {
         ch = orignalList.removeFirst();
         // Si es minicusla
         if (Character.isLowerCase(ch)) {
        	 // La transforma y la añade a la lista
             uppercaseList.addLast(Character.toUpperCase(ch));
         } else {
        	 // Si ya es mayuscula simplemente la añade
        	 // Y se evita transformarla
             uppercaseList.addLast(ch);
         }
     }

     System.out.println("Lista procesada:" + uppercaseList.toString());

 }


 private ILinkedList<Character> getData() { // returned -> SimpleLinkedList<ELEMENT>

     Integer option;
     while (true) {
         System.out.println(
                 "\nTrabajo Práctico Nº 4 - Caso Ejempo b)\n" +
                         "\nOpciones" +
                         "\n 1. Ingresa valores por consola" +
                         "\n 2. Genera valores aleatorios"
         );
         option = Helper.getInteger("\nSu opción: ");

         switch (option) {
             case 1:
                 return consoleInput(); // list
             case 2:
                 return randomGenerate();
         }
     }
 }

 private ILinkedList<Character> consoleInput() {
	 // Puedes declarar una variable de tipo de interfaz "ILinkedList<Character" y asignarle una
	 // instancia de una clase que implementa esa interfaz "SimpleLinkedList<Character>"
	 // Y estamos asignando esa instancia a "list"
     ILinkedList<Character> list = new SimpleLinkedList<Character>();

     Character ch;
     while (true) {
         ch = Helper.getCharacter("Ingrese una letra (@ para finalizar): ");
         if (ch.equals('@')) {
             break;
         }
         list.addLast(ch);
     }
     return list;
 }

 private ILinkedList<Character> randomGenerate() {
     ILinkedList<Character> list = new SimpleLinkedList<Character>();
     String characters = "ABCDEFGHIJKLMNÑOPRSTUVWXYZabcdefghijklmnñoprstuvwxyz";
     for (int count = Helper.random.nextInt(20) + 1; count > 0; --count) {
    	 // Primero se saca la longitud de la cadena, despues un numero ramdon entre esa longitud
    	 // charAt() recibe un numero entero como paramtro y lo busca en la cadena por su indice
         list.addLast(characters.charAt(Helper.random.nextInt(characters.length())));
     }
     return list;
 }

}
