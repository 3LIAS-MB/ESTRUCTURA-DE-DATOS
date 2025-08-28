//
//Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
package menu;



import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Helper {


 //region Static Objects
 static Random random = new Random();
 static Scanner scanner = new Scanner(System.in);
 //endregion
 
 public static int plazo() {
		int plazo[]= {24,48,72};
		int i =Helper.randomInt(0,3);
		int num=plazo[i];
		return num;	
	}
 
 public static int randomInt(int inicio,int bound) {
     int num = random.nextInt(bound-inicio);
     return num;
 }
 
 public static String randomInStr(int inicio,int bound) {
     int num = random.nextInt(bound-inicio);
     String codigo = "" + num;
     return codigo;
 }
 
 public static char yesOrNo(String question){
     char resp;
     do {
         System.out.println("\n" + question + "\nPRESIONE 'S'-SI\nPRESIONE 'N'-NO\n");
         resp = Character.toUpperCase(scanner.next().toUpperCase().charAt(0));
         if(resp == 'N' || resp == 'S')
             return resp;
         System.out.println("\nERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO\n");
     } while (true);
 }
 
 public static String IngresoNumero(String dato) {
 	String resp;
 	do {
         System.out.print(dato);
         resp = scanner.nextLine();
         boolean contieneAlfanumericosYEspacios = Pattern.compile("[0-9]+$").matcher(resp).find();

         if (contieneAlfanumericosYEspacios) {
         	return resp;
         } else {
             System.out.println("\nERROR: CARACTERES ESPECIALES NO PERMITIDOS Y LETRAS NO PERMITIDO");
         }
         
 	}while(true);    
}
 
//METODO PARA VALIDAR STRING
	public static String validarString(String inputMessage, String errorMessage) {
		while(true) {
			try {
				System.out.println(inputMessage);
				return scanner.nextLine();
		    }catch(Exception e) {
		        	System.out.println(errorMessage);
			}
		}
}	
	public static String validarString(String inputMessage) {
    return validarString(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN STRING");
}
	
	public static String IngresoAlphanumeric(String dato) {
    	String resp;
    	do {
            System.out.print(dato);
            resp = scanner.nextLine();
            
            boolean esAlfanumerico =resp.matches("^[a-zA-Z0-9]+$");

            if (esAlfanumerico) {
            	return resp;
            } else {
                System.out.println("\nERROR: CARACTERES ESPECIALES NO PERMITIDOS");
            }
            
            
            
    	}while(true);    
	}
    
    public static String IngresoAlphanumericConEspacio(String dato) {
    	String resp;
    	do {
            System.out.print(dato);
            resp = scanner.nextLine();
            boolean contieneAlfanumericosYEspacios = Pattern.compile("[a-zA-Z0-9\\s]+$").matcher(resp).find();

            if (contieneAlfanumericosYEspacios) {
            	return resp;
            } else {
                System.out.print("\nERROR: CARACTERES ESPECIALES NO PERMITIDOS");
            }
            
    	}while(true);    
	}
	
 //region Character Helpers
 public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage) {
     Character characterValue;
     while (true) {
         System.out.print(inputMessage);
         try {
             characterValue = scanner.nextLine().charAt(0);
             return characterValue;
         } catch (Exception exception) {
             System.out.println(errorMessage);
             scanner.nextLine();
         }
     }
 }
 public static Character getCharacter(Scanner scanner, String inputMessage) {
     return getCharacter(scanner, inputMessage, "Ingrese un caracter válido");
 }
 public static Character getCharacter(String inputMessage, String errorMessage) {
     return getCharacter(Helper.scanner, inputMessage, errorMessage);
 }
 public static Character getCharacter(String inputMessage) {
     return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter válido");
 }
 //endregion


 //region Integer Helpers
 public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
     Integer integerValue = 0;
     while (true) {
         try {
             System.out.print(inputMessage);
             integerValue = Integer.parseInt(scanner.nextLine());
             return integerValue;
         }
         catch (Exception exception) {
             System.out.println(errorMessage);
         }
     }
 }
 public static Integer getInteger(Scanner scanner, String inputMessage) {
     return getInteger(scanner, inputMessage, "Ingrese un número válido");
 }
 public static Integer getInteger(String inputMessage, String errorMessage) {
     return getInteger(Helper.scanner, inputMessage, errorMessage);
 }
 public static Integer getInteger(String inputMessage) {
     return getInteger(Helper.scanner, inputMessage, "Ingrese un número válido");
 }
 //endregion


 //region Double Helpers
 public static Double getDouble(Scanner scanner, String inputMessage, String errorMessage) {
     Double doubleValue = 0.0;
     while (true) {
         try {
             System.out.print(inputMessage);
             doubleValue = Double.parseDouble(scanner.nextLine());
             return doubleValue;
         }
         catch (Exception exception) {
             System.out.println(errorMessage);
         }
     }
 }
 public static Double getDouble(Scanner scanner, String inputMessage) {
     return getDouble(scanner, inputMessage, "Ingrese un número válido");
 }
 public static Double getDouble(String inputMessage, String errorMessage) {
     return getDouble(Helper.scanner, inputMessage, errorMessage);
 }
 public static Double getDouble(String inputMessage) {
     return getDouble(Helper.scanner, inputMessage, "Ingrese un número válido");
 }
 //endregion


 //region Array Helpers
 static void printOneDimensionArray(String textBefore, Object[] array, String textAfter) {
     System.out.print(textBefore);
     System.out.print("[" + array[0]);
     for (int i = 1; i < array.length; ++i) {
         System.out.print("," + array[i]);
     }
     System.out.print("]");
     System.out.print(textAfter);
 }


 static void printTwoDimensionArray(String textBefore, Object[][] array, String textAfter) {
     System.out.print(textBefore);

     System.out.print("[[" + array[0][0]);
     for (int j = 1; j < array[0].length; ++j) {
         System.out.print("," + array[0][j]);
     }
     System.out.print("]");

     for (int i = 1; i < array.length; ++i) {
         System.out.print(",[" + array[i][0]);
         for (int j = 1; j < array[i].length; ++j) {
             System.out.print("," + array[i][j]);
         }
         System.out.print("]");
     }
     System.out.print("]");
     System.out.print(textAfter);
 }
}

