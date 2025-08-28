/*Pedir el dia, mes y año de una fecha e indicar si la fecha es correcta.
 * Con meses de 28, 30 y 31 dias. Sin años bisiestos*/

package EJERCICIOS;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el día: ");
        int dia = scanner.nextInt();

        System.out.print("Ingrese el mes: ");
        int mes = scanner.nextInt();

        System.out.print("Ingrese el año: ");
        int año = scanner.nextInt();

        // Verificar si el año es válido (mayor que cero)
        if (año > 0) {
            // Verificar si el mes es válido (entre 1 y 12)
            if (mes >= 1 && mes <= 12) {
                // Verificar si el día es válido en función del mes
                boolean esFechaValida = false;

                if ((mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia >= 1 && dia <= 31)) {
                    esFechaValida = true;
                } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia >= 1 && dia <= 30)) {
                    esFechaValida = true;
                } else if (mes == 2) {
                    // Febrero tiene 28 días en este caso (sin años bisiestos)
                    if (dia >= 1 && dia <= 28) {
                        esFechaValida = true;
                    }
                }

                if (esFechaValida) {
                    System.out.println("La fecha ingresada es válida.");
                } else {
                    System.out.println("La fecha ingresada no es válida.");
                }
            } else {
                System.out.println("El mes ingresado no es válido.");
            }
        } else {
            System.out.println("El año ingresado no es válido.");
        }

        scanner.close();
    }
}
