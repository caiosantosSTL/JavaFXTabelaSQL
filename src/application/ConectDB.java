package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectDB {
	
	String url = "jdbc:sqlite:/Users/Roberto/Documents/ECLIPSE PROYECTOS/TabelaFX/src/application/BazDat/exportDB2.db";
	Connection con;
	
	///******************************************************** Conex
	public Connection Conect() {
		try {
			con= DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conex foi");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("nao foi conex "+e);
		}
		return con;
	}

}
