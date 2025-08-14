/*Escribir un programa que permita ingresar números a una matriz M x N, mostrar la matriz en la consola y
obtener su matriz transpuesta. Además, calcular el producto de los elementos de una fila o la suma de una
columna, efectuando los cálculos sobre la matriz o su transpuesta, todo a petición del usuario. Los valores
M y N son indicados por el usuario. Agregar los controles necesarios.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio. El ejercicio debe implementar un mecanismo
para seleccionar el ingreso de valores por consola o generados aleatoriamente.*/

package Ejercicio3;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
	    Scanner entrada = new Scanner(System.in);
	    
        int matriz[][] = null, transpuesta[][] = null;
        int opcion;
        do {
        	System.out.println();
        	System.out.println("\t----MENU----"
            		+ "\n1. Ingresar matriz MxN"
            		+ "\n2. Mostrar matriz"
            		+ "\n3. Obtener transpuesta"
            		+ "\n4. Calcular producto de fila"
            		+ "\n5. Calcular suma columna"
            		+ "\n6. Salir");
            
            System.out.print("Ingrese una opción: ");
            opcion = entrada.nextInt();
            
            switch(opcion) {
            case 1:
            	matriz = construirMatriz(matriz);
            	break;
            case 2:
            	mostrarMatriz(matriz);
            	break;
            case 3:
            	transpuesta = obtenerTranspuesta(matriz);
            	break;
            case 4:
            	calcularProducto(matriz, transpuesta);
            	break;
            case 5:
            	calcularSuma(matriz, transpuesta);
            	break;
            case 6:
            	System.out.println("Adiós!");
            	break;
            	
            default:
                System.out.println("Se equivocó de opción");
                break;            
            }
            
        } while(opcion != 6);
        
        entrada.close();
    }
    
    /**/
	
    public static int[][] construirMatriz(int[][] matriz){
    	Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese M: ");
    	int m = entrada.nextInt();
    	System.out.print("Ingrese N: ");
    	int n = entrada.nextInt();
    	matriz = new int[m][n];
    	
    	System.out.print("¿Generar aleatoriamente(A) o manualmente(M)?: ");
        String generar = entrada.next(); // Usar next() en lugar de nextLine() para leer una sola palabra
    	
    	
        //if ("a".equals(generar) || "A".equals(generar)) { // Usar equals para comparar cadenas
        if ("a".equalsIgnoreCase(generar)) {
    		for(int i=0; i<matriz.length; i++) {
    			for(int j=0; j<matriz[i].length; j++) {
        			int random = (int) (Math.random() * 100);
            		matriz[i][j] = random;
    			}
    		}
    	}
    	
        else if ("M".equals(generar) || "m".equals(generar)) { // Usar equals para comparar cadenas
        	for(int i=0; i<matriz.length; i++) {
        		for(int j=0; j<matriz[i].length; j++) {
        			System.out.print("Ingrese fila " + i + " columna " + j + ": ");
        			int value = entrada.nextInt();
        			matriz[i][j] = value;
        		}
        	}
    	}
        
    	return matriz;
    }
    
    /**/
    
    public static void mostrarMatriz(int[][] matriz){
        if (matriz == null) {
            System.out.println("La matriz está vacía.");
            return;
        }
        
    	for(int i=0; i<matriz.length; i++) {
    		for(int j=0; j<matriz[i].length; j++) {
    			System.out.print(matriz[i][j] + "\t");
    		}
    		System.out.println("");
    	}
    }
    
    /**/
    
    public static int[][] obtenerTranspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        
        mostrarMatriz(transpuesta);

        return transpuesta;
    }
    /**/
    public static void calcularProducto(int[][] matriz, int[][] transpuesta){
        Scanner entrada = new Scanner(System.in);
    	int filas = matriz.length;
        int columnas = matriz[0].length;
        int producto = 1;
        
        System.out.print("Calcular producto de la Matriz(M) o Transpuesta(T): ");
        String choose = entrada.next();
        
        if ("M".equalsIgnoreCase(choose)) { // Usar equalsIgnoreCase para comparar sin importar mayúsculas/minúsculas
            System.out.print("Ingrese el número de fila a calcular en la matriz: ");
            int fila = entrada.nextInt();
            if (fila >= 0 && fila < filas) {
                for (int j = 0; j < columnas; j++) {
                    producto *= matriz[fila][j];
                }
                System.out.println("El producto de la fila " + fila + " de la matriz es: " + producto);
            } else {
                System.out.println("Fila fuera de rango.");
            }
            
        } else if ("T".equalsIgnoreCase(choose)) { // Usar equalsIgnoreCase para comparar sin importar mayúsculas/minúsculas
            System.out.print("Ingrese el número de fila a calcular en la transpuesta: ");
            int fila = entrada.nextInt();

            if (fila >= 0 && fila < columnas) {
                for (int j = 0; j < filas; j++) {
                    producto *= transpuesta[fila][j];
                }
                System.out.println("El producto de la fila " + fila + " de la transpuesta es: " + producto);
            } else {
                System.out.println("Fila fuera de rango.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
    /**/
    
    public static void calcularSuma(int[][] matriz, int[][] transpuesta) {
        Scanner entrada = new Scanner(System.in);
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int suma = 0;

        System.out.print("Calcular suma de la Matriz(M) o Transpuesta(T): ");
        String choose = entrada.next();

        if ("M".equalsIgnoreCase(choose)) { // Usar equalsIgnoreCase para comparar sin importar mayúsculas/minúsculas
            System.out.print("Ingrese el número de fila a calcular: ");
            int fila = entrada.nextInt();

            if (fila >= 0 && fila < filas) {
                for (int j = 0; j < columnas; j++) {
                    suma += matriz[fila][j];
                }
                System.out.println("La suma de la fila " + fila + " de la matriz es: " + suma);
            } else {
                System.out.println("Fila fuera de rango.");
            }
        } else if ("T".equalsIgnoreCase(choose)) { // Usar equalsIgnoreCase para comparar sin importar mayúsculas/minúsculas
            System.out.print("Ingrese el número de fila a calcular en la transpuesta: ");
            int fila = entrada.nextInt();

            if (fila >= 0 && fila < columnas) {
                for (int j = 0; j < filas; j++) {
                    suma += transpuesta[fila][j];
                }
                System.out.println("La suma de la fila " + fila + " de la transpuesta es: " + suma);
            } else {
                System.out.println("Fila fuera de rango.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
