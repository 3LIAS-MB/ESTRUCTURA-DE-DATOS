package Ejercicio7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AlumnoUniversitario[] alumnos = new AlumnoUniversitario[3]; // Crea un array de clase con una longitud de 3
		
		for (int i = 0; i < 3; i++) {
			alumnos[i] = AlumnoUniversitario.crearAlumno();
			System.out.println(alumnos[i]+ "\n"); // Imprime el array
		}
		
		AlumnoUniversitario mujerJoven = AlumnoUniversitario.calcularMujerJoven(alumnos, "lic sis");
		System.out.println("\n Mujer mas joven: "+ mujerJoven);
		
		AlumnoUniversitario hombreViejo = AlumnoUniversitario.buscarHombreViejo(alumnos, "Unju");
		System.out.println("\n Hombre mas viejo "+ hombreViejo);
	}

}