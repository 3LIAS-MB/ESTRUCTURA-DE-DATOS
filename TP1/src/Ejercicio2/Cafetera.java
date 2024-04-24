/*Crear una clase Cafetera con atributos capacidadMaxima (la cantidad máxima de café que puede contener
la cafetera) y cantidadActual (la cantidad actual de café que hay en la cafetera). Implementar, al menos, los
siguientes métodos: a) Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.) y la
actual en cero (cafetera vacía); b) Constructor con argumentos: si la cantidad actual es mayor que la
capacidad máxima de la cafetera, se debe ajustar al máximo; c) servirTaza(capacidad): simula la acción de
servir una taza con la capacidad indicada. Si la cantidad actual de café “no alcanza” para llenar la taza, se
sirve lo que quede; d) vaciarCafetera(): pone la cantidad de café actual en cero y e) agregarCafe(cantidad):
añade a la cafetera la cantidad de café indicada.

Escribir un programa que mediante un menú de opciones permita crear una cafetera y ejecutar las
diferentes operaciones que se pueden hacer sobre ella.*/

package Ejercicio2;

class Cafetera {
    private int capacidadMaxima;
    private int cantidadActual;

    // Constructor predeterminado
    public Cafetera() {
        capacidadMaxima = 1000;
        cantidadActual = 0;
    }

    // Constructor con argumentos
    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this.capacidadMaxima = capacidadMaxima;

        // Ajustar cantidadActual si es mayor que capacidadMaxima
        if (cantidadActual > capacidadMaxima) {
            this.cantidadActual = capacidadMaxima;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    // Método para servir una taza de café
    public void servirTaza(int capacidad) {
        if (cantidadActual >= capacidad) {
            cantidadActual -= capacidad;
            System.out.println("Se sirvió una taza de " + capacidad + " c.c. de café.");
        } else {
            System.out.println("No hay suficiente café en la cafetera para llenar la taza.");
        }
    }

    // Método para vaciar la cafetera
    public void vaciarCafetera() {
        cantidadActual = 0;
        System.out.println("La cafetera ha sido vaciada.");
    }

    // Método para agregar café a la cafetera
    public void agregarCafe(int cantidad) {
        if (cantidadActual + cantidad <= capacidadMaxima) {
            cantidadActual += cantidad;
            System.out.println("Se agregaron " + cantidad + " c.c. de café a la cafetera.");
        } else {
            System.out.println("La cafetera no puede contener más café.");
        }
    }

    // Método para mostrar el estado actual de la cafetera
    public void mostrarEstado() {
        System.out.println("Capacidad máxima: " + capacidadMaxima + " c.c.");
        System.out.println("Cantidad actual: " + cantidadActual + " c.c.");
    }
}