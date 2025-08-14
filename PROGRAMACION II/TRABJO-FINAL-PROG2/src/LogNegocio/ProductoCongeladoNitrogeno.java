package LogNegocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ProductoCongeladoNitrogeno extends ProductoCongelado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String metodoDeCongelacion;
    private int tiempoDeExposicionAlNitrogeno;
    
	public ProductoCongeladoNitrogeno(int codigo,String descripcion, LocalDate localDate,int numeroLote,double costoTratamiento,
			String codigoOrganismoSupervisionAlimentaria, LocalDate fechaDeEnvasado, String granjaDeOrigen, double temperaturaDeMantenimientoRecomendada, 
			String metodoDeCongelacion, int tiempoDeExposicionAlNitrogeno) {
		super(codigo,descripcion,localDate,numeroLote,costoTratamiento,codigoOrganismoSupervisionAlimentaria, fechaDeEnvasado, granjaDeOrigen,
				temperaturaDeMantenimientoRecomendada);
		this.metodoDeCongelacion = metodoDeCongelacion;
		this.tiempoDeExposicionAlNitrogeno = tiempoDeExposicionAlNitrogeno;
	}

	public String getMetodoDeCongelacion() {
		return metodoDeCongelacion;
	}
	public void setMetodoDeCongelacion(String metodoDeCongelacion) {
		this.metodoDeCongelacion = metodoDeCongelacion;
	}
	public int getTiempoDeExposicionAlNitrogeno() {
		return tiempoDeExposicionAlNitrogeno;
	}
	public void setTiempoDeExposicionAlNitrogeno(int tiempoDeExposicionAlNitrogeno) {
		this.tiempoDeExposicionAlNitrogeno = tiempoDeExposicionAlNitrogeno;
	}

	@Override
	public String toString() {
		return "\nPRODUCTO  CONGELADO CON NITROGENO:"
				+ "\nCodigo:" + getCodigo()
				+ "\nDescripcion: " + getDescripcion()
				+ "\nFecha de vencimiento: " + getFechaVencimiento()
				+ "\nCosto de tratamiento: " + getCostoTratamiento()
				
				+ "\nNumero de lote: " + getNumeroLote()
				+ "\nFecha de envasado:" + getFechaDeEnvasado()
				+ "\nCodigo de supervision alimentaria: " + getCodigoOrganismoSupervisionAlimentaria()
				+ "\nGranja de origen:" + getGranjaDeOrigen()
				+ "\nTemperatura de mantenimiento recomendada: " + getTemperaturaDeMantenimientoRecomendada()

				+ "\nMetodo de congelacion: " + metodoDeCongelacion
				+ "\nTiempo de exposicion al nitrogeno: " + tiempoDeExposicionAlNitrogeno;
		}
}
