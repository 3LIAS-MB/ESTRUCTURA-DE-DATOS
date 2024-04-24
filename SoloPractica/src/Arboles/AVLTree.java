//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
// La altura de un arbol esta relacionada con el nive, de modo que podemos decir
// que la altura tiene un orden o un big0 "h = O(1.44log n), o sea, es logaritmica
// no va a ser lineal como en el peor de los casos como un arbol de busqueda binaria
// que no cuide el balence o equilibrio

/*El balance en un árbol binario de búsqueda AVL se refiere a la diferencia de alturas
entre los subárboles izquierdo y derecho de cada nodo. La condición fundamental que
debe cumplirse para que un árbol binario sea AVL es que para cada nodo, la diferencia
de alturas entre sus subárboles izquierdo y derecho (conocida como el factor de equilibrio)
debe estar en el rango {-1, 0, 1}.*/
 
// AVLTree es una clase genérica que se usa para crear un
// árbol AVL de elementos comparables. Los elementos deben
// ser comparables para que el árbol pueda mantenerse equilibrado.

// Implementa un árbol AVL (Árbol de Búsqueda Binario Equilibrado)
package Arboles;

public class AVLTree<ELEMENT extends Comparable<ELEMENT>> { 
    protected AVLNode<ELEMENT> root;
    // atributo para propositos académicos
    protected boolean verbose;
    
    public AVLTree() {
        this.root = null;
        this.verbose = false;
    }
    
    protected class AVLNode<ELEMENT> {
        public ELEMENT item;
        public AVLNode<ELEMENT> left;
        public AVLNode<ELEMENT> right;
        // Factor de equilibrio que se utiliza
        // para mantener el árbol balanceado
        public int balance;
 
        public AVLNode() {
            this(null, null, null, 0);
        }
        public AVLNode(ELEMENT item) {
            this(item, null, null, 0);
        }
        public AVLNode(ELEMENT item, AVLNode<ELEMENT> left, AVLNode<ELEMENT> right, int balance) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.balance = balance;
        }
 
        @Override
        public String toString() {
            return this.item.toString();
        }
 
