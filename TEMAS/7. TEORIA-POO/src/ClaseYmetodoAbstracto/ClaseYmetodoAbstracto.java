package ClaseYmetodoAbstracto;

//Clase abstracta para figuras geométricas
abstract class Figura {
 // Método abstracto para calcular el área
 public abstract double calcularÁrea();
}

//Clase concreta para un círculo
class Círculo extends Figura {
 private double radio;

 public Círculo(double radio) {
     this.radio = radio;
 }

 @Override
 public double calcularÁrea() {
     return Math.PI * radio * radio;
 }
}

//Clase concreta para un rectángulo
class Rectángulo extends Figura {
 private double ancho;
 private double alto;

 public Rectángulo(double ancho, double alto) {
     this.ancho = ancho;
     this.alto = alto;
 }

 @Override
 public double calcularÁrea() {
     return ancho * alto;
 }
}

public class ClaseYmetodoAbstracto {
 public static void main(String[] args) {
     Figura círculo = new Círculo(5.0);
     Figura rectángulo = new Rectángulo(4.0, 6.0);

     System.out.println("Área del círculo: " + círculo.calcularÁrea());
     System.out.println("Área del rectángulo: " + rectángulo.calcularÁrea());
 }
}
