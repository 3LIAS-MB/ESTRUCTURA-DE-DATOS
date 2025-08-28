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

class Fecha {
    private int dia;
    private int mes;
    private int año;

    // Constructor predeterminado (1-1-1900 por defecto)
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.año = 1900;
    }

    // Constructor parametrizado
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        esValida(); // Comprobar y ajustar la fecha
    }

    // Método para leer una fecha desde la entrada estándar
    public void leer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el día (1-31): ");
        dia = scanner.nextInt();
        System.out.print("Ingrese el mes (1-12): ");
        mes = scanner.nextInt();
        System.out.print("Ingrese el año (1900-2030): ");
        año = scanner.nextInt();

        esValida(); // Comprobar y ajustar la fecha
        scanner.close();
    }

    // Método privado para comprobar y ajustar la fecha
    private void esValida() {
        if (dia < 1 || dia > 31) {
            dia = 1;
        }
        if (mes < 1 || mes > 12) {
            mes = 1;
        }
        if (año < 1900 || año > 2030) {
            año = 1900;
        }
    }

    // Método para verificar si dos fechas son iguales
    public boolean igualQue(Fecha otraFecha) {
        return dia == otraFecha.dia && mes == otraFecha.mes && año == otraFecha.año; // Devuelve true o false XD // Las atributos quedan con el valor de la primera instancia
    }

    // Método para verificar si una fecha es anterior a otra
    public boolean menorQue(Fecha otraFecha) {
        if (año < otraFecha.año) {
            return true;
        } else if (año == otraFecha.año && mes < otraFecha.mes) {
            return true;
        } else if (año == otraFecha.año && mes == otraFecha.mes && dia < otraFecha.dia) {
            return true;
        }
        return false;
    }

    // Método para verificar si una fecha es posterior a otra
    public boolean mayorQue(Fecha otraFecha) {
        return !igualQue(otraFecha) && !menorQue(otraFecha); // Se realiza una doble negación lógica con el operador ! // La exclamasion nieva y vuelve false lo true, y true lo false
    }

    // Método para mostrar la fecha
    public void mostrarFecha() {
        System.out.println("Fecha: " + dia + "-" + mes + "-" + año);
    }
    
}

