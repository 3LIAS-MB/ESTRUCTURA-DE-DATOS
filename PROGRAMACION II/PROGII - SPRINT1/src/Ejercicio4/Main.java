package Ejercicio4;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 Scanner entrada = new Scanner(System.in);
		 Animal animal = new Animal("Cachorrao", "gris", 123);
		 
		 System.out.println("CREAR LEON\n");
		 System.out.print("Ingrese el nombre del Leon: ");
		 String nombre = entrada.nextLine();
		 System.out.print("Ingrese el color del Leon: ");
		 String color = entrada.nextLine();
		 System.out.print("Ingrese el peso del Leon: ");
		 int peso = entrada.nextInt();
		 System.out.print("Ingrese la altura del Leon: ");
		 Double altura = entrada.nextDouble();
		 System.out.print("Ingrese la velocidad del Leon: ");
		 int velocidad = entrada.nextInt();
		 entrada.nextLine();
		 System.out.print("Ingrese la especie del Leon: ");
		 String especie = entrada.nextLine();
		 System.out.print("Ingrese el color de la melena: ");
		 String melena = entrada.nextLine();
		 Leon leon1 = new Leon(nombre, color, peso, altura, velocidad, especie, melena);
		 System.out.println("");
		 leon1.accionAnimal();
		 
		 System.out.println("\nCREAR PERRO\n");
		 System.out.print("Ingrese el nombre del perro: ");
		 String nombre_ = entrada.nextLine();
		 System.out.print("Ingrese el color del perro: ");
		 String color_ = entrada.nextLine();
		 System.out.print("Ingrese el peso del perro: ");
		 int peso_ = entrada.nextInt();
		 entrada.nextLine();
		 System.out.print("Cual es la onomatopeya del perro?: ");
		 String onomatopeya = entrada.nextLine();
		 System.out.print("Cual es el apodo del perro?: ");	
		 String apodo = entrada.nextLine();
		 System.out.print("Cual es la raza del perro?: ");
		 String raza = entrada.nextLine();
		 
		 Perro perro1 = new Perro(nombre_, color_, peso_, onomatopeya, apodo, raza);
		 System.out.println("");
		 perro1.accionAnimal();
		 
		 
		 System.out.println(animal);
		 entrada.close();
	 }
		 
}