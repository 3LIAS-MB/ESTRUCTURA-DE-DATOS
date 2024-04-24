package EJERCICIOS;

import javax.swing.JOptionPane;

public class Ejercicio1 {
	public static void main(String[] args) {
		char letra;
		
		letra  = JOptionPane.showInputDialog("Digite un caracter").charAt(0);
		
		if (Character.isUpperCase(letra)) {
			JOptionPane.showMessageDialog(null, "Es una letra mayuscula");
		}
		else {
			JOptionPane.showMessageDialog(null, "Es una letra minuscula");
		}
	}
}
