package br.com.eduardo.controleMembros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/igreja", "root","223580");
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}
