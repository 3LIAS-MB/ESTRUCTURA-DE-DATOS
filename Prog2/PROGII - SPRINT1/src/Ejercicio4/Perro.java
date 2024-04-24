package Ejercicio4;

public class Perro extends Animal {
	private String onomatopeya;
	private String apodo;
	private String raza;
	
	public Perro(String nombre, String color, int peso, String onomatopeya, String apodo, String raza) {
		super(nombre, color, peso);
		this.onomatopeya = onomatopeya;
		this.apodo = apodo;
		this.raza = raza;
		
	}

	public String getOnomatopeya() {
		return onomatopeya;
	}


	public void setOnomatopeya(String onomatopeya) {
		this.onomatopeya = onomatopeya;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
	public void accionAnimal() {
		System.out.println(super.getNombre() + " es de color " + super.getColor() + " y ladra " + onomatopeya);
	}

	@Override
	public String toString() {
		return super.toString() + "\nPerro [onomatopeya=" + onomatopeya + ", apodo=" + apodo + ", raza=" + raza + "]";
		// super.toString() -> Llama al "toString" de la superclase
	}	
}