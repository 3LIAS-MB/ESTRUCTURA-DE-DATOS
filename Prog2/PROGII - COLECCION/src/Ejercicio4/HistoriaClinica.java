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

import java.util.ArrayList;
import java.util.List;

class HistoriaClinica {
    private Paciente paciente; // Atributo de tipo Paciente
    private List<Enfermedad> enfermedades;

    public HistoriaClinica(Paciente paciente) {
        this.paciente = paciente; // Le asigno el atributo al objeto de tipo Paciente
        this.enfermedades = new ArrayList<>();
    }

    public void registrarEnfermedad(String nombre, String sintomas, String tratamiento) {
        Enfermedad enfermedad = new Enfermedad(nombre, sintomas, tratamiento);
        enfermedades.add(enfermedad);
    }

    public void imprimirHistoriaClinica() {
        System.out.println("---------HISTORIA CLINICA---------");
        System.out.println(paciente);
        System.out.println("------ENFERMEDADES------");
        for (Enfermedad enfermedad : enfermedades) {
            System.out.println(enfermedad);
        }
    }

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Enfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
    
    
}
