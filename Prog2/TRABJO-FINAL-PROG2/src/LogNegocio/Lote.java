package LogNegocio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Datos.PersistenciaDatos;
// T debe ser de tipo Producto o una clase que herede de Producto
public class Lote<T extends Producto> implements Serializable {
	static Scanner entrada = new Scanner(System.in);
    //public static Stock stock = new Stock();
	
	private static final long serialVersionUID = 1L	;
	private int nroDeLote;
    private String nombreDelResponsable;
    private String dni;
    private int nroDeLegajoDelResponsable;
    private String codigoDeUbicacionDelLote;
    private LocalDate fechaDeCreacionDelLote;
    private List<Producto> productos;    
    
    public Lote(int nroDeLote, String nombreDelResponsable, String dni, int nroDeLegajoDelResponsable,
        String codigoDeUbicacionDelLote, LocalDate fechaDeCreacionDelLote) {
        this.nroDeLote = nroDeLote;
        this.nombreDelResponsable = nombreDelResponsable;
        this.dni = dni;
        this.nroDeLegajoDelResponsable = nroDeLegajoDelResponsable; 
        this.codigoDeUbicacionDelLote = codigoDeUbicacionDelLote;
        this.fechaDeCreacionDelLote = fechaDeCreacionDelLote;

    }
    
    public Lote() {}
	
