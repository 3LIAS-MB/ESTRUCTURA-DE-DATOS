package ProgramacionGenerica3;

public class Pareja <T> { // Clase generica
	private T primero;
	
	public Pareja() {
		primero  = null;
	}
	
	public void setPrimero(T nuevoValor) {
		primero = nuevoValor;
	}
	
	public T getPrimero() {
		return this.primero; // devuelve un objeto de la clase persona
	}						 // en el caso del objeto 'dos'
}
