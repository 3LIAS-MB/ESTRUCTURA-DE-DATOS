package Ejercicio4;

public class Animal {
	private String nombre;
	private String color;
	private int peso;

	public Animal(String nombre, String color, int peso2) {
		this.nombre = nombre;
		this.color = color;
		this.peso = peso2;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public void accionAnimal() {
		System.out.println(nombre + " realiza una acción genérica.");
	}


	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", color=" + color + ", peso=" + peso + "]";
	}
}
		



