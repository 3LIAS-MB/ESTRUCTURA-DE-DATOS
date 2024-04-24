package Ejercicio7;

public class Persona {
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	
	public Persona(String nombre, String apellido, int edad, String genero) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.genero=genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return this.genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String toString() {
		return "Persona: "+ this.nombre + " "+ this.apellido +" "+this.edad + " "+this.genero;
	}
	
}