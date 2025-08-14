package Ejercicio5;

public class EmpleadoPorHora extends Empleado{
	private int horasTrabajadasAlMes;
	
	public EmpleadoPorHora(double salarioBasico,String nombre, String apellido, int dni, int horasTrabajadasAlMes) {
		super(salarioBasico, nombre, apellido, dni);
		this.horasTrabajadasAlMes=horasTrabajadasAlMes;
	}
	
	@Override
	public double calcularSueldoTotal() {
		double sueldo = super.getSalarioBasico()*horasTrabajadasAlMes; // this.getSalarioBasico
        return sueldo;
	}

	@Override
	public String toString() {
		return super.toString() + "\nEmpleadoPorHora [horasTrabajadasAlMes=" + horasTrabajadasAlMes + "]";
	}

	//getters-setters
	public int getHorasTrabajadasAlMes() {
		return horasTrabajadasAlMes;
	}

	public void setHorasTrabajadasAlMes(int horasTrabajadasAlMes) {
		this.horasTrabajadasAlMes = horasTrabajadasAlMes;
	}
	
	
}
