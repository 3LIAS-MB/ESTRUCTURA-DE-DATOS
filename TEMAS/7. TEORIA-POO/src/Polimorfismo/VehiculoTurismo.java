package Polimorfismo;

public class VehiculoTurismo extends Vehiculo{
	private int nPuertas;
	
	public VehiculoTurismo(int nPuertas, String matricula, String marca, String modelo) {
		super(matricula, marca, modelo);
		this.nPuertas = nPuertas;
	}
	
	public int gerPuertas() {
		return nPuertas;
	}
	
	@Override
	public String mostrarDatos() {
		return "\nMatricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo + "\nNumero de puertas:  " + nPuertas;
	}
}
