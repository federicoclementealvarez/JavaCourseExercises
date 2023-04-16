package entities;

import java.sql.*;
import data.*;
import java.util.LinkedList;

public class Producto{

	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	
	public String toString() {
		return("Producto: [id: "+this.getId()+", nombre: "+this.getName()+"]");
	}
	
	public static void main(String[] args) {
		Producto prod;
		LinkedList<Producto> lista = new LinkedList<>();
		
		Statement stmt = null;
		ResultSet rs=null;
		try {
			stmt = DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id,name from productos");
			if(rs!=null) {
				while(rs.next()) {
					prod = new Producto();
					prod.setId(rs.getInt("id"));
					prod.setName(rs.getString("name"));
					lista.add(prod);
				}
			}
			if (rs!=null) {rs.close();}
			if (stmt!=null) {stmt.close();}
			DbConnector.getInstancia().releaseConn();
		}catch (SQLException e) {
			e.printStackTrace();}
		
		for(int i=0;i<=2;i++) {
			System.out.println(lista.get(i).toString());
		}
	}
}
