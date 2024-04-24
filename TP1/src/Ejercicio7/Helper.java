package Ejercicio7;
import java.util.Scanner;

public class Helper{
	
	public static Scanner scanner = new Scanner(System.in);
	
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
	
	//METODO PARA VALIDAR INT
	public static Integer getInt(String inputMessage, String errorMessage) {
        while(true){
            try {
                System.out.println(inputMessage);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }
 
    public static Integer getInt(String inputMessage) {
        return getInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
    }
    // METODO PARA VALIDAR EDAD
    public static Integer validarEdad(String inputMessage) {
    	while(true) {
    		try {
    			Integer edad = getInt(inputMessage);
    			if(edad >= 0 && edad<=100) {
    				return edad;
    			}else {
                    throw new Exception("\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UNA EDAD ENTRE 0 y 100");
                    }
    		} catch(Exception e){
    			System.out.println("\n" + e.getMessage());
    		}
    	}
    }
    //METODO PARA VALIDAR AÑO DE INGRESO
    public static Integer validarAnoIngreso(String inputMessage) {
    	while(true) {
    		try {
    			Integer anoIngreso = getInt(inputMessage);
    			if(anoIngreso >= 1972 && anoIngreso<=2024) {
    				return anoIngreso;
    			}else {
                    throw new Exception("\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN AÑO ENTRE 1972 y 2024");
                    }
    		} catch(Exception e){
    			System.out.println("\n" + e.getMessage());
    		}
    	}
    }
    
    //	region Character Helper
    
    //METODO PARA VALIDAR LETRAS(CHAR)  
    public static String getChar(String inputMessage, String errorMessage) {
        while (true) {
            try {
                System.out.println("\n" + inputMessage);
                String letra= scanner.nextLine().toUpperCase();
                if(letra.length()==1 && validarCaracter(letra)) {
                    return letra;
                }else {
                    throw new Exception(errorMessage);
                    }
            } catch (Exception e) {
                //scanner.nextLine();
                System.out.println("\n" + e.getMessage());
            }
        }
      
    }
    //Metodo validar caracter para el genero
    public static boolean validarCaracter(String letra)
    {
         char caracter = letra.charAt(0);
         int valorASCII = (int)caracter;
         System.out.println(valorASCII);
         //valida que solo ingrese F(70) o M(77), 
         if (valorASCII == 70 || valorASCII==77) {
            return true;
         }
        return false;
    }
    public static String getChar(String inputMessage){
        return getChar(inputMessage, "\nERROR: INGRESE UN CARACTER VALIDO");
    }
    
}