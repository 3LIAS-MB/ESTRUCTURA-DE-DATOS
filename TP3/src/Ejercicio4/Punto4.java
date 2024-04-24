/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio4;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author exe20
 */
public class Punto4 {

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
        Stack <Character> pila = new Stack <Character>();
        String notPosFija = algoritmo(pila);
        System.out.println("La notacion posfija es: "+notPosFija);
    }
    
    public static String algoritmo(Stack <Character> pila  ){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una expresion matematica");
        String expresion = sc.nextLine();
        char c;
        String notPosFija = "";
        
        for(int i=0; i<expresion.length();i++){
            c = expresion.charAt(i);
            
            if(c >= '0' && c <= '9'){
                notPosFija = notPosFija + c;
            }
            if(c == '*' || c == '+' || c=='-'|| c=='/'){
                pila.push(c);
            }
            if(c == ')'){
                notPosFija = notPosFija + pila.pop();
            }
        }
        while(!pila.isEmpty()){
                notPosFija = notPosFija + pila.pop();
            }
       
        return notPosFija;
    }
    
    public static void menuPorRandom(){
        
    }
}