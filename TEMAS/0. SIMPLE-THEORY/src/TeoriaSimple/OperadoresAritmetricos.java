package TeoriaSimple;
import java.util.Scanner;

public class OperadoresAritmetricos {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		float numero1, numero2, suma, resta, mult, div, resto, sumaY_asign;
		
		System.out.print("Digite dos numeros: ");
		numero1 = entrada.nextFloat();
		numero2 = entrada.nextFloat();
		sumaY_asign = 0; // definiendo
		int x = 5, y = 0;
		
		suma = numero1 +  numero2;
		resta = numero1 -  numero2;
		mult = numero1 * numero2;
		div = numero1 / numero2;
		resto = numero1 % numero2;
		
		
		sumaY_asign += 1; // suma y asignacion (se puede sumar una variable)	
		
		// INCREMENTO Y DECREMENTO
		
		x ++; // incremento -> se suma 1, queda en 6
		y --; // decremento -> se resta 1, queda en 4
		
		y = ++x; // primero se aumenta el valor  de "x" en 1, y DESPUÉS se le asigna a "y"
		y = x++; // primero se le asigna "x" a "y", DESPUÉS se suma "++x" -> prefijo
		
		
		System.out.println("La suma es: " + suma);
		System.out.println("La resta es: " + resta);
		System.out.println("La multiplicacion es: " + mult);
		System.out.println("La division es: " + div);
		System.out.println("El resto es: " + resto);
		System.out.println("La suma fue: " + sumaY_asign);
		
		System.out.println("La incremento fue de: " +  x); //  4
		System.out.println("El decremento fue de: " +  y); // -1

		
		entrada.close();
	}
}