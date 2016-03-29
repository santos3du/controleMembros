package br.com.eduardo.controleMembros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.eduardo.controleMembros.model.Profissao;
import br.com.eduardo.controleMembros.util.ConnectionFactory;

public class ProfissaoDAO {
	private Connection connection;
	
	
	public ProfissaoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Profissao p){
		try {
			String sql = "insert into profissao (id,profissao)values(?,?)";
			PreparedStatement pstm = connection.prepareStatement(sql);
			
			pstm.setString(1, p.);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
