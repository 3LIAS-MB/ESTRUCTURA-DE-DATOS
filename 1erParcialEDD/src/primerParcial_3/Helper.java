package primerParcial_3;

import java.util.Scanner;

public class Helper{
	
	public static Scanner scanner = new Scanner(System.in);
	
	//METODO PARA VALIDAR INT
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
 
    public static Integer validarInt(String inputMessage) {
        return validarInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
    }
   
}