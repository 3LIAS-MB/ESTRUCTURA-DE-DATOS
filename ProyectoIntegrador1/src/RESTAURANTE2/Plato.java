package RESTAURANTE2;
public class Plato {
    private int codigo;
    private String descripcion;
    private double precioUnitario;

    public Plato(int codigo, String descripcion, double precioUnitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
