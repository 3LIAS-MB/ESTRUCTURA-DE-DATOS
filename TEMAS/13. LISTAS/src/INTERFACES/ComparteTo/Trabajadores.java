package INTERFACES.ComparteTo;

/* Hay una diferencia sutil: una clase abstracta
puede contener tanto métodos abstractos como
métodos concretos. En otras palabras, una clase
abstracta puede tener, por ejemplo, un método abstracto
y 30 que no lo son. Cuando una clase abstracta tiene al
menos un método abstracto, se convierte automáticamente
en abstracta. Esta situación no se aplica de la misma manera
a las interfaces. Las interfaces no pueden tener métodos normales;
siempre deben contener métodos abstractos.*/

// Los metodos que hereden de esta clase tienen que implementar sus metodos en ellas
public interface Trabajadores {
	
	// double establece_bonus(double gratificacion);
	public abstract double establece_bonus(double gratificacion);
	
	// -> Esto es una constante. Se puede ignorar 'public static final'. Por defecto es 'publica' para
	// que se pueda acceder de cualquier clase, 'estatica' porque es perteneciente a la interfaz 
	// trabajadores y 'final' porque es una constante, no se puede reasignar su valor
	public static final double bonus_base = 1500; 
												  
}											      