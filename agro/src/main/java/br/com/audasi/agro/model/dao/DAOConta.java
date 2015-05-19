package br.com.audasi.agro.model.dao;

import br.com.audasi.agro.entity.Conta;

public interface DAOConta extends DAOBase<Conta> {

	public Conta getConta(long id);

	public Conta getConta(String chave);
}
