package menu;
import java.time.LocalDate;
import java.util.Scanner;

import programasArbol.BinarySearchTree;
import programasListas.DoubleLinkedList;
import programasListas.DoubleLinkedOrderedList;
import programasListas.SimpleLinkedList;

public class Main {
	static Scanner entrada =new Scanner(System.in);
	static BinarySearchTree<Socio> activos=new BinarySearchTree<Socio>(); // root -> item, left, right
	static BinarySearchTree<Libro> disponibles=new BinarySearchTree<Libro>(); // root -> item, left, right
	static DoubleLinkedOrderedList<Prestamo> prestamos=new DoubleLinkedOrderedList<Prestamo>(); // count, head, tail -> item, next, prev
	
	// Para gestionar los préstamos se hará uso de listas enlazadas (prestados, perdidos).
	static DoubleLinkedOrderedList<Libro> prestados=new DoubleLinkedOrderedList<Libro>(); // count, head, tail -> item, next, prev
	static DoubleLinkedOrderedList<Libro> perdidos=new DoubleLinkedOrderedList<Libro>(); // count, head, tail -> item, next, prev
	

	public static void main(String[] args) {
		disponibles.add(new Libro("512", "Codigo Facilito", "MiluDev", "San Pablo", 2010, "Programación", 2000));
		disponibles.add(new Libro("412", "Geometria", "Julio Profe", "Aguilar", 1999, "Matematica", 17000));
		disponibles.add(new Libro("123", "Fisica I", "Profe Alex", "Ivrea", 2015, "Fisica Universal", 1500));
		
		activos.add(new Socio(123, "24633912", "Elias", "Messi", "Jujuy", 388463120, "moroso"));
		activos.add(new Socio(125, "64632912", "Pedro", "Perez", "Salta", 388462350, "suspendido"));
		activos.add(new Socio(126, "44632912", "Martin", "Castillo", "Misiones", 388562350, "ok"));
		
		System.out.println(activos.buscar(new Socio(123)));
		
		for(Socio s:activos.generarLista()) {
			System.out.println(s.toString());
		}
		for(Libro l: disponibles.generarLista()) {
			System.out.println(l.toString());
		}
		
		cargarEjemplos();
		menu();
	}
	public static void menu() {
		int opcion;
		do {
			System.out.println("\t**MENÚ**");
			System.out.println("1) Agregar un libro");
			System.out.println("2) Eliminar un libro");
			System.out.println("3) Agregar socio");
			System.out.println("4) Eliminar socio");
			System.out.println("5) Prestar libro");
			System.out.println("6) Control libro");
			System.out.println("7) Devolver libro");
			System.out.println("8) -> CONSULTAS:");
			System.out.println("0) salir");
			opcion=Helper.getInteger("Ingrese opcion: ");
			switch(opcion) {
			case 1:
				nuevoLibro();
				break;
			case 2:
				eliminarLibro();
				break;
			case 3:
				nuevoSocio();
				break;
			case 4:
				eliminarSocio();
				break;
			case 5:
				prestarLibro();
				break;
			case 6:
				controlPrestamos();
				break;
			case 7:
				devolucion();
				break;
			case 8:
				consultas();
				break;
			case 0:
				System.out.println("salir");
				break;
			default:
				System.out.println("opcion no valida");
			}
			
		}while(opcion!=0);
	}
	
