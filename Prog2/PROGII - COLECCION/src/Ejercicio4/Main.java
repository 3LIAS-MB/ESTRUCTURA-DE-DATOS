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
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 Scanner entrada = new Scanner(System.in);

		 	Clinica clinica = new Clinica();

		    Paciente paciente1 = new Paciente("43633913", "Juan Perez", "123-456-7890", LocalDate.of(1980, 5, 15));
		    Paciente paciente2 = new Paciente("87654321", "Maria Rodriguez", "987-654-3210", LocalDate.of(1990, 8, 25));

		    HistoriaClinica historiaClinica1 = new HistoriaClinica(paciente1);
		    HistoriaClinica historiaClinica2 = new HistoriaClinica(paciente2);

		    historiaClinica1.registrarEnfermedad("Sarampión", "Rondas, Calenturas", "Descanso");
		    historiaClinica2.registrarEnfermedad("Gripe", "Fiebre, Tos", "Medicamentos");

		    clinica.agregarHistoriaClinica(historiaClinica1);
		    clinica.agregarHistoriaClinica(historiaClinica2);

		    historiaClinica1.imprimirHistoriaClinica();	 
		    
		    
		}
	 }


