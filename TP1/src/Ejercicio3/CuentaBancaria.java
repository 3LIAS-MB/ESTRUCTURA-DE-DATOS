/*Crear una clase Cuenta Bancaria cuyos datos mínimos son: número de cuenta, titular, dni y saldo. La clase
debe incluir los siguientes métodos: a) Constructores con argumentos y por defecto (se inicia saldo en 0);
b) Depositar una cantidad de dinero en la cuenta; c) Extraer una cantidad de dinero de la cuenta; d)
Informar el saldo actual y e) Mostrar los datos de la cuenta.
Escribir un programa que mediante un menú de opciones permita crear una cuenta bancaria y ejecutar las
diferentes operaciones que se pueden hacer sobre ella**/

package Ejercicio3;

class CuentaBancaria {
    private int numeroCuenta;
    private String titular;
    private String dni;
    private double saldo;

    // Constructor por defecto (saldo inicial en 0)
    public CuentaBancaria() {
        saldo = 0;
    }

    // Constructor con argumentos
    public CuentaBancaria(int numeroCuenta, String titular, String dni, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.dni = dni;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se depositó $" + cantidad + " en la cuenta.");
        } else {
            System.out.println("La cantidad debe ser mayor que cero.");
        }
    }

    // Método para extraer dinero
    public void extraer(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Se extrajo $" + cantidad + " de la cuenta.");
        } else {
            System.out.println("No se puede realizar la extracción. Verifique el saldo y la cantidad.");
        }
    }

    // Método para informar el saldo actual
    public void informarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }

    // Método para mostrar los datos de la cuenta
    public void mostrarDatos() {
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("DNI: " + dni);
        informarSaldo(); // Lamma al metodo directo
    }
}

