package br.com.eduardo.controleMembros.model;

import java.time.LocalDate;

public class Membro {
	private Long id;
	private String nome;
	private Integer endereco;
	private String telefoneResidencial;
	private String telefoneCelular;
	private LocalDate dataNascimento;
	private byte[]foto;
	private Integer idProfissao;
	
	public Integer getIdProfissao() {
		return idProfissao;
	}
	public void setIdProfissao(Integer idProfissao) {
		this.idProfissao = idProfissao;
	}
	public Long getCodigoMembro() {
		return id;
	}
	public void setCodigoMembro(Long codigoMembro) {
		this.id = codigoMembro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getEndereco() {
		return endereco;
	}
	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	

}
