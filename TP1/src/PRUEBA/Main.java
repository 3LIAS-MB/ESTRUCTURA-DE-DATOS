package PRUEBA;

import java.util.Scanner;

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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[4];

        for (int i = 0; i < personas.length; i++) {
            System.out.println("Ingrese los datos para la persona " + (i + 1) + ":");
            System.out.print("DNI: ");
            String dni = scanner.next();
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Sexo (H/M): ");
            char sexo = scanner.next().charAt(0);
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            System.out.print("Altura (metros): ");
            double altura = scanner.nextDouble();
            System.out.print("Peso (kilogramos): ");
            double peso = scanner.nextDouble();

            personas[i] = new Persona(dni, nombre, sexo, edad, altura, peso);
        }

        System.out.println("\nInformación de las personas:");

        for (Persona persona : personas) {
            persona.mostrarDatos();
            System.out.println();
        }

        System.out.print("Ingrese una edad para filtrar personas: ");
        int edadFiltrar = scanner.nextInt();

        int hombres = 0;
        int mujeres = 0;

        for (Persona persona : personas) {
            if (persona.getSexo() == 'H') {
                hombres++;
            } else {
                mujeres++;
            }

            if (persona.getEdad() >= edadFiltrar) {
                System.out.println("Persona con edad igual o superior a " + edadFiltrar + ":");
                persona.mostrarDatos();
                System.out.println();
            }
        }

        System.out.println("Cantidad de hombres: " + hombres);
        System.out.println("Cantidad de mujeres: " + mujeres);

        scanner.close();
    }
}
