package LogNegocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ProductoCongeladoAgua extends ProductoCongelado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double salinidad;

	public ProductoCongeladoAgua(int codigo, String descripcion, LocalDate fechaVencimiento, int numeroLote,double costoTratamiento,
			String codigoOrganismoSupervisionAlimentaria, LocalDate fechaDeEnvasado, String granjaDeOrigen,
			double temperaturaDeMantenimientoRecomendada, double salinidad) {
			super(codigo,descripcion,fechaVencimiento,numeroLote,costoTratamiento,codigoOrganismoSupervisionAlimentaria, fechaDeEnvasado, granjaDeOrigen,temperaturaDeMantenimientoRecomendada);
			this.salinidad = salinidad;
	}
	
	public double getSalinidad() {
		return salinidad;
	}

	public void setSalinidad(double salinidad) {
		this.salinidad = salinidad;
	}
	
	@Override
	public String toString() {
		return "\nPRODUCTOS CONGELADOS CON AGUA:"
				+ "\nCodigo: " + getCodigo() 
				+ "\nDescripcion: " + getDescripcion()
				+ "\nFecha de vencimiento: " + getFechaVencimiento()
				+ "\nCosto de tratamiento: " + getCostoTratamiento()
				
				+ "\nNumero de lote: " + getNumeroLote()
				+ "\nCodigo de supervisión alimentaria: " + getCodigoOrganismoSupervisionAlimentaria()
				+ "\nFecha de envasado: " + getFechaDeEnvasado()
				+ "\nGranja de origen: " + getGranjaDeOrigen()
				+ "\nTemp. de mantenimiento recomendada: " + getTemperaturaDeMantenimientoRecomendada()
				
				+ "\nSalinidad: " + getSalinidad();
	}
	
	
}
