package menu;

public class Socio implements Comparable<Socio> { // Árbol binario de búsqueda - activos
	private int numero;
	private String dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private int telefono;
	private String estado; // moroso, suspendido, ok
	
	public Socio(int numero,String dni,String nombre,String apellido,String domicilio,int telefono) {
		this.numero=numero;
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.estado="ok"; // moroso, suspendido, ok
	}
	public Socio(int numero) {
		this.numero=numero;
		this.estado="ok";
	}

	public Socio(int numero, String dni, String nombre, String apellido, String domicilio, int telefono, String estado) {
		this.numero = numero;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.estado = estado;
	}
	public int getNumero() {
		return numero;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Socio: \nnumero=" + numero + "\ndni=" + dni + "\nnombre=" + nombre + "\npellido=" + apellido
				+ "\ndomicilio=" + domicilio + "\ntelefono=" + telefono + "\nestado=" + estado + "\n";
	}
	// Integer.compare toma dos valores int
	public int compareTo(Socio o) {
        return Integer.compare(this.getNumero(), o.getNumero());
    }
}
