package BLUCLES;
import javax.swing.JOptionPane;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dato;
		
		dato = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero entero: ")); // Te deja ingrear un valor en la ventana emergente
		
		switch (dato) { // "dato" 
		case 1: JOptionPane.showMessageDialog(null, "Es el numero 1"); // Muestra un mensaje en una ventana emergente
			break;
		case 2: JOptionPane.showMessageDialog(null, "Es el numero 2"); // Si no tiene "break" sigue imprimiendo
			break;
		case 3: JOptionPane.showMessageDialog(null, "Es el numero 3");
			break;
		case 4: JOptionPane.showMessageDialog(null, "Es el numero 4");
			break;
		case 5: JOptionPane.showMessageDialog(null, "Es el numero 1");
			break;
		default: JOptionPane.showMessageDialog(null, "El numero no esta en el rango del 1 al 5");
			break;
		}
	}

}
