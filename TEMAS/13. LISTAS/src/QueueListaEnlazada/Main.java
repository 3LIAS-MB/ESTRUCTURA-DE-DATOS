package QueueListaEnlazada;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {	
        Cola cola = new Cola();
        

        while (true) {
            try {
                String opcion = JOptionPane.showInputDialog(
                    "Elija una opción:\n" +
                    "1. Encolar (Offer)\n" +
                    "2. Desencolar (Poll)\n" +
                    "3. Mostrar elemento al inicio (Peek)\n" +
                    "4. Mostrar tamaño (Size)\n" +
                    "5. Verificar si la cola está vacía (IsEmpty)\n" +
                    "6. Salir"
                );

                if (opcion == null) {
                    // El usuario cerró la ventana o eligió cancelar
                    break;
                }

                int choice = Integer.parseInt(opcion);

                switch (choice) {
                    case 1:
                        String inputOffer = JOptionPane.showInputDialog("Ingrese el elemento para encolar:");
                        int elementoOffer = Integer.parseInt(inputOffer);
                        cola.offer(elementoOffer);
                        break;

                    case 2:
                        if (!cola.isEmpty()) {
                            int elementoPoll = cola.poll();
                            JOptionPane.showMessageDialog(null, "Elemento desencolado: " + elementoPoll);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola está vacía.");
                        }
                        break;

                    case 3:
                        if (!cola.isEmpty()) {
                            int elementoInicio = cola.peek();
                            JOptionPane.showMessageDialog(null, "Elemento al inicio: " + elementoInicio);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola está vacía.");
                        }
                        break;

                    case 4:
                        int tamañoCola = cola.size();
                        JOptionPane.showMessageDialog(null, "Tamaño de la cola: " + tamañoCola);
                        break;

                    case 5:
                        boolean estaVacia = cola.isEmpty();
                        JOptionPane.showMessageDialog(null, "La cola " + (estaVacia ? "está vacía." : "no está vacía."));
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                        System.exit(0);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida.");
            } catch (NullPointerException e) {
                // El usuario cerró la ventana o eligió cancelar
                break;
            }
        }
    }
}
