package br.com.audasi.agro.model.dao.hibernate;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.audasi.agro.entity.Produto;
import br.com.audasi.agro.model.dao.DAOProduto;

@Transactional(propagation = Propagation.SUPPORTS)
@Repository("daoProduto")
public class HBProduto extends HBDAO<Produto> implements DAOProduto {

	public Produto getProduto(int id) {
		Query query = getSession().createQuery("from Produto p where p.id = ? ");
		query.setInteger(0, id);
		return (Produto) query.uniqueResult();
	}

	public Produto getProduto(String nome) {
		Query query = getSession().createQuery("from Produto p where p.nome = ?");
		query.setString(0, nome);
		return (Produto) query.uniqueResult();
	}

	@Override
	protected Class getClazz() {
		// TODO Auto-generated method stub
		return Produto.class;
	}
	
	

}
