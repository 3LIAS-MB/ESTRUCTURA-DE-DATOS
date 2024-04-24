// Miembros estaticos de una clase o miembros de ckase

package MiembrosEstaticosDeUnaClase;

public class Estatico {
	
	private static String frase = "Primera frase"; // static hace que el atributo ya no le pertenezca al objeto, sino  a la clase y que tampoco haya que instanciarlos
	
	//Metodo para sumar
	public static int sumar(int n1, int n2) { // ESTATIC FUNCIONA PARA METODOS 
		int suma = n1 + n2;					  // Y PARA ATRIBUTOS
		return suma;
	}
	
	public static void main(String[] args) {
		
		System.out.print(Estatico.frase); // Invoco el valor del atributo con el nombre de la clase y "frase"
		System.out.print("\nsLa suma es: "+Estatico.sumar(3, 4));
		
		//Estatico ob1 = new Estatico(); 
		//Estatico ob2 = new Estatico();
		
		// ob2.frase = "Segunda frase"; -> Con "static" no importa desde que objeto modifico al atributo, lo hace para todos en general
	}
	
	
}
