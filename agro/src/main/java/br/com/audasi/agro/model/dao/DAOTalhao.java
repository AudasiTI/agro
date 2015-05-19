package br.com.audasi.agro.model.dao;

import br.com.audasi.agro.entity.Talhao;

public interface DAOTalhao extends DAOBase<Talhao> {

	public Talhao getTalhao(int id);

	public Talhao getTalhao(String nome);
}
