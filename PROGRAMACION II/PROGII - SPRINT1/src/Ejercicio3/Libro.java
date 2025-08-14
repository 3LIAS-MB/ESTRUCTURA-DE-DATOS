package Ejercicio3;

import java.time.LocalDate;

public class Libro {
    private String titulo;
    private String isbn;
    private LocalDate fechaPublicacion;
    private Autor autor = null; // El "null" en este caso es opcional

 
    public Libro() {
        titulo = "";
        isbn = "";
        fechaPublicacion = LocalDate.now(); // Fecha actual por defecto
        autor = new Autor(); // Inicializamos el autor con valores predeterminados
    }

    public Libro(String titulo, String isbn, LocalDate fechaPublicacion, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {	
        this.isbn = isbn;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean esPublicacionReciente() {
        LocalDate fechaActual = LocalDate.now();
        return fechaPublicacion.isAfter(fechaActual.minusYears(5)); // Devuelve un valor booleano
    }

    public String getInfoLibro() {
        return "Título: " + titulo + "\nISBN: " + isbn + "\nFecha de Publicación: " + fechaPublicacion + "\nAutor: " + autor.getEdad();
    }

    // Getter y setter para el autor
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
