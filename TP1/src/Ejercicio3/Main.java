/*Crear una clase Cuenta Bancaria cuyos datos mínimos son: número de cuenta, titular, dni y saldo. La clase
debe incluir los siguientes métodos: a) Constructores con argumentos y por defecto (se inicia saldo en 0);
b) Depositar una cantidad de dinero en la cuenta; c) Extraer una cantidad de dinero de la cuenta; d)
Informar el saldo actual y e) Mostrar los datos de la cuenta.
Escribir un programa que mediante un menú de opciones permita crear una cuenta bancaria y ejecutar las
diferentes operaciones que se pueden hacer sobre ella*/

package Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = null;

        int opcion;
        do {
            System.out.println("\n*** Menú de Opciones ***");
            System.out.println("1. Crear una nueva cuenta bancaria");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Extraer dinero");
            System.out.println("4. Informar saldo");
            System.out.println("5. Mostrar datos de la cuenta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear una nueva cuenta bancaria
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuenta = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea - Consumir la línea vacía pendiente
                    System.out.print("Ingrese el nombre del titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Ingrese el DNI del titular: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();

                    cuenta = new CuentaBancaria(numeroCuenta, titular, dni, saldoInicial);
                    break;
                case 2:
                    // Depositar dinero
                    if (cuenta != null) {
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double cantidadDeposito = scanner.nextDouble();
                        cuenta.depositar(cantidadDeposito);
                    } else {
                        System.out.println("Primero debe crear una cuenta bancaria.");
                    }
                    break;
                case 3:
                    // Extraer dinero
                    if (cuenta != null) {
                        System.out.print("Ingrese la cantidad a extraer: ");
                        double cantidadExtraccion = scanner.nextDouble();
                        cuenta.extraer(cantidadExtraccion);
                    } else {
                        System.out.println("Primero debe crear una cuenta bancaria.");
                    }
                    break;
                case 4:
                    // Informar saldo
                    if (cuenta != null) {
                        cuenta.informarSaldo();
                    } else {
                        System.out.println("Primero debe crear una cuenta bancaria.");
                    }
                    break;
                case 5:
                    // Mostrar datos de la cuenta
                    if (cuenta != null) {
                        cuenta.mostrarDatos();
                    } else {
                        System.out.println("Primero debe crear una cuenta bancaria.");
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