    public void grabarNuevoProducto() {
    	ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();
    	
        System.out.print("¿Qué tipo de producto desea agregar?:"
                + "\n1. Producto congelado por agua"	
                + "\n2. Producto congelado por aire"
                + "\n3. Producto congelado por nitrógeno"
                + "\n4. Producto refrigerado\n"
                + "OPCIÓN: ");

        int opcion = entrada.nextInt();

        switch (opcion) {
            case 1	:
        		ArrayList<Lote> lotes = PersistenciaDatos.cargarLotes(); // -> CONFIRMADO

                ProductoCongeladoAgua productoAgua;
                int codigo = Helper.validarInt("Ingrese el código del producto: ");
                String descripcion = Helper.validarString("Ingrese la descripción del producto: ");
                int numeroLote = Helper.validarInt("Ingrese el número del lote: ");
                double costoTratamiento = Helper.validarDouble("Ingrese el costo del tratamiento: "); 
                String codigoOrganismoSupervisionAlimentaria = Helper.validarString("Ingrese el codigo de supervision alimentaria: ");
                String granjaDeOrigen = Helper.validarString("Ingrese granja de origen: ");
                double temperaturaDeMantenimientoRecomendada = Helper.validarDouble("Ingrese costo de temperatura recomendada: ");
                double salinidad = Helper.validarDouble("Ingrese costo de la salinidad: ");
                productoAgua = new ProductoCongeladoAgua(codigo, descripcion, null, numeroLote, costoTratamiento, codigoOrganismoSupervisionAlimentaria, null, granjaDeOrigen, temperaturaDeMantenimientoRecomendada, salinidad);
                
                Lote<ProductoCongeladoAgua> loteAgua = obtenerLoteCorrespondiente(1);
                loteAgua.agregarProducto(productoAgua);
                
                /*for(Lote<?> asd: lotes) {
                	if(asd.getNroDeLote() == 1) {
                		asd.getProductos().add(productoAgua);
                	}
                }*/
                
                PersistenciaDatos.guardarLotes(stock);
                break;
            case 2:
            	ProductoCongeladoAire productoAire;
            	int codigo2 = Helper.validarInt("Ingrese el código del producto: ");
                String descripcion2 = Helper.validarString("Ingrese la descripción del producto: ");
                int numeroLote2 = Helper.validarInt("Ingrese el número del lote: ");
                double costoTratamiento2 = Helper.validarDouble("Ingrese el costo del tratamiento: "); /**/
                String codigoOrganismoSupervisionAlimentaria2 = Helper.validarString("Ingrese numero del lote:");
                String granjaDeOrigen2 = Helper.validarString("Ingrese granjaDeOrigen: ");
                double temperaturaDeMantenimientoRecomendada2 = Helper.validarDouble("Ingrese costo de temperatura recomendada: ");
                double nitrogeno = Helper.validarDouble("Ingrese % del nitrogeno del aire: ");
                double oxigeno = Helper.validarDouble("Ingrese % del oxigeno del aire: ");
                double dioxidoDeCarbono = Helper.validarDouble("Ingrese % del dioxido de carbono del aire: ");
                double vaporDeAgua = Helper.validarDouble("Ingrese % del vapor de agua del aire: ");
                productoAire = new ProductoCongeladoAire(codigo2, descripcion2, null, numeroLote2, costoTratamiento2, codigoOrganismoSupervisionAlimentaria2, null, granjaDeOrigen2, temperaturaDeMantenimientoRecomendada2, nitrogeno, oxigeno, dioxidoDeCarbono, vaporDeAgua);
                
                Lote<ProductoCongeladoAire> loteAire = obtenerLoteCorrespondiente(2);
                loteAire.agregarProducto(productoAire);
                
                PersistenciaDatos.guardarLotes(stock);

            	break;
            case 3:
            	ProductoCongeladoNitrogeno productoNitrogeno;
            	int codigo3 = Helper.validarInt("Ingrese el código del producto: ");
                String descripcion3 = Helper.validarString("Ingrese la descripción del producto: ");
                int numeroLote3 = Helper.validarInt("Ingrese el número del lote: ");
                double costoTratamiento3 = Helper.validarDouble("Ingrese el costo del tratamiento: "); /**/
                String codigoOrganismoSupervisionAlimentaria3 = Helper.validarString("Ingrese numero del lote:");
                String granjaDeOrigen3 = Helper.validarString("Ingrese granjaDeOrigen: ");
                double temperaturaDeMantenimientoRecomendada3 = Helper.validarDouble("Ingrese costo del temperaturaDeMantenimientoRecomendada: ");
                String metodoDeCongelacion = Helper.validarString("Ingrese el metodo de congelacion usado: (nitrogeno)");
                int tiempoDeExposicionAlNitrogeno = Helper.validarInt("Tiempo de exposicion al nitrogeno: ");
                productoNitrogeno = new ProductoCongeladoNitrogeno(codigo3, descripcion3, null, numeroLote3, costoTratamiento3, codigoOrganismoSupervisionAlimentaria3, null, granjaDeOrigen3, temperaturaDeMantenimientoRecomendada3, metodoDeCongelacion, tiempoDeExposicionAlNitrogeno);
	             
                Lote<ProductoCongeladoNitrogeno> loteNitrogeno = obtenerLoteCorrespondiente(3); 
                loteNitrogeno.agregarProducto(productoNitrogeno);
                
                PersistenciaDatos.guardarLotes(stock);

            	break;
            case 4:
            	ProductoRefrigerado productoRefrigerado;
            	int codigo4 = Helper.validarInt("Ingrese el código del producto: ");
                String descripcion4 = Helper.validarString("Ingrese la descripción del producto: ");
                int numeroLote4 = Helper.validarInt("Ingrese el número del lote: ");
                double costoTratamiento4 = Helper.validarDouble("Ingrese el costo del tratamiento: ");
                String codigoSupervision = Helper.validarString("Ingrese codigo de supervision:");
                String granjaDeOrigen4 = Helper.validarString("Ingrese granjaDeOrigen: ");
                double temperaturaDeMantenimientoRecomendada4 = Helper.validarDouble("Ingrese costo del temperaturaDeMantenimientoRecomendada: ");
                productoRefrigerado = new ProductoRefrigerado(codigo4, descripcion4, null, numeroLote4, costoTratamiento4, codigoSupervision, null, temperaturaDeMantenimientoRecomendada4, granjaDeOrigen4);
                
                Lote<ProductoRefrigerado> refrigerado = obtenerLoteCorrespondiente(4); 
                refrigerado.agregarProducto(productoRefrigerado);
                
                PersistenciaDatos.guardarLotes(stock);
            	break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

	public void modificarProducto() {
        ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();

	    System.out.print("¿A qué lote pertenece el producto?:\n"
	            + "1) Productos congelados con agua\n"
	            + "2) Productos congelados con aire\n"
	            + "3) Productos congelados con nitrógeno\n"
	            + "4) Productos refrigerados\n"
	            + "OPCION: ");
	    int choice = entrada.nextInt();
	    int newcode, newnumeroLote, codigo, opcion;
	    String newdescription;
	    double newCostoTratamiento;

	    switch (choice) {
	        case 1:
	            codigo = Helper.validarInt("Ingrese código del producto: ");
	            Producto productoAgua = buscarProductoEnLote(1, codigo);
	            if(productoAgua != null) {
	            	System.out.println("\n¿Qué atributo quiere modificar?\n"
		                    + "1) Codigo del producto\n"
		                    + "2) Descripción del producto\n"
		                    + "3) Fecha de vencimiento\n"
		                    + "4) Numero de Lote\n"
		                    + "5) Costo de tratamiento\n"
		                    + "6) Volver");
		            opcion = Helper.validarInt("Ingrese una opción: ");
		            switch (opcion) {
		                case 1:
		                    newcode = Helper.validarInt("Ingrese nuevo código de producto: ");
		                    productoAgua.setCodigo(newcode);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 2:
		                    newdescription = Helper.validarString("Ingrese nueva descripción");
		                    productoAgua.setDescripcion(newdescription);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 3:
		                    // product.setFechaVencimiento(fechaDeCreacionDelLote)
		                    break;
		                case 4:
		                    newnumeroLote = Helper.validarInt("Ingrese nuevo numero de lote: ");
		                    productoAgua.setNumeroLote(newnumeroLote);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 5:
		                    newCostoTratamiento = Helper.validarDouble("Ingrese nuevo costo de tratamiento: ");
		                    productoAgua.setCostoTratamiento(newCostoTratamiento);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 6:
		                    break;
		                default:
		                    System.out.println("Opción invalida...");
		                    break;
		            }   
	            } else {
	            	System.out.println("Producto no encontrado...");
	            }
	            break;
	        case 2:
	            codigo = Helper.validarInt("Ingrese código del producto: ");
	            Producto productoAire = buscarProductoEnLote(2, codigo);
	            if(productoAire != null) {
		            System.out.println("\n¿Qué atributo quiere modificar?\n"
		                    + "1) Codigo del producto\n"
		                    + "2) Descripción del producto\n"
		                    + "3) Fecha de vencimiento\n"
		                    + "4) Numero de Lote\n"
		                    + "5) Costo de tratamiento\n"
		                    + "6) Volver");
		            opcion = Helper.validarInt("Ingrese una opción: ");

		            switch (opcion) {
		                case 1:
		                    newcode = Helper.validarInt("Ingrese nuevo código de producto: ");
		                    productoAire.setCodigo(newcode);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 2:
		                    newdescription = Helper.validarString("Ingrese nueva descripción: ");
		                    productoAire.setDescripcion(newdescription);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 3:
		                    // product.setFechaVencimiento(fechaDeCreacionDelLote)
		                    break;
		                case 4:
		                    newnumeroLote = Helper.validarInt("Ingrese nuevo numero de lote: ");
		                    productoAire.setNumeroLote(newnumeroLote);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 5:
		                    newCostoTratamiento = Helper.validarDouble("Ingrese nuevo costo de tratamiento: ");
		                    productoAire.setCostoTratamiento(newCostoTratamiento);
			            	PersistenciaDatos.guardarLotes(stock);
		                    break;
		                case 6:
		                    break;
		                default:
		                    System.out.println("Opción invalida...");
		                    break;
		            }
	            } else {
	            	System.out.println("Producto no encontrado...");
	            }
	            
	            break;
	        case 3:
	        	codigo = Helper.validarInt("Ingrese código del producto: ");
	        	Producto productoNitrogeno = buscarProductoEnLote(3, codigo);
	        	if(productoNitrogeno != null) {
		        	System.out.println("\n¿Qué atributo quiere modificar?\n"
		        			+ "1) Codigo del producto\n"
		        			+ "2) Descripción del producto\n"
		        			+ "3) Fecha de vencimiento\n"
		        			+ "4) Numero de Lote\n"
		        			+ "5) Costo de tratamiento\n"
		        			+ "6) Volver");
		        	opcion = Helper.validarInt("Ingrese una opción: ");
		      
		        	switch(opcion) {
			        	case 1:
			        		newcode = Helper.validarInt("Ingrese nuevo código de producto: ");
			        		productoNitrogeno.setCodigo(newcode);
			            	PersistenciaDatos.guardarLotes(stock);
			        		break;
			        	case 2:
			        		newdescription = Helper.validarString("Ingrese nueva descripción");
			        		productoNitrogeno.setDescripcion(newdescription);
			            	PersistenciaDatos.guardarLotes(stock);
			        		break;
			        	case 3:
			        		//product.setFechaVencimiento(fechaDeCreacionDelLote)
			        		break;
			        	case 4:
			        		newnumeroLote = Helper.validarInt("Ingrese nuevo numero de lote: ");
			        		productoNitrogeno.setNumeroLote(newnumeroLote);
			            	PersistenciaDatos.guardarLotes(stock);
			        		break;
			        	case 5:
			        		newCostoTratamiento = Helper.validarDouble("Ingrese nuevo costo de tratamiento: ");
			        		productoNitrogeno.setCostoTratamiento(newCostoTratamiento);
			            	PersistenciaDatos.guardarLotes(stock);
			            break;
			        } 
	        	} else {
	            	System.out.println("Producto no encontrado...");
	            }
	        case 4:
	        	codigo = Helper.validarInt("Ingrese código del producto: ");
	        	Producto productoRefrigerado = buscarProductoEnLote(4, codigo);
	        	if(productoRefrigerado != null) {
	        		System.out.println("\n¿Qué atributo quiere modificar?\n"
		        			+ "1) Codigo del producto\n"
		        			+ "2) Descripción del producto\n"
		        			+ "3) Fecha de vencimiento\n"
		        			+ "4) Numero de Lote\n"
		        			+ "5) Costo de tratamiento\n"
		        			+ "6) Volver");
		        	opcion = Helper.validarInt("Ingrese una opción: ");
		      
		        	switch(opcion) {
		        	case 1:
		        		newcode = Helper.validarInt("Ingrese nuevo código de producto: ");
		        		productoRefrigerado.setCodigo(newcode);
		            	PersistenciaDatos.guardarLotes(stock);
		        		break;
		        	case 2:
		        		newdescription = Helper.validarString("Ingrese nueva descripción: ");
		        		productoRefrigerado.setDescripcion(newdescription);
		            	PersistenciaDatos.guardarLotes(stock);
		        		break;
		        	case 3:
		        		//product.setFechaVencimiento(fechaDeCreacionDelLote)
		        		break;
		        	case 4:
		        		newnumeroLote = Helper.validarInt("Ingrese nuevo numero de lote: ");
		        		productoRefrigerado.setNumeroLote(newnumeroLote);
		            	PersistenciaDatos.guardarLotes(stock);
		        		break;
		        	case 5:
		        		newCostoTratamiento = Helper.validarDouble("Ingrese nuevo costo de tratamiento: ");
		        		productoRefrigerado.setCostoTratamiento(newCostoTratamiento);
		            	PersistenciaDatos.guardarLotes(stock);
		        	break;
		        	default:
		        		System.out.println("Opción invalida...");
		        	}
	        	} else {
	            	System.out.println("Producto no encontrado...");
	        	}
	    	}
		}

    public void mostrarLotes() {
    	ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();

    	System.out.println("------Listado de lotes y productos------");

        for (Lote<?> lote : stock) {
            System.out.println("Número de lote: " + lote.getNroDeLote());
            System.out.println("Responsable: " + lote.getNombreDelResponsable());
            System.out.println("Ubicación: " + lote.getCodigoDeUbicacionDelLote());
            System.out.println("Fecha de creación: " + lote.getFechaDeCreacionDelLote());

            List<? extends Producto> productos = lote.getProductos();
            if (productos.isEmpty()) {
                System.out.println("Este lote no tiene productos.");
            } else {
                System.out.println("Productos en el lote:");
                for (Producto producto : productos) {
                    System.out.println(producto.toString());
                }
            	System.out.println("-------------------------------------");
            }
        }
    }
    
    public Producto buscarProductoEnLote(int numeroLote, int codigoProducto) {
        ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();

        if (stock != null) {
            for (Lote<?> lote : stock) {
                if (lote.getNroDeLote() == numeroLote) {
                    for (Producto producto : lote.getProductos()) {
                        if (producto.getCodigo() == codigoProducto) {
                            return producto;
                        }
                    }
                }
            }
        }
        return null;
    }

    
	public static <T extends Producto> Lote<T> obtenerLoteCorrespondiente(int numeroLote) {
        ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();
	    for (Lote<?> lote : stock) {
	        if (lote.getNroDeLote() == numeroLote) {
	            @SuppressWarnings("unchecked")
	            Lote<T> loteEspecifico = (Lote<T>) lote;
	            return loteEspecifico;
	        }
	    }
	    return null;
	}
	

	
	public void eliminarProducto() {
    	ArrayList<Lote> stock = PersistenciaDatos.cargarLotes();

	    System.out.print("¿A qué lote pertenece el producto?:\n"
	            + "1) Productos congelados con agua\n"
	            + "2) Productos congelados con aire\n"
	            + "3) Productos congelados con nitrógeno\n"
	            + "4) Productos refrigerados\n"
	            + "5) Cancelar\n"
	            + "OPCION: ");
	    int choice = entrada.nextInt();
	    int codigo, opcion;


	    switch (choice) {
        case 1:
            codigo = Helper.validarInt("Ingrese código del producto: ");
            Producto productoAgua = buscarProductoEnLote(1, codigo);
            if (productoAgua != null) {
                Lote<ProductoCongeladoAgua> loteAgua = obtenerLoteCorrespondiente(1);
                loteAgua.eliminarProducto(productoAgua);
                PersistenciaDatos.guardarLotes(stock);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Producto no encontrado...");
            }
		    break;
        case 2:
            codigo = Helper.validarInt("Ingrese código del producto: ");
            Producto productoAire = buscarProductoEnLote(2, codigo);
            if (productoAire != null) {
                Lote<ProductoCongeladoAgua> loteAire = obtenerLoteCorrespondiente(2);
                loteAire.eliminarProducto(productoAire);
                PersistenciaDatos.guardarLotes(stock);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Producto no encontrado...");
            }
        	break;
        case 3:
            codigo = Helper.validarInt("Ingrese código del producto: ");
            Producto productoNitrogeno = buscarProductoEnLote(3, codigo);
            if (productoNitrogeno != null) {
                Lote<ProductoCongeladoNitrogeno> loteNitrogeno = obtenerLoteCorrespondiente(3);
                loteNitrogeno.eliminarProducto(productoNitrogeno);
                PersistenciaDatos.guardarLotes(stock);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Producto no encontrado...");
            }
        	break;
        case 4:
            codigo = Helper.validarInt("Ingrese código del producto: ");
            Producto productoRefrigerado = buscarProductoEnLote(4, codigo);
            if (productoRefrigerado != null) {
                Lote<ProductoRefrigerado> loteRefrigerado = obtenerLoteCorrespondiente(4);
                loteRefrigerado.eliminarProducto(productoRefrigerado);
                PersistenciaDatos.guardarLotes(stock);
                System.out.println("Producto eliminado correctamente.");
            } else {
                System.out.println("Producto no encontrado...");
            }
        	break;
        case 5:
        	break;
	    }
	}
	
	 public double calcularCostoTotalLote() { 
	        double costoTotal = 0;
	        for (Producto producto : productos) {
	        	if(producto instanceof ProductoCongelado) {
	        		costoTotal += producto.getCostoTratamiento();
	        		costoTotal *= ProductoCongelado.margenGananciaCongelados; 
	        	}
	        	else if(producto instanceof ProductoRefrigerado) {
	        		costoTotal += producto.getCostoTratamiento();
	        		costoTotal *= ProductoRefrigerado.margenGananciaRefrigerados;
	        	}
	        }
	        return costoTotal;
	    }
    
	public void calcularCostoPorCadaLote() {
		//List<Producto> productos = PersistenciaDatos.cargarLotes();
		
        double margenLoteAgua = 0, margenLoteAire = 0, margenLoteNitrogeno = 0;
        double margenLoteRefrigerado = 0;
        for(Producto producto : productos) {
        	if(producto instanceof ProductoCongeladoAgua) {
        		margenLoteAgua += producto.getCostoTratamiento();
        	} else if(producto instanceof ProductoCongeladoAire) {
        		margenLoteAire += producto.getCostoTratamiento();
        	} else if(producto instanceof ProductoCongeladoNitrogeno) {
        		margenLoteNitrogeno += producto.getCostoTratamiento();
        	} else if(producto instanceof ProductoRefrigerado) {
        		margenLoteRefrigerado += producto.getCostoTratamiento();
        	}
        }
        margenLoteAgua *= ProductoCongeladoAgua.margenGananciaCongelados;
        margenLoteAire *= ProductoCongeladoAire.margenGananciaCongelados;
        margenLoteNitrogeno *= ProductoCongeladoNitrogeno.margenGananciaCongelados;
        margenLoteRefrigerado *= ProductoRefrigerado.margenGananciaRefrigerados;
        
        System.out.println("Margen de ganancia total lote congelado por agua: " +  margenLoteAgua);
        System.out.println("Margen de ganancia total lote congelado por aire: " + margenLoteAire);
        System.out.println("Margen de ganancia total lote congelado por nitrogeno: " + margenLoteNitrogeno);
        System.out.println("Margen de ganancia total lote refrigerado: " + margenLoteRefrigerado + "\n");
	}
	
	public int getNroDeLote() {
		return nroDeLote;
	}

	public void setNroDeLote(int nroDeLote) {
		this.nroDeLote = nroDeLote;
	}

	public String getNombreDelResponsable() {
		return nombreDelResponsable;
	}

	public void setNombreDelResponsable(String nombreDelResponsable) {
		this.nombreDelResponsable = nombreDelResponsable;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getNroDeLegajoDelResponsable() {
		return nroDeLegajoDelResponsable;
	}

	public void setNroDeLegajoDelResponsable(int nroDeLegajoDelResponsable) {
		this.nroDeLegajoDelResponsable = nroDeLegajoDelResponsable;
	}

	public String getCodigoDeUbicacionDelLote() {
		return codigoDeUbicacionDelLote;
	}

	public void setCodigoDeUbicacionDelLote(String codigoDeUbicacionDelLote) {
		this.codigoDeUbicacionDelLote = codigoDeUbicacionDelLote;
	}

	public LocalDate getFechaDeCreacionDelLote() {
		return fechaDeCreacionDelLote;
	}

	public void setFechaDeCreacionDelLote(LocalDate fechaDeCreacionDelLote) {
		this.fechaDeCreacionDelLote = fechaDeCreacionDelLote;
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}