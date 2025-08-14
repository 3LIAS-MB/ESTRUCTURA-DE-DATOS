package LogNegocio;

import java.time.LocalDate;
import java.util.Date;

public class ProductoRefrigerado extends Producto {
	private static final long serialVersionUID = 1L;
    // Atributos específicos para productos refrigerados
    private String codigoSupervision;
    private LocalDate fechaEnvasado;
    private double temperaturaMantenimiento;
    private String granjaOrigen;
    public static double margenGananciaRefrigerados;
    
    // Constructor y métodos getter y setter
	public ProductoRefrigerado(int codigo, String descripcion, LocalDate localDate, int numeroLote,
		double costoTratamiento, String codigoSupervision, LocalDate localDate2,
		double temperaturaMantenimiento, String granjaOrigen) {
		super(codigo, descripcion, localDate, numeroLote, costoTratamiento);
		this.codigoSupervision = codigoSupervision;
		this.fechaEnvasado = localDate2;
		this.temperaturaMantenimiento = temperaturaMantenimiento;
		this.granjaOrigen = granjaOrigen;
		this.margenGananciaRefrigerados = 1.15;
	}
	
	public String getCodigoSupervision() {
		return codigoSupervision;
	}
	public void setCodigoSupervision(String codigoSupervision) {
		this.codigoSupervision = codigoSupervision;
	}
	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public double getTemperaturaMantenimiento() {
		return temperaturaMantenimiento;
	}
	public void setTemperaturaMantenimiento(double temperaturaMantenimiento) {
		this.temperaturaMantenimiento = temperaturaMantenimiento;
	}
	public String getGranjaOrigen() {
		return granjaOrigen;
	}
	public void setGranjaOrigen(String granjaOrigen) {
		this.granjaOrigen = granjaOrigen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\nPRODUCTO REFRIGERADO:"
				+ "\nCodigo: " + getCodigo()
				+ "\nDescripcion: " + getDescripcion()
				+ "\nFechaVencimiento: " + getFechaVencimiento()
				+ "\nCosto tratamiento: " + getCostoTratamiento()
				
				+ "\nNumero de lote: " + getNumeroLote()
				+ "\nFecha de envasado: " + fechaEnvasado
				+ "\nCodigo de supervision: " + codigoSupervision 
				+ "\nGranja de origen=" + granjaOrigen
				+ "\nTemperatura de mantenimiento: " + temperaturaMantenimiento

				+ "\nFechaEnvasado: " + getFechaEnvasado();

	}
}
