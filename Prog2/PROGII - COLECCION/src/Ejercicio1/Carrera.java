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
j) Obtenga los datos del atleta que salió último en la carrera.
k) Indique si existe algún atleta de nacionalidad Peruana. */

package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
	String distanciaRecorrida;
	String ganador;
	List<Atletas> competidores;
	
	 public Carrera() {
	        competidores = new ArrayList<>(); // Inicializar la lista en el constructor
	    }
	 
	public void registrarAtletas(Atletas atletas) {
		 competidores.add(atletas);
	}
	
    public int getCantidadDeAtletas() { // Cambio de Atletas a Atleta y corrección del tipo de retorno
        return competidores.size();
	}
    
    
}
