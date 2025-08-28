package EJERCICIOS;
import java.util.Scanner;

public class Ejercicio8 {
	public static void  main(String[] args) {
	Scanner entrada = new Scanner(System.in); 
	      
	      double a,b,c,x1,x2,d = 0;
	        System.out.println("Digite el valor de a: ");
	        a = entrada.nextDouble();
	        System.out.println("Digite el valor de b: ");
	        b = entrada.nextDouble();
	        System.out.println("Digite el valor de c: ");
	        c = entrada.nextDouble();
	        
	        d = Math.pow(b,2)-4*a*c;
	        
	        if(d <0){
	            System.out.println("La solucion no es real");
	        }else{
	            x1 = (-b + Math.sqrt(d))/2*a;
	            x2 = (-b - Math.sqrt(d))/2*a;
	            System.out.println();
	            System.out.println("La solucion es: x1 = "+x1);
	            System.out.println("La solucion es: x2 = "+x2);
	   
	        entrada.close();
	        
	        }
	    }
	}