package br.com.audasi.agro.model.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.entity.Fazenda;
import br.com.audasi.agro.model.dao.DAOFazenda;

@Transactional(propagation=Propagation.SUPPORTS)
@Repository("daoFazenda")
public class HBFazenda extends HBDAO<Fazenda> implements DAOFazenda {

	public Fazenda getFazenda(String nome) {
		Query query = getSession().createQuery("from Fazenda f where f.nome = ?");
		query.setString(0, nome);
		return (Fazenda) query.uniqueResult();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Fazenda.class;
	}

	public Fazenda getFazenda(long id) {
		Query query = getSession().createQuery("from Fazenda f where f.id = ? ");
		query.setLong(0, id);
		return (Fazenda) query.uniqueResult();	
	}
	
	public List<Fazenda> getFazendasPorConta(Conta conta, int offset, int max) {
		Query busca = getSession().createQuery("from Fazenda f where f.conta = ?");
		busca.setEntity(0, conta);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

}
