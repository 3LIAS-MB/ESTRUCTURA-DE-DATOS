package MetodoAbstracto;

public class Principal {

	public static void main(String[] args) {
		
		// SerVivo servivo = new SerVivo(); // No se puede instanciar objetos de una clase abstracta
											// Solo funciona como superclase. Animal tmb es abstracto
		Planta planta = new Planta();
		planta.alimentarse();
		
		AnimalCarnivoro animalC = new AnimalCarnivoro();
		animalC.alimentarse();
	}

}
