package INTERFACES.ComparteTo;

import java.sql.Date;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class UsoEmpleado {
    public static void main(String[] args) {
    									  // altaContrato, id, incentivo, nombre, sueldo
        Jefatura jefe_RRHH = new Jefatura("Juan", 55.000, 2006, 9, 25);
        jefe_RRHH.estableceIncentivo(2570);

        Empleado[] misEmpleados = new Empleado[6];
        // Las instancias de la clase empleado no llevan
        // el atributo 'incentivo' perteneciente a la clase Jefatura
        misEmpleados[0] = new Empleado("Ana", 30000, 2000, 07, 07);
        misEmpleados[1] = new Empleado("Carlos", 50000, 1995, 06, 15);
        misEmpleados[2] = new Empleado("Paco", 25000, 2005, 9, 25);
        misEmpleados[3] = new Empleado("Antonio", 47500, 2009, 11, 9);
        
	    // El polimorfismo permite que una instancia de una subclase se
	    // almacene en una variable o estructura de datos de la superclase.
        // -> Principio de sustitucion 'es un...'
        misEmpleados[4] = jefe_RRHH; 
        misEmpleados[5] = new Jefatura("Maria", 95000, 1999, 5, 26);

        Jefatura jefa_Finanzas = (Jefatura) misEmpleados[5]; // El casting es necesario porque estás tratando de convertir una instancia de Empleado (almacenada en misEmpleados[5]) en una instancia de Jefatura
        													 // Esta conversión se realiza para permitir el acceso a métodos y atributos específicos de la clase Jefatura que no están disponibles en la clase base Empleado.
        jefa_Finanzas.estableceIncentivo(55000);		   	 // Jefatura es una subclase de Empleado, lo que significa que una instancia de Jefatura es también una instancia de Empleado, pero no al revés
        
        /* -> Utilizar el principio de sustitucion con dos clases*/
        // Esto significa que puedes tratar una instancia de una
        // subclase como si fuera una instancia de su superclase.
        Empleado director_comercial = new Jefatura("Sandra", 85000, 2012, 05, 05);
        /*No se puede instanciar directamente una insterfaz pero si se puede utilizar el 
         principio de sustitucion, de tal forma que si la clase 'Empleado' implementa la
         interfaz 'Comparable', podemos crearnos una instancia perteneciente a la interfaz
         pero luego a la hora de instanciarla decirle que es de tipo Empleado*/
        
        // Se está creando una instancia de la clase Empleado y luego se está almacenando en una 
        // variable de tipo Comparable. Esto demuestra otro aspecto del principio de sustitución
        // La interfaz Comparable es una interfaz genérica que define un método compareTo. Dado
        // que la clase Empleado implementa la interfaz Comparable, puedes crear una instancia de	
        // Empleado y asignarla a una variable de tipo Comparable.
        Comparable<Empleado> ejemplo = new Empleado("Elizabeth", 95000, 2001, 06, 07);
        if(director_comercial instanceof Empleado) { 
        	System.out.println("Es de tipo jefatura: "); // Lo imprime porque Jefatura es una subclase de Empleado
        }
        if(ejemplo instanceof Comparable) {
        	System.out.println("Implementa la interfaz comparable");
        }
        
        System.out.println(jefa_Finanzas.tomarDecisiones("Dar más dias de vacaciones a los empleados"));
        System.out.println("El jefe " + jefa_Finanzas.dameNombre() + "tiene un  bonus de " + jefa_Finanzas.establece_bonus(500));
        
        System.out.println(misEmpleados[3].dameNombre() + " tiene un  bonus de: " + misEmpleados[3].establece_bonus(200));
        
        for (Empleado e : misEmpleados) { // Le sube a todos el sueldo con el metodo
            e.subeSueldo(5);
        }
        
        Arrays.sort(misEmpleados);
        
        for(Empleado e: misEmpleados) {
        	System.out.println("Nombre: " + e.dameNombre()
        	+ " Sueldo: " + e.dameSueldo() + " Fecha de alta: " + e.dameFechaContrato());
        }
    }
}

//  Una clase abstracta en Java puede tener tanto métodos abstractos (que no 
//  tienen implementación) como métodos concretos (que sí tienen implementación).
abstract class Persona {
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
    public String dameNombre() {
    	return nombre;
    }
    
    // Metodo abstracto
    // -> Tan solo se define pero no se construye
    public abstract String dameDescripción();	
}
    
//Esta declaración define una clase Empleado que implementa dos interfaces,
class Empleado extends Persona implements Comparable<Empleado>, Trabajadores {
    private double sueldo;
    private Date altaContrato;
    private static int idSiguiente; /**/
    private int id;

    public Empleado(String nombre, double sueldo, int año, int mes, int dia) {
    	super(nombre); 				// Llamado al constructor de una clase abstracta
        this.sueldo = sueldo;		// -> Java no permite la herencia multiple
        GregorianCalendar calendario = new GregorianCalendar(año, mes - 1, dia);
        altaContrato = new Date(calendario.getTimeInMillis());
        id = ++idSiguiente;
    }
    
    @Override
    public double establece_bonus(double gratificacion) {
    	// No hay prima. Desarrollamos como nosotros lo queramos
    	return Trabajadores.bonus_base - gratificacion; 
    }

    public Empleado(String nom) {
        this(nom, 30000, 2000, 1, 1);
    }

    public double dameSueldo() {
        return sueldo;
    }
    
    public void subeSueldo(double porcentaje) {
        double aumento = sueldo * porcentaje / 100;
        sueldo += aumento;
    }
    
    public Date dameFechaContrato() {
        return altaContrato;
    }
    
	@Override
	public String dameDescripción() {
		return "Este empleado tiene un ID" + id + "con un sueldo de: " + sueldo;
	}
 
    // Metodo para poder implementar la interfaz comparable
    @Override
    public int compareTo(Empleado miObjeto) {
    	Empleado otroEmpleado = miObjeto;
    	if(this.sueldo < otroEmpleado.sueldo) { // Si el sueldo de uno es menor que el de otro -1
    		return -1;
    	}
    	if(this.sueldo > otroEmpleado.sueldo) { // Si el sueldo de uno es mayor que el de otro 1
    		return 1;
    	}
    	return 0;
    }

}

class Alumno extends Persona {
	private String carrera;
	
	public Alumno(String nombre, String carrera) {
		super(nombre);
		this.carrera = carrera;
	}

	@Override
	public String dameDescripción() {
		return "Este alumno está estudiando la carrera de " + carrera;
	}
}

