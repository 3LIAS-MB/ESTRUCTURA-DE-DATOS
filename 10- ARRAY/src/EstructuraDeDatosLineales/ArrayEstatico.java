
//Los arrays en Java son estructuras de datos estáticas con un tamaño fijo, por lo que no tienen una
//gran cantidad de métodos incorporados. Algunos métodos comunes para trabajar con arrays incluyen:

//length: Devuelve la longitud (tamaño) del array.

//Acceso a elementos: Puedes acceder a elementos individuales del array usando el operador de índice, por ejemplo: miArray[0] para el primer elemento.


// Arrays Estáticos: Son estructuras de datos que tienen un tamaño fijo y contienen elementos del mismo tipo de dato.
// La longitud del array se define en el momento de la creación y no puede cambiar. Los arrays estáticos son eficientes
// "en cuanto al acceso a elementos por índice, pero pueden ser ineficientes al insertar o eliminar elementos, ya que pueden
// "requerir cambios costosos de tamaño.

package EstructuraDeDatosLineales;

public class ArrayEstatico { // -> LISTA ALMACENADA EN SECUENCIA
    public static void main(String[] args) {
        // Declarar y crear un array estático de enteros
        int[] numeros = new int[5];
        int[] numeros3 = {1, 2, 3, 4}; // forma 1 de inicializar un arreglo
		int[] numeros2 = new int[]{1, 2, 3, 4}; // forma 2 de inicializar un arreglo
		


        // Asignar valores a los elementos del array
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        // Acceder y mostrar elementos del array
        System.out.println("Elementos del array estático:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // Modificar un elemento del array
        numeros[1] = 25;

        // Acceder y mostrar elementos del array después de la modificación
        System.out.println("Elementos del array estático después de la modificación:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }

        // Calcular la suma de los elementos del array
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        System.out.println("La suma de los elementos del array es: " + suma);

        // Buscar un valor en el array
        int valorBuscado = 30;
        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == valorBuscado) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El valor " + valorBuscado + " se encuentra en el array.");
        } else {
            System.out.println("El valor " + valorBuscado + " no se encuentra en el array.");
        }
    }
}
