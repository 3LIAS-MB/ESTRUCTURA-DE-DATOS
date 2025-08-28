package INTERFACES.ComparteTo;

// Jerarquia de interfaces. La que está en la custipide seria 'Trabajadores'
public interface Jefes extends Trabajadores { 
		
	// El comportamiento que queremos determinar para las clases que implementen esta interfaz,
	// es que estas clases tienen que tener un metodo y va a ser los siguientes metodos:
	
	// Se puede obviar 'public abstract'
	// Esta es la forma de declarar un metodo en una,
	// los metodos se definen, pero no se desarrollan
	public abstract String tomarDecisiones(String decicion); 														
}

	// Extiende la interfaz Trabajadores, lo que significa que cualquier clase que implemente la interfaz Jefes también
	// debe proporcionar la implementación del método establece_bonus(double gratificacion) de la interfaz 'Trabajadores'
