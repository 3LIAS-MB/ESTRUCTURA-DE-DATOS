/*Crear la clase Persona cuyos datos mínimos son: dni, nombre, sexo (H: hombre, M: mujer), edad, altura (en
metros) y peso (en kilogramos). Incluir los siguientes métodos: a) Constructor con argumentos (usar
validaciones); b) Calcular IMC de la persona (imc = peso / altura 2
); c) Nivel de peso correspondiente al IMC calculado (ver cuadro más abajo) y d) Mostrar los datos de la persona. Escribir un programa que permita
crear cuatro personas, informar sus niveles de peso, mostrar la información de las personas cuya edad es
igual o superior a una dada e indicar la cantidad de hombres y mujeres ingresados.*/

package Ejercicio5;

class Persona {
    private String dni;
    private String nombre;
    private char sexo;
    private int edad;
    private double altura;
    private double peso;

    // Constructor con argumentos y validaciones
    public Persona(String dni, String nombre, char sexo, int edad, double altura, double peso) {
        if (edad < 0 || altura <= 0 || peso <= 0) {
            throw new IllegalArgumentException("Edad, altura y peso deben ser valores positivos.");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
    }

    // Calcular IMC
    public double calcularIMC() {
        return peso / (altura * altura);
    }

    // Determinar el nivel de peso correspondiente al IMC
    public String nivelDePeso() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso saludable";
        } else if (imc >= 25.0 && imc <= 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    // Mostrar los datos de la persona
    public void mostrarDatos() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Sexo: " + sexo);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Peso: " + peso + " kilogramos");
        System.out.println("IMC: " + calcularIMC());
        System.out.println("Nivel de peso: " + nivelDePeso());
    }

    // Obtener el sexo de la persona
    public char getSexo() {
        return sexo;
    }

    // Obtener la edad de la persona
    public int getEdad() {
        return edad;
    }
}

