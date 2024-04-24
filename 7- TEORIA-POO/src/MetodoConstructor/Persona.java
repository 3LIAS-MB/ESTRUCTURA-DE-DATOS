	package MetodoConstructor;

public class Persona {
	// Atributos
	String nombre;
	int edad;
	
	// Metodos
	
	
	
	// Metodo Constructor -> La forma para no usar el "this" es poner los parametros y atributos con nombre diferente
	public Persona(String nombre, int edad) {
		this.nombre = nombre; // "this.nombre" es  el atributo
		this.edad = edad;    //  "nombre" es el parametro
	}
	
	public void mostrarDatos() {
		System.out.println("El nombre es: "+nombre);
		System.out.println("La edad es: "+edad);

	}
}
