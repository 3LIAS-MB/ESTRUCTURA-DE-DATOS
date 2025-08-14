package Ejercicio4;

import java.util.Scanner;

public class Leon extends Animal {
	private double altura;
	private int velocidad;
	private String especie;
	private String colorMelena;
	
	static Scanner entrada = new Scanner(System.in);
	
	public Leon(String nombre, String color, int peso, double altura, int velocidad, String especie, String colorMelena) {
		super(nombre, color, peso);
		this.altura = altura;
		this.velocidad = velocidad;
		this.especie = especie;
		this.colorMelena = colorMelena;
		
	}

	public double getAltura() {
		return altura;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getEspecie() {
		return especie;
	}

	public String getColorMelena() {
		return colorMelena;
	}

	public void accionAnimal() {
		System.out.println(super.getNombre() + " es de color " + super.getColor() + " y corre a " + velocidad + "km/h");
	}
		
	@Override
	public String toString() {
		return super.toString() + "\nLeon [altura=" + altura + ", velocidad=" + velocidad + ", especie=" + especie + ", colorMelena="
				+ colorMelena + "]";
	}
	
}	