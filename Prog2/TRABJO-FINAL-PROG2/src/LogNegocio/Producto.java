package LogNegocio;
import java.io.Serializable;
import java.time.LocalDate;

/*: La interfaz Serializable en Java se utiliza para indicar que una clase puede ser convertida a una
 * secuencia de bytes y luego reconstruida, lo que se conoce como serialización. Esta interfaz no tiene
 * métodos a implementar; actúa como una marca para el mecanismo de serialización de Java*/

public abstract class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

    private int codigo;
    private String descripcion;
    private LocalDate fechaVencimiento;
    private int numeroLote;
    private double costoTratamiento;
    
    
    public Producto(int codigo, String descripcion, LocalDate fechaVencimiento2, int numeroLote2,double costoTratamiento) {
    	this.codigo=codigo;
    	this.descripcion=descripcion;
    	this.fechaVencimiento=fechaVencimiento2;
    	this.numeroLote=numeroLote2;
    	this.costoTratamiento=costoTratamiento;
    }
    
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}

	public double getCostoTratamiento() {
		return costoTratamiento;
	}

	public void setCostoTratamiento(double costoTratamiento) {
		this.costoTratamiento = costoTratamiento;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", fechaVencimiento=" + fechaVencimiento
				+ ", numeroLote=" + numeroLote + ", costoTratamiento=" + costoTratamiento + "]";
	}
}
