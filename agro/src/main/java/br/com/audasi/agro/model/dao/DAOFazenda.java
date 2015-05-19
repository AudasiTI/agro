/**
 * 
 */
package br.com.audasi.agro.model.dao;

import java.util.List;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.entity.Fazenda;

/**
 * @author jocemar
 *
 */
public interface DAOFazenda extends DAOBase<Fazenda> {

	public Fazenda getFazenda(long id);

	public Fazenda getFazenda(String nome);
	
	public List<Fazenda> getFazendasPorConta(Conta conta, int offset, int max);

}
