package Ejercicio4;

class Enfermedad {
    private String nombre;
    private String sintomas;
    private String tratamiento;

    public Enfermedad(String nombre, String sintomas, String tratamiento) {
        this.nombre = nombre;
        this.sintomas = sintomas;
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nSíntomas: " + sintomas + "\nTratamiento: " + tratamiento + "\n******";
    }
}

