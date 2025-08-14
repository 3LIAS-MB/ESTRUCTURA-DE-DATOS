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

import java.util.List;
import java.util.ArrayList;


public class Clinica {
    private List<HistoriaClinica> historiasClinicas;

    public Clinica() {
        this.historiasClinicas = new ArrayList<>();
    }

    public void agregarHistoriaClinica(HistoriaClinica historiaClinica) {
        historiasClinicas.add(historiaClinica);
    }

    public void eliminarHistoriaClinica(Paciente paciente) {
        historiasClinicas.removeIf(historiaClinica -> historiaClinica.getPaciente().equals(paciente));
    }

    public HistoriaClinica buscarHistoriaClinica(Paciente paciente) {
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            if (historiaClinica.getPaciente().equals(paciente)) {
                return historiaClinica;
            }
        }
        return null;
    }
    
    public void imprimirHistoriaClinica(Paciente paciente) {
        HistoriaClinica historiaClinica = buscarHistoriaClinica(paciente);
        if (historiaClinica != null) {
            historiaClinica.imprimirHistoriaClinica();
        } else {
            System.out.println("No se encontró la historia clínica de " + paciente.getNombre());
        }
    }

}

