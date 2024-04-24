package LogNegocio;

import java.io.Serializable;
import java.util.ArrayList;

import Datos.PersistenciaDatos;

public class Stock implements Serializable {
	
	/*El propósito de serialVersionUID es proporcionar una versión única
	 * de la clase para que los objetos serializados puedan ser deserializados
	 * correctamente, incluso si la clase ha cambiado desde que se serializó el objeto.*/
	
	/*Este número se utiliza para identificar la versión de la clase al serializar objetos.
	 * Si el número de versión en el momento de la deserialización no coincide con el número
	 *  de versión actual de la clase, se produce una excepción InvalidClassException.*/
	
	private static final long serialVersionUID = 1L;
	//PersistenciaDatos datos = new PersistenciaDatos();
	
	private static ArrayList<Lote> lotes;
	
	public Stock() {
		lotes =  PersistenciaDatos.cargarLotes();
	}
	
    public static double calcularCostoTotalEnStock() {
        double costoTotal = 0;
        for (Lote<?> lote : lotes) {
            for (Producto producto : lote.getProductos()) {
                costoTotal += producto.getCostoTratamiento();
            }
        }
        return costoTotal;
    }
    
	public static double costoTotalDeUnLoteDeterminado(int numeroLote) {
        for (Lote lote : lotes) {
            if (lote.getNroDeLote() == numeroLote) {
                return lote.calcularCostoTotalLote();
            }
        }
        return -1;
    }
    
    // Setters y Getters
	public ArrayList<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(ArrayList<Lote> lotes) {
		this.lotes = lotes;
	}

	public void add(Lote<?> lote) {
		lotes.add(lote);
	}
}