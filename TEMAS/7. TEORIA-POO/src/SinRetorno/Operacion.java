package SinRetorno;

public class Operacion {
	// Atributos
	int numero1;
	int numero2; 	// Cuando las variables estan fuera del metodo, se las conoce como variables globales
	int suma;       // y cuando estan dentro, se las conoce como variables locales
	int resta;
	int multiplicacion;
	int division;
	
	// Metodos
	

	// Metodo para sumar2
	public void sumar(int numero1, int numero2) {
		suma = numero1 + numero2;
	}
	// Metodo para restar
	public void restar(int numero1, int numero2) {
		resta = numero1 - numero2;
	}
	// Metodo para multiplicar
	public void multiplicacion(int numero1, int numero2) {
		multiplicacion = numero1 * numero2;
	}
	// Metodo para dividir
	public void division(int numero1, int numero2) {
		division = numero1 / numero2;
	}
	
	public void mostrarResultados() {
		System.out.println("La suma  es: "+ suma);
		System.out.println("La resta  es: "+ resta);
		System.out.println("La multiplicacion  es: "+ multiplicacion);
		System.out.println("La division  es: "+ division);
		
	}
}
	