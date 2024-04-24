package RESTAURANTE2;

import java.util.Arrays;

public class Pedido {
    private static int contadorPedidos = 1;

    private int numeroPedido;
    private int[] orden;
    private int numeroMesa;
    private String estado;

    public Pedido(int[] orden, int numeroMesa) {
        this.numeroPedido = contadorPedidos++;
        this.orden = orden;
        this.numeroMesa = numeroMesa;
        this.estado = "espera";  // preparando
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public int[] getOrden() {
        return orden;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static Pedido crearPedido(int[] orden, int numeroMesa) {
        return new Pedido(orden, numeroMesa); // creo una instancia de pedido
    }

	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", orden=" + Arrays.toString(orden) + ", numeroMesa="
				+ numeroMesa + ", estado=" + estado + "]";
	}
}