package BinaryTree;

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
public class Main {
	public static void main(String[] args) {
		Main start = new Main();
		start.Run();
	}
 public void Run() { 
     System.out.println("Ejercicio Propuesto 1 - Arbol Binario");
     
     /*BinaryTree<Character> a1 = new BinaryTree<Character>('B', new BinaryTree<Character>('A'), new BinaryTree<Character>('C'));
     BinaryTree<Character> a2 = new BinaryTree<Character>('G', new BinaryTree<Character>('F'), null); // Se salta null obvio xd
     BinaryTree<Character> a3 = new BinaryTree<Character>('E', null, a2);
     BinaryTree<Character> a = new BinaryTree<Character>('D', a1, a3);*/
     
     										    	// RAIZ		 //NODO IZQUIERDO             // NODO DERECHO
     BinaryTree<Integer> a1 = new BinaryTree<Integer>(33, new BinaryTree<Integer>(56), new BinaryTree<Integer>(6));
     BinaryTree<Integer> a2 = new BinaryTree<Integer>(17, new BinaryTree<Integer>(7), null);
     BinaryTree<Integer> a3 = new BinaryTree<Integer>(29, null, a2); // cuando no son instancias se mandan como argumentos
     BinaryTree<Integer> a = new BinaryTree<Integer>(8, a1, a3);	 // fijos, cuando son instancias se mandan 1x1

     
     System.out.printf("Arbol...... %s", a.toString());
     System.out.println();

     System.out.print("Pre Orden.. ");
     a.PreOrder();
     System.out.println();
     System.out.print("En Orden... ");
     a.InOrder();
     System.out.println();
     System.out.print("Post Orden. ");
     a.PostOrder();
     System.out.println();
     System.out.print("Descendente ");
     a.DescendingOrder();
     System.out.println();

     System.out.printf("Cantidad de Nodos %s\n", a.NodeCount());
     System.out.printf("Cantidad de Hojas %s\n", a.LeafCount());
     System.out.printf("Nodos Internos    %s\n", a.InternalCount());
     System.out.printf("Máximo Nivel      %s\n", a.MaxLevel());
     System.out.printf("Altura            %s\n", a.Height());

 }
}
