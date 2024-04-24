package SobreCargaDeMetodos;

public class Main {
	public static void main(String[] args) {
		
		// JAVA DIFERENCIA POR LA CANTIDAD DE PARAMETROS O EL TIPO DE DATO
		// NO POR EL TIPO DE RETORNO QUE TANGAN (VOID, INT, STRING, ETC)
		
		Persona persona1 = new Persona("Elias", 21);
		persona1.correr();
		
		Persona persona2 = new Persona("123123");
		persona2.correr(100);
	}
}
