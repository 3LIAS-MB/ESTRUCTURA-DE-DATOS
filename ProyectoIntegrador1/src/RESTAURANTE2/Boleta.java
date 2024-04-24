package RESTAURANTE2;

public class Boleta {
    private static int contadorBoletas = 1;

    private int numeroBoleta;
    private int numeroPedido;
    private double montoPagar;

    public Boleta(int numeroPedido, double montoPagar) {
        this.numeroBoleta = contadorBoletas++;
        this.numeroPedido = numeroPedido;
        this.montoPagar = montoPagar;
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public static Boleta generarBoleta(int numeroPedido, double montoPagar) {
        return new Boleta(numeroPedido, montoPagar); // Crea e instanciar un objeto de la clase Boleta
    }
}