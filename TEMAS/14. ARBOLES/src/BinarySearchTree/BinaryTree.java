package BinarySearchTree;
//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//


public class BinaryTree<ELEMENT> { // -> Árbol binario


 //region Binary Tree Node Class

 protected class BTNode<ELEMENT> { // -> Nodo de arbol binario

     public ELEMENT item;
     public BTNode<ELEMENT> left;
     public BTNode<ELEMENT> right;

     public BTNode() {
         this(null, null, null);
     }
     public BTNode(ELEMENT item) {
         this(item, null, null);
     }
     public BTNode(ELEMENT item, BTNode<ELEMENT> left, BTNode<ELEMENT>  right) {
         this.item = item;
         this.left = left;
         this.right = right;
     }

     @Override
     public String toString() {
         return this.item.toString();
     }

     // Método para propósitos académicos
     public void Visit() {
    	 // La cadena de formato (%s)se utiliza con métodos como printf para dar 
    	 // formato a las cadenas que se imprimen en la consola o se almacenan en archivos
         System.out.printf("%s ", this.item.toString()); // -> %s%n
         // Puedes usar %s para cadenas, %d para números enteros, %f para números en 
         // coma flotante, y otros marcadores de formato para diferentes tipos de datos.
         
     }
 }
 //endregion




 //region Attributes
 //-> Representa el nodo raíz del árbol binario
 protected BTNode<ELEMENT> root;//= new BTNode<ELEMENT>(item, null, null);

 //region Constructors

 public BinaryTree() {
     this.root = null;
 }

 // Métodos para propósitos académicos
 public BinaryTree(ELEMENT item) {
     this(item, null, null);
 }
 
 public BinaryTree(ELEMENT item, BinaryTree<ELEMENT> left, BinaryTree<ELEMENT> right) {
     this.root = new BTNode<ELEMENT>(item, null, null); // root siempre en null
     // Si el subárbol izquierdo no es nulo, conectarlo al nodo raíz
     if (left != null) {
    	 // Le asigno el nodo principal 'root' 
    	 // al lado izquierdo del nodo padre
         this.root.left = left.root;
     }
     // Si el subárbol derecho no es nulo, conectarlo al nodo raíz
     // Esto ocurre despues cuando el nodo raiz termina de instanciar
     // sus parametros. Tambien pasa con el primer 'if'
     if (right != null) {
         this.root.right = right.root;
     }
 }

 //endregion

 @Override 
 public String toString() { 
     StringBuilder sb = new StringBuilder();
     toString(sb, this.root);
     return sb.toString();
 }
 protected void toString(StringBuilder sb, BTNode<ELEMENT> root) { // Recursividad
     if (root != null) {
         sb.append(root.item.toString());
         if (root.left != null) {
             sb.append("(");
             toString(sb, root.left);
             if (root.right != null) {
                 sb.append(",");
                 toString(sb, root.right);
             }
             sb.append(")");
         } else {
             if (root.right != null) {
                 sb.append("(,");
                 toString(sb, root.right);
                 sb.append(")");
             }
         }
     }
 }

 /* Realiza un recorrido en preorden del árbol, visitando el nodo raíz primero,
 * luego el subárbol izquierdo y finalmente el subárbol derecho.*/
 // -> Es útil para copiar o clonar árboles, calcular expresiones aritméticas o 
 // -> para cualquier tarea en la que debas procesar el nodo raíz antes de sus hijos.
 public void PreOrder() {
     PreOrder(this.root);
 }	
 protected void PreOrder(BTNode<ELEMENT> root) { // -> Recibe un nodo root como argumento, 
     if (root != null) {						 // que es el nodo actual que se va a visitar.
    	 // nodo raiz 1ro
         root.Visit(); 
         PreOrder(root.left); 
         PreOrder(root.right);
     }
 }

 /* Realiza un recorrido inorden del árbol, visitando primero el subárbol izquierdo,
  * luego el nodo raíz y finalmente el subárbol derecho.*/
 // ->  Se usa cuando necesitas visitar los nodos en orden ascendente
 public void InOrder() {
     InOrder(this.root);
 }
 protected void InOrder(BTNode<ELEMENT> root) {
     if (root != null) {
         InOrder(root.left);
         root.Visit();
         InOrder(root.right);
     }
 }
 
