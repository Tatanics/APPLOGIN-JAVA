/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jonathan Alexis Sanchez Rodriguez
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/app_login";
    private static final String USUARIO = "root";       
    private static final String PASSWORD = "MyNewPass1";         
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection conexion = null;
    
    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                System.out.println("Conexión establecida correctamente.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con MySQL: " + e.getMessage());
        }
        return conexion;
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar: " + e.getMessage());
        }
    }
}
