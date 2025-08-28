package CasosDeEjemplo;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
 
/*
 
Escribir una función, método o subprograma que reciba como
parámetros dos colas y devuelva una cola que resulte ser
la unión de las otras dos. Se debe definir el mecanismo de
“unión entre colas”, puede ser que la primera cola se encole
detrás de la segunda, o que la segunda cola se encole después
de la primera.
 
 */
 
import java.util.Random;
 
public class CasosDeEjemplo_B {
 
    private static Random random = new Random();
 
    public void Run() {
 
        System.out.println("Trabajo Práctico Nº 3 - Caso Ejemplo b)\n");
 
        Queue<Integer> queue1 = new Queue<Integer>(10);
        Queue<Integer> queue2 = new Queue<Integer>(10);
 
        for (int cta = random.nextInt(10) + 1; cta > 0 ; --cta) {
            queue1.offer(random.nextInt(500));
        }
        for (int cta = random.nextInt(10) + 1; cta > 0 ; --cta) {
            queue2.offer(random.nextInt(500));
        }
 
        System.out.println("cola 1.....: " + queue1.toString());
        System.out.println("cola 2.....: " + queue2.toString());
 
        System.out.println("unión 1 - 2: " + Queue.union(queue1, queue2));
 
        System.out.println("unión 1 - 1: " + queue1.union(queue1).toString());
        System.out.println("unión 1 - 2: " + queue1.union(queue2).toString());
        System.out.println("unión 2 - 1: " + queue2.union(queue1).toString());
        System.out.println("unión 2 - 2: " + queue2.union(queue2).toString());
    }
}
 