package data;
import entities.*;
import java.sql.*;
import java.util.LinkedList;

public class DataPersona {
	
	public LinkedList<Persona> getAll(){
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> pers= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Persona p=new Persona();
					p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.getDocumento().setTipo(rs.getString("tipo_doc"));
					p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					pers.add(p);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return pers;
	}
	
	
	public Persona getByDocumento(Persona per) {
		DataRol dr=new DataRol();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where tipo_doc=? and nro_doc=?"
					);
			stmt.setString(1, per.getDocumento().getTipo());
			stmt.setString(2, per.getDocumento().getNro());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	
	public LinkedList<Persona> getByAp(Persona per) {
		DataRol dr=new DataRol();
		LinkedList<Persona> listp= new LinkedList<>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where apellido like ?"
					);
			stmt.setString(1, "%"+per.getApellido()+"%");
			rs=stmt.executeQuery();
			if(rs!=null) {
				while (rs.next()) {
					Persona p=new Persona();
					p.setDocumento(new Documento());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.getDocumento().setTipo(rs.getString("tipo_doc"));
					p.getDocumento().setNro(rs.getString("nro_doc"));
					p.setEmail(rs.getString("email"));
					p.setTel(rs.getString("tel"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					
					dr.setRoles(p);
					
					listp.add(p);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listp;
	}
	
	
	
	public Persona getByUser(Persona per) {
		DataRol dr=new DataRol();
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id,nombre,apellido,tipo_doc,nro_doc,email,tel,habilitado from persona where email=? and password=?"
					);
			stmt.setString(1, per.getEmail());
			stmt.setString(2, per.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Persona();
				p.setDocumento(new Documento());
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.getDocumento().setTipo(rs.getString("tipo_doc"));
				p.getDocumento().setNro(rs.getString("nro_doc"));
				p.setEmail(rs.getString("email"));
				p.setTel(rs.getString("tel"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				//
				dr.setRoles(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	
	public Persona add(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into persona(nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado) values(?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDocumento().getTipo());
			stmt.setString(4, p.getDocumento().getNro());
			stmt.setString(5, p.getEmail());
			stmt.setString(6, p.getPassword());
			stmt.setString(7, p.getTel());
			stmt.setBoolean(8, p.isHabilitado());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
            
            this.setRol_Persona(p);
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return(p);
    }


	public Persona update(Persona p) {
		PreparedStatement stmt = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("UPDATE persona SET tipo_doc=?, nro_doc=?, nombre=?, apellido=?, email=?, tel=?, habilitado=?, password=? WHERE id=?");
			stmt.setString(1, p.getDocumento().getTipo());
			stmt.setString(2, p.getDocumento().getNro());
			stmt.setString(3, p.getNombre());
			stmt.setString(4, p.getApellido());
			stmt.setString(5, p.getEmail());
			stmt.setString(6, p.getTel());
			stmt.setBoolean(7, p.isHabilitado());
			stmt.setString(8, p.getPassword());
			stmt.setInt(9, p.getId());
			stmt.executeUpdate();
			
			this.deleteRol_Persona(p);
			this.setRol_Persona(p);
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException error) {
				error.printStackTrace();
			}
		}
		
		return(p);
	}
	
	public void delete (Persona p) {
		this.deleteRol_Persona(p);
		PreparedStatement stmt = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM persona WHERE id=?");
			stmt.setInt(1, p.getId());
			stmt.executeUpdate();
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException error) {
				error.printStackTrace();
			}
		}
	}
	
	private void setRol_Persona(Persona p) {
		DataRol dr=new DataRol();
		LinkedList <Rol> roles = dr.getAll();
        for(Rol r : roles) {
        	if (p.hasRol(r)) {
        		this.addRol_Persona(p,r);
        	}
        }
	}
	
	private void addRol_Persona(Persona p, Rol r) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("INSERT INTO rol_persona(id_persona, id_rol) VALUES (?,?)");
			stmt.setInt(1,p.getId());
			stmt.setInt(2,r.getId());
			stmt.executeUpdate();
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException error){
				error.printStackTrace();
			}
		}
	}
	
	private void deleteRol_Persona(Persona p) {
		PreparedStatement stmt = null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement("DELETE FROM rol_persona WHERE id_persona=?");
			stmt.setInt(1, p.getId());
			stmt.executeUpdate();
		}
		catch (SQLException error) {
			error.printStackTrace();
		}
		finally {
			try {
				if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
			}
			catch (SQLException error){
				error.printStackTrace();
			}
		}
	}
	
}
