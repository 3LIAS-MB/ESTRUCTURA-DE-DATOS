package SinRetorno;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
		
		Operacion op = new Operacion(); // Creando un objeto de la clase "Operacion"
		
		op.sumar(n1, n2);
		op.restar(n1, n2);
		op.multiplicacion(n1, n2);
		op.division(n1, n2);
		
		op.mostrarResultados();
	}

}
