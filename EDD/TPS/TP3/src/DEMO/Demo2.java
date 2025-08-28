package DEMO;

import java.util.Stack;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

public class Demo2 {
	
 public void Run() {
     System.out.println("Demo de Stack (Estructura de Datos y Librería de Java)");

     Stack<Character> miPila = new Stack<Character>();
     java.util.Stack<Character> otraPila = new java.util.Stack<Character>();


     miPila.push('a');
     otraPila.push('a');
     miPila.push('b');
     otraPila.push('b');
     miPila.push('c');
     otraPila.push('c');

     System.out.println("miPila..: " + miPila);
     System.out.println("otraPila: " + otraPila);

     while (!miPila.empty()) {
         System.out.println(miPila.pop() + " - " + otraPila.pop());
     }

     try {
         System.out.println(miPila.peek());
     } catch (Exception e){
         System.out.println(e);
     }

     try {
         System.out.println(otraPila.peek());
     } catch (Exception e){
         System.out.println(e);
     }

 }
}