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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Carrera {
    private String distanciaRecorrida;
    private Atleta ganador;
    private List<Atleta> competidores;

    public Carrera(String distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
        this.competidores = new ArrayList<>();
    }

    public void registrarAtleta(Atleta atleta) {
        competidores.add(atleta);
    }

    public int getCantidadDeAtletas() {
        return competidores.size();
    }

    public void imprimirCompetidores() {
        for (Atleta atleta : competidores) {
            System.out.println(atleta);
        }
    }

    public void determinarGanador() {
        if (!competidores.isEmpty()) {
            ganador = Collections.min(competidores, Comparator.comparing(Atleta::getTiempoCarrera));
            System.out.println("Ganador de la carrera:\n" + ganador);
        } else {
            System.out.println("No hay competidores en la carrera.");
        }
    }

    public int contarAtletasUruguayos() {
        int contador = 0;
        for (Atleta atleta : competidores) {
            if (atleta.getNacionalidad().equalsIgnoreCase("Uruguaya")) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarAtletasUruguayos() {
        System.out.println("Atletas de nacionalidad Uruguaya:");
        for (Atleta atleta : competidores) {
            if (atleta.getNacionalidad().equalsIgnoreCase("Uruguaya")) {
                System.out.println(atleta);
            }
        }
    }

    public void ordenarPorNombre() {
        Collections.sort(competidores, Comparator.comparing(Atleta::getNombre));
    }

    public Atleta primerArgentinoMenorDeEdad() {
        for (Atleta atleta : competidores) {
            if (atleta.getNacionalidad().equalsIgnoreCase("Argentino")) {
                int edad = 2023 - Integer.parseInt(atleta.getFechaNacimiento().substring(6));
                if (edad < 18) {
                    return atleta;
                }
            }
        }
        return null;
    }

    public Atleta obtenerUltimoAtleta() {
        if (!competidores.isEmpty()) {
            return competidores.get(competidores.size() - 1);
        } else {
            return null;
        }
    }

    public boolean existeAtletaPeruano() {
        for (Atleta atleta : competidores) {
            if (atleta.getNacionalidad().equalsIgnoreCase("Peruana")) {
                return true;
            }
        }
        return false;
    }
}