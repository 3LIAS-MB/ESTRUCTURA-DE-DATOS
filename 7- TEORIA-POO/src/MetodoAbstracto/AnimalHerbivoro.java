package MetodoAbstracto;

public class AnimalHerbivoro extends Animal {
	
	@Override // -> Sobreescribiendo el metodo
	public void alimentarse() {
		System.out.println("El animal herbivoro se alimenta de hierba");
	}
}
