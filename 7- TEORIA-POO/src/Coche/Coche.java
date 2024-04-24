package Coche;

public class Coche {
		String color;
		String marca;
		int km;
		
		public static void main(String[] args) { // En Java, el método main tiene un significado especial y es el punto de entrada principal
			                                     // para la ejecución de un programa. Aquí se desglosa su función:
			Coche coche1 = new Coche();
			
			coche1.color = "Blanco";
			coche1.marca = "Audi";
			coche1.km = 0;
			
			System.out.println("El color del coche1 es: " + coche1.color);
			System.out.println("La marca del coche1 es: " + coche1.marca);
			System.out.println("El kilometraje del coche1 es:: " + coche1.km);
			
			Coche coche2 = new Coche();
			
			coche2.color = "Rojo";
			coche2.marca = "Ferrari";
			coche2.km = 100;
			
			System.out.println("\nEl color del coche2 es: " + coche2.color);
			System.out.println("La marca del coche2 es: " + coche2.marca);
			System.out.println("El kilometraje del coche2 es:: " + coche2.km);
			
		}
	}

			
			// Coche coche1 = new Coche(); - > nombreDeLaClase NombreObjeto = new Constructor();
			

