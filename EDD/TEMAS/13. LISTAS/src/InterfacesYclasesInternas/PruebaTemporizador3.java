package InterfacesYclasesInternas; // CLASE INTERNA LOCAL -> Solo se puede hacer cuando se usa la clase interna una unica vez

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador3 {

	public static void main(String[] args) {
		Reloj3 mireloj = new Reloj3(); // -> Invoca al constructor por defecto
		mireloj.enMarcha(3000, true);
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	}
}

class Reloj3 { // Esta es una clase normal dentro del mismo fichero fuente	
	/*private int intervalo;
	private boolean sonido;*/
	
	/*public Reloj3(int intervalo, boolean sonido) {
		this.intervalo = intervalo;
		this.sonido = sonido;
	}*/
	
	public void enMarcha(int intervalo, final boolean sonido) {
		// Las clases internas locales no lleva ningun modificador de acceso
		// Su ambito es solo el metodo 'enMarcha', es decir, solo es visible
		// dentro del metodo. Esta clase puede acceder a los campos de la
		// clase externa. Tambien a las variables locales que declaremos dentro
		// de este metodo. Las clases externas no pueden acceder a la clase interna
		// local a no ser que utilice el metodo al que pertenece.
		class DameLaHora2 implements ActionListener {
			// La clase interna que va a acceder a una variable local que pertenece
			// al metodo donde fue declarada. Esa variable debe ser declarada como
			// 'final', es una regla que hay que tener en cuenta
			public void actionPerformed(ActionEvent evento) {
				Date ahora = new Date();
				System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
				
				if(sonido) { // Las	clases internas pueden acceder a los campos de ejemplar
							 // aunque esten encapsulados de la clase que la engloba
							 // Nos ahorramos en ciertos casos declarar los getters y setters
					Toolkit.getDefaultToolkit().beep();
				}
			}

		}
		
		ActionListener oyente = new DameLaHora2();
		
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start(); // start() es de la clase Timer
	}
}