package Ejercicio5;

public class Main {
    public static void main(String[] args) {

    	Libros libro2 = new Libros("Libro 2", "Juan", "Paraninfo", "2016", 200.0f);
    	
    	System.out.println(libro2.getTitulo());
    	System.out.println(libro2.getAutor());
    	System.out.println(libro2.getAñoDePublicacion());
    	System.out.println(libro2.getEditorial());
    	System.out.println(libro2.getPrecio());

    	System.out.println(libro2.toString()); // Imprime el @Override
    	
    }
}
