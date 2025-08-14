/*"
 * 
 * /*ArrayList:
 * Utiliza un arreglo dinámico para almacenar elementos.
 * Proporciona un acceso rápido a los elementos a través de índices.
 * Es eficiente para acceso aleatorio y lectura, pero menos eficiente para inserciones y eliminaciones en posiciones intermedias debido a la necesidad de desplazar elementos en el arreglo.*/

/*Arreglos dinámicos" se refieren a estructuras de datos como ArrayList en Java.
Estas estructuras son similares a los arreglos estáticos, pero tienen la ventaja de que
pueden crecer o reducirse dinámicamente en tamaño durante la ejecución del programa
A diferencia de los arreglos estáticos, no necesitas especificar un tamaño fijo al crear un ArrayList.
Puedes agregar o quitar elementos según sea necesario.*/

// 1- Estructura de datos subyacente:

/*ArrayList se implementa utilizando un arreglo dinámico que se redimensiona automáticamente cuando
 * es necesario. Esto significa que tiene un acceso rápido a elementos en posiciones aleatorias pero
 * puede ser menos eficiente cuando se insertan o eliminan elementos en el medio de la lista.*/

// 2- Acceso a elementos:

/*ArrayList proporciona acceso rápido a elementos en posiciones específicas mediante índices.
 * El acceso a elementos es de tiempo constante O(1).*/

// 3- Inserciones y eliminaciones:

/*ArrayList puede ser más lento para insertar o eliminar elementos en el medio
 * de la lista (es de tiempo lineal 'O(n)'), ya que puede requerir desplazar elementos en el arreglo. */

// 4- Uso de memoria

/*ArrayList generalmente consume menos memoria que LinkedList debido a la estructura de datos subyacente basada en un arreglo.*/

// 5- Iteracion

/*ArrayList es más eficiente para iterar sobre todos los elementos en secuencia debido a su estructura de arreglo contiguo.*/

