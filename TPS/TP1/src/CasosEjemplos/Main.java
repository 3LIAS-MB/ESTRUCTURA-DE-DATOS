package CasosEjemplos;

public class Main {
    public static void main(String[] args) {

    	CasosEjemplos libro2 = new CasosEjemplos("Libro 2", "Juan", "Paraninfo", "2016", 200.0f);
    	
    	System.out.println(libro2.getTitulo());
    	System.out.println(libro2.getAutor());
    	System.out.println(libro2.getAñoDePublicacion());
    	System.out.println(libro2.getEditorial());
    	System.out.println(libro2.getPrecio());

    	System.out.println(libro2.toString()); // Imprime el @Override
    	
    }
}
