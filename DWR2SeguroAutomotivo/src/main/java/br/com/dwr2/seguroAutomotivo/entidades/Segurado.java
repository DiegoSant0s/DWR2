package br.com.dwr2.seguroAutomotivo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "segurado")
public abstract class Segurado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private Date dataCadastro;
	private String nome;
	private String email;
	private String observacao;
	private String ocupacaoProficional;
	private TipoPessoa tipo;
	private Endereco endereco;
	private List<Telefone> telefones;

	public Segurado() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", nullable = false, unique = true, updatable = false)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false, updatable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "nome", length = 100, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", length = 100, nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "observacao", columnDefinition = "text", nullable = true)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Column(name = "ocupacao_proficional", length = 50, nullable = true)
	public String getOcupacaoProficional() {
		return ocupacaoProficional;
	}

	public void setOcupacaoProficional(String ocupacaoProficional) {
		this.ocupacaoProficional = ocupacaoProficional;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", nullable = false)
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	@OneToOne(mappedBy = "segurado", fetch = FetchType.EAGER)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(mappedBy = "segurado", fetch = FetchType.EAGER)
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segurado other = (Segurado) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(getCodigo()).append("\n");
		output.append(getEmail()).append("\n");
		output.append(getNome()).append("\n");
		output.append(getObservacao()).append("\n");
		output.append(getOcupacaoProficional()).append("\n");
		output.append(getDataCadastro().toString()).append("\n");
		output.append(getTipo().name()).append("\n");
		return output.toString();
	}

}
