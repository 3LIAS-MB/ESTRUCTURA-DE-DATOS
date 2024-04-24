/*Series
Una Serie está formada por un conjunto de temporadas, cada una de las cuales tiene una
cantidad de episodios. Cada episodio posee un título, una descripción, un atributo indicando
si el usuario ya vio el episodio y una calificación dada por el usuario (con valores de 1 a 5).
Si el usuario no vio un episodio particular, la calificación dada será un valor negativo.
Las series poseen como atributos (además de los episodios correspondientes) un título, una
descripción, un creador y un género.

Implementar las clases involucradas, determinar qué clase es responsable de responder los
siguientes servicios:

1) Ingresar la calificación de un episodio. Si el valor ingresado como calificación no es
correcto imprimir un mensaje por pantalla y no cambiar el valor anterior.
2) Obtener el total episodios vistos de una temporada particular.
3) Obtener el promedio de las calificaciones dadas por el usuario para una temporada
particular.
4) Obtener el total de episodios vistos de una serie.
5) Obtener el promedio de las calificaciones dadas por el usuario para una serie.
6) Determinar si el usuario ya vio todos los episodios de la serie. */

package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private List<Episodio> episodios;

    public Temporada() {
        this.episodios = new ArrayList<>();
    }

    public void agregarEpisodio(Episodio episodio) {
        episodios.add(episodio);
    }

    public int getTotalEpisodiosVistos() {
        int totalVistos = 0;
        for (Episodio episodio : episodios) {
            if (episodio.isVisto()) {
                totalVistos++;
            }
        }
        return totalVistos;
    }

    public double getPromedioCalificaciones() {
        int sumCalificaciones = 0;
        int countCalificaciones = 0;
        for (Episodio episodio : episodios) {
            if (episodio.isVisto()) {
                sumCalificaciones += episodio.getCalificacion();
                countCalificaciones++;
            }
        }
        return (countCalificaciones > 0) ? (double) sumCalificaciones / countCalificaciones : 0; // operador condicional ternario, si se cumple la primera condicion se ejecuta la primera parte del opeador ternario
    }																							 // si se cumple la division devuelve el valor en punto flotante (double), si no se cumple la 1ra cond. devuelve 0
    																							 // condición ? valorSiVerdadero : valorSiFalso -> Forma compacta de expresar un condicional
	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}

    
}