	public static void consultas() {
		int opcion;
		do {
			System.out.println("\t **MENÚ CONSULTAS\n"
					+ "1) Mostrar los prestamos vencidos\n"
					+ "2) Mostrar los prestamos irrecuperables\n"
					+ "3) Mostrar socios morosos\n"
					+ "4) Mostrar libros prestados\n"
					+ "5) Mostrar libros perdidos\n"
					+ "6) Mostrar monto total de multas\n"
					+ "7) Mostrar cantidad de libros prestados por socio\n"
					+ "8) Mostrar todos los Socios activos\n"
					+ "9) Mostrar todos los Libros disponibles\n"
					+ "10) Salir.\n");
			opcion = Helper.getInteger("Ingrese opción: ");
			switch(opcion){
				case 1:
					prestamosVencidos();
					break;
				case 2:
					prestamosIrrecuperables();
					break;
				case 3:
					sociosMorosos();
					break;
				case 4:
					librosPrestados();
					break;
				case 5:
					librosPerdidos();
					break;
				case 6:
					montoTotalMultas();
					break;
				case 7:
					cantidadLibrosPrestadosPorSocio(opcion, null, null);
					break;
				case 8:
					mostrarSocio();
					break;
				case 9:
					mostrarLibros();
					break;
				case 10:
					System.out.println("Volviendo al menú principal...");
					break;
				default:
					System.out.println("Error, opción invalida");
						
			}
		} while(opcion != 10);
	}
	// Alta de libro
	public static void nuevoLibro() {
		Character salir;
		do {
			String codigo=codigoUnicoLibro();
			String titulos=Helper.IngresoAlphanumericConEspacio("Ingrese titulo del libro: ");
			String autor=Helper.IngresoAlphanumericConEspacio("Ingrese autor del libro: ");
			String editorial=Helper.IngresoAlphanumericConEspacio("Ingrese nombre de la editorial: ");
			int añoPublicacion=Helper.getInteger("Ingrese año de publicacion: ");
			String tematica=Helper.IngresoAlphanumericConEspacio("Ingrese la tematica: ");
			int precio=Helper.getInteger("Ingrese precio del libro: ");
			disponibles.add(new Libro(codigo, titulos, autor, editorial, añoPublicacion, tematica, precio));
			salir = Helper.yesOrNo("¿Desea continuar? S/N: ");
		} while(salir != 'N');
	}
	
	public static String codigoUnicoLibro() {
		while(true) {
			int auxiliar = 0;
			String random = Helper.randomInStr(1000, 9999);
			for(Libro dis : disponibles.generarLista()) {
				if(dis.getCodigo().equals(random)) {
					auxiliar = 1;
				}
			}
			if(auxiliar == 0) {
				return random;
			} else {
				System.out.println("El codigo ya está en uso");
			}
		}
	}
	
	// Baja de libro
	public static void eliminarLibro() {
		String codigo=Helper.IngresoAlphanumeric("Ingrese el codigo del libro a eliminar: ");
		try {
			Libro item = disponibles.remove(new Libro(codigo)); // ELEMENT item
			System.out.println("Libro eliminado: " + item);
		}
		catch(RuntimeException o) {
			System.out.println("libro no existente");
		}
	}
	// Baja de libro por rotura o perdida
	public static void bajaPorRoturaPerdida(String codigo) {
		for(Libro l:prestados) {
			if(l.getCodigo().equalsIgnoreCase(codigo)) {
				perdidos.addInOrder(l);
			}
		}
	}
	// Alta de socio
	public static void nuevoSocio() {
		Character salir;
		do {
			int numero=codigoUnicoSocio();
			String dni=Helper.IngresoNumero("Ingrese DNI: ");
			String nombre=Helper.IngresoAlphanumericConEspacio("Ingrese su nombre: ");
			String apellido=Helper.IngresoAlphanumericConEspacio("Ingrese su apellido: ");
			String domicilio=Helper.IngresoAlphanumericConEspacio("Ingrese su domilicio: ");
			int telefono=Helper.getInteger("Ingrese telefono ");
			activos.add(new Socio(numero, dni, nombre, apellido, domicilio, telefono));
			salir = Helper.yesOrNo("¿Desea continuar? S/N: ");
		} while(salir != 'N');
	}
	public static int codigoUnicoSocio() {
		while(true) {
			int auxiliar = 0;
			int random = Helper.randomInt(1000, 9999);
			for(Socio dis : activos.generarLista()) {
				if(dis.getNumero() == random) {
					auxiliar = 1;
				}
			}
			if(auxiliar == 0) {
				return random;
			} else {
				System.out.println("El codigo ya está en uso");
			}
		}
	}

	// Baja de socio
	public static void eliminarSocio() {
		int numero=Helper.getInteger("ingrese numero de socio ");
		try {
			System.out.println("\nEliminar "+activos.remove(new Socio(numero)));
		}
		catch(RuntimeException o) {
			System.out.println("Socio no existente");
		}
	}
	
