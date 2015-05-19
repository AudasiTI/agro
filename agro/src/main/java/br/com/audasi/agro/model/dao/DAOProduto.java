package br.com.audasi.agro.model.dao;

import br.com.audasi.agro.entity.Produto;

public interface DAOProduto extends DAOBase<Produto> {

	public Produto getProduto(int id);

	public Produto getProduto(String nome);
}
