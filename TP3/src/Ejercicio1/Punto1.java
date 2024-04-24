/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio1;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author exe20
 */

public class Punto1 {
    public static void main(String[] args) {
       menu();
    }
    
   public static void menu(){
        int opcion;
       
    do{    
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Ingreso de datos por teclado");
        System.out.println("2. Ingreso de datos generados aleatoriamente");
        System.out.println("3. Sslir");

        opcion = HelperN.getPositiveInt("Ingrese la opcion: ");
        
        switch(opcion){
            case 1 -> menuPorTeclado();
            case 2 -> menuPorRandom();
            case 3 -> System.out.println("Fin del programa");
            default -> System.out.println("Opcion erronea");
            }
        }while(opcion != 3);
    
    }
    
    public static void menuPorTeclado(){
        boolean n = palindromo();
        
        if(n == true){
            System.out.println("La cadena es un palindromo");
        }
        else{
            System.out.println("La cadena no es un palindromo");
        }
        
    }
    
    public static boolean palindromo(){
        Stack <Character> pila = new Stack <Character>();
        char c;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra: "); // elias
        String n = sc.nextLine();
        
        for(int i=0;i< n.length();i++){
            c = n.charAt(i);
            pila.push(c); // saile
        }
        for(int j= 0;j<n.length();j++){
            if(pila.peek() == n.charAt(j)){ // s = s
                if(!pila.isEmpty()){
                    pila.pop();
                }
            }
        }
        return pila.isEmpty();
    }
    
    public static boolean esPalindromo(String palabra) {
        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            pila.push(c);
        }

        for (int j = 0; j < palabra.length(); j++) {
            if (!pila.isEmpty() && pila.peek() == palabra.charAt(j)) {
                pila.pop();
            }
        }

        return pila.isEmpty();
    }
    
    public static void menuPorRandom(){
        
    }
    
}