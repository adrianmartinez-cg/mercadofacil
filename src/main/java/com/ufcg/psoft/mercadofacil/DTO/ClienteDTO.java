package com.ufcg.psoft.mercadofacil.DTO;

public class ClienteDTO {

	private Long cpf;
	
	private String nome;

	private Integer idade;

	private String endereco;
	
	private String perfil;
	
	public String getNome() {
		return nome;
	}
	
	public Long getCPF() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public String getPerfil() {
		return perfil;
	}
}
