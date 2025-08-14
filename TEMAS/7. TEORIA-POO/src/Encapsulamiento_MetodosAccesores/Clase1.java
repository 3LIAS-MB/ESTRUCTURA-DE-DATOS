// Encapsulamiento y Metodos accesores (Setters y Getters) -> Nos sirven para manipular atrivutos que esten encapsulados (private)

package Encapsulamiento_MetodosAccesores;

public class Clase1 {
	
	private int edad;
	private String nombre;
	
	public static String apellido = "mamani"; // Creando un atributo estatico (Se accede con el nombre de la clase y no necesita una instancia)
	
	// Metodo Setter: Estableciendo la edad
	
	public void setEdad(int edad) { 
		this.edad = edad; 
	}
	
	// Metodo Getter: Mostrando la edad
	
	public int getEdad() { 
		return edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}

	
// Modificadores de acceso -> private y public