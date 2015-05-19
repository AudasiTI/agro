package br.com.audasi.agro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Safra;
import br.com.audasi.agro.model.dao.DAOConta;
import br.com.audasi.agro.model.dao.DAOProduto;
import br.com.audasi.agro.model.dao.DAOSafra;

@RestController
public class SafraController {

	@Autowired
	private DAOSafra daoSafra;

	@Autowired
	private DAOProduto daoProduto;

	@Autowired
	private DAOConta daoConta;

	@RequestMapping(value = "/safra/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Safra safraPorID(@PathVariable("id") int id) {
		return daoSafra.getSafra(id);
	}

	@RequestMapping(value = "/safra", method = RequestMethod.POST)
	@ResponseBody
	public Safra adicionar(@RequestParam("ano") int ano,
			@RequestParam("sequencia") int sequencia,
			@RequestParam("idproduto") int idproduto,
			@RequestParam("ativo") Boolean ativo) {
		Safra safra = new Safra();
		safra.setAno(ano);
		safra.setSequencia(sequencia);
		safra.setAtivo(ativo);
		safra.setProduto(daoProduto.getProduto(idproduto));
		daoSafra.persistir(safra);
		return safra;
	}

	@RequestMapping(value = "/safras/conta/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Safra> safrasPorConta(@PathVariable("id") Long id) {
		List<Safra> lista = new ArrayList<Safra>();
		lista.addAll(daoSafra.getSafrasPorConta(daoConta.getConta(id), 0, 100));
		return lista;
	}
}
