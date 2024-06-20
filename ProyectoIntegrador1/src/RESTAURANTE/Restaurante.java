package RESTAURANTE;

import java.util.Scanner;

/*pedidosEnPreparación: Esta variable es de tipo QueueMejorado, lo que significa
 * que puedes acceder a los métodos y atributos específicos de la implementación
 * de la cola, como agregar elementos, quitar elementos, verificar si la cola está vacía,
 * entre otros. pedidosEnPreparación no tiene acceso directo a los atributos ni a los métodos
 * específicos de los objetos de tipo Pedido que almacena.

Pedido: Los objetos de tipo Pedido tienen sus propios atributos y
métodos definidos en la clase Pedido. Para acceder a estos atributos
y métodos específicos de un objeto Pedido, necesitas tener una instancia de Pedido*/

public class Restaurante {
	public static Scanner scanner = new Scanner(System.in);
	// Variables de instancia
	private Mesa[] mesas; /**/
	private Plato[] platos; // Almacena un arreglo (array) de objetos de tipo Plato
	// El tipo de la variable es un tipo genérico llamado 'QueueMejorado'
	private QueueMejorado<Pedido> pedidosEnEspera; // -> numeroPedido, orden, numeroMesa, estado // Esto especifica el
													// tipo de la variable. En este caso, es un tipo genérico
	private QueueMejorado<Pedido> pedidosEnPreparacion; // llamado QueueMejorado, que es una implementación
														// personalizada o extendida
	private Stack<Boleta> pagosRecibidos; // de una cola, y se espera que contenga objetos de tipo Pedido.

	// El <Boleta> especifica el tipo de datos que se almacena en la instancia de
	// Stack
	// que QueueMejorado es una instancia específica de una clase genérica que
	// maneja objetos de ese tipo.

	public Restaurante(int nMesas, int nPlatos) {
		this.mesas = new Mesa[nMesas];
		this.platos = new Plato[nPlatos];
		this.pedidosEnEspera = new QueueMejorado<>();
		this.pedidosEnPreparacion = new QueueMejorado<>();
		this.pagosRecibidos = new Stack<>();
	}

	public void registrarMesas(int nMesas) {
		int numMesas2Personas = (int) (nMesas * 0.3);
		int numMesas4Personas = nMesas - numMesas2Personas;

		this.mesas = new Mesa[nMesas];

		for (int i = 0; i < numMesas2Personas; i++) {
			this.mesas[i] = new Mesa(2);
		}

		for (int i = numMesas2Personas; i < nMesas; i++) {
			this.mesas[i] = new Mesa(4);
		}

		System.out.println("Mesas registradas correctamente.");
	}

	public void registrarPlatos(int nPlatos) {

		this.platos = new Plato[nPlatos];

		for (int i = 0; i < nPlatos; i++) {
			boolean codigoUnico = false;
			int codigo = 0;

			// Solicitar un código único
			while (!codigoUnico) {
				// System.out.print("Ingrese código del plato" + (i+1) + ": ");
				codigo = Helper.randomInt(100, 999);
				// scanner.nextLine(); // Consumir el salto de línea

				// Verificar si el código ya ha sido utilizado
				codigoUnico = verificarCodigoUnico(codigo);
				if (!codigoUnico) {
					System.out.println("El código ingresado ya está en uso. Ingrese un código único.");
				}
			}

			System.out.print("Ingrese descripción del plato" + (i + 1) + ": ");
			String descripcion = scanner.nextLine();
			System.out.print("Ingrese precio unitario del plato" + (i + 1) + ": ");
			double precio = scanner.nextDouble();
			scanner.nextLine();

			this.platos[i] = new Plato(codigo, descripcion, precio);
		}

		System.out.println("Platos registrados correctamente.");
	}

	// Método para verificar si un código ya ha sido utilizado
	private boolean verificarCodigoUnico(int codigo) {
		for (Plato plato : this.platos) {
			if (plato != null && plato.getCodigo() == codigo) {
				return false;
			}
		}
		return true;
	}

	public void consultarMesasDisponibles() {
		System.out.println("Mesas disponibles: ");
		for (Mesa mesa : mesas) {
			if (mesa.getEstado().equals("libre")) {
				System.out.println("Mesa " + mesa.getNumeroMesa() + " - Capacidad: " + mesa.getCapacidad());
			}
		}
	}

