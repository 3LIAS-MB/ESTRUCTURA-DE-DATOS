package LogNegocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class ProductoCongeladoAire extends ProductoCongelado implements Serializable {

	private static final long serialVersionUID = 1L;
	private double nitrogeno;
    private double oxigeno;
    private double dioxidoDeCarbono;
    private double vaporDeAgua;
    
	public ProductoCongeladoAire(int codigo, String descripcion, LocalDate localDate,
								int numeroLote, double costoTratamiento, String codigoOrganismoSupervisionAlimentaria,
								LocalDate fechaDeEnvasado, String granjaDeOrigen,double temperaturaDeMantenimientoRecomendada,
								double nitrogeno, double oxigeno, double dioxidoDeCarbono, double vaporDeAgua) {
		
			super(codigo,descripcion,localDate,numeroLote,costoTratamiento,
				 codigoOrganismoSupervisionAlimentaria, fechaDeEnvasado,
				 granjaDeOrigen, temperaturaDeMantenimientoRecomendada);
			
			this.nitrogeno = nitrogeno; 
			this.oxigeno = oxigeno;
			this.dioxidoDeCarbono = dioxidoDeCarbono;
			this.vaporDeAgua = vaporDeAgua;
	}

	public double getNitrogeno() {
		return nitrogeno;
	}

	public void setNitrogeno(double nitrogeno) {
		this.nitrogeno = nitrogeno;
	}

	public double getOxigeno() {
		return oxigeno;
	}

	public void setOxigeno(double oxigeno) {
		this.oxigeno = oxigeno;
	}

	public double getDioxidoDeCarbono() {
		return dioxidoDeCarbono;
	}

	public void setDioxidoDeCarbono(double dioxidoDeCarbono) {
		this.dioxidoDeCarbono = dioxidoDeCarbono;
	}

	public double getVaporDeAgua() {
		return vaporDeAgua;
	}

	public void setVaporDeAgua(double vaporDeAgua) {
		this.vaporDeAgua = vaporDeAgua;
	}

	@Override
	public String toString() {
		return "\nPRODUCTO CONGELADO CON AIRE:"
				+ "\nCodigo: " + getCodigo()
				+ "\nDescripcion: " + getDescripcion()
				+ "\nFecha de vencimiento: " + getFechaVencimiento()
				+ "\nCosto de tratamiento:  " + getCostoTratamiento()
				
				+ "\nNumero de lote: " + getNumeroLote()
				+ "\nFecha de envasado: " + getFechaDeEnvasado()
				+ "\nCodigo de supervision alimentaria: " + getCodigoOrganismoSupervisionAlimentaria()
				+ "\nGranja de origen: " + getGranjaDeOrigen()
				+ "\nTemperatura de mantenimiento: " + getTemperaturaDeMantenimientoRecomendada()
				
				+ "\nNitrogeno: " + nitrogeno
				+ "\nOxigeno: " + oxigeno
				+ "\nDioxido de carbono: " + dioxidoDeCarbono
				+ "\nVapor de agua: " + vaporDeAgua;
				

	}
}