	// Búsqueda de libro por título o autor o temática
	public static Libro buscarLibro() {
		System.out.println("buscar Libro por:");
		System.out.println("1) Titulo");
		System.out.println("2) Autor");
		System.out.println("3) Tematica");
		int opcion=Helper.getInteger("Ingrese opcion: ");
		switch(opcion) {
		case 1:
			String titulo=Helper.IngresoAlphanumericConEspacio("Ingrese el titulo del libro: ");
			for(Libro l:disponibles.generarLista()) {
				if(l.getTitulo().equalsIgnoreCase(titulo)) {
					return l;
				}
			}
			break;
		case 2:
			String autor=Helper.IngresoAlphanumericConEspacio("Ingrese el nombre del autor: ");
			for(Libro l:disponibles.generarLista()) {
				if(l.getAutor().equalsIgnoreCase(autor)) {
					return l;
				}
			}
			break;
		case 3:
			String tematica=Helper.IngresoAlphanumericConEspacio("Ingrese la tematica: ");
			for(Libro l:disponibles.generarLista()) {
				if(l.getTematica().equalsIgnoreCase(tematica)) {
					return l;
				}
			}
			break;
		}
		return null;
	}
	
	// Búsqueda de socio
	public static Socio buscarSocio() {
		int numero=Helper.getInteger("ingrese numero de socio ");
		for(Socio s:activos.generarLista()) {
			if(s.getNumero()==numero) {
				System.out.println(s.toString());
				return s;
			}
		}
		return null;
	}
	
	// Préstamo de libro
	public static void prestarLibro() {
		Socio s=buscarSocio();
		if(s!=null) {
			if(s.getEstado().equals("ok")) {
				Libro l=buscarLibro();
				if(l!=null) {
					System.out.println(l.toString());
					Prestamo p=new Prestamo(l.getCodigo(), s.getNumero(), LocalDate.now(), Helper.plazo());
					System.out.println(p.toString());
					prestamos.addLast(p);
					prestados.addLast(disponibles.remove(l));
				}
				else {
					System.out.println("libro no encontrado o no existente en disponobles");
				}
			} else {
				System.out.println("Socio moroso/suspendido.");
			}
		}
		else{
			System.out.println("socio no encontrado o no existente en activos");
		}
	}

	// Control de préstamos
	public static void controlPrestamos() {
		for(Prestamo p:prestamos) {
			if(LocalDate.now().getDayOfYear()-p.getFechaVencimiento().getDayOfYear()>0) {
				Socio s=activos.buscar(new Socio(p.getNumeroSocio()));
				if(LocalDate.now().getDayOfYear()-p.getFechaVencimiento().getDayOfYear()<30) {
					p.setEstado("vencido");
					s.setEstado("moroso");
					System.out.println(p.toString());
					System.out.println(s.toString());
				}
				else {
					p.setEstado("irrecuperable");
					for(Libro l:prestados) {
						if(l.getCodigo().equalsIgnoreCase(p.getCodigoDeLibro())) {
							bajaPorRoturaPerdida(p.getCodigoDeLibro());
						}
					}
					prestados.findAndRemove(new Libro(p.getCodigoDeLibro()));
					s.setEstado("moroso");
					System.out.println(s.toString());
				}
			}
		}
	}
	// Devolución de libro
	public static void devolucion() {
		controlPrestamos();
		int numero=Helper.getInteger("numero de prestamo ");
		System.out.println("estado del libro");
		System.out.println("1) bien");
		System.out.println("2) rotura operdida");
		int opcion=Helper.getInteger("ingrese opcion ");
		switch(opcion) {
		case 1:
			devolverLibro(numero);
			break;
		case 2:
			roturaPerdida(numero);
			break;
		}
		
	}
	public static void devolverLibro(int numero) {
		for(Prestamo p:prestamos) {
			if(p.getNumeroIdentificador()==numero) {
				p.setFechaDevolucion(LocalDate.now());
				System.out.println(p.toString());
				if(p.getEstado().equals("vigente")) {
					p.setEstado("devuelto");
					for(Libro l:prestados) {
						if(l.getCodigo().equals(p.getCodigoDeLibro())) {
							prestados.findAndRemove(l);
							disponibles.add(l);
						}
					}
					System.out.println("Libro devuelto en tiempo");
					System.out.println(p.toString());
				}
				else if(p.getEstado().equals("vencido")) {
					p.setEstado("devuelto");
					for(Libro l:prestados) {
						if(l.getCodigo().equals(p.getCodigoDeLibro())) {
							prestados.findAndRemove(l);
							disponibles.add(l);
							System.out.println("estado del prestamo vencido, socio suspendido por 30 dias");
							Socio s=activos.buscar(new Socio(p.getNumeroSocio()));
							s.setEstado("suspendido");
						}
					}
					System.out.println(p.toString());
				}
				else {
					System.out.println("estado del prestamo irrecuperable se le multara el valor del libro");
					for(Libro l: perdidos) {
						if(l.getCodigo().equals(p.getCodigoDeLibro())) {
							System.out.println(l.toString());
							p.setMulta(l.getPrecio());
						}
					}
					System.out.println(p.toString());
				}
			}
		}
	}
	public static void roturaPerdida(int numero) {
		for(Prestamo p:prestamos) {
			p.setFechaDevolucion(LocalDate.now());
			if(p.getNumeroIdentificador()==numero) {
				bajaPorRoturaPerdida(p.getCodigoDeLibro());
				System.out.println("estado del prestamo irrecuperable se le multara el valor del libro");
				for(Libro l: perdidos) {
					if(l.getCodigo().equals(p.getCodigoDeLibro())) {
						System.out.println(l.toString());
						p.setMulta(l.getPrecio());
					}
				}
				System.out.println(p.toString());
			}
		}
	}
	