        // Método para propósitos académicos
        public void Visit() {
            System.out.printf("%s ", this.item.toString());
        }
    }

 
    // método para propósitos académicos
    public boolean setVerbose(boolean verbose) {
        this.verbose = verbose;
        return this.verbose;
    }
 
    //region Métodos para buscar
    public boolean contains(ELEMENT item) {
        return contains(this.root, item);
    }
    private boolean contains(AVLNode<ELEMENT> root, ELEMENT item) {
        if (root == null) {
            return false;
        }
        if (item.compareTo(root.item) < 0) {
            return contains(root.left, item);
        }
        if (item.compareTo(root.item) > 0) {
            return contains(root.right, item);
        }
        return true;
    }
    //endregion
 
    //region Métodos para agregar elementos al árbol
 
    public void add(ELEMENT item) {
        if (this.verbose) {
            System.out.printf("Agrega %s", item.toString());
        }
 
        boolean[] change = { false };
        this.root = addAVL(this.root, item, change);
 
        if (this.verbose) {
            System.out.printf("\t %s\n", this.toString());
        }
    }
 
    private AVLNode<ELEMENT> addAVL(AVLNode<ELEMENT> root, ELEMENT item, boolean[] change) {	
        AVLNode<ELEMENT> n1;
 
        if (root == null) {
            root = new AVLNode<ELEMENT>(item);
            change[0] = true; // cambia el balance
            return root;
        }
 
        if (item.compareTo(root.item) < 0) { // el nuevo elemento es menor
            root.left = addAVL(root.left, item, change); // agrega por la izquierda
            if (change[0]) { // cambió el balance?
                switch (root.balance) { // balance = hD - hI
                    case 1: // antes izquierda < derecha
                        root.balance = 0; // después izquierda == derecha
                        change[0] = false; // balance ajustado
                        break;
                    case 0: // antes izquierda == derecha
                        root.balance = -1; // después izquierda > derecha
                        break;
                    case -1: // antes izquierda > derecha
                        n1 = root.left;
                        if (n1.balance == -1) { // izquierda izquierda es mayor
                            root = leftleftRotation(root, n1); // LR rotación doble
                        } else {
                            root = leftrightRotation(root, n1); // LL rotación simple
                        }
                        change[0] = false; // balance ajustado
                        break;
                }
            }
            return root;
        }
 
        if (item.compareTo(root.item) > 0) { // el nuevo elemento es mayor
            root.right = addAVL(root.right, item, change); // agregar por la derecha
            if (change[0]) { // cambió el balance?
                switch (root.balance) { // balance = hD - hI
                    case -1: // antes izquierda > derecha
                        root.balance = 0; // ahora izquierda == derecha
                        change[0] = false; // balance ajustado
                        break;
                    case 0: // antes izquierda == derecha
                        root.balance = 1; // ahora izquierda < derecha
                        break;
                    case 1: // antes izquierda < derecha
                        n1 = root.right;
                        if (n1.balance == 1) { // derecha derecha es mayor
                            root = rightrightRotation(root, n1); // RR rotación simple
                        } else {
                            root = rightleftRotation(root, n1); // RL rotación doble
                        }
                        change[0] = false; // balance ajustado
                        break;
                }
            }
            return root;
        }
        throw new RuntimeException("Claves repetidas");
    }
    //endregion
 
    //region Rotaciones LL LR RR RL
    private AVLNode<ELEMENT> leftleftRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" LL ");
        }
 
        n.left = n1.right;
        n1.right = n;
        if (n1.balance == -1) {
            n.balance = 0;
            n1.balance = 0;
        } else {
            n.balance = -1;
            n1.balance = 1;
        }
        return n1;
    }
 
    private AVLNode<ELEMENT> leftrightRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" LR ");
        }
 
        AVLNode<ELEMENT> n2;
        n2 = n1.right;
        n.left = n2.right;
        n2.right = n;
        n1.right = n2.left;
        n2.left = n1;
        n1.balance = (n2.balance == 1) ? -1 : 0;
        n.balance = (n2.balance == -1) ? 1 : 0;
        n2.balance = 0;
        return n2;
    }
 
    private AVLNode<ELEMENT> rightrightRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" RR ");
        }
 
        n.right = n1.left;
        n1.left = n;
        if (n1.balance == 1) {
            n.balance = 0;
            n1.balance = 0;
        } else {
            n.balance = 1;
            n1.balance = -1;
        }
        return n1;
    }
 
 
    private AVLNode<ELEMENT> rightleftRotation(AVLNode<ELEMENT> n, AVLNode<ELEMENT> n1) {
        if (this.verbose) {
            System.out.print(" RL ");
        }
 
        AVLNode<ELEMENT> n2;
        n2 = n1.left;
        n.right = n2.left;
        n2.left = n;
        n1.left = n2.right;
        n2.right = n1;
        n.balance = (n2.balance == 1) ? -1: 0;
        n1.balance = (n2.balance == -1) ? 1 : 0;
        n2.balance = 0;
        return n2;
    }
    //endregion
 
    //region Métodos para remover elementos
 
    public void remove(ELEMENT item) {
        if (this.verbose) {
            System.out.printf("Extrae %s", item.toString());
        }
 
        boolean[] change = { false };
        this.root = removeAVL(this.root, item, change);
 
        if (this.verbose) {
            System.out.printf("\t %s\n", this.toString());
        }
    }
    private AVLNode<ELEMENT> removeAVL(AVLNode<ELEMENT> root, ELEMENT item, boolean[] change) {
 
        if (root == null) {
            throw new RuntimeException("No existe");
        }
 
        if (item.compareTo(root.item) < 0) { // el elemento es menor
            root.left = removeAVL(root.left, item, change); // borrar por la izquierda
            if (change[0]) { // cambió el balance?
                root = leftBalance(root, change); // ajustar el balance izquierdo
            }
            return root;
        }
 
        if (item.compareTo(root.item) > 0) { // el elemento es mayor
            root.right = removeAVL(root.right, item, change); // borrar por la derecha
            if (change[0]) { // cambió el balance?
                root = rightBalance(root, change); // ajustar el balance derecho
            }
            return root;
        }
 
 
        AVLNode<ELEMENT> q;
        q = root;
        if (q.left == null) { // no hay izquierda
            root = q.right; // un descendiente por la derecha u hoja
            change[0] = true; // cambia el balance
        } else {
            if (q.right == null) { // no hay derecha
                root = q.left; // un descendiente por la izquierda
                change[0] = true; // cambia el balance
            } else { // dos descendientes !!!
                root.left = eldestOfMinors(root, root.left, change); // mayor de los menores
                if (change[0]) { // cambió el balance?
                    root = leftBalance(root, change); // ajustar el balance izquierdo
                }
                q = null; // eliminar el nodo
            }
        }
        return root;
    }
 
    private AVLNode<ELEMENT> eldestOfMinors(AVLNode<ELEMENT> n, AVLNode<ELEMENT> eldest, boolean[] change) {
        if (eldest.right != null) { // hay algo a la derecha
            eldest.right = eldestOfMinors(n, eldest.right, change); // busca el mayor de los menores
            if (change[0]) { // cambió el balance?
                eldest = rightBalance(eldest, change); // ajustar el balance derecho
            }
        } else {
            n.item = eldest.item;
            n = eldest;
            eldest = eldest.left;
            n = null;
            change[0] = true;
        }
        return eldest;
    }
 
    private AVLNode<ELEMENT> leftBalance(AVLNode<ELEMENT> n, boolean[] change) {
        AVLNode<ELEMENT> n1;
        switch (n.balance) { // balance = hD - hI
            case -1 : // antes izquierda > derecha
                n.balance = 0; // ahora izquierda == derecha
                break;
            case 0 : // antes izquierda == derecha
                n.balance = 1; // ahora izquierda < derecha
                change[0] = false; // balance ajustado
                break;
            case 1 : // antes izquierda < derecha
                n1 = n.right;
                if (n1.balance >= 0) {
                    if (n1.balance == 0) {
                        change[0] = false; // balance ajustado
                    }
                    n = rightrightRotation(n, n1);
                } else {
                    n = rightleftRotation(n, n1);
                }
                break;
        }
        return n;
    }
 
    private AVLNode<ELEMENT> rightBalance(AVLNode<ELEMENT> n, boolean[] change) {
        AVLNode<ELEMENT> n1;
        switch (n.balance) { // balance = hD - hI
            case -1 : // antes izquiera > derecha
                n1 = n.left;
                if (n1.balance <= 0) {
                    if (n1.balance == 0) {
                        change[0] = false; // balance ajustado
                    }
                    n = leftleftRotation(n, n1);
                } else {
                    n = leftrightRotation(n, n1);
                }
                break;
            case 0 : // antes izquierda == derecha
                n.balance = -1; // ahora izquierda > derecha
                change[0] = false; // balance ajustado
                break;
            case 1 : // antes izquierda < derecha
                n.balance = 0;
                break;
        }
        return n;
    }

    @Override
    public String toString() {
        return toString(this.root);
    }
    protected String toString(AVLNode<ELEMENT> root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.item.toString());
            //sb.append("[" + root.balance.toString() + "]");
            sb.append((root.balance < 0) ? "[-]" : (root.balance == 0) ? "[.]" : "[+]" );
            if (root.left != null) {
                sb.append("(" + toString(root.left));
                if (root.right != null) {
                    sb.append(", " + toString(root.right));
                }
                sb.append(")");
            } else {
                if (root.right != null) {
                    sb.append("(, " + toString(root.right) + ")");
                }
            }
        }
        return sb.toString();
    }
}