/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author exe20
 */
public class HelperN {
 

    
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
 
    //endregion
 
    //region Integer HelperN
 
    public static Integer getInt(String inputMessage, String errorMessage) { // (MensajeEnPantalla, MensajeDeError)
        while(true){
            try {
                System.out.println(inputMessage); // Muestra el mensaje
                return Integer.parseInt(scanner.nextLine()); // -> Devuelve el número entero como un objeto Integer
                											 // la forma "Integer.parseInt" es para transforamar una cadena en entero
            } catch (NumberFormatException e) {
                System.out.println(errorMessage); // -> Mensaje de error por si se ingres algo que
            }           					 	  // no puede conversitirse en un numero entero
        }
    }
 
    public static Integer getInt(String inputMessage) {
        return getInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
    }
 
    public static Integer getPositiveInt(String inputMessage, String errorMessge) {
        while (true) {
            int num = getInt(inputMessage);
            if(num > 0)
                return num;
            System.out.print("\n" + errorMessge);
        }
    }
 
    public static Integer getPositiveInt(String inputMessage){
        return getPositiveInt(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
    }
    
    //region Double HelperN
    public static Double getDouble(String inputMessage, String errorMessage) {
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
    
     public static double getPositiveDouble(String inputMessage, String errorMessge) {
        while (true) {
            double num = getDouble(inputMessage);
            if(num > 0)
                return num;
            System.out.println("\n" + errorMessge);
        }
    }
    
    public static double getPositiveDouble(String inputMessage){
        return getPositiveDouble(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
    }
 
    //endregion
 
    //region Character HelperN
 
    //METODO PARA VALIDAR LETRAS PARA EL PUNTO 4  
    public static String getChar(String inputMessage, String errorMessage) {
        while (true) {
            try {
                System.out.println("\n" + inputMessage);
                String letra= scanner.next().toUpperCase();
                if(letra.length()==1 && validarCaracter(letra)) 
                    return letra;
                else
                    throw new Exception(errorMessage);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("\n" + e.getMessage());
            }
        }
      
    }
    //Metodo validar caracter para el ejercicio del punto 4
    public static boolean validarCaracter(String letra)
    {
         char caracter = letra.charAt(0);
         int valorASCII = (int)caracter;
         if (valorASCII == 165 || (valorASCII >= 64 && valorASCII <= 90))
            return true;
         
        return false;
    }
    public static String getChar(String inputMessage){
        return getChar(inputMessage, "\nERROR: INGRESE UN CARACTER VALIDO");
    }
 
    //region Random Double with two decimal 
    public static double randomDouble(int bound) {
        double num;
        num = random.nextInt(bound) + random.nextDouble();
        return (double)Math.round(num * 100d)/100;
    } 
    
    //region Question (yes or no)
    public static char yesOrNo(String question){
        char resp;
        do {
            System.out.println("\n" + question + "\nPRESIONE 'S'-SI\nPRESIONE 'N'-NO");
            resp = Character.toUpperCase(scanner.next().toUpperCase().charAt(0));
            if(resp == 'N' || resp == 'S')
                return resp;
            System.out.println("\nERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO");
        } while (true);
    }
 
}