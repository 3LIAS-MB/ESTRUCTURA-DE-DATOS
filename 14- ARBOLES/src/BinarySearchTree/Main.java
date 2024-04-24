package BinarySearchTree; // -> "Árbol de busqueda binaria" 

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

public class Main {
	public static void main(String[] args) {
		Main start = new Main();
		
		start.Run();
	}
	
 public void Run() {
     System.out.println("Demo Arbol Binario de Búsqueda");
     // Se crea un árbol binario de búsqueda
     BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
     Integer number;
     for (int i = 0; i < 10; ++i) {
    	 // El casting (Integer) se utiliza para convertir el resultado a un objeto de tipo Integer
    	 // convirtiendo el valor primitivo int en un objeto Integer, lo que te permite almacenar
    	 // ese valor en una estructura de datos que requiere objetos en lugar de tipos primitivos.
         number = (Integer) Helper.random.nextInt(100) + 1;
         bst.add(number);
     }

     System.out.printf("Arbol       %s", bst.toString());
     System.out.println();

     System.out.print("Pre Orden   ");
     bst.PreOrder();
     System.out.println();
     System.out.print("En Orden    ");
     bst.InOrder();
     System.out.println();
     System.out.print("Post Orden  ");
     bst.PostOrder();
     System.out.println();
     System.out.print("Descendente ");
     bst.DescendingOrder();
     System.out.println();

     System.out.printf("Cantidad de Nodos %s\n", bst.NodeCount());
     System.out.printf("Cantidad de Hojas %s\n", bst.LeafCount());
     System.out.printf("Nodos Internos    %s\n", bst.InternalCount());
     System.out.printf("Máximo Nivel      %s\n", bst.MaxLevel());
     System.out.printf("Altura            %s\n", bst.Height());


     System.out.println("\nDemo Arbol Binario de Búsqueda Extracción");
     while (true) {
         System.out.printf("Arbol...: %s\n", bst.toString());
         System.out.printf("En Orden: ");
         bst.InOrder();
         System.out.println();
         number = Helper.getInteger("Ingrese valor a remover (0 finaliza) ");
         if (number == 0) {
             break;
         }
         try {
             bst.remove(number);
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }

 }
}
