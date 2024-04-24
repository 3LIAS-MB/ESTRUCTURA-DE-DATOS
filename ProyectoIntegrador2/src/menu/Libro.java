package menu;

public class Libro implements Comparable<Libro> { // Árbol binario de búsqueda - disponibles
	private String codigo;
	private String titulo;
	private String autor;
	private String editorial;
	private int añoDePublicacion;
	private String tematica;
	private int precio;
	
	public Libro(String codigo,String titulo,String autor,String editorial, int añoDePublicacion, String tematica,int precio) {
		this.codigo=codigo;
		this.titulo=titulo;
		this.autor=autor;
		this.editorial=editorial;
		this.añoDePublicacion=añoDePublicacion;
		this.tematica=tematica;
		this.precio=precio;
	}
	
	public Libro(String codigo) {
		this.codigo=codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public int getAñoDePublicacion() {
		return añoDePublicacion;
	}

	public String getTematica() {
		return tematica;
	}

	public int getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "Libro: \ncodigo=" + codigo + "\ntitulo=" + titulo + "\nautor=" + autor + "\neditorial=" + editorial
				+ "\nañoDePublicacion=" + añoDePublicacion + "\ntematica=" + tematica + "\nprecio=" + precio + "\n";
	}
	
	public int compareTo(Libro o) {
        return (getCodigo().compareTo(o.getCodigo()));
    }
	
}
