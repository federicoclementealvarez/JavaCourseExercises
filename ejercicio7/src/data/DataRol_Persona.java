package data;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import entities.*;

public class DataRol_Persona {

	public void add(Persona pers, Rol rol) {
		PreparedStatement stmt = null;
		try {
		stmt = DbConnector.getInstancia().getConn().prepareStatement("INSERT INTO rol_persona(id_persona, id_rol) VALUES (?,?)");
		stmt.setInt(1,pers.getId());
		stmt.setInt(2,rol.getId());
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
			catch (SQLException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	
}
