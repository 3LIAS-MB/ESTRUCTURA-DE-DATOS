package Ejercicio1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Helper {
//region Static Objects

public static Scanner scanner = new Scanner(System.in);
public static Scanner scanner2 = new Scanner(System.in);
public static Random random = new Random();

//endregion

//region Integer Helper

private static Integer getInt(String inputMessage, String errorMessage) {
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

private static Integer getPositiveInt(String inputMessage, String errorMessge) {
    while (true) {
        int num = getInt(inputMessage);
        if(num > 0)return num;
        System.out.println("\n" + errorMessge);
    }
}

public static Integer getPositiveInt(String inputMessage){
    return getPositiveInt(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
}

//endregion

//region Double Helper

private static Double getDouble(String inputMessage, String errorMessage) {
    while(true){
        try {
            System.out.println(inputMessage);
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
        }
    }
}

public static Double getDouble(String inputMessage){
    return getDouble(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO");
}

//endregion


//region Character Helper

private static Character getChar(String inputMessage, String errorMessage) {

    while (true) {
        try {
            System.out.println("\n" + inputMessage);
            char caracter = scanner.nextLine().toUpperCase().charAt(0);
            int valorASCII = (int)caracter;
            if (valorASCII == 165 || (valorASCII >= 65 && valorASCII <= 90) || 
            		 (valorASCII >= 97 && valorASCII <= 122) || valorASCII == 164)
                return caracter;
            else
                throw new Exception(errorMessage);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
            scanner.nextLine();
        }
    }
}

public static Character getChar(String inputMessage){
    return getChar(inputMessage, "\nERROR: INGRESE UN CARACTER VALIDO");
}

//endregion


//region Question (yes or no)

public static char yesOrNo(String question){
    char resp;
    do {
        System.out.println("\n" + question + "\nPRESIONE 'S'-SI\nPRESIONE 'N'-NO");
        resp = Character.toUpperCase(scanner.nextLine().charAt(0));
        if(resp == 'N' || resp == 'S')return resp;
        System.out.println("\nERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO");
    } while (true);
}

//endregion

//region Date
public static Date fecha(String fec) {
	
		while(true) {	
		try {
			Date fecha;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			fecha = formato.parse(fec);
			return fecha;
		} catch (Exception e) {
			System.out.println("ERROR EN FECHA");
		}
	
	}
	
}
}
