package InterfacesYclasesInternas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import java.util.*;
//  Clase Timer
import javax.swing.Timer;

public class PruebaTemporizador {
	public static void main(String[] args) {
		// Constructor por defecto. Creamos una instancia perteneciente a la clase 'DameLaHora'
		// esta clase lo que hace es implementar la interfaz ActionListener
		DameLaHora oyente = new DameLaHora();
		// Creamos una instancia de tipo 'ActionListener' pero a la hora de invocar al constructor,
		// le decimos que es de tipo 'DameLaHora' que es la clase que implementa la interfaz, ya que
		// las interfaces no se pueden instanciar directamente
		ActionListener oyente2 = new DameLaHora();
		// Usamos la clase timer. El constructor nos pide una frecuencia de ejecucion y un
		// objeto de tipo ActionListeniner. Este objeto no es de tipo ActionListeniner, es de
		// tipo 'DameLaHora', sim embargo, esta clase implementa la interfaz ActionListener
		Timer mitemporizador = new Timer(5000, oyente);
		
		mitemporizador.start(); // Pertenece a la clase timer
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		// Se utiliza para terminar la ejecución de un programa 
		System.exit(0);
	}
}

class DameLaHora implements ActionListener {
	
	// Siempre que se desencadene un evento, esa accion, ese evento, tiene que llamar a un metodo
	// 'actionPerformed'. Debido a esto todas las clases que desencadenen eventos tienen que
	// implementar la interfaz 'ActionListener' simplemente para asegurarse de que construimos el
	// metodo 'ActionPermorfed'. Por eso, como segundo parametro nos obliga a pasarle un parametro
	// de tipo Interfaz ActionListener, simplemente para asegurarse de que a la hora de construir
	// nuestros programas este metodo 'actionPermorfed' está desarrolado. La interfaz marca su diseño
	@Override
	public void actionPerformed(ActionEvent e) {
		Date ahora = new Date(); // Dentro del objeto almacenamos la hora actual
		System.out.println("Te pongo la hora cada 5 segundos: " + ahora);
		Toolkit.getDefaultToolkit().beep(); // Suena un sonido del sistema
		
	}
}