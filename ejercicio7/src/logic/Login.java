package logic;

import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr= new DataRol();
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
	
	public Persona add(Persona pers) {
		return(dp.add(pers));
	}
	
	public Persona update(Persona p) {
		return(dp.update(p));
	}
	
	public void delete(Persona p) {
		dp.delete(p);
	}
}