/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio6;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author exe20
 */
public class Punto6 {

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
         Stack <Integer> pila = new Stack <Integer>();
        int resultado = algoritmo(pila);
        System.out.println("La notacion posfija es: "+resultado);
    }
    
    public static int algoritmo(Stack <Integer> pila){
        int resultadoFinal= 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una expresion matematica posfija: ");
        String expresion = sc.nextLine();
        char c;
        
        for(int i=0;i<expresion.length();i++){
            c = expresion.charAt(i);
            
            if(c >= '0' && c <= '9'){
                int n = Character.getNumericValue(c);
                pila.push(n);
            }
            else if(c == '*' || c == '+' || c=='-'|| c=='/'){
                if(c == '+'){
                    int numero2 = pila.pop();
                    int numero1 = pila.pop();
                    int resultado = numero1 + numero2;
                    pila.push(resultado);
                }
                else if(c== '*'){
                    int numero2 = pila.pop();
                    int numero1 = pila.pop();
                    int resultado = numero1 * numero2;
                    pila.push(resultado);
                }
                else if(c== '-'){
                    int numero2 = pila.pop();
                    int numero1 = pila.pop();
                    if(numero1>numero2){
                        int resultado = numero1 - numero2;
                        pila.push(resultado);
                    }else{
                        System.out.println("No se aceptan numeros negativos");
                        return resultadoFinal = 0;
                    }
                }
                else if(c== '/'){
                    int numero2 = pila.pop();
                    int numero1 = pila.pop();
                    if(numero2 != 0){
                        int resultado = numero1 / numero2;
                        pila.push(resultado);
                    }else{
                        System.out.println("No se puede divir por cero");
                        return resultadoFinal = 0;
                    }
                }
            }
        }
        resultadoFinal = pila.pop();
        return resultadoFinal;
    }
    
    
    public static void menuPorRandom(){
        
    }

    
}