package Ejercicio5;

public class Principal {

	public static void main(String[] args) {
		
		EmpleadoPlantaPermanente empleadoPp = new EmpleadoPlantaPermanente(140000.0, "sammi", "soria", 12345, 2, 2022);
		double sueldoTotal1 =empleadoPp.calcularSueldoTotal();
		System.out.println(empleadoPp + "\nSalario Total: "+ sueldoTotal1);
		
		System.out.println("\n");
		
		EmpleadoPorHora empleadoPh = new EmpleadoPorHora(2000.0, "alexxe", "calatayud", 67890,200);
		double sueldoTotal2 =empleadoPh.calcularSueldoTotal();
		System.out.println(empleadoPh + "\nSalario Total: "+ sueldoTotal2);
	}

}
