import javax.swing.JOptionPane;

public class BusquedaSecuencial {
	public static void main(String[] args) {
			int arreglo[] = {4, 1, 5, 2, 3};
			int dato;
			boolean band = false;
			
			dato = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar: "));
			
			// Busqueda secuencial
			int i=0;
			while(i<5 && band == false) {
				if(arreglo[i] == dato) {
					band = true;
				}
				i++;
			}
			
			if(band == false) {
				JOptionPane.showMessageDialog(null, "El numero no se encuentra en el arreglo");
			} else {
				JOptionPane.showMessageDialog(null, "El numero ha sido encontrado en la posicion: "+(i-1)); // Se le resta -1 porque antes de salir del while se suma 1
			}
	}
}
