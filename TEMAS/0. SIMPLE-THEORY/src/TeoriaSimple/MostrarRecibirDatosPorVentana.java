package TeoriaSimple;
	import javax.swing.JOptionPane; // Se necesita esta libreria para usar el "JOptionPane
	
	public class MostrarRecibirDatosPorVentana {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			String cadena;
			int entero;
			char letra;
			double decimal;
			// protected -> hace al atributo privado y solo puede ser accedido por las clases hijas de este
			
			cadena = JOptionPane.showInputDialog("Digite una cadena: "); // Te muestra una ventana para ingresar  datos
			entero = Integer.parseInt(JOptionPane.showInputDialog("Digite un entero: ")); // Transforma la entrada a entero
			letra = JOptionPane.showInputDialog("Digite una cadena: ").charAt(0);
			decimal = Double.parseDouble(JOptionPane.showInputDialog("Digite un decimal: "));
			
			JOptionPane.showMessageDialog(null, "La cadena es: " + cadena); // Muestra los datos en forma de ventana
			JOptionPane.showMessageDialog(null, "El numero entero es: " + entero);
			JOptionPane.showMessageDialog(null, "El caracter  es: " + letra);
			JOptionPane.showMessageDialog(null, "El decimal es: " + decimal);
			
		}
	
	}
