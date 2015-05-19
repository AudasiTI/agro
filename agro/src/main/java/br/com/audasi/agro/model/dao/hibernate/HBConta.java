package br.com.audasi.agro.model.dao.hibernate;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.model.dao.DAOConta;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoConta")
public class HBConta extends HBDAO<Conta> implements DAOConta {

	public Conta getConta(long id) {
		Query query = getSession().createQuery("from Conta c where c.id = ? ");
		query.setLong(0, id);
		return (Conta) query.uniqueResult();
	}

	public Conta getConta(String chave) {
		Query query = getSession().createQuery(
				"from Conta c where c.chave = ? ");
		query.setString(0, chave);
		return (Conta) query.uniqueResult();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Conta.class;
	}

}
