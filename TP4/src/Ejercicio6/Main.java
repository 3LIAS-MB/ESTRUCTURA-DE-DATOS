package Ejercicio6;

public class Main {
	public static void main(String[] args) {
		
		 String original = "HOLA";
		 String codificado = "";
		 
		 for (char c: original.toCharArray()){
		 codificado += (char)((int)c + 5);
		 }
		 System.out.println(codificado);
		 
		 String decodificado = "";
		 System.out.println("Mensaje decodificado");
		 for (char a: codificado.toCharArray()){
		 decodificado += (char)((int)a - 5);
		 }
		 
		 System.out.println(decodificado);

	}
}

