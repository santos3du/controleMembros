package br.com.eduardo.controleMembros.model;

import java.time.LocalDate;


/*
 * Classe modelo para o cadastro de Membros
 * @author : Eduardo Santos
 * data da criação: 03/05/2016
 * 
 */
public class Membro {
	private Integer id;
	private String nome;
	private String endereco;
	private String telefoneResidencial;
	private String celular;
	private LocalDate dataNascimento;
	private byte[]foto;
	private String profissao;
	private boolean isBatizado;
	private boolean isDizimista;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
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
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String idProfissao) {
		this.profissao = idProfissao;
	}
	public boolean isBatizado() {
		return isBatizado;
	}
	public void setBatizado(boolean isBatizado) {
		this.isBatizado = isBatizado;
	}
	public boolean isDizimista() {
		return isDizimista;
	}
	public void setDizimista(boolean isDizimista) {
		this.isDizimista = isDizimista;
	}

}	