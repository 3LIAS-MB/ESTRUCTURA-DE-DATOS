package MetodoAbstracto;

public class Planta extends SerVivo { // Cuando creamos una clase hija que deriva de una clase abstracta
									  // si o si tenemos que implementar todos los metodos que haya en esa clase
	
	@Override // -> Sobreescribiendo el metodo abstracto de la clase padre
	public void alimentarse() {
		System.out.println("La planta se alimenta a traves de la fotosintesis"); 
	}
}
