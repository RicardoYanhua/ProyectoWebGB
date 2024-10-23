package com.unu.proyectoWebGB.utils;


import java.sql.*;

public class Conexion {
	


	private String url = "jdbc:mysql://localhost:3306/bdbiblioteca"; // URL de la base de datos
    private String usuario = "root"; // Usuario de la base de datos
    private String contrasena = "123456"; // Contraseña de la base de datos
    protected Connection conexion;

	
 // Método para abrir la conexión
    public void abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            conexion = DriverManager.getConnection(url, usuario, contrasena); // Establecer la conexión
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error de coenxion");
        }
    }

	
	public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close(); // Cierra la conexión
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
