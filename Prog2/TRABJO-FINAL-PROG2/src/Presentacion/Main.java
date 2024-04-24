package Presentacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.PersistenciaDatos;
import LogNegocio.Helper;
import LogNegocio.Lote;
import LogNegocio.Producto;
import LogNegocio.ProductoCongeladoAgua;
import LogNegocio.ProductoCongeladoAire;
import LogNegocio.ProductoCongeladoNitrogeno;
import LogNegocio.ProductoRefrigerado;
import LogNegocio.Stock;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
    	ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();

		int opcion, codigo, codigoLote;
		double costo, costoTotalLoteDeterminado;
		Lote lot = new Lote();
		
		ProductoCongeladoAgua productoAgua = new ProductoCongeladoAgua(10, "Producto Agua", LocalDate.now(), 1, 1000, "CS001", LocalDate.now(), "Granja Refrigerado", 12.4, 1.2);
		ProductoCongeladoAire productoAire = new ProductoCongeladoAire(11, "Producto Aire", LocalDate.now(), 2, 2000, "OSA002", LocalDate.now(), "Granja Aire", -8.0, 70.0, 20.0, 5.0, 15.0);
		ProductoCongeladoNitrogeno productoNitrogeno = new ProductoCongeladoNitrogeno(12, "Producto Nitrogeno", LocalDate.now(), 3, 3000, "OSA003", LocalDate.now(), "Granja Nitrógeno", -10.0, "Método X", 30);
		ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(13, "Producto Refrigerado", LocalDate.now(), 4, 4000, "CS001", LocalDate.now(), 4.0, "Granja Refrigerado");
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		productos.add(productoAgua);
		productos.add(productoAire);
		productos.add(productoNitrogeno);
		productos.add(productoRefrigerado);
	
		PersistenciaDatos.guardarProductos(productos); //  -> CONFIRMADO
		

	//  System.out.println(asd.toString());
	//  System.out.println("\n");

		
	    Lote<ProductoCongeladoAgua> loteAgua = new Lote<>(1, "Elias", "12345678", 101, "Ubicacion1", LocalDate.now());
	    Lote<ProductoCongeladoAire> loteAire = new Lote<>(2, "Responsable3", "11111111", 103, "Ubicacion3", LocalDate.now()); 
	    Lote<ProductoCongeladoNitrogeno> loteNitrogeno = new Lote<>(3, "Responsable4", "99999999", 104, "Ubicacion4", LocalDate.now());
	    Lote<ProductoRefrigerado> loteRefrigerado = new Lote<>(4, "Responsable2", "87654321", 102, "Ubicacion2", LocalDate.now());

	    loteAgua.agregarProducto(productoAgua);
	    loteAire.agregarProducto(productoAire);
	    loteNitrogeno.agregarProducto(productoNitrogeno);
	    loteRefrigerado.agregarProducto(productoRefrigerado);
	    
		ArrayList<Lote> lotes = new ArrayList<Lote>(); // -> CONFIRMADO
		lotes.add(loteAgua);
		lotes.add(loteAire);
		lotes.add(loteNitrogeno);
		lotes.add(loteRefrigerado);

		
		while(true) {
			System.out.print("\t**MENU**\n"
					+ "1) Grabar un nuevo producto\r\n"
					+ "2) Modificar los datos de un Producto determinado\r\n"
					+ "3) Eliminar un Producto determinado\r\n"
					+ "4) Costo total en Stock\r\n"
					+ "5) Costo Total de un lote determinado.\r\n"
					+ "6) Margen de ganancia total en cada lote\r\n"
					
					+ "7) Cantidad de productos en cada lote\r\n" /**/
					//+ "8) Cantidad de productos de un determinado tipo en cada lote.\n" /**/
					+ "9) Verificar y eliminar productos vencidos en un lote.\r\n" /**/
					+ "10) Mostrar la etiqueta del producto\n" /**/
					
					+ "11) Mostrar lotes y sus productos\n"
					+ "12) Salir\n"
					+ "OPCIÓN: ");

			opcion = entrada.nextInt();
			
			switch(opcion){
			case 1:
				lot.grabarNuevoProducto();
				break;
			case 2:
				lot.modificarProducto();
				break;
			case 3:
				lot.eliminarProducto();
				break;
			case 4:
				costo = Stock.calcularCostoTotalEnStock();
				System.out.println("El costo total en stock es de $" + costo);
				break;
			case 5:
				codigoLote = Helper.validarInt("Ingrese el numero de lote: ");
				costoTotalLoteDeterminado = Stock.costoTotalDeUnLoteDeterminado(codigoLote);
				if(costoTotalLoteDeterminado != -1) {
					System.out.println("El costo total del lote es de $" + costoTotalLoteDeterminado);
				} else {
					System.out.println("No se ha encontrado el lote...");
				}
				break;
			case 6:
				lot.calcularCostoPorCadaLote();
				break;
			case 7:
				//Stock.cantidadDeProductosEnCadaLote();
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				lot.mostrarLotes();
				break;
			case 12:
				System.out.println("Saliendo...");
				break;
				default:
					System.out.println("Opcion incorrecta");
			}
		}
	}
}