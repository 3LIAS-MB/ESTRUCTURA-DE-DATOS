	package Encapsulamiento_MetodosAccesores;

public class Clase2 {
	public static void main(String[] args) {
		
		Clase1 objeto1 = new Clase1();
		
		// objeto1.edad = 10;
		
		// Set: establecer un valor al atributo
		// Get: obtener el valor del atributo
		
		
		
		objeto1.setEdad(21);
		System.out.println("La edad es: " + objeto1.getEdad());
		
		
		objeto1.setNombre("Elias");
		System.out.println("El nombre es: " + objeto1.getNombre());
		
		System.out.println(Clase1.apellido); // Puedo acceder a un atributo con el nombre de su clase solo si este es estatico
	}
}
