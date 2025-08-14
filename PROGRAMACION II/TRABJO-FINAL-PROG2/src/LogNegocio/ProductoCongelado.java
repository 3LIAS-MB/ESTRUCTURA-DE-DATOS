package LogNegocio;
	
import java.io.Serializable;
import java.time.LocalDate;
	
public class ProductoCongelado extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String codigoOrganismoSupervisionAlimentaria;
    private LocalDate fechaDeEnvasado;
    private String granjaDeOrigen;
    private double temperaturaDeMantenimientoRecomendada;
    public static double margenGananciaCongelados;
    
	public ProductoCongelado(int codigo, String descripcion, LocalDate fechaVencimiento, int numeroLote, double costoTratamiento,
		String codigoOrganismoSupervisionAlimentaria, LocalDate fechaDeEnvasado, String granjaDeOrigen, double temperaturaDeMantenimientoRecomendada) {
		
		super(codigo,descripcion,fechaVencimiento,numeroLote,costoTratamiento);
		this.codigoOrganismoSupervisionAlimentaria = codigoOrganismoSupervisionAlimentaria;
		this.fechaDeEnvasado = fechaDeEnvasado;
		this.granjaDeOrigen = granjaDeOrigen;
		this.temperaturaDeMantenimientoRecomendada = temperaturaDeMantenimientoRecomendada;
		margenGananciaCongelados = 1.25;
	}

	public String getCodigoOrganismoSupervisionAlimentaria() {
		return codigoOrganismoSupervisionAlimentaria;
	}

	public void setCodigoOrganismoSupervisionAlimentaria(String codigoOrganismoSupervisionAlimentaria) {
		this.codigoOrganismoSupervisionAlimentaria = codigoOrganismoSupervisionAlimentaria;
	}

	public LocalDate getFechaDeEnvasado() {
		return fechaDeEnvasado;
	}

	public void setFechaDeEnvasado(LocalDate fechaDeEnvasado) {
		this.fechaDeEnvasado = fechaDeEnvasado;
	}

	public String getGranjaDeOrigen() {
		return granjaDeOrigen;
	}

	public void setGranjaDeOrigen(String granjaDeOrigen) {
		this.granjaDeOrigen = granjaDeOrigen;
	}

	public double getTemperaturaDeMantenimientoRecomendada() {
		return temperaturaDeMantenimientoRecomendada;
	}

	public void setTemperaturaDeMantenimientoRecomendada(double temperaturaDeMantenimientoRecomendada) {
		this.temperaturaDeMantenimientoRecomendada = temperaturaDeMantenimientoRecomendada;
	}

	@Override
	public String toString() {
		return "\nProductoCongelado\n"
				+ "Codigo supervision alimentaria: " + codigoOrganismoSupervisionAlimentaria
				+ "\nFecha de envasado: " + fechaDeEnvasado
				+ "\nGranja de origen:" + granjaDeOrigen
				+ "\nTemperatura de mantenimiento recomendada=" + temperaturaDeMantenimientoRecomendada;
	}
	
	
}
