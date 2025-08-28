package MetodoDeCadena;

public class STRINGS {
	public static void main(String[] args) {
		
		String miCadena = "Hola, mundo!"; // 12 CARACTERES
		
		// Obtener la longitud de una cadena
		int longitud = miCadena.length(); // Devuelve 12 -> Lo transforma en entero
		
		
		miCadena.length(); // Devuelve 12
		System.out.println("Cadena: " + miCadena.length()); // 12
		
		// Concatenar cadenas
		String nombre = "Juan";
		String apellido = "Pérez";
		String nombreCompleto = nombre + " " + apellido; // "Juan Pérez"
		
		// Comparar cadenas
		
		String cadena1 = "Hola";
		String cadena2 = "Hola";
		boolean sonIguales = cadena1.equals(cadena2); // true
		
		// Comparar cadenas sin distinción entre mayúsculas y minúsculas:

		String cadena01 = "hola";
		String cadena02 = "Hola";
		boolean sonIgualesIgnoreCase = cadena01.equalsIgnoreCase(cadena02); 
		
		// Obtener un carácter en una posición específica:
		char primerCaracter = miCadena.charAt(0); // 'H'
		
		// Obtener una subcadena:
		String subcadena = miCadena.substring(0, 4); // "Hola"
		
		// Buscar la posición de una subcadena:
		int posicion = miCadena.indexOf("mundo"); // Devuelve la posición donde comienza "mundo" (7 en este caso)
		
		// Reemplazar parte de una cadena:
		String nuevaCadena = miCadena.replace("Hola", "Saludos"); // "Saludos, mundo!"
		
		// Dividir una cadena en partes:
		String[] partes = miCadena.split(", "); // Divide la cadena en un array de partes ["Hola", "mundo!"]
		
		// Eliminar espacios en blanco al principio y al final de una cadena:
		String cadenaConEspacios = "  Hola, mundo!  ";
		String cadenaSinEspacios = cadenaConEspacios.trim(); // "Hola, mundo!"
		
		// Verificar si una cadena comienza o termina con cierto prefijo o sufijo:
		boolean comienzaCon = miCadena.startsWith("Hola"); // true
		boolean terminaCon = miCadena.endsWith("mundo!"); // true
		
		// Convertir una cadena a mayúsculas o minúsculas:
		String mayusculas = miCadena.toUpperCase(); // "HOLA, MUNDO!"
		String minusculas = miCadena.toLowerCase(); // "hola, mundo!"

		// Comparar cadenas y obtener la diferencia lexicográfica:
		String cadena001 = "Manzana";
		String cadena002 = "Manzanares";
		int comparacion = cadena001.compareTo(cadena002); // Devuelve un valor negativo porque "Manzana" es menor que "Manzanares"
		
		//Verificar si una cadena está vacía o nula:
		String cadenaVacia = "";
		boolean estaVacia = cadenaVacia.isEmpty(); // true

		String cadenaNula = null;
		boolean esNula = (cadenaNula == null); // true
		
		 
		// El método toCharArray en Java se utiliza para convertir una cadena (String) en un
		// array de caracteres (char[]). Este método toma la cadena original y la descompone
		// en sus caracteres individuales, almacenándolos en un arreglo de caracteres.
		// Es útil cuando necesitas trabajar con caracteres individuales de una cadena
		// como en el caso de verificar la parentización de una expresión matemática
		
		// Ahora, el arreglo "caracteres" contiene los caracteres de la cadena "Hola, mundo"
		
		String cadena = "Hola, mundo";
		char[] caracteres = cadena.toCharArray(); // ['H', 'o', 'l', 'a', ',', ' ', 'm', 'u', 'n', 'd', 'o']

		// 

	}
}


//Métodos para la manipulación básica de cadenas:

//length(): Devuelve la longitud de la cadena.
//charAt(int index): Devuelve el carácter en la posición index.
//concat(String str): Concatena la cadena especificada al final de la cadena actual.
//substring(int beginIndex): Devuelve una subcadena desde beginIndex hasta el final de la cadena.
//substring(int beginIndex, int endIndex): Devuelve una subcadena desde beginIndex hasta endIndex.
//indexOf(String str): Devuelve la posición de la primera ocurrencia de la cadena especificada.
//lastIndexOf(String str): Devuelve la posición de la última ocurrencia de la cadena especificada.

//Métodos para comparación y búsqueda:

//equals(Object obj): Compara la cadena con otro objeto y devuelve true si son iguales.
//equalsIgnoreCase(String anotherString): Compara la cadena sin importar mayúsculas o minúsculas.
//contains(CharSequence s): Comprueba si la cadena contiene una secuencia especificada.
//startsWith(String prefix): Comprueba si la cadena comienza con la cadena especificada.
//endsWith(String suffix): Comprueba si la cadena termina con la cadena especificada.
//compareTo(String anotherString): Compara la cadena lexicográficamente con otra cadena.
//matches(String regex): Comprueba si la cadena coincide con una expresión regular.
//replace(char oldChar, char newChar): Reemplaza todas las ocurrencias de oldChar con newChar.
//Métodos para transformación y formato:

//toLowerCase(): Convierte la cadena a minúsculas.
//toUpperCase(): Convierte la cadena a mayúsculas.
//trim(): Elimina espacios en blanco al principio y al final de la cadena.
//split(String regex): Divide la cadena en subcadenas utilizando una expresión regular como delimitador.
//format(String format, Object... args): Crea una cadena formateada según un formato especificado.

//Métodos para inspección:

//isEmpty(): Comprueba si la cadena está vacía.
//isBlank(): Comprueba si la cadena está en blanco (disponible a partir de Java 11).
//toCharArray(): Convierte la cadena en un arreglo de caracteres.

//Métodos para creación de cadenas:

//valueOf(Object obj): Convierte un objeto en una cadena.
//join(CharSequence delimiter, CharSequence... elements): Une elementos con un delimitador.

//Métodos para construcción de cadenas:

//StringBuilder: Esta clase proporciona métodos para construir cadenas de manera eficiente.

//Métodos para conversión:

//getBytes(): Convierte la cadena en un arreglo de bytes utilizando la codificación predeterminada.
//toCharArray(): Convierte la cadena en un arreglo de caracteres.
