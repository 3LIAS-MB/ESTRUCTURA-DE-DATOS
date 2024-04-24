package primerParcial_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Matriz {
/*Escribir un programa que permita ingresar los valores de una matriz cuadrada (arreglo de dos 
dimensiones), mostrar la matriz en la consola y calcular la suma de los elementos que no pertenezcan a 
la diagonal principal. Además, informar la cantidad de números positivos, negativos y ceros que 
contiene la matriz.*/
	private int filas, columnas;
	private int matriz[][];
	Scanner scanner = new Scanner(System.in);
	
	public Matriz(int filas, int columnas) {
		this.filas=filas;
		this.columnas=columnas;
		this.matriz=new int[filas][columnas];
	}
	
	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	
	public void llenarMatrizConsecutivos() {
	    for (int i =  0; i < filas; i++) {
	        for (int j =  0; j < columnas; j++) {
	            System.out.println("Ingrese el valor para la posición [" + i + "][" + j + "]: ");
	            matriz[i][j] = scanner.nextInt();
	        }
	    }
	}
	
	public void sumaNumerosNoMatrizDiagonal() {
	    int suma =  0;
	    for (int i =  0; i < filas; i++) {
	        for (int j =  0; j < columnas; j++) {
	            // Verifica que el índice de columna sea diferente al de fila
	            // para excluir la diagonal principal
	            if (i != j) {
	                suma += matriz[i][j];
	            }
	        }
	    }
	    System.out.println("Suma de los números de la matriz que no pertenecen a la diagonal principal: " + suma);
	}
	
	public void imprimirMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	/*A) La suma de los elementos de cada fila y
	guardar el resultado en un vector.*/
	public ArrayList<Integer> sumaElementosFila() {
		ArrayList<Integer> vectorSuma = new ArrayList<>();
		for(int i=0;i<matriz.length;i++) {
			int sumaFila=0;
			for(int j=0;j<matriz[i].length;j++) {
				sumaFila+=matriz[i][j];
		    }
			vectorSuma.add(sumaFila);
		}
		return vectorSuma;
	}
	
	/*public double[] obtenerMinimosColumna() {
	    int filas = matriz.length;
	    int columnas = matriz[0].length;

	    double[] minimosColumnas = new double[columnas];

	    for (int j = 0; j < columnas; j++) {
	        double minimo = matriz[0][j];
	        
	        for (int i = 1; i < filas; i++) {
	            if (matriz[i][j] < minimo) {
	                minimo = matriz[i][j];
	            }
	        }
	        minimosColumnas[j] = minimo;
	    }
	    return minimosColumnas;
	}*/

	
	public ArrayList<Integer> obtenerMinimosColumnas() {
	    int filas = matriz.length;
	    int columnas = matriz[0].length;

	    ArrayList<Integer> minimosColumnas = new ArrayList<>();

	    for (int j = 0; j < columnas; j++) {
	    	Integer minimo = matriz[0][j];
	        
	        for (int i = 1; i < filas; i++) {
	            if (matriz[i][j] < minimo) {
	                minimo = matriz[i][j];
	            }
	        }

	        minimosColumnas.add(minimo) ;
	    }
	    return minimosColumnas;
	}

	public static Matriz crearMatriz() {
		int filas = Helper.validarInt("Ingrese n° de filas: ");
		int columnas = Helper.validarInt("Ingrese n° de columnas");
		return new Matriz(filas, columnas);
	}
	
	
}