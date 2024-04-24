/*a) En una carrera de velocidad participan un cierto número de atletas, cada uno de ellos
tiene un nombre, número, nacionalidad, fecha de nacimiento y el tiempo que le tomó
correr la carrera. Cree una clase “Atleta” que represente a un atleta, con los métodos de
acceso a los atributos y constructores necesarios.
b) Una carrera cubre una cierta distancia y cada carrera tiene un ganador. Cree una clase
Carrera que maneje esta información y que permita registrar la información de todos los
participantes en la carrera, podemos hacer esto añadiendo un atributo “competidores” a
la clase Carrera, que será una colección de atletas.
c) Registre atletas en la carrera.
d) Obtenga la cantidad de atletas de la carrera.
e) Imprima los datos de todos los competidores.
f) Determine el ganador de la carrera, mostrando en pantalla los datos del atleta y el tiempo
registrado.
g) ¿Cuántos atletas de nacionalidad Uruguaya hay? Visualice los datos de los mismos.
h) Ordene los atletas por nombre.
i) Encuentre el primer atleta argentino menor de edad.
j) Obtenga los datos del atleta que salió último en la carrera*/

package EJERCICIO_PRUEBA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la distancia recorrida en la carrera: ");
        String distanciaRecorrida = scanner.nextLine();
        Carrera carrera = new Carrera(distanciaRecorrida);

        while (true) {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Registrar Atleta");
            System.out.println("2. Obtener Cantidad de Atletas");
            System.out.println("3. Imprimir Competidores");
            System.out.println("4. Determinar Ganador de la Carrera");
            System.out.println("5. Contar Atletas de Nacionalidad Uruguaya");
            System.out.println("6. Mostrar Atletas de Nacionalidad Uruguaya");
            System.out.println("7. Ordenar Atletas por Nombre");
            System.out.println("8. Encontrar Primer Atleta Argentino Menor de Edad");
            System.out.println("9. Obtener Último Atleta en la Carrera");
            System.out.println("10. Verificar si Existe Atleta de Nacionalidad Peruana");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del atleta: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el número del atleta: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese la nacionalidad del atleta: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento del atleta (AAAA-MM-DD): ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Ingrese el tiempo que le tomó correr la carrera (segundos): ");
                    double tiempoCarrera = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea

                    Atleta atleta = new Atleta(nombre, numero, nacionalidad, fechaNacimiento, tiempoCarrera);
                    carrera.registrarAtleta(atleta);
                    System.out.println("Atleta registrado con éxito.");
                    break;
                case 2:
                    int cantidadAtletas = carrera.getCantidadDeAtletas();
                    System.out.println("Cantidad de Atletas en la Carrera: " + cantidadAtletas);
                    break;
                case 3:
                    System.out.println("Competidores en la Carrera:");
                    carrera.imprimirCompetidores();
                    break;
                case 4:
                    carrera.determinarGanador();
                    break;
                case 5:
                    int cantidadUruguayos = carrera.contarAtletasUruguayos();
                    System.out.println("Cantidad de Atletas de Nacionalidad Uruguaya: " + cantidadUruguayos);
                    break;
                case 6:
                    carrera.mostrarAtletasUruguayos();
                    break;
                case 7:
                    carrera.ordenarPorNombre();
                    System.out.println("Atletas ordenados por Nombre:");
                    carrera.imprimirCompetidores();
                    break;
                case 8:
                    Atleta primerArgentinoMenor = carrera.primerArgentinoMenorDeEdad();
                    if (primerArgentinoMenor != null) {
                        System.out.println("Primer Atleta Argentino Menor de Edad:");
                        System.out.println(primerArgentinoMenor);
                    } else {
                        System.out.println("No se encontró ningún Atleta Argentino Menor de Edad.");
                    }
                    break;
                case 9:
                    Atleta ultimoAtleta = carrera.obtenerUltimoAtleta();
                    if (ultimoAtleta != null) {
                        System.out.println("Último Atleta en la Carrera:");
                        System.out.println(ultimoAtleta);
                    } else {
                        System.out.println("No hay atletas en la carrera.");
                    }
                    break;
                case 10:
                    boolean existePeruano = carrera.existeAtletaPeruano();
                    if (existePeruano) {
                        System.out.println("Sí, hay al menos un Atleta de Nacionalidad Peruana.");
                    } else {
                        System.out.println("No, no hay Atletas de Nacionalidad Peruana.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
