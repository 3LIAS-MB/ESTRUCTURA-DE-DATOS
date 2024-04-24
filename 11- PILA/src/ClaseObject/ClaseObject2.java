// El uso de "Object" como tipo de parámetro significa que puedes enviar 
//  cualquier objecto como argumento sin especificar de qué clase proviene

// Este enfoque puede ser útil en situaciones en las que necesitas trabajar
// con objetos de diversas clases en un método genérico o cuando deseas crear
// una interfaz que pueda manejar objetos de múltiples tipos.

// Sin embargo, debes recordar que, una vez que un objeto se almacena como tipo "Object",
// no puedes acceder directamente a los miembros específicos de la clase original del objeto
// sin realizar una conversión de tipo explícita,

// -> Las comprobaciones de tipo (casting) son operaciones para convertir objetos de un tipo a otro.
// EJEMPLO SIMPLE DE CASTING: String nombrePersona = (String) archivos.get(2); -> donde archivos
// viene de un metodo con parametro Object

/*La clase "Object" en Java es la superclase de todas las clases y se utiliza en situaciones en las que se
 * necesita una referencia a un objeto, pero no se sabe con certeza qué tipo de objeto será en tiempo de compilación*/

package ClaseObject;

public class ClaseObject2 {
    public static void main(String[] args) {
        // Creación de objetos de diferentes clases
        String cadena = "Hola, soy una cadena";
        Integer entero = 42;
        Double decimal = 3.1416;

        // Llamada a métodos que aceptan Object como argumento
        imprimirInfoObjeto(cadena);
        imprimirInfoObjeto(entero);
        imprimirInfoObjeto(decimal);
        
        // Creación de un arreglo de objetos Object
//      int[] numeros = new int[]{1, 2, 3, 4, 5};
        Object[] objetos = new Object[]{cadena, entero, decimal};

        // Iteración a través del arreglo y uso de instanceof para determinar el tipo
        for (Object obj : objetos) {
            if (obj instanceof String) {
                System.out.println("\nEs una cadena: " + obj);
            } else if (obj instanceof Integer) {
                System.out.println("Es un entero: " + obj);
            } else if (obj instanceof Double) {
                System.out.println("Es un número decimal: " + obj);
            }
        }
    }

    // Método que acepta un parámetro Object e imprime información sobre él
    public static void imprimirInfoObjeto(Object objeto) {
    	
    	System.out.println("getClass: " + objeto.getClass()); // referencia al objeto -> class java.lang.String

        System.out.println("\nTipo de objeto: " + objeto.getClass().getSimpleName()); // Tipo de objeto, string, int, char, log, etc
        System.out.println("Valor del objeto: " + objeto); // Valor -> Hola, soy una cadena
    }
}

/*getClass(): Este método pertenece a la clase Object y se utiliza para obtener una
 * referencia a la clase de un objeto en tiempo de ejecución. Retorna un objeto de tipo
 * Class, que proporciona información sobre la clase, como su nombre, métodos, campos, etc.*/


/*getSimpleName(): Este método se utiliza para obtener el nombre simple de una clase, es decir,
 * el nombre de la clase sin el paquete completo al que pertenece.*/




