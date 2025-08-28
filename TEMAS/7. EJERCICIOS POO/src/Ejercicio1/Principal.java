package Ejercicio1;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		Cuadrilatero c1;
		float lado1, lado2;
		
		lado1 =  Float.parseFloat(JOptionPane.showInputDialog("Digite el lado1: "));
		lado2 =  Float.parseFloat(JOptionPane.showInputDialog("Digite el lado2: "));
		
		if (lado1 == lado2) { // Es un cuadrado
			c1 = new Cuadrilatero(lado1); // Inicializando objeto c1
		}
		else {
			c1 = new Cuadrilatero(lado1, lado2);
		}
		
		System.out.println("El perimetro es: "+ c1.getPerimetro()); // EL OBJETO C1 ME SIRVE PARA DAR PARAMETROS AL CONSTRUCTOR Y LLAMAR A LOS METODOS XDD
		System.out.println("El area es: "+ c1.getArea());


	}

}
