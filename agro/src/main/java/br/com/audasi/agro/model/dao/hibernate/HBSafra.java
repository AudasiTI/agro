package br.com.audasi.agro.model.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.entity.Produto;
import br.com.audasi.agro.entity.Safra;
import br.com.audasi.agro.model.dao.DAOSafra;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoSafra")
public class HBSafra extends HBDAO<Safra> implements DAOSafra {

	public Safra getSafra(long id) {
		Query query = getSession().createQuery("from Safra s where s.id = ? ");
		query.setLong(0, id);
		return (Safra) query.uniqueResult();
	}

	public Safra getSafra(int ano, int sequencia) {
		Query query = getSession().createQuery(
				"from Safra s where s.ano = ? and s.sequencia = ?");
		query.setInteger(0, ano);
		query.setInteger(1, sequencia);
		return (Safra) query.uniqueResult();
	}

	public List<Safra> getSafrasPorProduto(Produto produto, int offset, int max) {
		Query busca = getSession().createQuery(
				"from Safra s where s.produto = ?");
		busca.setEntity(0, produto);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

	public List<Safra> getSafrasPorConta(Conta conta, int offset, int max) {
		Query busca = getSession()
				.createQuery("from Safra s where s.conta = ?");
		busca.setEntity(0, conta);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Safra.class;
	}

}
