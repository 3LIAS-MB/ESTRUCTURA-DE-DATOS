/*Crea una clase Fecha con atributos para el día, el mes y el año de la fecha. Incluir, al menos, los siguientes
métodos: a) Constructor predeterminado con el 1-1-1900 como fecha por defecto; b) Constructor
parametrizado con día, mes y año; c) Leer: pide al usuario el día (1 a 31), el mes (1 a 12) y el año (1900 a
2030); d) esValida: comprueba si la fecha es correcta (entre el 1-1-1900 y el 31-12-2030); si el día no es
correcto, lo pondrá a 1; si el mes no es correcto, lo pondrá a 1; y si el año no es correcto, lo pondrá a 1900.
Es un método auxiliar (privado) que se llama en el constructor parametrizado y en Leer. e) igualQue(Fecha):
indica si la fecha es la misma que la proporcionada. f) menorQue(Fecha): indica si la fecha es anterior a la
proporcionada. g) mayorQue(Fecha): indica si la fecha es posterior a la proporcionada.
Escribir un programa que, mediante un menú de opciones, permita crear fechas y ejecutar las diferentes
operaciones que se pueden hacer sobre ellas.*/

package Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fecha fecha1 = null;

        int opcion;
        
        do {
            System.out.println("\n*** Menú de Opciones ***");
            System.out.println("1. Crear una nueva fecha");
            System.out.println("2. Verificar si dos fechas son iguales");
            System.out.println("3. Verificar si una fecha es menor que otra");
            System.out.println("4. Verificar si una fecha es mayor que otra");
            System.out.println("5. Mostrar una fecha");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear una nueva fecha
                    fecha1 = new Fecha(); 
                    fecha1.leer(); // fecha1 cambia su valor
                    break;
                case 2:
                    // Verificar si dos fechas son iguales
                    if (fecha1 != null) {
                        Fecha fecha2 = new Fecha();
                        fecha2.leer();
                        if (fecha1.igualQue(fecha2)) {
                            System.out.println("Las fechas son iguales.");
                        } else {
                            System.out.println("Las fechas no son iguales.");
                        }
                    } else {
                        System.out.println("Primero debe crear una fecha.");
                    }
                    break;
                case 3:
                    // Verificar si una fecha es menor que otra
                    if (fecha1 != null) {
                        Fecha fecha2 = new Fecha();
                        fecha2.leer();
                        if (fecha1.menorQue(fecha2)) {
                            System.out.println("La primera fecha es menor que la segunda.");
                        } else {
                            System.out.println("La primera fecha no es menor que la segunda.");
                        }
                    } else {
                        System.out.println("Primero debe crear una fecha.");
                    }
                    break;
                case 4:
                    // Verificar si una fecha es mayor que otra
                    if (fecha1 != null) {
                        Fecha fecha2 = new Fecha();
                        fecha2.leer();
                        if (fecha1.mayorQue(fecha2)) {
                            System.out.println("La primera fecha es mayor que la segunda.");
                        } else {
                            System.out.println("La primera fecha no es mayor que la segunda.");
                        }
                    } else {
                        System.out.println("Primero debe crear una fecha.");
                    }
                    break;
                case 5:
                    // Mostrar una fecha
                    if (fecha1 != null) {
                        fecha1.mostrarFecha();
                    } else {
                        System.out.println("Primero debe crear una fecha.");
                    }
                    break;
                case 0:
                    System.out.println("Adiós.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}