package EstructuraDeDatosLineales;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ArrayDinamico { // -> LISTA ALMACENADA EN SECUENCIA
    public static void main(String[] args) {
        // Crear un ArrayList de enteros
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<Integer>();
        
        // En esta línea, estás utilizando la interfaz List como el tipo de referencia para 'numeros3',
        // pero estás instanciando un objeto de la clase ArrayList. Esto significa que puedes cambiar
        // fácilmente la implementación subyacente de la lista en el futuro sin cambiar el resto de tu
        // código. Esto se conoce como programación orientada a interfaces y es una buena práctica de programación.

        // Por ejemplo, si en el futuro decides cambiar a una implementación diferente de lista,
        // como LinkedList, solo necesitas cambiar la parte derecha de la asignación:
        List<Integer> numeros3 = new ArrayList<Integer>(); // -> Uso como referencia la interfaz List
       
        ArrayList<Object> archivos = new ArrayList<Object>(); // ArrayList de tipo génerico, tiene que parametrizarse
        ArrayList archivos2 = new ArrayList(4); // Esto es un "raw ArrayList" o un ArrayList sin tipo (tipo crudo)

        
        // Agregar elementos al ArrayList
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        	
        // Acceder a elementos por índice
        int primerNumero = numeros.get(0);
        int segundoNumero = numeros.get(1);

        System.out.println("Primer número: " + primerNumero);
        System.out.println("Segundo número: " + segundoNumero);

        // Modificar un elemento
        numeros.set(0, 100); // (posicion, nParaModificar)

        System.out.println("Primer número modificado: " + numeros.get(0));

        // Recorrer el ArrayList
        System.out.println("Elementos del ArrayList:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }

        // Eliminar un elemento por índice
        numeros.remove(1);

        System.out.println("Elementos del ArrayList después de eliminar el segundo elemento:");
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Verificar si el ArrayList contiene un elemento
        boolean contieneTreinta = numeros.contains(30);
        System.out.println("¿Contiene 30? " + contieneTreinta); // Devuelve un booleano

        // Obtener el tamaño del ArrayList
        int tamano = numeros.size();
        System.out.println("Tamaño del ArrayList: " + tamano);

        // Limpiar el ArrayList (eliminar todos los elementos)
        numeros.clear();

        System.out.println("ArrayList vacío después de limpiarlo. Tamaño: " + numeros.size());
        	
        //Iterator<ArrayList> iterador = numeros2.iterator(); -> estudiar
        
        //***************************************************
        
        // Crear un ArrayList de tipo Integer
        ArrayList<Integer> arrayList = new ArrayList<>(); 	

        // Agregar elementos al ArrayList
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        // Acceder al primer elemento
        int primerElemento = arrayList.get(0);
        System.out.println("Primer elemento: " + primerElemento);

        // Acceder al último elemento
        int ultimoElemento = arrayList.get(arrayList.size() - 1);
        System.out.println("Último elemento: " + ultimoElemento);

        // Acceder a un elemento por índice
        int elementoEnIndice2 = arrayList.get(2);
        System.out.println("Elemento en índice 2: " + elementoEnIndice2);
    }
    
    public void miMetodo(ArrayList<Object> archivos) {
        // Tu código aquí
    }
}


// METODOS

// numeros2.ensureCapacity(11); -> CREO DIRECTAMENTE UN ARRAY DE 11 ELEMENTOS PARA METERLOS EN SU INTERIOR, DE ESTA FORMA
// CUANDO LLEGO AL ELEMENTO 11 EVITO EL CONSUMO DE RECURSO DE CREAR UNA COPIA, EL TRASPASO DE ELEMENTOS Y ELIMINACION
// listaEmpleados.trimToSize(); -> RECORTA EL ESPACIO SOBRANTE, EL EXCESO DE MEMORIA VA AL FINAL DEL ARRAYLIST

//add(insertar) -> Añade un elemento a el ArrayList. Añade desde el final. Devuelve un booleano indicando el estado de la operacion

//get(elemento) -> Devuelve el elemento en el índice indicado
//set(int índice, newElement): Reemplaza el elemento en la posición especificada con el nuevo elemento.
//size(-) -> Devuelve el tamaño del arraylist. Devuelve la cantidad de elementos en el ArrayList
//isEmpty(-) -> Indica si el ArrayList esta o no vacio. Devuelve un valor booleano
//lista1.equals(lista2) -> Compara si la lista es igual a otro objeto.
//contains(elemento) -> Verificar si el ArrayList contiene un elemento. Devuelve un valor booleano

//indexOf("elemento") -> Devuelve la primera posición del elemento puesto como parámetro. Devuelve -1 si no esta
//lastIndexOf("elemento") -> Devuelve el índice de la última ocurrencia del objeto especificado en la lista. Devuelve -1 si no está
//clear-(-) -> Limpia el ArrayList de elementos. No devuelve nada

//lista.remove(0)); -> Elimina el primer elemento en la lista. Devuelve el elemento
//lista.remove(Integer.valueOf(5))); -> Elimina la primera ocurrencia de 5 en la lista. Devuelve true si lo elimino y false si no
//lista.remove("Manzana"); -> Elimina la primera ocurrencia de "Manzana" en la lista. Devuelve true si lo elimino y false si no

// iterator(-) -> Devuelve un iterador para recorrer el ArrayList. Retorna el iterador
// toArray(): Convierte la lista en un array.

// NO IMPORTAN POR AHORA

//addAll(Collection<? extends E> colección): Agrega todos los elementos de una colección dada al ArrayList.
//removeAll(Collection<?> colección): Elimina todos los elementos que están en la colección dada del ArrayList.
//retainAll(Collection<?> colección): Elimina todos los elementos del ArrayList excepto los que están en la colección dada.

// clone()
// listIterator(int index)
// removeRange(int fromIndex, int toIndex)
// subList(int fromIndex, int toIndex)








