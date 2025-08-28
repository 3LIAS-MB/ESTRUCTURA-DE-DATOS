package DEMO;

public class Demo {
    public static void main(String[] args) {
    	
    	/*Se crea una nueva instancia de la clase Demo2 utilizando la palabra clave new,
    	 * y luego inmediatamente se llama al método Run() en esa instancia recién creada.
    	 * Es una forma de hacerlo en una sola línea sin almacenar la instancia en una variable.*/
        (new Demo2()).Run();
        
        
        /*En este caso, se crea una instancia de Demo2 y se almacena en la variable demo.
         * Luego, se llama al método Run() en esa instancia almacenada en la variable.*/
        Demo2 demo = new Demo2();
        demo.Run();
 
    }
 
 
}
 