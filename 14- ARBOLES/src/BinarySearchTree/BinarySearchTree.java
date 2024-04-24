package BinarySearchTree; // -> "Árbol Binario de Búsqueda" 

//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

/* La restricción de tipo <ELEMENT extends Comparable<ELEMENT>> significa
 * que cualquier tipo ELEMENT que uses como argumento genérico debe
 * implementar la interfaz Comparable o ser una subclase de una clase que lo haga*/

// -> SINTAXIS: public class NombreDeLaClase<T extends Interfaz>
// Significa que los elementos de tipo ELEMENT deben ser capaces de ser comparados entre sí
	public class BinarySearchTree<ELEMENT extends Comparable<ELEMENT>> extends BinaryTree<ELEMENT> {
		// Arbol de busqueda binaria		   				     // Esto indica que BinarySearchTree hereda la funcionalidad de la clase BinaryTree
// Se llama al constructor de la clase base super().			 // para gestionar un árbol binario (es una subclase). Puede usar campos y metodos
// En este caso, la clase base es: BinaryTree<ELEMENT>	
 public BinarySearchTree() {
     super();
     // el constructor de la clase derivada (subclase) llama automáticamente al constructor
     // predeterminado de la clase base (superclase) si no se especifica explícitamente un
     // constructor de la clase base en el constructor de la subclase
 }


 public void add(ELEMENT item) {
	 // protected BTNode<ELEMENT> root;
     if (this.root == null) {
         // Si el árbol está vacío, crea un nuevo nodo
    	 // con el elemento y lo establece como la raíz.
    	 
         this.root = new BTNode<ELEMENT>(item, null, null);
     } else {
    	 // Se utiliza para la iteración y búsqueda
    	 // Tecnica de persecucion, 'temp' recorre el arbol buscando el lugar adecuado para
    	 // el nuevo elemento y 'prev' la va a ir persiguiendo, tomando el valor anterior
    	 // de manera que al final, cuando 'temp`' encuentre el lugar, 'prev' apunta al padre
         BTNode<ELEMENT> temp = this.root; // Inicializa desde la raíz del árbol
         BTNode<ELEMENT> prev = null; // Inicializa un nodo previo
         // Recorre el árbol hasta encontrar la ubicación adecuada para insertar el nuevo elemento.
         while (temp != null ) {
        	 // El nodo previo se actualiza para seguir el recorrido
             prev = temp; 
             // Si 'item' es menor que 'temp.item' devuelve -1    
             // Si son iguales, devuelve 0
             // Si 'item' es mayor que 'temp.item' devuelve 1 
             if (item.compareTo(temp.item) < 0) { // -> tiene un valor de retorno
            	 // Si el nuevo elemento es menor, va al subárbol izquierdo
                 temp = temp.left; 
             } else {
            	 // Si el nuevo elemento es mayor o igual, ve al subárbol derecho
                 temp = temp.right;
             }
         }
         // Crea un nuevo nodo con el elemento y ningún hijo (inicialmente).
         // Se utiliza para la inserción de un nuevo nodo en el árbol.
         temp = new BTNode<ELEMENT>(item, null, null); // -> Apunta a una nueva posicion de memoria
         // Compara el nuevo elemento con el nodo previo, establece el 
         // nuevo nodo como el hijo izquierdo o derecho del nodo previo.
         if (item.compareTo(prev.item) < 0) {
             prev.left = temp; // El nuevo elemento es menor, por lo que se establece como hijo izquierdo.
         } else {
             prev.right = temp; // El nuevo elemento es mayor o igual, por lo que se establece como hijo derecho.
         }
         // Cualquiera elegido se modifica 'root', porque 'prev' apunta a la misma
         // posicion de memoria que 'this.root' que es el nodo raiz.
         // 
     }
 }

 public ELEMENT remove(ELEMENT item) {
     return removeByCopy(item);
     //return removeByFusion(item);
 }

/*Cuando el nodo a eliminar tiene dos descendientes, busca el nodo más grande
 * en el subárbol izquierdo (el sucesor en orden) y copia su valor al nodo que
 * se eliminará. Luego, elimina el nodo más grande. Esto mantiene la propiedad
 * del árbol de búsqueda binaria. Ya que el nodo copiado es el más grande de los
 * valores menores,  lo que garantiza que el nuevo nodo sea mayor que todos los
 * nodos en el subárbol izquierdo y menor que todos los nodos en el subárbol derecho.
 * En el proceso, los nodos descendientes del nodo copiado se ajustan apropiadamente.*/
 
 private ELEMENT removeByCopy(ELEMENT item) {
	 // Se inicia una variable find como la raíz del árbol. Esto	
	 // se usa para buscar el nodo con el valor a eliminar.
     BTNode<ELEMENT> find = this.root;
     // Se inicializa una variable prev en null, que se utilizará
     // para rastrear el nodo padre del nodo que se eliminará.
     BTNode<ELEMENT> prev = null;
     //  El bucle continúa mientras find no sea nulo (esto significa que todavía hay nodos para 
     //  buscar) y el valor del nodo actual (find.item) no sea igual al valor que se busca (item).
     // TECNICA DE LA PERSECUCION
     while ((find != null) && (find.item.compareTo(item) != 0)) {
         prev = find;
         if (item.compareTo(find.item) < 0) {
             find = find.left;
         } else {
             find = find.right;
         }
         // Si el bucle termina y find es null, significa que no se
         // encontró el elemento en el árbol y se lanza una excepción.
     }
     if (find == null) {
         throw new RuntimeException("No existe el elemento o el árbol está vacío");
     } 
     
     // 'find' es el nodo con el valor a extraer (eliminar) y prev el padre de ese nodo
     // El elemento a eliminar se guarda en 'save' para despues poder retornarlo
     ELEMENT save = find.item;
     // Se crea para ayudar en el proceso de manipulación del árbol durante la eliminación
     BTNode<ELEMENT> node = find;
     if (node.right == null) { // no hay subarbol derecho
         node = node.left; // nodo con un descendiente u hoja
     } else {
         if (node.left == null) { // no hay subarbol izquierdo
             node = node.right; // nodo con un descendiente u hoja
         } else { // dos descendientes
             BTNode<ELEMENT> last = node;
             BTNode<ELEMENT> temp = node.right; // a la derecha (mayores)
             while (temp.left != null) { // busca a la izquierda el menor
                 last = temp;
                 temp = temp.left;
             }
             // temp es el menor de los mayores
             node.item = temp.item; // hace la copia
             if (last == node) {
                 last.right = temp.right;
             } else {
                 last.left = temp.right;
             }
             temp.right = null;
         }
     }
     // reajustar el arbol
     if (find == this.root) {
         this.root = node;
     } else {
         if (prev.left == find) {
             prev.left = node;
         } else {
             prev.right = node;
         }
     }
     return save;
 }

/*Cuando el nodo a eliminar tiene dos descendientes, busca el nodo más pequeño en el
 * subárbol derecho (el predecesor en orden) y lo coloca en el lugar del nodo que se
 * eliminará. Luego, elimina el nodo más pequeño, esto mantiene la propiedad del árbol
 * de búsqueda binaria, ya que el nodo colocado es el más pequeño de los valores mayores,
 * lo que garantiza que el nuevo nodo sea menor que todos los nodos en el subárbol derecho
 * y mayor que todos los nodos en el subárbol izquierdo..*/
 // En el proceso, los nodos descendientes del nodo colocado se ajustan apropiadamente.
 private ELEMENT removeByFusion(ELEMENT item) {
     BTNode<ELEMENT> find = this.root;
     BTNode<ELEMENT> prev = null;
     // Busqueada iterativa del nodo recordando al nodo padre
     // 'find' es el nodo  que se va a extraer y 'prev'
     // es el padre de ese nodo
     while ((find != null) && (find.item.compareTo(item) != 0)) {
         prev = find;
         if (item.compareTo(find.item) < 0) {
             find = find.left;
         } else {
             find = find.right;
         }
     }
     // 
     if (find == null) {
         throw new RuntimeException("No existe el elemento o el árbol está vacío");
     }
     ELEMENT save = find.item;
     // Node es el  nodo que va a quedar después de la extracción
     BTNode<ELEMENT> node = find;
     if (node.right == null) { // No hay subarbol derecho
    	 // node con un descendiente (el izq) o hoja
         node = node.left;
     } else {
         if (node.left == null) { // No hay subarbol izquierdo
        	 // node con descendiente (el derecho) o hoja
             node = node.right;
         } else {
        	 // nodo con dos descendientes 
        	 // aplicar la tecnica del menor de los mayores
             BTNode<ELEMENT> temp = node.right;	// (1) a la derecha, los mayores
             while (temp.left != null) { // (2) busca el menor de los mayores
                 temp = temp.left;
             }
             // (3) conectar el arbol izquierdo del nodo que se retira
             temp.left = node.left;
             // (4) desconectar el nodo (queda en 'find')
             node = node.right;
         }
     }
     // (5) ajustar todo el arbol	
     if (find == this.root) {
         this.root = node;
     } else {
         if (prev.left == find) {
             prev.left = node;
         } else {
             prev.right = node;
         }
     }
     find.left = find.right = null;
     return save;
 }
}