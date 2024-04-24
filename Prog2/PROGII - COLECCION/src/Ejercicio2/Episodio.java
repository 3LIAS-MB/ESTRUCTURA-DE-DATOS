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

class Episodio {
    private String titulo;
    private String descripcion;
    private boolean visto;
    private int calificacion; // Valor de 1 a 5

    public Episodio(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.visto = false;
        this.calificacion = -1; // -1 por defecto no vio el capitulo
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isVisto() {
        return visto;
    }

    public int getCalificacion() {
        return calificacion;
    }

	public void setCalificacion(int calificacion) {
		
        if (calificacion >= 1 && calificacion <= 5) {
        	this.calificacion = calificacion;
            this.visto = true;
        } else {
            System.out.println("La calificación debe estar en el rango de 1 a 5.");
        }
	}
}
