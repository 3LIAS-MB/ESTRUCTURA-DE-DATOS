package BLUCLES;

public class BlucleForEach {
	public static void main(String[] args) {
		int[] numeros = {1, 2, 3, 4, 5};

		for (int numero : numeros) { // Bucle for each -> Las variables temporales de una clase pueden llamar a metodos
		    System.out.println(numero);
		}
		
		/**/
		
		String[] nombres = {"Alejandro", "Elias", "Elena",  "Martina", "Josefa"};
		
		for (String i: nombres) { // Bucle for each -> (Tipo variable : Coleccion)
			System.out.println("Nombres: "+i);
		}
	}

}
	