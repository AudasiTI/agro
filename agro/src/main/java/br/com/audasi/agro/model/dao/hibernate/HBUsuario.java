package br.com.audasi.agro.model.dao.hibernate;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Usuario;
import br.com.audasi.agro.model.dao.DAOUsuario;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoUsuario")
public class HBUsuario extends HBDAO<Usuario> implements DAOUsuario {

	public Usuario getUsuario(long id) {
		Query query = getSession().createQuery("from Usuario u where u.id = ?");
		query.setLong(0, id);
		return (Usuario) query.uniqueResult();
	}

	public Usuario getUsuario(String login) {
		Query query = getSession().createQuery(
				"from Usuario u where u.login = ?");
		query.setString(0, login);
		return (Usuario) query.uniqueResult();
	}

	public Usuario getUsuario(String login, String senha) {
		Query query = getSession().createQuery(
				"from Usuario u where u.login = ? and u.senha = ?");
		query.setString(0, login);
		query.setString(1, senha);
		return (Usuario) query.uniqueResult();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

}
