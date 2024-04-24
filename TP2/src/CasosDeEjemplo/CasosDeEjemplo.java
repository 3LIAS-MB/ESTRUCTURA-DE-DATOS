/*Escribir un programa que permita ingresar números generados aleatoriamente (entre 1 y 100 inclusive)
en un arreglo de enteros de dimensión 10. El programa debe mostrar el resultado de la suma de los
números pares así como el producto de los impares.*/

package CasosDeEjemplo;

public class CasosDeEjemplo {
	public static void main(String[] args) {
		int suma = 0, producto = 1;
		int arreglo[] = new int[10];
		
		for(int i=0; i < arreglo.length; i++) {
			arreglo[i] = (int) (Math.random() * 100);
			
			if (arreglo[i] % 2 == 0) {
				suma += arreglo[i];
			}
			
			else if(arreglo[i] % 2 != 0) {
				producto *= arreglo[i];
			}
		}
		
		System.out.println("La suma es: " + suma);
		System.out.println("El producto es: " + producto);	
	}
}

