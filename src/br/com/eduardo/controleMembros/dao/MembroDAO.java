package br.com.eduardo.controleMembros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eduardo.controleMembros.model.Membro;
import br.com.eduardo.controleMembros.util.ConnectionFactory;

public class MembroDAO {
	private Connection connection;

	public MembroDAO(Connection connection) {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Membro membro) {
		String sql = "insert into membro (nome,endereco,telefoneResidencial,celular,dataNascimento, foto,profissao,isBatizado, isDizimista)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, membro.getNome());
			pstm.setString(2, membro.getEndereco());
			pstm.setString(3, membro.getTelefoneResidencial());
			pstm.setString(4, membro.getCelular());
			pstm.setDate(5, java.sql.Date.valueOf(membro.getDataNascimento()));
			pstm.setBytes(6, membro.getFoto());
			pstm.setString(7, membro.getProfissao());
			pstm.setBoolean(8, membro.isBatizado());
			pstm.setBoolean(9, membro.isDizimista());
			
			// executa o prepared Statement
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void exclui(Membro membro) {
		try {
			PreparedStatement pstm = connection.prepareStatement("delete from membro where id=?");
			pstm.setInt(1, membro.getId());
			pstm.execute();
			pstm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void atualiza(Membro membro) {
		try {
			PreparedStatement pstm = connection.prepareStatement(
					"update membro set nome=?, idEndereco=?,telefoneResidencial=?,celular=?,dataNascimento=?, foto=?,idProfissao=?	"
							+ "where codigoMembro=? ");
			pstm.setString(1, membro.getNome());
			pstm.setString(2, membro.getEndereco());
			pstm.setString(3, membro.getTelefoneResidencial());
			pstm.setString(4, membro.getCelular());
			pstm.setDate(5, java.sql.Date.valueOf(membro.getDataNascimento()));
			pstm.setBytes(6, membro.getFoto());
			pstm.setString(6, membro.getProfissao());
			pstm.setLong(7, membro.getId());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Membro> listarMembros(){
		//TODO: Terminar método de listagem
		try{
			List<Membro> listaMembros = new ArrayList<Membro>();
			PreparedStatement pstm = connection.prepareStatement("select * from membro");
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				Membro membro = new Membro();
				membro.setId(rs.getInt("id"));
				membro.setNome(rs.getString("nome"));
				membro.setTelefoneResidencial(rs.getString("telefoneResidencial"));
				membro.	setCelular(rs.getString("telefoneCelular"));
				membro.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
				membro.setFoto(rs.getBytes("foto"));
				membro.setProfissao(rs.getString("profissao"));
				membro.setBatizado(true);
				membro.setDizimista(true);
				listaMembros.add(membro);
			}
			
			rs.close();
			pstm.close();
			
			return listaMembros;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
