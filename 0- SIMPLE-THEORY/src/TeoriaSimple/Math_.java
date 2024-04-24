package TeoriaSimple;
public class Math_ {
    public static void main(String[] args) {
    	
    	// Raiz cuadrada
        int raiz = (int) Math.sqrt(9);   // Convierte el resultado a int
        double raiz2 = Math.sqrt(9);
        
        System.out.println(raiz);        // Imprimirá 3
        System.out.println(raiz2);       // Imprimirá 3.0
        
        // Potencia
        double base = 5, exponente = 2;
        double resultado = Math.pow(base, exponente); // Todo tiene que ser "double"
        
        System.out.println(resultado);        // Imprime 25

        // Redondeando double -> Pasar de decimal a entero
        double numero = 4.56f;
        long result = Math.round(numero); // Si quiero cambiar un  double (decimal) a número entero uso "long"
        
        System.out.println(result); // Imprime 5
        
        // Redondeando flaot -> Pasar de float a entero
        
        float numero2 = 4.56f;
        int result2 = Math.round(numero2); // Si quiero cambiar un  float a entero uso  "int"
        
        System.out.println(result2); // Imprime 5
        
        
        // Ramdon 

        double numero3 = Math.random(); // Si quiero cambiar un  double (decimal) a número entero uso "long"
        
        System.out.println(numero3); // Imprime un numero ramdon	
    }
}	