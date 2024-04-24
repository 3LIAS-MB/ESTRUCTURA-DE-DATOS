package CasosEjemplos;
	
public class CasosEjemplos {
	private String titulo;
	private String autor;
	private String editorial;
	private String añoDePublicacion;
	private float precio;
	
	public CasosEjemplos() {
	}
	
	public CasosEjemplos(String titulo, String autor, String editorial, String añosDePublicacion, float precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.añoDePublicacion = añosDePublicacion;
		this.precio = precio;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTiutlo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAñoDePublicacion() {
		return añoDePublicacion;
	}

	public void setAñoDePublicacion(String añoDePublicacion) {
		this.añoDePublicacion = añoDePublicacion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "CasosDeEstudio [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", añoDePublicacion=" + añoDePublicacion + ", precio=" + precio + "]";
	}	
	
}
