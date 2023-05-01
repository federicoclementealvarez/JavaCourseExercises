package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	private DataRol_Persona drp;
	
	public Login() {
		dp=new DataPersona();
		dr= new DataRol();
		drp = new DataRol_Persona();
	}
	
	public Persona validate(Persona p) {
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Persona> getByAp(Persona pers){
		return(dp.getByAp(pers));
	}
	
	public Rol getById(Rol rol) {
		return(dr.getById(rol));
	}
	
	public void add(Persona pers) {
		dp.add(pers);
	}
	
	public void add(Persona pers, Rol rol) {
		drp.add(pers, rol);
	}
}