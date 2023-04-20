package logic;

import data.*;
import entities.*;
import java.util.LinkedList;

public class Login {

	private DataProducto datap;

	public Login() {
		datap = new DataProducto();
	}
	
	public LinkedList<Producto> list() {
		return(datap.list());
	}
	
	public Producto search (Producto prod) {
		return (datap.search(prod));
	}
}
