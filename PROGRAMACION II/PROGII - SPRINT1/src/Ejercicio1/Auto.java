package Ejercicio1;

public class Auto {
	private String color;
	private String marca;
	private int km;
	private int precio;
	
	public Auto(String color, String marca, int km, int precio) {
		this.color = color;
		this.marca = marca;
		this.km = km;
		this.precio = precio;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getInfo() {
		return "\nEl auto color " + color + " iba a " + km + " km/h";
	}
	
}

