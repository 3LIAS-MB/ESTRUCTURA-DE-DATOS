package Ejercicio5;

public class Empleado {	
	private String nombre;
	private int dni;
	private String apellido;
	private double salarioBasico;
	
	public Empleado(double salarioBasico, String nombre, String apellido, int dni) {
		this.salarioBasico=salarioBasico;
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
	
	public double calcularSueldoTotal() {
		return this.salarioBasico;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", dni=" + dni + ", apellido=" + apellido + ", salarioBasico="
				+ salarioBasico + "]";
	}

	//getters-setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSalarioBasico() {
		return salarioBasico;
	}

	public void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}
	
	
	
}
