package Ejercicio7;

public class AlumnoUniversitario extends Persona{
	private String lu;
	private String carrera;
	private int anoDeIngreso;
	private String uni;
	
	public AlumnoUniversitario(String nombre, String apellido, int edad,String genero,String lu, String carrera, int anoDeIngreso, String uni) {
		super(nombre, apellido, edad, genero);
		this.lu=lu;
		this.carrera=carrera;
		this.anoDeIngreso=anoDeIngreso;
		this.uni = uni;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n"+ "Alumno Uni: "+ this.carrera + " "+ this.lu + 
				" "+ this.uni + " "+ this.anoDeIngreso;
	}
	
	public static AlumnoUniversitario crearAlumno() { // El tipo de retorno del metodo es AlumnoUniversitario,
												      // lo que significa que devuelve una instancia de la clase "AlumnoUniversitario"
		String nombre = Helper.validarString("Ingrese nombre del alumno: ");
		String apellido =  Helper.validarString("Ingrese apellido del alumno: ");
		int edad = Helper.validarEdad("Ingrese edad del alumno: ");
		String genero = Helper.getChar("Ingrese genero del alumno: ");
		String lu = Helper.validarString("Ingrese lu del alumno: ");
		String carrera = Helper.validarString("Ingrese carrera del alumno: ");
		int anoIngreso = Helper.validarAnoIngreso("Ingrese Año de ingreso del alumno: ");
		String uni = Helper.validarString("Ingrese nombre de la uni del alumno: ");
		
		return new AlumnoUniversitario(nombre, apellido, edad, genero,lu, carrera, anoIngreso, uni); // Crea unea instancia de AlumnoUniversitario
	}
	
	public static AlumnoUniversitario calcularMujerJoven(AlumnoUniversitario[] alumnos, String carrera) {
		AlumnoUniversitario menor = null;
        for (AlumnoUniversitario alumno : alumnos) {
            if (alumno.getGenero().equals("F") && alumno.getCarrera().equals(carrera)) {
                if (menor == null || alumno.getEdad() < menor.getEdad()) {
                    menor = alumno;
                }
            }
        }
        return menor;
	}
	
	public static AlumnoUniversitario buscarHombreViejo(AlumnoUniversitario[] alumnos, String universidad) {
        AlumnoUniversitario mayor = null;
        for (AlumnoUniversitario alumno : alumnos) {
            if (alumno.getGenero().equals("M") && alumno.getUni().equals(universidad)) {
                if (mayor == null || alumno.getEdad() > mayor.getEdad()) {
                    mayor = alumno;
                }
            }
        }
        return mayor;
    }

	public String getLu() {
		return lu;
	}

	public void setLu(String lu) {
		this.lu = lu;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getAnoDeIngreso() {
		return anoDeIngreso;
	}

	public void setAnoDeIngreso(int anoDeIngreso) {
		this.anoDeIngreso = anoDeIngreso;
	}

	public String getUni() {
		return uni;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}
	
	
	
}