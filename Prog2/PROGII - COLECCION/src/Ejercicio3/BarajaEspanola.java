/*
- Una carta tiene un número entre 1 y 12 (el 8 y el 9 no se cuentan)
y un palo (oro, basto, espada, copa).
- La baraja está compuesta por un conjunto de cartas (40 cartas).
- Deberá crear un método que permita crear la baraja española (ver figura 1).
Las operaciones que podrá realizar la Baraja son:

• Barajar(): cambia de posición las cartas aleatoriamente.
• CartasDisponibles(): muestra la cantidad de cartas disponibles en la baraja.
• ExtraerCarta(): extrae aleatoriamente una carta de la baraja.
• DarCartas():devolverá un número determinado de cartas. En caso de que haya menos
cartas de las pedidas, no devolverá nada, pero se lo informaremos al usuario.
• MostrarBaraja(): muestra todas las cartas hasta el final.
• CartasMonton(): muestra las cartas que ya han salido.
• RestablecerBaraja(): vuelve a crear la baraja. */

package Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BarajaEspanola {	// Variables de instancia -> Uso como referencia la interfaz List
    private List<Carta> baraja; // En este caso, "monton" es una lista (java.util.List) que contiene elementos del tipo "Carta"
    private List<Carta> monton; // Solo acepta objetos de la clase "Carta" o sus subclases, si las hubiera

    public BarajaEspanola() {
        this.baraja = new ArrayList<>();
        monton = new ArrayList<>();
        restablecerBaraja();
    }

    public void barajar() {
        Collections.shuffle(baraja);
    }

    public int cartasDisponibles() {
        return baraja.size();
    }

    public Carta extraerCarta() {
        if (baraja.isEmpty()) {
            System.out.println("No quedan cartas en la baraja.");
            return null;
        }

        Random random = new Random();
        int indice = random.nextInt(baraja.size());
        Carta carta = baraja.remove(indice); // Puedo usar el tipo "Carta" porque la clase Carta está en el mismo paquete o se ha importado correctamente
        monton.add(carta);
        return carta;
    }
    
    public List<Carta> darCartas(int cantidad) {
        if (cantidad > baraja.size()) {
            System.out.println("No hay suficientes cartas en la baraja.");
            return null;
        }

        List<Carta> cartas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            cartas.add(extraerCarta());
        }

        return cartas;
    }

    public void mostrarBaraja() {
        for (Carta carta : baraja) {
            System.out.println(carta);
        }
    }

    public void cartasMonton() {
        for (Carta carta : monton) {
            System.out.println(carta);
        }
    }

    public void restablecerBaraja() {
        baraja.clear();
        monton.clear();
        String[] tipos = {"Oro", "Basto", "Espada", "Copa"};
        for (String tipo : tipos) {
            for (int numero = 1; numero <= 7; numero++) {
                baraja.add(new Carta(numero, tipo));
            }
            
            for (int numero = 10; numero <= 12; numero++) {
                baraja.add(new Carta(numero, tipo));
            }
        }
    }
}