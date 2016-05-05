package br.com.eduardo.controleMembros.util;

import java.sql.Connection;

public class ConnectionFactoryTest {
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		if(con != null){
			System.out.println("Conexão aberta");
		}else{
			System.out.println("Falha ao conectar no banco de dados.");
		}
		
	}
}
