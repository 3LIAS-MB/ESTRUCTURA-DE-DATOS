package Ejercicio6;

import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BinaryTree<Character> a6 = new BinaryTree<Character>('D', new BinaryTree<Character>('G'), null);
		BinaryTree<Character> a5 = new BinaryTree<Character>('E', new BinaryTree<Character>('H'),  new BinaryTree<Character>('I'));
		BinaryTree<Character> a1 = new BinaryTree<Character>('B', a6, a5);
		BinaryTree<Character> a4 = new BinaryTree<Character>('J', null,  new BinaryTree<Character>('K'));   
		BinaryTree<Character> a2 = new BinaryTree<Character>('F', a4 ,null);
	    BinaryTree<Character> a3 = new BinaryTree<Character>('C', null, a2);
	    BinaryTree<Character> a = new BinaryTree<Character>('A', a1, a3);
	        
	        
		String cont = "si";
		do {
			
			
			System.out.println("ingrese que desea realizar:");
			System.out.println("1-Cantidad de nodos");
			System.out.println("2-Cantidad de hojas");
			System.out.println("3-Cantidad de nodos internos");
			System.out.println("4-Maximo nivel del arbol");
			System.out.println("5-Altura de arbol");
			System.out.println("6-Recorrer en orden descendente");
			System.out.println("7-Representacion parentizada");
			
			int op = Helper.getPositiveInt_conLimitador("ingrese su opcion:", "error", 7);
			switch (op) {
			
			case 1:
				System.out.println("la cantidad de nodos son:"+a.NodeCount());
				break;
			case 2:
				System.out.println("la cantidad de hojas es: "+a.LeafCount());
				break;
			case 3:
				System.out.println("la cantidad de nodos internos es: "+a.InternalCount());
				break;
			case 4:
				System.out.println(" el maximo nivel del arbol es: "+a.MaxLevel());
				break;
			case 5:
				System.out.println("la altura del arbol es: "+a.Height());
				break;
			case 6:
				System.out.println(" el recorrido es el siguiente:");
				a.DescendingOrder();
				scanner.nextLine();
				break;
			case 7:
				System.out.printf("Arbol...... %s", a.toString());
		        System.out.println();
		        break;
			default:
				System.out.println("opcion no valida");
				break;
			}
			
		} while (cont.equalsIgnoreCase("si"));
	}
	

}