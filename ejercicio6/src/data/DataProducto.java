package data;

import java.sql.*;
import java.util.LinkedList;
import entities.*;

public class DataProducto {

	public LinkedList<Producto> list() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Producto> productos = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select id,name,description,price,stock,shippingIncluded from productos");
			if (rs!=null) {
				while (rs.next()) {
					Producto prod = new Producto();
					prod.setId(rs.getInt("id"));
					prod.setName(rs.getString("name"));
					prod.setDescription(rs.getString("description"));
					prod.setPrice(rs.getDouble("price"));
					prod.setStock(rs.getInt("stock"));
					prod.setShippingIncluded(rs.getBoolean("shippingIncluded"));
					productos.add(prod);
				}
			}
			
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
		finally {
			try {
				if (rs!=null) {rs.close();};
				if (stmt!=null) {stmt.close();};
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException ex){
				ex.printStackTrace();
			}
		}
			
		return (productos);
	}
	
	
	public Producto search (Producto prod) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Producto prodFound = null;
		try {
			stmt= DbConnector.getInstancia().getConn().prepareStatement("Select id,name,description,price,stock,shippingIncluded from productos where id=?");
			stmt.setInt(1,prod.getId());
			rs = stmt.executeQuery();
			if (rs!=null && rs.next()) {
				prodFound = new Producto();
				prodFound.setId(rs.getInt("id"));
				prodFound.setName(rs.getString("name"));
				prodFound.setDescription(rs.getString("description"));
				prodFound.setPrice(rs.getDouble("price"));
				prodFound.setStock(rs.getInt("stock"));
				prodFound.setShippingIncluded(rs.getBoolean("shippingIncluded"));
			}
		}
		catch (SQLException ex){
			ex.getStackTrace();
		}
		finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException ex) {
				ex.getStackTrace();
			}
		}
		
		return(prodFound);
	}
	
}