	// CONSULTAS
	public static void prestamosVencidos() {
		int count = 0;
		for(Prestamo estado : prestamos) {
			if(estado.getEstado().equals("vencido")) {
				System.out.println(estado.toString());
				count += 1;
			}
			System.out.println("Total de prestamos vencidos: " + count);
		}
	}
	
	public static void prestamosIrrecuperables() {
		int count = 0;
		for(Prestamo estado : prestamos) {
			if(estado.getEstado().equals("irrecuperable")) {
				System.out.println(estado.toString());
				count += 1;
			}
			System.out.println("Total de prestamos irrecuperables" + count);
		}
	}
	
	public static void sociosMorosos() {
		for(Socio estado: activos.generarLista()) {
			if(estado.getEstado().equals("moroso")) {
				System.out.println(estado.toString());
			}
		}
	}
	
	public static void librosPrestados() {
	    System.out.println("Libros Prestados:");
	    for (Libro libro : prestados) {
	        System.out.println(libro.toString());
	    }
	}
	
	public static void librosPerdidos() {
	    System.out.println("Libros Prestados:");
	    for (Libro libro : perdidos) {
	        System.out.println(libro.toString());
	    }
	}
	
	public static int montoTotalMultas() {
	    int totalMultas = 0;
	    for (Prestamo prestamo : prestamos) {
	        if (prestamo.getEstado().equals("irrecuperable")) {
	            totalMultas += prestamo.getMulta();
	        }
	    }
	    return totalMultas;
	}

	public static int cantidadLibrosPrestadosPorSocio(int numeroSocio, LocalDate fechaInicio, LocalDate fechaFin) {
	    int cantidadPrestamos = 0;
	    for (Prestamo prestamo : prestamos) {
	        if (prestamo.getNumeroSocio() == numeroSocio &&
	            prestamo.getFechaPrestamo().isAfter(fechaInicio) &&
	            prestamo.getFechaPrestamo().isBefore(fechaFin.plusDays(1))) {
	            cantidadPrestamos++;
	        }
	    }
	    return cantidadPrestamos;
	}
	public static void mostrarSocio() {
		for(Socio s:activos.generarLista()) {
			System.out.println(s.toString());
		}
	}
	public static void mostrarLibros() {
		for(Libro l:disponibles.generarLista()) {
			System.out.println(l.toString());
		}
	}
	public static void cargarEjemplos() {
		prestamos.addInOrder(new Prestamo("512", 123, LocalDate.now(), 48));
		prestamos.addInOrder(new Prestamo("412", 125, LocalDate.parse("2023-10-01"), 72));
		prestamos.addInOrder(new Prestamo("123", 126, LocalDate.parse("2023-11-18"), 24));
		
		prestados.addInOrder(new Libro("512", "Codigo Facilito", "MiluDev", "San Pablo", 2010, "Programación", 2000));
		prestados.addInOrder(new Libro("412", "Geometria", "Julio Profe", "Aguilar", 1999, "Matematica", 17000));
		prestados.addInOrder(new Libro("123", "Fisica I", "Profe Alex", "Ivrea", 2015, "Fisica Universal", 1500));
	}
}
