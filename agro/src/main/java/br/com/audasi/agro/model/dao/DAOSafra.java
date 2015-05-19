package br.com.audasi.agro.model.dao;

import java.util.List;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.entity.Safra;


public interface DAOSafra extends DAOBase<Safra> {

	public Safra getSafra(long id);

	public Safra getSafra(int ano, int sequencia);
	
	public List<Safra> getSafrasPorConta(Conta conta, int offset, int max);

}
