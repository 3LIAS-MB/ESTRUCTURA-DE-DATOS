package InterfacesYclasesInternas; // CLASE INTERNA

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

public class PruebaTemporizador2 {
	public static void main(String[] args) {
		Reloj2 mireloj = new Reloj2(3000, true);
		mireloj.enMarcha();
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para terminar");
		System.exit(0);
	}
}

class Reloj2 { // Esta es una clase normal dentro del mismo fichero fuente	
	private int intervalo;
	private boolean sonido;
	
	public Reloj2(int intervalo, boolean sonido) {
		this.intervalo = intervalo;
		this.sonido = sonido;
	}
	
	public void enMarcha() {
		ActionListener oyente = new DameLaHora2();
		
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start(); // start() es de la clase Timer
	}
	// Solo las clases internas pueden tener el modificador 'private'
	// las clases normales solo admiten el modificar public y por defecto
	private class DameLaHora2 implements ActionListener {
		
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
	
}