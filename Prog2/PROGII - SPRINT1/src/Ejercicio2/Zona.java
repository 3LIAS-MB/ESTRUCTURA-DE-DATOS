package Ejercicio2;


public class Zona {
	private String nombreZona;
	private int entradasDisponibles;
	
	public Zona(String nombreZona, int entradasDisponibles) {
		this.nombreZona=nombreZona;
		this.entradasDisponibles=entradasDisponibles;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public int getEntradasDisponibles() {
		return entradasDisponibles;
	}

	public void setEntradasDisponibles(int entradasDisponibles) {
		this.entradasDisponibles = entradasDisponibles;
	}
	
	public int venderEntradas(int cantidadEntradas) {
		while(true) {
			if (cantidadEntradas>0 && cantidadEntradas <= this.entradasDisponibles) {
				this.entradasDisponibles = this.entradasDisponibles - cantidadEntradas;
				System.out.println("Cantidad de entradas restantes: "+ entradasDisponibles);
				return this.entradasDisponibles;
			} else {
				System.out.println("Ingrese un valor valido");
			}
			
		}
	}
}
	