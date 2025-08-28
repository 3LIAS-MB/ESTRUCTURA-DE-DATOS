package Ejercicio6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


	public class Helper {

		public static Scanner scanner = new Scanner(System.in);
		public static Random random = new Random();

		public static Integer getInt(String inputMessage, String errorMessage) {
			while(true){
				try {
					System.out.print(inputMessage);
					return Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.print(errorMessage);
				}
			}
		}

		public static Integer getInt(String inputMessage) {
			return getInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO \n");
		}
		public static Integer getPositiveInt(String inputMessage, String errorMessge) {
			while (true) {
				int num = getInt(inputMessage);
				if(num > 0)
					return num;
				System.out.print("\n" + errorMessge);
			}
		}
		public static Integer getPositiveInt_conLimitador(String inputMessage, String errorMessge, int limite) {
			while (true) {
				int num = getInt(inputMessage);
				if(num > 0 && num <= limite)
						return num;
				System.out.print("\n" + errorMessge+"\n");
			}
		}

		public static Integer getPositiveInt(String inputMessage){

			return getPositiveInt(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO\n");


		}

		//region Double Helper
		public static Double getDouble(String inputMessage, String errorMessage) {
			while(true){
				try {
					System.out.print(inputMessage);
					return Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.print(errorMessage);
				}
			}
		}

		public static Double getDouble(String inputMessage){
			return getDouble(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO\n");
		}


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
		//Metodo validar caracter 
		public static boolean validarCaracter(String letra)
		{
			char caracter = letra.charAt(0);
			int valorASCII = (int)caracter;
			if (valorASCII == 165 || (valorASCII >= 64 && valorASCII <= 90))
				return true;

			return false;
		}
		public static String getChar(String inputMessage){
			return getChar(inputMessage, "\nERROR: INGRESE UN CARACTER VALIDO\n");
		}

		//region Random Double with two decimal
		public static double randomDouble(int bound) {
			double num;
			num = random.nextInt(bound) + random.nextDouble();

			return (double)Math.round(num * 100d)/100;
		}

		public static int randomInt(int inicio,int bound) {
			int num = random.nextInt(bound-inicio);

			return num;

		}

		public static int randomIntLimitado(int limite) {
			int num=(int)( Math.random()*limite);
			return num;
		}

		//region Question (yes or no)
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


		public static String IngresoAlphanumeric(String dato) {
			String resp;
			do {
				System.out.print("\nIngrese " + dato);
				resp = scanner.nextLine();

				boolean esAlfanumerico =resp.matches("^[a-zA-Z0-9]+$");

				if (esAlfanumerico) {
					return resp;
				} else {
					System.out.println("ERROR: CARACTERES ESPECIALES NO PERMITIDOS");
				}



			}while(true);    
		}

		public static String IngresoAlphanumericConEspacio(String dato) {
			String resp;
			do {
				System.out.print("\nIngrese " + dato);
				resp = scanner.nextLine();
				boolean contieneAlfanumericosYEspacios = Pattern.compile("[a-zA-Z0-9\\s]+$").matcher(resp).find();

				if (contieneAlfanumericosYEspacios) {
					return resp;
				} else {
					System.out.println("ERROR: CARACTERES ESPECIALES NO PERMITIDOS\n");
				}

			}while(true);    
		}
		public static String fechaYhora() {
			LocalDateTime ahora = LocalDateTime.now();

			// Formatear la fecha y hora según un patrón deseado (opcional)
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String fechaHoraFormateada = ahora.format(formatter);

			// Imprimir la fecha y hora actual
			return fechaHoraFormateada;
		}
		public static String validarPalabraEntre4(String dato,String string1,String string2,String string3,String string4){
			String resp ;
			do {
				resp = IngresoAlphanumeric(dato);
				if(resp.equalsIgnoreCase(string1)||
						resp.equalsIgnoreCase(string2)||
						resp.equalsIgnoreCase(string3)||
						resp.equalsIgnoreCase(string4)) {
					return resp.toLowerCase();
				}
				System.out.println("ERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO\n");
			} while (true);
		}
	}
