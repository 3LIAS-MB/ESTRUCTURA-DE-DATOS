package Ejercicio3;

public class Autor {
    private String nombre;
    private int edad; // Puedes agregar más atributos según tus necesidades

    public Autor() {
        nombre = "";
        edad = 0;
    }

    public Autor(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
