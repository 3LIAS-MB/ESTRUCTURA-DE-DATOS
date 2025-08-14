package StackListaEnlazada;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Pila pila = new Pila();

        while (true) {
            try {
                String opcion = JOptionPane.showInputDialog(
                    "Elija una opción:\n" +
                    "1. Apilar (Push)\n" +
                    "2. Desapilar (Pop)\n" +
                    "3. Mostrar elemento en la cima (Peek)\n" +
                    "4. Mostrar tamaño (Size)\n" +
                    "5. Vaciar la pila\n" +
                    "6. Verificar si la pila está vacía (IsEmpty)\n" +
                    "7. Mostrar pila" +
                    "8. Salir"
                );

                if (opcion == null) {
                    // El usuario cerró la ventana o eligió cancelar
                    break;
                }

                int choice = Integer.parseInt(opcion);

                switch (choice) {
                    case 1:
                        String inputPush = JOptionPane.showInputDialog("Ingrese el elemento para apilar:");
                        int elementoPush = Integer.parseInt(inputPush);
                        pila.push(elementoPush);
                        break;

                    case 2:
                        if (!pila.empty()) {
                            int elementoPop = pila.pop();
                            JOptionPane.showMessageDialog(null, "Elemento desapilado: " + elementoPop);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila está vacía.");
                        }
                        break;

                    case 3:
                        if (!pila.empty()) {
                            int elementoCima = pila.peek();
                            JOptionPane.showMessageDialog(null, "Elemento en la cima: " + elementoCima);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila está vacía.");
                        }
                        break;

                    case 4:
                        int tamañoPila = pila.size();
                        JOptionPane.showMessageDialog(null, "Tamaño de la pila: " + tamañoPila);
                        break;

                    case 5:
                        pila.clear();
                        JOptionPane.showMessageDialog(null, "La pila ha sido vaciada.");
                        break;
                    case 6:
                        boolean estaVacia = pila.empty();
                        JOptionPane.showMessageDialog(null, "La pila " + (estaVacia ? "está vacía." : "no está vacía."));
                        break;

                    case 7:
                        pila.mostrarPila();
                        break;
                        
                    case 8:
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
