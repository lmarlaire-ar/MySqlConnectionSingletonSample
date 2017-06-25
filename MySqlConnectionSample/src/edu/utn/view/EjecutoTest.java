package edu.utn.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.*;

import edu.utn.dao.MySqlConnection;

public class EjecutoTest {

	public static void main(String[] args) {
		
		
		MySqlConnection conx = MySqlConnection.newInstance();
	
		String query = "SELECT * FROM directortecnico";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conx.connectDB().createStatement();
			//rs = stmt.executeQuery(query);
			
			if (stmt.execute(query)) {
			    rs = stmt.getResultSet();
			}
		
			while (rs.next()){
				System.out.println(rs.getString("nombre")+" "+rs.getString("apellido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{ //Libero recursos
			if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { }

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } 

		        stmt = null;
		    }
		}
	}

}
