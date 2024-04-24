/*Series
Una Serie está formada por un conjunto de temporadas, cada una de las cuales tiene una
cantidad de episodios. Cada episodio posee un título, una descripción, un atributo indicando
si el usuario ya vio el episodio y una calificación dada por el usuario (con valores de 1 a 5).
Si el usuario no vio un episodio particular, la calificación dada será un valor negativo.
Las series poseen como atributos (además de los episodios correspondientes) un título, una
descripción, un creador y un género.

Implementar las clases involucradas, determinar qué clase es responsable de responder los
siguientes servicios:

• Ingresar la calificación de un episodio. Si el valor ingresado como calificación no es
correcto imprimir un mensaje por pantalla y no cambiar el valor anterior.
• Obtener el total episodios vistos de una temporada particular.
• Obtener el promedio de las calificaciones dadas por el usuario para una temporada
particular.

• Obtener el total de episodios vistos de una serie.
• Obtener el promedio de las calificaciones dadas por el usuario para una serie.
• Determinar si el usuario ya vio todos los episodios de la serie. */

package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        
    	//Creación de Episodios, temporada y serie...
    	
        Episodio episodio1 = new Episodio("1-Señor Dinosaurio", "George pierde su juguete favorito..");
        Episodio episodio2 = new Episodio("2-Lucas el Loro", "Los abuelos tienen una nueva mascota..");
        Episodio episodio3 = new Episodio("3-Mejores Amigas", "Peppa no quiere que George juegue con ella y con su amiga..");

        episodio1.setCalificacion(4);
        episodio2.setCalificacion(5);
        episodio3.setCalificacion(3);

        Temporada temporada1 = new Temporada();
        temporada1.agregarEpisodio(episodio1);
        temporada1.agregarEpisodio(episodio2);
        temporada1.agregarEpisodio(episodio3);

        Serie serie1 = new Serie("Peppa Pig", "Peppa es una cerdita que vive con su hermano George y sus padres Mamá Pig y Papá Pig", "Mark Baker", "Infantíl");
        serie1.agregarTemporada(temporada1);


        // Imprimir por pantalla la información... .
        System.out.println("Nombre de la serie: "+serie1.getTitulo());
        System.out.println("Total de episodios vistos en la serie: " + serie1.getTotalEpisodiosVistos());
        System.out.println("Promedio de calificaciones en la serie: " + serie1.getPromedioCalificaciones());
        
        
        if (serie1.haVistoTodosLosEpisodios()) {
            System.out.println("Has visto todos los capitulos de "+ serie1.getTitulo());
        } else {
            System.out.println("No viste todos los capitulos de " + serie1.getTitulo());
        }
    }
}
