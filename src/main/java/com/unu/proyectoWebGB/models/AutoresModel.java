package com.unu.proyectoWebGB.models;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

import com.unu.proyectoWebGB.beans.*;
import com.unu.proyectoWebGB.utils.Conexion;

import java.sql.*;


public class AutoresModel extends Conexion{
	

	/*public List<Autor> getlistarAutores(){
		
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor(1,"García Marquez", "Colombiana"));
		autores.add(new Autor(2,"Borges", "Argentina"));
		autores.add(new Autor(3,"Allende", "Chilena"));
		return autores;
	}*/
	
	
	CallableStatement cs;
	ResultSet rs;
	
	

	
	
	public List<Autor> listarAutores() throws SQLException{
		 try {
				 List<Autor> lista = new ArrayList<>();
				 String sql = "CALL sp_listarAutores()";
				 this.abrirConexion();
				 cs = conexion.prepareCall(sql);
				 rs = cs.executeQuery();
				 
				 
				 while(rs.next()){
					 
				 Autor autor = new Autor();
				 autor.setIdAutor(rs.getInt("idautor"));
				 autor.setNombre(rs.getString("nombre"));
				 autor.setNacionalidad(rs.getString("nacionalidad"));
				 lista.add(autor);
			 }
				 
				 
			 this.cerrarConexion();
			 
			 
			 return lista;
			 
			 } catch (SQLException ex) {
			 Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.cerrarConexion();;
			 return null;
			 }
			 }

	

}
