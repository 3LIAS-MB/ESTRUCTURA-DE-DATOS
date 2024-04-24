package EJERCICIOS;

import javax.swing.JOptionPane;

public class Ejercicio4 {

	public static void main(String[] args) {
		final int saldo_inicial =  1000;
		int opcion;
		float ingreso, saldoActual, retiro;
		
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:\n"
				+ "1. Ingresar dinero a la cuenta\n"
				+ "2. Retirar dinero de la cuenta\n"
				+ "3. Salir"));
		
		switch(opcion) {
		case 1: ingreso = Float.parseFloat(JOptionPane.showInputDialog("Digite la cantidad que desesa ingresar a la cuenta: "));
				saldoActual = saldo_inicial + ingreso;
				JOptionPane.showMessageDialog(null, "Dinero en cuenta: "+saldoActual);
				break;
		
		case 2: retiro = Float.parseFloat(JOptionPane.showInputDialog("Digite la cantidad que desesa retirar de la cuenta: "));
		
				if (retiro > saldo_inicial) {
					JOptionPane.showMessageDialog(null, "No cuenta con el dinero suficiente");
				} else {	
					saldoActual = saldo_inicial - retiro;
					JOptionPane.showMessageDialog(null, "Dinero en cuenta: "+saldoActual);
				}
		case 3: break;
		default: JOptionPane.showMessageDialog(null, "Se equivo de opcion de menu xd");
 
		}
	}
}

