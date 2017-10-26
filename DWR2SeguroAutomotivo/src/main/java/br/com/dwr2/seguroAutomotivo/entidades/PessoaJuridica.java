package br.com.dwr2.seguroAutomotivo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Segurado implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cnpj;
	private String nomeFantasia;
	private String inscricaoEstadual;

	public PessoaJuridica() {
	}

	@Column(name = "cnpj", length = 30, nullable = true)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nome_fantasia", length = 100, nullable = true)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "inscricao_estadual", length = 50, nullable = true)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(getCnpj()).append("\n");
		output.append(getNomeFantasia()).append("\n");
		output.append(getInscricaoEstadual()).append("\n");
		return output.toString();
	}
}
