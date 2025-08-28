package Polimorfismo;

public class Principal {
	public static void main(String[] args) {
		
		Vehiculo misVehiculos[] = new Vehiculo[4];
		
		misVehiculos[0] = new Vehiculo("GH67", "Ferrari", "A89");
		misVehiculos[1] = new VehiculoTurismo(4, "78HJ", "Audi", "P14"); 		// -> Polimorfismo. Un objeto de la clase padre guarde la instanciacion de una de sus hijas
		misVehiculos[2] = new VehiculoDeportivo(500, "45GH", "Toyata", "KJ8"); //
		misVehiculos[3] = new VehiculoFurgoneta(1000, "JI8", "Toyota", "J9");
		
		for(Vehiculo vehiculos : misVehiculos) {
			System.out.println(vehiculos.mostrarDatos());
		}
	}
}

// ¿Qué es el polimorfismo? Poli -> muchos && Morfismo -> formas 

// 1. En una relacion de tipo herencia, un objeto de la superclase puede almacenar un
// objeto de cualquiera de sus subclases

// 2. Esto significa que la clase padre o superclase es compatible con los tipos que
// derivan de ella. Pero no al revés

// 3. Para que haya polimorfismo debe haber herencia, estan totalmente ligados

/*El polimorfismo es un concepto fundamental en la programación orientada a objetos (POO)
 * y se refiere a la capacidad de diferentes objetos de responder de manera específica a
 * un mismo mensaje o solicitud. En otras palabras, el polimorfismo permite que objetos de
 * diferentes clases puedan compartir un mismo nombre de método o interfaz, pero cada clase
 * puede proporcionar su propia implementación específica para ese método.*/
