package br.com.audasi.agro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@Generated(GenerationTime.INSERT)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConta", unique = true)
	protected long id;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@Column(name = "ativacao", nullable = false)
	private Date ativacao;

	@Column(name = "chave", nullable = false, length = 120)
	private String chave;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getAtivacao() {
		return ativacao;
	}

	public void setAtivacao(Date ativacao) {
		this.ativacao = ativacao;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

}
