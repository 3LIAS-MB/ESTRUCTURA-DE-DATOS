package EJERCICIOS; // Insertar un numero en algun lugar del array/tabla
import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int[] arreglo=new int[10];
        
        System.out.println("*Llenado de arreglo*");
        for(int i=0; i<=8; i++) {                                         
            System.out.print(i+".- Dijite un número: ");
            arreglo[i] = entrada.nextInt();
        }
        
        System.out.println();
        System.out.println("*Número y posición*");
        System.out.print("Teclee un número: ");
        int numero = entrada.nextInt();
        
        System.out.print("Teclee una posición: ");
        int posicion = entrada.nextInt();
        
        for(int j=9; j>posicion; j--)
        {                                                 
            arreglo[j]=arreglo[j-1]; // Se le asigna el valor anterior
        }
        	
        arreglo[posicion] = numero;
        
        System.out.println();
        int cont=0;
        System.out.println("*Nuevo acomodo con nuevo número y posición*");
        for(int k:arreglo) // Bucle for each
        {
            System.out.println(cont+".- "+k);
            cont++;
        }
        entrada.close();
    }
}