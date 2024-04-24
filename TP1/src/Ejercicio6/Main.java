/*Crear la clase Alumno Universitario cuyos datos incluyen los de una persona y además, libreta universitaria,
carrera, universidad y año de ingreso. Establecer la relación existente entre Persona y AlumnoUniversitario.
Incluir al menos los siguientes métodos: a) Constructor con argumentos y b) Mostrar los datos del alumno.
Escribir un programa que permita crear cuatro alumnos, mostrar la información de los hombres y determinar
cuál es la mujer más joven de una carrera dada y cuál es el hombre de mayor edad
correspondiente a una universidad dada.*/

package Ejercicio6;

import java.util.Scanner;

public class Main {	
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        AlumnoUniversitario[] alumnos = new AlumnoUniversitario[4]; // Creando un arreglo de objetos de la clase AlumnoUniversitario con un tamaño fijo de 4 elementos.
        
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingrese nombre completo: ");
            String nombre = entrada.nextLine();
            System.out.print("Ingrese DNI: ");
            int dni = entrada.nextInt();                                    
            entrada.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese la edad: ");
            int edad = entrada.nextInt();
            System.out.print("Ingrese año de ingreso: ");
            int añoDeIngreso = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese LU: ");
            String lu = entrada.nextLine();
            System.out.print("Ingrese carrera: ");
            String carrera = entrada.nextLine();
            System.out.print("Ingrese universidad: ");
            String universidad = entrada.nextLine();
            System.out.print("Ingrese sexo (hombre o mujer): ");
            String sexo = entrada.nextLine();

            alumnos[i] = new AlumnoUniversitario(dni, edad, nombre, añoDeIngreso, lu, carrera, universidad, sexo); // Se crean instancias para cada objeto
            
        }
        
        for(int i=0;i<4;i++) {
        	System.out.println(alumnos[i].mostrarInfo()); // Alumnos itera los arrays y los muestra en mostrarInfo
        }
        
        entrada.close();
    }
}

	