	public void consultarMesasOcupadas() {
		int contador = 0;
		System.out.println("Mesas ocupadas: ");
		for (Mesa mesa : mesas) {
			if (mesa.getEstado().equals("ocupada")) {
				contador += 1;
				System.out.println("Mesa " + mesa.getNumeroMesa() + " - Comensales: " + mesa.getComensales());
			}
		}
		if (contador == 0) {
			System.out.println("No hay mesas ocupadas por el momento...");
		}
	}

	public void consultarPorNumeroMesa(int numeroMesa) {
		for (Mesa mesa : mesas) {
			if (mesa.getNumeroMesa() == numeroMesa) {
				System.out.println("Estado: " + mesa.getEstado());
				System.out.println("Capacidad: " + mesa.getCapacidad());
				if (mesa.getEstado().equals("ocupada")) { /**/
					System.out.println("Servicio: " + mesa.getServicio());
					System.out.println("Comensales: " + mesa.getComensales());
				}
				return;
			}
		}
		System.out.println("No se encontró la mesa con el número especificado...");
	}

	public void consultarTotales() {
		int clientesEspera = 0;
		int clientesAtendidos = 0;
		int clientesServidos = 0;

		for (Mesa mesa : mesas) {
			if (mesa.getServicio().equals("espera")) {
				clientesEspera += mesa.getComensales();
			} else if (mesa.getServicio().equals("atendida")) {
				clientesAtendidos += mesa.getComensales();
			} else if (mesa.getServicio().equals("servida")) {
				clientesServidos += mesa.getComensales();
			}
		}

		System.out.println("Total de clientes en espera: " + clientesEspera);
		System.out.println("Total de clientes atendidos: " + clientesAtendidos);
		System.out.println("Total de clientes servidos: " + clientesServidos);
	}

	public void ocuparMesa() {

		consultarMesasDisponibles();
		// System.out.print("Ingrese el número de la mesa que desea ocupar: ");
		int numMesa = Helper.getPositiveInt("Ingrese el número de la mesa que desea ocupar: ");
		// scanner.nextLine(); // Consumir el salto de línea

		for (Mesa mesa : mesas) {
			if (mesa.getNumeroMesa() == numMesa) {
				// System.out.print("Ingrese la cantidad de comensales: ");
				int numComensales = Helper.getPositiveInt("Ingrese la cantidad de comensales: ");
				if (numComensales > 0 && numComensales <= mesa.getCapacidad()) {
					mesa.ocuparMesa(numComensales);
				} else if (numComensales >= 3 && numComensales <= mesa.getCapacidad()) {
					mesa.ocuparMesa(numComensales);
				} else {
					System.out.println("La cantidad de comensales debe ser coherente...");
				}
			}
		}
	}

	public void atenderMesas() {
		System.out.println("Atendiendo mesas en espera:");
		for (Mesa mesa : mesas) {
			if (mesa.getServicio().equals("espera")) {
				mesa.atenderMesa();
			}
		}
	}

	public void altaDePedido() {

		consultarMesasOcupadas();

		for (Mesa mesa : mesas) {
			int numMesa = Helper.getPositiveInt("Ingrese el número de la mesa para realizar el pedido: ");

			if (mesa.getNumeroMesa() == numMesa) {
				if (mesa.getNumeroMesa() == numMesa) {
					System.out.println("Presentando menú:");
					for (Plato plato : platos) {
						System.out.println(
								plato.getCodigo() + ". " + plato.getDescripcion() + " - $" + plato.getPrecioUnitario());
					}

					int[] orden = new int[4]; // guarda el pedido del usuario
					for (int i = 0; i < 4; i++) {
						System.out.print(
								"Seleccione el plato ingresando el codigo (0 para finalizar) - " + (i + 1) + ": ");
						int codigoPlato = scanner.nextInt();
						if (codigoPlato == 0) {
							break;
						}
						orden[i] = codigoPlato; // -> lo almacena
					}

					Pedido pedido = Pedido.crearPedido(orden, numMesa); // -> retorna una instancia de 'Pedido', asigna
																		// el orden
					pedidosEnEspera.offer(pedido); // y numero de mesas a sus atributos
					System.out.println("Pedido realizado con éxito."); // numeroPedido, orden, numeroMesa, estado
					return;
				}
			} else {
				System.out.println("La mesa ingresada no existe...");
			}
		}

		System.out.println("No se encontró la mesa con el número especificado.");
	}

