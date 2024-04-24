package Ejercicio1;
public class Main {
	public static void main(String[] args) {
		
		Auto auto1 = new Auto("rojo", "ferrari", 1000, 200000);
		
		System.out.println("Atributos del objeto:");
		System.out.println(auto1.getColor());
		System.out.println(auto1.getKm());
		System.out.println(auto1.getMarca());
		 
		auto1.setPrecio(4); // cambia el valor de "precio"
		
		System.out.println(auto1.getPrecio());
		System.out.println(auto1.getInfo());
	}
}
