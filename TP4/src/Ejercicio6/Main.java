package Ejercicio6;

import java.util.Scanner;


public class Main {

	public static Queue<String> codificado0 = new Queue<String>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int op;
		int[] clave;		
		int [] claveP = new int[4];
		
		do {
			op = opc();
			switch(op) {
			case 1:			
				String frase = IngresoDeFrase();
				System.out.println("\nSu frase es: " + frase);
				clave = new int[4];
				claveP = clave(clave, claveP, frase);		
				break;
			case 2: 				
				String Stringdecodificado =decodificar(codificado0,claveP);
				System.out.println(Stringdecodificado+"\n");
				break;
			}			
		} while(op!=3);
	}
	
	private static int[] clave(int[] clave, int[] claveP, String frase ) {
		int[] subclave=new int[4];
		int num= Helper.getPositiveInt_conLimitador("\n1-Ingreso de 3 claves de forma manual\n2-Ingreso de 3 clave de forma automatica\nIngrese una opcion: ","ingreso invalido", 2);
		String frase2=frase;			
			for(int i=0;i<=2;i++) {	
				IngresoDeClave(subclave,num);
				System.out.print("Subclave generada:");
				mostrar(subclave);			
				suma(clave,subclave);
				System.out.print("Suma de subclaves	generadas:");
				mostrar(clave);
				String codificado=codificar(frase2,subclave);
				frase2=codificado;					
				System.out.println("Frase codificada: " +codificado);							
			}
			claveP=clave;
			System.out.print("Clave final generada:");
			mostrar(claveP);
			System.out.println();				
			codificado0.add(frase2);
			System.out.println("Su frase Codificada por Tripe-DES es:"+frase2+"\n");
			return claveP;		
	}
	
	private static String decodificar(Queue<String> codificado2, int[] clave) {
		mostrar(clave);
		String decodificado="";
		if(!codificado2.isEmpty()) {
			String frase= codificado2.pool();
			Queue<Character>cola2=new Queue<Character>(frase.length());			
			int largo=0;
			while(frase.length()>largo) {
				Character p = frase.charAt(largo);
				cola2.add(p);
				++largo;
			}
			int i=0;
			while(!cola2.isEmpty()) {
				Character sacar=cola2.remove();
				decodificado+=(char)((int)sacar-clave[i]);
				if(i==3) {
					i=0;
				}else {
					++i;
				}
			}
			return "El mensaje decodificado es: "+ decodificado;			
		}else {
			return "No hay frase para decodificar";
			}
	}
	
	private static void suma(int[] clave, int[] subclave) {		
		for(int i=0;i<clave.length;i++) {
			clave[i]=clave[i]+subclave[i];			
		}		
	}
	
	private static void mostrar(int[] clave) {
		System.out.println();
		for(int i=0;i<clave.length;i++) {
			System.out.print(clave[i]+";");			
		}
		System.out.println();
	}
	
	private static String codificar(String frase, int[] clave) {		
		Queue<Character>cola= new Queue<Character>(frase.length());
		String codificado="";
		int largo = 0;
		while (frase.length()> largo) {
			Character p = frase.charAt(largo);
			cola.add(p);
			++largo;
		}		
		int i=0;
		while (!cola.isEmpty()) {
			Character sacar= cola.remove();
			codificado+=(char)((int)sacar+clave[i]);
			if (i==3) {
				i=0;
			}else {
				++i;
			}
		}
		return codificado;			
	}
	
	private static String IngresoDeFrase() {
		String frase;
		int num= Helper.getPositiveInt_conLimitador("\n1-Ingreso de frase de forma manual"
												   + "n2-Ingreso de frase de forma automatica"+
												   	 "\nIngrese una opccion: ", 
													 "Ingreso invalido", 2);
		if(num==1) {
			System.out.println("\nIngrese la frase deseada: ");
			frase = sc.nextLine();
		} else {
			String[] lista= {"El sol brilla en el cielo azul","Los pajaros cantan en el bosque",
							 "El mar susurra secretos al viento",
					         "Las flores bailan con el viento","La noche cubre el mundo de estrellas"};
			int i = Helper.randomIntLimitado(5);				
			frase = lista[i];    
		}		
		return frase;			
	}
	
	private static  void IngresoDeClave(int[] clave, int num2) {
		if(num2==1) {
			System.out.println("Ingrese 4 digitos para la clave");
				for(int j=0;j<=3;j++) {
					clave[j] = (sc.nextInt());			
			}			
		} else {
				for(int j=0;j<=3;j++) {
				clave[j] = (Helper.randomIntLimitado(21)-10);
			}				
		}		
	}
	
	private static int opc() {
		int num = Helper.getPositiveInt_conLimitador("1-Codificar\n2-Decodificar\n3-Salir\nIngrese una opccion: ","ingreso no valido", 3);
		return num;
	}
	
}