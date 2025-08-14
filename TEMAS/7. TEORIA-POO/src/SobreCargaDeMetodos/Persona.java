package SobreCargaDeMetodos; // -> Esto es polimorfismo

public class Persona {
	// Atributos
	String nombre;
	int edad;
	String dni;
	
	// Sobrecarga de metodos constructores

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona(String dni) {
		this.dni = dni;
	}
	
	// Sobrecarga de metodos normales
	
	public void correr() {
		System.out.println("Soy "+nombre+", tengo "+edad+" años y estoy corriendo una maraton");
	}
	
	public void correr(int km) { // Se diferencian por la cantidad de parametros o el tipo de parametro
		System.out.println("He corrido "+km+" kilometros");
	}
	
}
