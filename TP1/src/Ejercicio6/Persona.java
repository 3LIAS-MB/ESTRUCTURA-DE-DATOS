package Ejercicio6;

public class Persona {
	private int dni;
	private int edad;
	private String nombre;
	
	public Persona(int dni, int edad, String nombre) {
		this.dni = dni;
		this.edad = edad;
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}


	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}
	
}
