package RESTAURANTE;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de mesas del restaurante: ");
		int nMesas = Scanner.nextInt();

		System.out.print("Ingrese la cantidad de platos disponibles: ");
		int nPlatos = Scanner.nextInt();

		Restaurante restaurante = new Restaurante(nMesas, nPlatos);
		restaurante.registrarMesas(nMesas);
		System.out.println("");

		System.out.println("\t~ Registrar Platos ~ ");
		restaurante.registrarPlatos(nPlatos);

		System.out.println("");
		// restaurante.iniciarJornada();

		int opcion;
		do {
			System.out.println("\n\t*** Menú del Restaurante ***");
			System.out.println("\t~ ~ ~ CONSULTAS ~ ~ ~ ");
			System.out.println("1. Mesas disponibles");
			System.out.println("2. Mesas ocupadas");
			System.out.println("3. Por número de mesa");
			System.out.println("4. Totales de clientes");
			System.out.println("\n\t ~ ~ ~ ACCIONES ~ ~ ~ ");
			System.out.println("5. Ocupar mesa");
			System.out.println("6. Atender mesas en espera");
			System.out.println("7. Dar de alta un nuevo pedido");
			System.out.println("8. Preparar pedidos");
			System.out.println("9. Entregar pedidos");
			System.out.println("10. Pagar consumo");
			System.out.println("11. Controlar ingresos de la jornada");
			System.out.println("0. Salir");

			System.out.print("Ingrese su opción: ");
			opcion = Scanner.nextInt();

			switch (opcion) {
			case 1:
				restaurante.consultarMesasDisponibles();
				break;
			case 2:
				restaurante.consultarMesasOcupadas();
				break;
			case 3:
				System.out.println("Ingrese el número de la mesa:");
				int numMesa = Scanner.nextInt();
				restaurante.consultarPorNumeroMesa(numMesa);
				break;
			case 4:
				restaurante.consultarTotales();
				break;
			case 5:
				restaurante.ocuparMesa();
				break;
			case 6:
				restaurante.atenderMesas();
				break;
			case 7:
				restaurante.altaDePedido();
				break;
			case 8:
				restaurante.prepararPedidos();
				break;
			case 9:
				restaurante.entregarPedido();
				break;
			case 10:
				restaurante.pagarConsumos(); // -> desde aquí
				break;
			case 11:
				restaurante.controlIngresos();
				break;
			case 0:
				System.out.println("Saliendo del programa. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}
		} while (opcion != 0);
	}
}