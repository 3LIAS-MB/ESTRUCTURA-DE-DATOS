package Ejercicio4;
import java.util.Scanner;

public class Helper{
	
	public static Scanner scanner = new Scanner(System.in);
	
	// METODO PARA VALIDAR INT
	public static Integer validarInt(String inputMessage, String errorMessage) {
        while(true){
            try {
                System.out.println(inputMessage);
                Integer valor = Integer.parseInt(scanner.next());
                if (valor >0) {
                	return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
	
	/**/
    public static Integer validarInt(String inputMessage) {
        return validarInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
    }
    
  
	  // METODO PARA VALIDAR CONTINUIDAD DE LA SERIE
	  // METODO PARA VALIDAR LETRAS(CHAR)
    public static String getChar(String inputMessage, String errorMessage) {
        while (true) {
            try {
                System.out.print("\n" + inputMessage);
                String letra = scanner.nextLine().toUpperCase();
                if(letra.length()==1 && validarCaracter(letra)) {
                    return letra;
                }else {
                    throw new Exception(errorMessage);
                    }
            } catch (Exception e) { // Declara una variable "e" de tipo "Exception" que actua como objeto
                //scanner.nextLine();
                System.out.print("\n" + e.getMessage());
            }
        }
      
    }
    
    /**/
    public static String getChar(String inputMessage){
        return getChar(inputMessage, "ERROR: Ingrese un caracter valido");
    }
    
    // Metodo validar caracter para el genero
    public static boolean validarCaracter(String letra)
    {
         char caracter = letra.charAt(0);
         int valorASCII = (int)caracter;
         //System.out.println(valorASCII);
         //valida que solo ingrese S(83) o N(78), 
         if (valorASCII == 83 || valorASCII==78) {
            return true;
         }
        return false;
    }
}