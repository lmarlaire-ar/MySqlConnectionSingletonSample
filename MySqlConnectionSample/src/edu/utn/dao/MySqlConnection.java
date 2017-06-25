package edu.utn.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class MySqlConnection {
	
	/* REM para Singleton
	 * 1 - Variable estática
	 * 2 - constructor privado
	 * 3 - Estructura inicializacion del objeto --> Singleton
	 * 4 - Inicializacion del objeto
	*/

	
	// Constantes de la BD
	private static MySqlConnection instance;  	// 1)
	private static String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/modavanzadotp1";
	private static String USER = "root";
	private static String PASS = "";
//	private static final String MAX_POOL = "250";
	
	// init connection object
	private Connection conexion;
	// init properties object
//	private Properties properties;
	
	private MySqlConnection(){} 					//2)

	public static MySqlConnection newInstance(){ 	//3)
		if (instance == null){
			instance = new MySqlConnection();		//4)
			System.out.println("instancia a la BD creada");
		}
		return instance;
	}
	
		
	// Conección a la BD
	public Connection connectDB() {
	    if (conexion == null) {
	        try {
	            Class.forName(DB_DRIVER);
	            conexion = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
//	            connection = (Connection) DriverManager.getConnection(DB_URL, getProperties()); // Usando Properties
	        } catch (ClassNotFoundException | SQLException ex) {
//	            e.printStackTrace();
	        	  System.out.println("SQLException: " + ex.getMessage());
	        }
	    }
	    return conexion;
	}
	
	public void disconnectDB() {
		  if(conexion != null) {
		    try {
		      conexion.close();
		      conexion = null;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		  }
	}
	
//	private Properties getProperties() {
//		  if(properties == null) {
//		    properties = new Properties();
//		    properties.setProperty("user", USER);
//		    properties.setProperty("password", PASS);
//		    properties.setProperty("MaxPooledStatements", MAX_POOL);
//		  }
//		  return properties;
//		}
}
