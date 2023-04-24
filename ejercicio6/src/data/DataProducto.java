package data;

import java.sql.*;
import java.time.*;

import java.util.LinkedList;
import entities.*;

public class DataProducto {

	public LinkedList<Producto> list() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Producto> productos = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select id,name,description,price,stock,shippingIncluded,disabledOn from productos");
			if (rs!=null) {
				while (rs.next()) {
					Producto prod = new Producto();
					prod.setId(rs.getInt("id"));
					prod.setName(rs.getString("name"));
					prod.setDescription(rs.getString("description"));
					prod.setPrice(rs.getDouble("price"));
					prod.setStock(rs.getInt("stock"));
					prod.setShippingIncluded(rs.getBoolean("shippingIncluded"));
					prod.setDisabledOn(rs.getObject(("disabledOn"),LocalDateTime.class));
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
			stmt= DbConnector.getInstancia().getConn().prepareStatement("Select id,name,description,price,stock,shippingIncluded,disabledOn from productos where id=?");
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
				prodFound.setDisabledOn(rs.getObject(("disabledOn"),LocalDateTime.class));
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
	
	
	public Producto nuevo(Producto prod) {
		//Producto prodNew = null;
		PreparedStatement stmt = null;
		ResultSet  keyRS = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT INTO productos(name, description, price, stock, shippingIncluded, disabledOn) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, prod.getName());
			stmt.setString(2, prod.getDescription());
			stmt.setDouble(3, prod.getPrice());
			stmt.setInt(4, prod.getStock());
			stmt.setBoolean(5, prod.isShippingIncluded());
			stmt.setObject(6, prod.getDisabledOn());
			stmt.executeUpdate();
			keyRS=stmt.getGeneratedKeys();
			
			if (keyRS!=null && keyRS.next()) {
				prod.setId(keyRS.getInt(1));
			}
		}
		catch (SQLException ex) {
			ex.getStackTrace();
		}
		finally {
			try {
				if(keyRS!=null) {keyRS.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return(prod);
	}
	
	
	public void delete(Producto prod) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM productos WHERE id = ?");
			stmt.setInt(1, prod.getId());
			stmt.executeUpdate();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void update(Producto prod) {
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("UPDATE productos SET name=?, description=?, price=?, stock=?, shippingIncluded=?, disabledOn=? WHERE id=?");
			stmt.setString(1, prod.getName());
			stmt.setString(2, prod.getDescription());
			stmt.setDouble(3, prod.getPrice());
			stmt.setInt(4, prod.getStock());
			stmt.setBoolean(5, prod.isShippingIncluded());
			stmt.setObject(6, prod.getDisabledOn());
			stmt.setInt(7,prod.getId());
			stmt.executeUpdate();
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
