package MetodoAbstracto;

public class AnimalCarnivoro extends Animal {
	
	 @Override // -> Indica que estoy sobreescribiendo un metodo abstracto
	public void alimentarse() {
		System.out.println("El animal carnivoro se alimenta de carne");
	}
}
