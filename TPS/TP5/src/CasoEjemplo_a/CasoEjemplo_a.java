package CasoEjemplo_a;

import java.util.Iterator;

public class CasoEjemplo_a {

    static String[] descriptions = new String[] {
        "Yoghurt firme",
        "Leche chocolatada",
        "Manteca",
        "Leche larga vida",
        "Dulce de leche",
        "Leche fortificada"
    };
                                            // Variable miembro de la clase. Esto significa que es un campo o atributo
    private ILinkedList<Product> products;  // de la clase y no está directamente relacionado con el método main en sí.
    
    public static void main(String[] args) {
        CasoEjemplo_a casoEjemploA = new CasoEjemplo_a();
        casoEjemploA.Run();
    }

    public void Run() {
    	// La lista enlazada simple se declara y se instancia por sí misma
    	// Esto crea una instancia de SimpleLinkedList que almacenará objetos de tipo Product
    	
        products = new SimpleLinkedList<>(); // Llama al constructor y lo inicializa como:
        getData();						 	 // head = null; count = 0; tail = null
        
      System.out.println("\n\nLista de productos (Iterable): ");
      for (Product p : products) {
          System.out.println(p.toString());
      }


    }

    private void showMenu() {
        System.out.println(
            "\nTrabajo Práctico Nº 4 - Caso Ejempo a)\n" +
            "\nOpciones" +
            "\n 1. Ingresa valores por consola" +
            "\n 2. Genera valores aleatorios" +
            "\n 3. Agregar al principio" +
            "\n 4. Agregar al final" +
            "\n 5. Remover el primer elemento" +
            "\n 6. Remover el último elemento" +
            "\n 7. Mostrar lista de productos" +
            "\n 8. Salir"
        );
    }

    private void getData() {
        Integer option;
        while (true) {
            showMenu(); // MUY BUENA IDEA
            option = Helper.getInteger("\nSu opción: ");
            switch (option) {
                case 1:
                    consoleInput();
                    break;
                case 2:
                    randomGenerate();
                    break;
                case 3:
                    products.addFirst(null);
                    break;
                case 4:
                    
                    break;
                case 5:
                	products.removeFirst();
                    break;
                case 6:
                	products.removeLast();
                    break;
                case 7:
                    System.out.println("\n\nLista de productos2: ");
                    Iterator<Product> it = products.iterator();
                    while (it.hasNext()) {
                        System.out.println(it.next().toString());
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    
    private void consoleInput() {
        Integer code;
        String description;
        Float salePrice;
        int position;

        System.out.println("\nIngrese los datos de los productos");
        do {
       	 
       	 
            while (true) {
                code = Helper.getInteger("Código..........: ");
                if (code > 0) {
                    break;
                }
                System.out.println("Ingrese un código válido...");
            }

            while (true) {
                System.out.print("Descripción.....: ");
                description = Helper.scanner.nextLine();
                if (!description.isEmpty()) {
                    break;
                }
                System.out.println("Ingrese una descripción válida...");
            }

            while(true) {
                salePrice = Helper.getFloat("Precio de Venta.: ");
                if (salePrice > 0f) {
                    break;
                }
                System.out.println("Ingrese un precio válido ...");
            }

            while (true) {
                position  = Helper.getInteger("\nDonde agrega el producto [1. Adelante,  2. Final] ");
                if (position == 1) {
                    products.addFirst( new Product(code, description, salePrice) ); // Te lleva al constructor
                    break;
                } else {
                    if (position == 2) {
                        products.addLast( new Product(code, description, salePrice) );
                        break;
                    }
                }
                System.out.println("Ingrese una posición correcta ...");
            }

        } while (Character.toUpperCase(Helper.getCharacter("Ingresa otro producto (S/N): ")) != 'N');
    }
    
    private void randomGenerate() {
        Integer code;
        String description;
        Float salePrice;
        int position;

        for (int count = 4 + 1; count > 0; --count) {
            code = Helper.random.nextInt(99) + 1; // Numero entre el 1 al 100
            description = descriptions[Helper.random.nextInt(descriptions.length)];
            salePrice = Helper.random.nextFloat(10) * 10;
            position = Helper.getInteger("\n1. Agregar al principio \n2. Agregar al final \n3. Salir\nOpción: ");
            
            switch(position) {
            case 1:
              	// Primero crea una instancia de 'Product' y después lo agrega a la lista de nodos
            	// Es perfectamente válido crear una instancia de una clase sin asignarla a una 
            	// variable local si no necesitas hacer referencia a esa instancia después de su creación
            	products.addFirst(new Product(code, description, salePrice));
            	break;
            case 2:
            	products.addLast(new Product(code, description, salePrice));
            	break;
            case 3:
            	return;
            } 
        }
    }
}
