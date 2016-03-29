package br.com.eduardo.controleMembros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eduardo.controleMembros.model.Endereco;
import br.com.eduardo.controleMembros.util.ConnectionFactory;

public class EnderecoDAO {
	private Connection connection;
	
	public EnderecoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Endereco end){
		try {
			String sql = "insert into endereco(logradouro,numero,complemento,bairro,cidade,estado)values(?,?,?,?,?,?)";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, end.getLogradouro());
			pstm.setInt(2, end.getNumero());
			pstm.setString(3, end.getComplemento());
			pstm.setString(4, end.getBairro());
			pstm.setString(5, end.getCidade());
			pstm.setString(6, end.getEstado());
			pstm.execute();
			pstm.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Endereco end){
		try {
			String sql = "update endereco set logradouro=?, numero=?, complemento=?, bairro=? cidade=?,estado=?"
					+ "where id=?";
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, end.getLogradouro());
			pstm.setInt(2, end.getNumero());
			pstm.setString(3, end.getComplemento());
			pstm.setString(4, end.getBairro());
			pstm.setString(5, end.getCidade());
			pstm.setString(6, end.getEstado());
			pstm.setLong(7, end.getId());
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Endereco end){
		try {
			PreparedStatement pstm = connection.prepareStatement("delete from endereco where id=?");
			pstm.setInt(1, end.getId());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Endereco> listarEnderecos(){
		try {
			List<Endereco> listaEnderecos = new ArrayList<Endereco>();
			PreparedStatement pstm = connection.prepareStatement("select * from endereco");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Endereco end = new Endereco();
				end.setId(rs.getInt("id"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setNumero(rs.getInt("numero"));
				end.setComplemento(rs.getString("complemento"));
				end.setBairro(rs.getString("bairro"));
				end.setCidade(rs.getString("cidade"));
				end.setEstado(rs.getString("estado"));
				listaEnderecos.add(end);
			}
			rs.close();
			pstm.close();
			return listaEnderecos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
