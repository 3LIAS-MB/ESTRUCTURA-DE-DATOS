import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CasosDeEstudio_a {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombre = entrada.nextLine();

        // Obtener la fecha y hora actual del sistema
        Date fechaActual = new Date();

        // Formatear la fecha y hora en un formato legible
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = formato.format(fechaActual);

        // Mostrar el saludo con el nombre y la fecha
        System.out.println("¡Hola, " + nombre + "! Bienvenido.");
        System.out.println("La fecha y hora actual es: " + fechaFormateada);

        entrada.close();
    }
}	
