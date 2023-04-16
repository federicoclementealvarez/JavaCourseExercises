package ej5bEntidades;

public class Administrativo extends Empleado {
	
	private float hsExtra;
	private float hsMes;
	
	public float getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public float getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) { 
		this.hsMes = hsMes;
	}
	

	public Administrativo(int dni, String nombre, String apellido, String email, float sueldoBase, float hsExtra, float hsMes) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.hsMes=hsMes;
		this.hsExtra=hsExtra;
	}
	
	public float getSueldo() {
		return(this.getSueldoBase() * (this.getHsExtra()*((float)1.5)+this.getHsMes()) /this.getHsMes());
	}
	
	
}
