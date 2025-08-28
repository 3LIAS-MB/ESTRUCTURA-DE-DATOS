package EJERCICIOS;
import javax.swing.JOptionPane;

public class Ejercicio9 {

    public static void main(String[] args) {
        
        int[] alumnos = new int[5];
        int nota, posalumno;
        int primer=0, segundo=0, tercer=0;
        
        for(int i=0;i<5;i++){
            nota=Integer.parseInt(JOptionPane.showInputDialog("Ingrese las notas del "
                    + "primer trimestre del alumno "+(i+1)+" :"));
            alumnos[i] += nota;
            primer += nota;
            nota=Integer.parseInt(JOptionPane.showInputDialog("Ingrese las notas del "
                    + "segundo trimestre del alumno "+(i+1)+" :"));
            alumnos[i] += nota;
            segundo += nota;
            nota=Integer.parseInt(JOptionPane.showInputDialog("Ingrese las notas del "
                    + "tercer trimestre del alumno "+(i+1)+" :"));
            alumnos[i] += nota;
            tercer += nota;
        }
        
        posalumno = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posición(1-5) del "
                + "alumno que desea saber su media : "));
        
        JOptionPane.showMessageDialog(null, "La media del primer trimestre es: "+(primer/5)+" \n"
                + "La media del segundo trimestre es: "+(segundo/5)+" \n"
                + "La media del tercer trimestre es: "+(tercer/5)+" ");
        
        JOptionPane.showMessageDialog(null, "La media del alumno en la "
                + "posicion "+(posalumno)+" es : "+(alumnos[posalumno-1]/3));
        
    }
    
}