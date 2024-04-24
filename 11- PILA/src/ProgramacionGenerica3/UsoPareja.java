package ProgramacionGenerica3;

public class UsoPareja {
	public static void main(String[] args) {
		Pareja<String> uno = new Pareja<>(); // primero = null
		uno.setPrimero("Elias");
		System.out.println(uno.getPrimero());
		
		Persona pers1 = new Persona("Ana");
		
		// Está siendo instanciada como un objeto de la clase Pareja con elementos de tipo Persona.
		Pareja<Persona> dos = new Pareja<Persona>(); // primero = null
		
		dos.setPrimero(pers1); 
		
		System.out.println(dos.getPrimero()); // Devuelve un objeto, pero como hay un
											  // toString devuelve "Ana". Cuando se imprime con 
	}										  // 'System.out...' llama automaticamente al metodo toString
}											  // -> ProgramacionGenerica3.Persona@5e265ba4

	class Persona {
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre  = nombre;
	}
	
	// Metodo toString para devolver Ana
	public String toString() {
		return this.nombre;
	}
}
	
/*Alcance (Scope): La clase Persona está contenida dentro de la clase UsoPareja.
 * Esto significa que la clase Persona solo es visible y accesible dentro de la clase
 * UsoPareja. No se puede acceder a la clase Persona desde fuera de UsoPareja.
 
Encapsulamiento: Al definir la clase Persona dentro de UsoPareja, estás encapsulando
la clase Persona dentro de la clase UsoPareja. Esto puede ser útil cuando tienes una
clase que está estrechamente relacionada con otra y no deseas que sea accesible desde
otros lugares en tu programa.

Independencia: Aunque la clase Persona está definida dentro de UsoPareja, aún es una
entidad independiente. Puedes crear objetos de la clase Persona y utilizarlos dentro
de UsoPareja como lo harías con cualquier otra clase.

Acceso a los miembros: Los miembros de la clase Persona (en este caso, el campo nombre
y el método toString) solo son accesibles dentro de la clase UsoPareja. Si intentaras
acceder a ellos desde fuera de UsoPareja, obtendrías un error de compilación.*/