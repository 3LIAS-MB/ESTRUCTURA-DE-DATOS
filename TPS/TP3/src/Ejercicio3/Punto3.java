/*
2 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio3;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author exe20
 */
public class Punto3 {

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
        boolean n = expresionMatematica();
        if(n == true){
            System.out.println("La expresion matematica esta bien parentizada");
        }
        else{
            System.out.println("La expresion matematica no esta bien parentizada");
        }
    }
    
    public static boolean expresionMatematica(){
        Stack <Character> pila1 = new Stack<Character>();
        Stack <Character> pila2 = new Stack<Character>();
        Stack <Character> pila3 = new Stack<Character>();
        
        char c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una expresion matematica: ");
        String cadena = sc.nextLine();
       
       
        
        for(int i=0; i<cadena.length();i++){
            c = cadena.charAt(i);
            if(c == '('){
                pila1.push(c);
            }else{
                if(c == ')'){
                    if(!pila1.isEmpty()){
                        pila1.pop();
                    }else{
                        return false;
                    }
                }
            }
            if(c == '['){
                pila2.push(c);
            }else{
                if(c == ']'){
                    if(!pila2.isEmpty()){
                        pila2.pop();
                    }else{
                        return false;
                    }
                }
            }
            if(c == '{'){
                pila3.push(c);
            }else{
                if(c == '}'){
                    if(!pila3.isEmpty()){
                        pila3.pop();
                    }else{
                        return false;
                    }
                }
            }
            
        }
        return pila1.isEmpty() && pila2.isEmpty() && pila3.isEmpty();
        
    }
   
    public static void menuPorRandom(){
        
    }
    
}