package br.com.dwr2.seguroAutomotivo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Segurado implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private Date dataNascimento;
	private int flagSexo;
	private int flagEstadoCivil;

	public PessoaFisica() {
	}

	@Column(name = "cpf", length = 20, nullable = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "data_nascimento", nullable = true)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "flag_sexo", length = 5, nullable = true)
	public int getFlagSexo() {
		return flagSexo;
	}

	public void setFlagSexo(int flagSexo) {
		this.flagSexo = flagSexo;
	}

	@Column(name = "flag_estado_civil", length = 5, nullable = true)
	public int getFlagEstadoCivil() {
		return flagEstadoCivil;
	}

	public void setFlagEstadoCivil(int flagEstadoCivil) {
		this.flagEstadoCivil = flagEstadoCivil;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(getCpf()).append("\n");
		output.append(getDataNascimento().toString()).append("\n");
		output.append(getFlagEstadoCivil()).append("\n");
		output.append(getFlagSexo()).append("\n");
		return output.toString();
	}
}
