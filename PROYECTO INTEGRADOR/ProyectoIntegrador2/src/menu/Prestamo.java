package menu;
import java.time.LocalDate;

public class Prestamo implements Comparable<Prestamo> { // Lista enlazada - prestamos -> (prestados, perdiddos)
	static int numero=0;
	private int numeroIdentificador;
	private String codigoDeLibro;
	private int numeroSocio;
	private LocalDate fechaPrestamo;
	private int plazo; // 24, 48 o 72 hs
	private LocalDate fechaVencimiento;
	private String estado; // vigente, vencido, devuelto, irrecuperable
	private LocalDate fechaDevolucion;
	private int multa;
	
	public Prestamo(String codigoDeLibro,int numeroSocio,LocalDate fechaPrestamo,int plazo) {
		this.numeroIdentificador=asignarNumero();
		this.codigoDeLibro=codigoDeLibro;
		this.numeroSocio=numeroSocio;
		this.fechaPrestamo=fechaPrestamo;
		this.plazo=plazo;
		this.fechaVencimiento=fechaPrestamo.plusDays(plazo/24); // plusYears();
		this.estado="vigente";	
		this.fechaDevolucion=null;
		this.multa=0;
	}
	public static int asignarNumero() {
		numero+=1;
		return numero;
	}
	public static int getNumero() {
		return numero;
	}
	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}
	public String getCodigoDeLibro() {
		return codigoDeLibro;
	}
	public int getNumeroSocio() {
		return numeroSocio;
	}
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}
	public int getPlazo() {
		return plazo;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	public int getMulta() {
		return multa;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public void setMulta(int multa) {
		this.multa = multa;
	}
	@Override
	public String toString() {
		return "Prestamo: \nnumeroIdentificador=" + numeroIdentificador + "\ncodigoDeLibro=" + codigoDeLibro
				+ "\nnumeroSocio=" + numeroSocio + "\nfechaPrestamo=" + fechaPrestamo + "\nplazo=" + plazo
				+ "\nfechaVencimiento=" + fechaVencimiento + "\nestado=" + estado + "\nfechaDevolucion="
				+ fechaDevolucion + "\nmulta=" + multa + "\n";
	}
	public int compareTo(Prestamo o) {
        return Integer.compare(getNumeroIdentificador(), o.getNumeroIdentificador());
    }
}
