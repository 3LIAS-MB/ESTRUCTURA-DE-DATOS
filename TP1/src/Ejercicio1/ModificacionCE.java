package Ejercicio1;

public class ModificacionCE {
    private String titulo;
    private String autor;
    private String editorial;
    private double precio;
    private int cantidadHojas;
    private String isbn;

    public ModificacionCE(String titulo, String autor, String editorial, double precio, int cantidadHojas, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.cantidadHojas = cantidadHojas;
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getInfoLibro() {
        return "Título: " + titulo + "\nAutor: " + autor + "\nEditorial: " + editorial + "\nPrecio: $" + precio + "\nHojas: " + cantidadHojas + "\nISBN: " + isbn;
    }
}	