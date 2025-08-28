package ConRetorno;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero XD: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
		
		Operacion op = new Operacion(); // Creando un objeto de la clase "Operacion"
		
		System.out.println("La suma es: " + op.sumar(n1, n2));
		System.out.println("La resta es: " + op.restar(n1, n2));
		System.out.println("La multiplicacion es: " + op.multiplicacion(n1, n2));
		System.out.println("La division es: " + op.division(n1, n2));
		
		//int suma =  op.sumar(n1, n2);
		//int resta = op.restar(n1, n2);
		//int mult = op.multiplicacion(n1, n2);
		//int div = op.division(n1, n2);
		
		//op.mostrarResultados(suma, resta, mult, div);
	}

}
	