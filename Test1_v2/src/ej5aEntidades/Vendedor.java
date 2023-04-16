package ej5aEntidades;

public class Vendedor extends Empleado {

	private float porcenComision;
	private float totalVentas;
	
	public float getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(float porcenComision) {
		this.porcenComision = porcenComision;
	}
	public float getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(float totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	public Vendedor(int dni, String nombre, String apellido, String email, float sueldoBase, float porcenComision, float totalVentas) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.porcenComision=porcenComision;
		this.totalVentas= totalVentas;
	}
	
	public float getSueldo() {
		return(this.getSueldoBase()+(this.getPorcenComision()*this.getTotalVentas()/100));
	}
}
