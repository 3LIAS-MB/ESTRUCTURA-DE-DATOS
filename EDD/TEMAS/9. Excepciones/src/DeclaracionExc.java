import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class DeclaracionExc {
	
	public void leerArchivo() throws FileNotFoundException, IOException { // -> Se usa cuando no queremos capturarla ni evitarla en este metodo
		File archivo = new File("C:\\Users\\campo\\OneDrive\\Documentos\\ads\\prueba.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		
		while((linea = bf.readLine()) != null){
			System.out.println(linea);
		}
		
		bf.close();
	}
	
	public void leerArchivo2() { // En este metodo utilizamos el try-catch para capturar la excepcion
			try {
				leerArchivo();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "XDDDDDDDDDDD");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "XDDDDDDDDDDD");
				//JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo deseado. Verifique la ruta.");
				
			} finally { // Se ejecuta si hay o no una excepcion
				System.out.println("ASD");
			}
			
			System.out.println("Programa terminado");
	}


	public static void main(String[] args) { // Podemos usar la clase inmediata o su superclase "IOEexpciom"
		DeclaracionExc prueba = new DeclaracionExc();
		
		prueba.leerArchivo2();
	}
}	