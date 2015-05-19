package br.com.audasi.agro.model.dao;

import br.com.audasi.agro.entity.Usuario;

public interface DAOUsuario extends DAOBase<Usuario> {

	public Usuario getUsuario(long id);

	public Usuario getUsuario(String login);
	
	public Usuario getUsuario(String login, String senha);

}
