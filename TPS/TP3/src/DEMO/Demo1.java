package DEMO;

import java.util.Stack;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

public class Demo1 {

 public void Run() {

     System.out.println("Demo de Stack (Estructura de Datos)");

     Stack<Character> miPila = new Stack<Character>();

     miPila.push('a');
     miPila.push('b');
     miPila.push('c');

     System.out.println("miPila: " + miPila);

     while (!miPila.empty()) {
         System.out.println(miPila.pop());
     }

     try {
         System.out.println(miPila.peek());
     } catch (Exception e){
         System.out.println(e);
     }
 }
}