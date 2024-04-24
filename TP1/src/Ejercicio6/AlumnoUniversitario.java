/*Crear la clase Alumno Universitario cuyos datos incluyen los de una persona y además, libreta universitaria,
carrera, universidad y año de ingreso. Establecer la relación existente entre Persona y Alumno
Universitario. Incluir al menos los siguientes métodos: a) Constructor con argumentos y b) Mostrar los
datos del alumno. Escribir un programa que permita crear cuatro alumnos, mostrar la información de los
hombres y determinar cuál es la mujer más joven de una carrera dada y cuál es el hombre de mayor edad
correspondiente a una universidad dada.*/

package Ejercicio6;

public class AlumnoUniversitario extends Persona {
	private int añoDeIngreso;
	private String libretaU;
	private String carrera;
	private String universidad;
	private String sexo;
	
	public AlumnoUniversitario(int dni, int edad, String nombre, int añoDeIngreso, String libretaU, String carrera, String universidad, String sexo) {
		super(dni, edad, nombre);
		this.añoDeIngreso = añoDeIngreso;
		this.libretaU = libretaU;
		this.carrera = carrera;	
		this.universidad = universidad;
		this.sexo = sexo;
	}

	public int getAñoDeIngreso() {
		return añoDeIngreso;
	}


	public String getLibretaU() {
		return libretaU;
	}

	public String getCarrera() {
		return carrera;
	}

	public String getUniversidad() {
		return universidad;
	}

	public String getSexo() {
		return sexo;
	}
	
	public String mostrarInfo() {
		return "\nNombre: " + getNombre() + "\nEdad: " + getEdad() + "\nDNI: " + getDni() + "\nLibreta Universitaria: " + libretaU +
				"\nCarrera: " + carrera + "\nUniversidad: " + universidad + "\nSexo: " + sexo;
	}
	
	
	public void mujerJoven() {
		
	}
	
	public void hombreMayor() {
		
	}
}