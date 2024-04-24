/*Crear la clase Persona cuyos datos mínimos son: dni, nombre, sexo (H: hombre, M: mujer), edad, altura (en
metros) y peso (en kilogramos). Incluir los siguientes métodos: a) Constructor con argumentos (usar
validaciones); b) Calcular IMC de la persona (imc = peso / altura 2
); c) Nivel de peso correspondiente al IMC
calculado (ver cuadro más abajo) y d) Mostrar los datos de la persona. Escribir un programa que permita
crear cuatro personas, informar sus niveles de peso, mostrar la información de las personas cuya edad es
igual o superior a una dada e indicar la cantidad de hombres y mujeres ingresados.*/

package Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[2];

        for (int i = 0; i < personas.length; i++) {
            System.out.print("Ingrese los datos para la persona " + (i + 1) + ":");
            
            System.out.print("\nDNI: ");
            String dni = scanner.nextLine();
             
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Sexo (H/M): ");
            char sexo = scanner.next().charAt(0);
            
            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            
            System.out.print("Altura (metros): ");
            float altura = scanner.nextFloat();
            
            System.out.print("Peso (kilogramos):");
            double peso = scanner.nextDouble();
            
            System.out.print("\n");
            
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

        for (Persona persona : personas) { 	// En cada iteración del bucle, se toma un objeto Persona de la matriz y se almacena en la variable persona (Clase/Tipo variable : Objeto/Coleccion)
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

