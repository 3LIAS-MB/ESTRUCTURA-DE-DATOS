package EJERCICIOS;

public class Ejercicio10 {
    public static void main(String[] args) {
        // Crear un arreglo de objetos Persona
        Persona[] personas = {
            new Persona("Juan"),
            new Persona("María"),
            new Persona("Pedro")
        };

        // Mostrar información de todas las personas
        for (Persona persona : personas) {
            persona.mostrarDatos();
            System.out.println();
        }
    }
}

class Persona {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
    }
}
