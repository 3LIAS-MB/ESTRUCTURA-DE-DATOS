package Ejercicio5;

public class EmpleadoPlantaPermanente extends Empleado{
	private int cantidadHijos;
	private int fechaIngreso;
	
	public EmpleadoPlantaPermanente(double salarioBasico,String nombre, String apellido, int dni, int cantidadHijos, int fechaIngreso) {
		super(salarioBasico,nombre,apellido, dni);
		this.cantidadHijos=cantidadHijos;
		this.fechaIngreso=fechaIngreso;
	}
	
	@Override
	public double calcularSueldoTotal() {
		double sueldo = super.getSalarioBasico() + (cantidadHijos * 2000) + ((2023 - fechaIngreso) * 8000);
        return sueldo;
	}
	@Override
	public String toString() {
		return super.toString() + "\nEmpleadoPlantaPermanente [cantidadHijos=" + cantidadHijos + ", fechaIngreso=" + fechaIngreso
				+ ", salarioBasico=" + super.getSalarioBasico() + "]";
	}
	
	//getters-setters
	public int getCantidadHijos() {
		return cantidadHijos;
	}
	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	public int getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