 /* Realiza un recorrido en postorden del árbol, visitando primero el subárbol izquierdo,
  * luego el subárbol derecho y finalmente el nodo raíz.*/
 // ->  Se utiliza cuando necesitas procesar los nodos hijos antes de procesar el nodo raíz.
 // ->  Es útil en tareas como liberar memoria de manera segura, calcular expresiones aritméticas en notación
 // ->  postfija o en cualquier escenario en el que se necesite procesar los nodos hoja antes del nodo raíz.
 public void PostOrder() {
     PostOrder(this.root);
 }
 protected void PostOrder(BTNode<ELEMENT> root) {
     if (root != null) {
         PostOrder(root.left);
         PostOrder(root.right);
         root.Visit();
     }
 }

 /* Realiza un recorrido en orden descendente del árbol, visitando el nodo raíz primero,
  * luego el subárbol derecho y finalmente el subárbol izquierdo -> el InOrder al revés.*/
 // -> Es el inorden en reversa y se utiliza cuando necesitas visitar los nodos en orden descendente
 // -> (si los valores en el árbol están ordenados de mayor a menor)
 public void DescendingOrder() {
     DescendingOrder(this.root);
 }
 protected void DescendingOrder(BTNode<ELEMENT> root) {
     if (root != null) {
         DescendingOrder(root.right);
         root.Visit();
         DescendingOrder(root.left);
     }
 }

// Cantidad de nodos
 public int NodeCount() {
	// Inicia la recursión desde el nodo raíz del árbol
     return NodeCount(this.root);
 }
 protected int NodeCount(BTNode<ELEMENT> root) {
     if (root != null) {
         // Suma 1 para contar el nodo actual y luego realiza llamadas recursivas
         // para contar los nodos en el subárbol izquierdo y derecho
         return 1 + NodeCount(root.left) + NodeCount(root.right);
         // Le sumamos lo que resulte de la rama izq y
    	 // lo que resulte de la rama derecha +1
     }
     // Si el nodo actual es nulo, no hay nodos que contar en este subárbol
     return 0;
 }

// Cantidad de hojas
 public int LeafCount() {
     return LeafCount(this.root);
 }
 protected int LeafCount(BTNode<ELEMENT> root) {
	 // Si es nulo, significa que no hay más nodos para contar
	 // en ese subárbol, por lo que regresamos 0 como resultado.
     if (root != null) {
    	 // Cuando la derecha y la izq son nulos a la vez,
    	 // es que tenemos una hoja y por eso devolvemos 1	
         if ( (root.left == null) && (root.right == null) ) {
             return 1;
         } else {
        	 // En caso contrario, devolvemos lo que resulte de contar en el 
        	 // subarbol izq + lo que resulte de contar en el subarbol derecho
             return LeafCount(root.left) + LeafCount(root.right);
         }
     }
     return 0;
 }

// Cantidad de nodos internos
// Se podria obtener como la cantidad de nodos menos las hojas
 public int InternalCount() { 
     return InternalCount(this.root);
 }
 protected int InternalCount(BTNode<ELEMENT> root) {
     if (root != null) {
    	 // Cuando la izq y la derecha son nulos, se devuelve
    	 // 0 porque estamos frente de una hoja
         if ( (root.left == null) && (root.right == null) ) {
             return 0;
         } else {
        	 // Si no, devolvemos 1 + lo que surga de la izq + la derecha
             return 1 + InternalCount(root.left) + InternalCount(root.right);
         }
     }
     return 0;
 }

// Maximo nivel
 public int MaxLevel() {
     return MaxLevel(this.root);
 }
 
// Si el arbol está vacio retornamos -1
// Si no, hacemos un calculo recursivo
 protected int MaxLevel(BTNode<ELEMENT> root) {
     if (root != null) {
    	 // Hacemos un calculo recursivo empezando por la raiz, y cuando un nodo
    	 // raiz, de un subarbol, tenga ramas distinta de null (ya sea la izq o derc),
    	 // lo que vamos a hacer es determinar cual es la más larga y ese valor le
    	 // vamos a sumar al 1 del nodo que ya tenemos. De manera obtenemos el max nivle
         if ( (root.left != null) || (root.right != null) ) {
             int leftLevel = MaxLevel(root.left);
             int rightLevel = MaxLevel(root.right);
             return 1 + Math.max(leftLevel, rightLevel);
         }
         return 0;
     }
     return -1;
 }

// Altura del arbol
 public int Height() {
	 // La profundidad o altura del arbol lo 
	 // vamos a tomar como 1+ que el maximo nivel
     return MaxLevel() + 1;
 }
}