	public void prepararPedidos() {
		int contador = 0;
		System.out.println("Preparando pedidos:");
		for (int i = 0; i < 5 && !pedidosEnEspera.isEmpty(); i++) {
			contador += 1;
			Pedido pedido = pedidosEnEspera.remove(); // estado, numeroMesa. numero -> pedidosEnEspera no remueve, solo
														// le resta 1 al cointador
			pedido.setEstado("preparando");
			pedidosEnPreparacion.add(pedido);
			System.out.println("Pedido " + pedido.getNumeroPedido() + " en preparación.");
		}

		if (contador == 0) {
			System.out.println("Todavia no se hadado de alta un mesa...");
		}
	}

	public void entregarPedido() {
		System.out.println("Entregando pedidos:");
		for (int i = 0; i < 5 && !pedidosEnPreparacion.isEmpty(); i++) {
			Pedido pedido = pedidosEnPreparacion.peek(); // cambia
			pedido.setEstado("preparando");
			int numMesa = pedido.getNumeroMesa();
			for (Mesa mesa : mesas) {
				if (mesa.getNumeroMesa() == numMesa) {
					mesa.setServicio("servida");
					System.out.println("Pedido " + pedido.getNumeroPedido() + " entregado en mesa " + numMesa);
					return;
				}
			}
		}
	}

	/* PAGOS Y GESTIÓN */
	public void pagarConsumos() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mesa con consumo servido y pendiente de pago:");
		for (Mesa mesa : mesas) {
			if (mesa.getEstado().equals("ocupada") && mesa.getServicio().equals("servida")) { // si el estado de la mesa
																								// es ocupada y el
																								// servicio es servida
				double monto = calcularMontoPorMesa(mesa.getNumeroMesa());
				if (monto > 0) { // Si el monto es mayor que 0 generamos una boleta y la guardamos en una pila

					int numPedido = obtenerNumeroPedidoPorMesa(mesa.getNumeroMesa());
					Boleta boleta = Boleta.generarBoleta(numPedido, monto);
					pagosRecibidos.push(boleta);
					System.out.println("Mesa " + mesa.getNumeroMesa() + " - Monto a pagar: $" + monto);
					System.out.println("Ingrese el monto a pagar:");
					double montoIngresado = scanner.nextDouble();
					if (montoIngresado == monto) {
						mesa.setEstado("libre");
						mesa.setServicio("ninguno");
						eliminarPedidoPorMesa(mesa.getNumeroMesa());
						System.out.println("Pago aceptado. Mesa liberada.");
					} else {
						System.out.println("Monto ingresado incorrecto. Pago rechazado.");
					}
				} else {
					System.out.println("No hay consumo pendiente para la mesa " + mesa.getNumeroMesa());
				}
			}
		}
	}

	private double calcularMontoPorMesa(int numeroMesa) {
		double total = 0;

		for (Pedido pedido : pedidosEnPreparacion) {
			if (pedido.getNumeroMesa() == numeroMesa && pedido.getEstado().equals("servida")) { //
				int[] orden = pedido.getOrden(); // ahora orden tiene el codigo de orden cada plato
				for (int codigoPlato : orden) {
					Plato plato = encontrarPlatoPorCodigo(codigoPlato); // le manda el primer codigo
					if (plato != null) {
						total += plato.getPrecioUnitario();
					}
				}
			}
		}

		return total;
	}

	private Plato encontrarPlatoPorCodigo(int codigoPlato) {
		for (Plato plato : platos) {
			if (plato.getCodigo() == codigoPlato) {
				return plato;
			}
		}
		return null; // significa que plato no se encuentra en la lista
	}

	private int obtenerNumeroPedidoPorMesa(int numeroMesa) {
		for (Pedido pedido : pedidosEnPreparacion) {
			if (pedido.getNumeroMesa() == numeroMesa) {
				return pedido.getNumeroPedido();
			}
		}
		return -1;
	}

	private void eliminarPedidoPorMesa(int numeroMesa) {
		for (Pedido pedido : pedidosEnPreparacion) {
			if (pedido.getNumeroMesa() == numeroMesa) {
				pedidosEnPreparacion.remove();
				return;
			}
		}
	}

	public void controlIngresos() {
		double total = 0;
		System.out.println("Control de ingresos de la jornada:");
		while (!pagosRecibidos.isEmpty()) { // contiene las bolas
			Boleta boleta = pagosRecibidos.pop();
			total += boleta.getMontoPagar();
			System.out.println("Boleta " + boleta.getNumeroBoleta() + " - Monto: $" + boleta.getMontoPagar());
			System.out.println("TOTAL: " + total);
		}
	}
}
