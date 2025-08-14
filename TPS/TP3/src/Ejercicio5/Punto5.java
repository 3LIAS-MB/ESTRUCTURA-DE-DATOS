/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio5;

import java.util.Stack;

import Ejercicio6.HelperN;

/**
 *
 * @author exe20
 */
public class Punto5 {

    /**
     * @param args the command line arguments
     */
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
        int opcion;
        Stack <String> pila = new Stack<String>();
        do{    
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Conversion de un numero a binario");
            System.out.println("2. Conversion de un numero a octal");
            System.out.println("3. Sslir");

            opcion = HelperN.getPositiveInt("Ingrese la opcion de conversion: ");
        
            switch(opcion){
                case 1 -> {
                    int n1 = HelperN.getPositiveInt("Ingrese un numero para la conversion");
                    conversionBinario(pila,n1);
                }
                case 2 ->{                   
                     int n2 = HelperN.getPositiveInt("Ingrese un numero para la conversion");
                    conversionOctal(pila,n2);
                }
            }
            }while(opcion != 3);
    }
    
    public static void conversionBinario(Stack <String> pila, int n){
        int cociente= 3;
        int resto;
        String c;
        String conversion="";
        while(cociente >= 2){
            cociente = n/2;
            resto = n%2;
            c = Integer.toString(resto);
            pila.push(c);
            n = cociente;
            if(cociente < 2){
                c = Integer.toString(cociente);
                pila.push(c);
            }
        }
       while(!pila.isEmpty()){
           conversion = conversion + pila.pop();
       }
       System.out.println("El numero en binario es: "+ conversion);
    }
    
    public static void conversionOctal(Stack <String> pila, int n){
        int cociente= 9;
        int resto;
        String c;
        String conversion="";
        while(cociente >= 8){
            cociente = n/8;
            resto = n%8;
            c = Integer.toString(resto);
            pila.push(c);
            n = cociente;
            if(cociente < 8){
                c = Integer.toString(cociente);
                pila.push(c);
            }
        }
       while(!pila.isEmpty()){
           conversion = conversion + pila.pop();
       }
       
       System.out.println("El numero en octal es: "+ conversion);
    }
    
    
    public static void menuPorRandom(){
        
    }
    
}