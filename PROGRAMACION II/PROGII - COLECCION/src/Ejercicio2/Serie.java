package Ejercicio2;
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

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String titulo;
    private String descripcion;
    private String creador;
    private String genero;
    private List<Temporada> temporadas; // Recibe 

    public Serie(String titulo, String descripcion, String creador, String genero) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.genero = genero;
        this.temporadas = new ArrayList<>(); // Guardar temporadas
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public int getTotalEpisodiosVistos() {
        int totalVistos = 0;
        for (Temporada temporada : temporadas) {
            totalVistos += temporada.getTotalEpisodiosVistos();
        }
        return totalVistos;
    }

    public double getPromedioCalificaciones() {
        int sumCalificaciones = 0;
        int countCalificaciones = 0;
        for (Temporada temporada : temporadas) {
            sumCalificaciones += temporada.getPromedioCalificaciones();
            countCalificaciones++;
        }
        return (countCalificaciones > 0) ? sumCalificaciones / countCalificaciones : 0;
    }
    

    public boolean haVistoTodosLosEpisodios() {
        for (Temporada temporada : temporadas) {
            for (Episodio episodio : temporada.getEpisodios()) {
                if (!episodio.isVisto()) {
                    return false;
                }
            }
        }
        return true;
    }

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCreador() {
		return creador;
	}

	public String getGenero() {
		return genero;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}
    
}

