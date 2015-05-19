package br.com.audasi.agro.model.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Fazenda;
import br.com.audasi.agro.entity.Safra;
import br.com.audasi.agro.entity.Talhao;
import br.com.audasi.agro.model.dao.DAOTalhao;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoTalhao")
public class HBTalhao extends HBDAO<Talhao> implements DAOTalhao {

	public Talhao getTalhao(int id) {
		Query query = getSession().createQuery(
				"from talhao t where t.idTalhao = ? ");
		query.setInteger(0, id);
		return (Talhao) query.uniqueResult();
	}

	public Talhao getTalhao(String nome) {
		Query query = getSession()
				.createQuery("from talhao t where t.nome = ?");
		query.setString(0, nome);
		return (Talhao) query.uniqueResult();
	}

	public List<Talhao> getTalhoesPorFazenda(Fazenda fazenda, int offset,
			int max) {
		Query busca = getSession().createQuery(
				"from Talhao talhao where talhao.fazenda = ?");
		busca.setEntity(0, fazenda);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

	public List<Talhao> getTalhoesPorSafra(Safra safra, int offset, int max) {
		Query busca = getSession().createQuery(
				"from Talhao talhao where talhao.safra = ?");
		busca.setEntity(0, safra);
		busca.setMaxResults(max);
		busca.setFirstResult(offset);
		return busca.list();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Talhao.class;
	}

}
