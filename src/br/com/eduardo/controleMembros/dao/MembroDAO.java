package br.com.eduardo.controleMembros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.eduardo.controleMembros.model.Membro;
import br.com.eduardo.controleMembros.util.ConnectionFactory;

public class MembroDAO {
	private Connection connection;
		
	public MembroDAO(Connection connection) {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Membro membro) {
		String sql = "insert into membro (nome,idEndereco,telefoneResidencial,celular,dataNascimento, foto,idProfissao)"
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, membro.getNome());
			pstm.setInt(2, membro.getEndereco());
			pstm.setString(3, membro.getTelefoneResidencial());
			pstm.setString(4, membro.getTelefoneCelular());
			pstm.setDate(5, java.sql.Date.valueOf(membro.getDataNascimento()));
			pstm.setBytes(6, membro.getFoto());
			pstm.setInt(7, membro.getIdProfissao());
			
			
			//executa o prepare Statement	
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Membro membro){
		try {
			PreparedStatement pstm = connection.prepareStatement("delete from membro where id=?");
			pstm.setLong(1, membro.getCodigoMembro());
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			
	}
	
	public void atualiza(Membro membro){
		try{
			PreparedStatement pstm = connection.prepareStatement("update membro set nome=?, idEndereco=?,telefoneResidencial=?,celular=?,dataNascimento=?, foto=?,idProfissao=?	"
					+ "where codigoMembro=? ");
			pstm.setString(1, membro.getNome());
			pstm.setInt(2, membro.getEndereco());
			pstm.setString(3, membro.getTelefoneResidencial());
			pstm.setString(4, membro.getTelefoneCelular());
			pstm.setDate(5, java.sql.Date.valueOf(membro.getDataNascimento()));
			pstm.setBytes(6, membro.getFoto());
			pstm.setInt(6, membro.getIdProfissao());
			pstm.setLong(7, membro.getCodigoMembro());
			pstm.execute();
			pstm.close();	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
