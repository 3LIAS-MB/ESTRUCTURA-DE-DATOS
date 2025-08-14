/*Para cada clase complete o adicione los métodos de acuerdo a su responsabilidad y a las
necesidades requeridas.

a) Crear una clase llamada Clínica que contenga una colección de historias clínicas, y los
atributos que crea conveniente. Implementar un método que permita agregar historias
clínicas a dicha colección.
b) Para crear una historia clínica se requiere como paso obligatorio, ingresar los datos de
un paciente, el cual será un objeto tipo Paciente. Los datos del paciente son: dni, nombre,
teléfono y fecha de nacimiento.
c) Registrar enfermedad de un paciente determinado: debe solicitar los datos de la
enfermedad que desea agregarse a la historia clínica (nombre, síntomas, tratamientos).
d) Eliminar la historia clínica de un paciente determinado.
e) Imprimir historia clínica de un paciente determinado: Despliega la información en pantalla
de la historia clínica. Se sugiera utilizar el método “ToString()” de la clase HistoriaClínica,
el cual tiene el siguiente formato de presentación: */

package Ejercicio4;

import java.time.LocalDate;

class Paciente {
    private String dni;
    private String nombre;
    private String telefono;
    private LocalDate fechaNacimiento; //fechaNacimiento puede contener objetos LocalDate, y puede acceder a los
    								   //métodos y propiedades proporcionados por la clase LocalDate para trabajar con fechas.

    public Paciente(String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + calcularEdad() + "\nTeléfono: " + telefono;
    }

    private int calcularEdad() {
        LocalDate now = LocalDate.now(); // Fecha actual
        return now.getYear() - fechaNacimiento.getYear();// 
    }

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
}