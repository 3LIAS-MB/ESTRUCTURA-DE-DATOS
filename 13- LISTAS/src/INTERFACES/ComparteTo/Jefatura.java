package INTERFACES.ComparteTo;

public class Jefatura extends Empleado implements Jefes { // Esta es una subclase de Empleado
    private double incentivo; // 0.0

    public Jefatura(String nombre, double sueldo, int año, int mes, int dia) {
        super(nombre, sueldo, año, mes, dia);
    }

    public void estableceIncentivo(double incentivo) {
        this.incentivo = incentivo;
    }

    public double dameSueldo() {
        double sueldoJefe = super.dameSueldo();
        return sueldoJefe + incentivo;
    }
    
    // Al implementaar la interfaz Jefes obliga a desarrollar el metodo de la interfaz
	@Override
	public String tomarDecisiones(String decicion) {
		return "Un miembro de la direccion ha tomado la decicion de: " + decicion;
	}
	// No es obligatorio sobreescribir el metodo de la superinterfaz o interfaz padre. Sí es obligatorio
	// definir el metodo de la subinterfaz o interfaz hija
	@Override
	public double establece_bonus(double gratificacion) {
		double prima = 2000; // Esto solo lo tienen los jefes
		return Trabajadores.bonus_base + gratificacion + prima; // Trabajadores es la interfaz y bonus_base es
	}															// la constante estatica 	
}