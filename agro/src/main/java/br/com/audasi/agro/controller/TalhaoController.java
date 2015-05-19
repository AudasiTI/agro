package br.com.audasi.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Talhao;
import br.com.audasi.agro.model.dao.DAOFazenda;
import br.com.audasi.agro.model.dao.DAOSafra;
import br.com.audasi.agro.model.dao.DAOTalhao;

@RestController
public class TalhaoController {

	@Autowired
	private DAOTalhao daoTalhao;

	@Autowired
	private DAOSafra daoSafra;

	@Autowired
	private DAOFazenda daoFazenda;

	@RequestMapping(value = "/talhao/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Talhao talhaoPorID(@PathVariable("id") int id) {
		return daoTalhao.getTalhao(id);
	}

	@RequestMapping(value = "/talhao", method = RequestMethod.POST)
	@ResponseBody
	public Talhao adicionar(@RequestParam("nome") String nome,
			@RequestParam("area") Float area,
			@RequestParam("idsafra") Long idsafra,
			@RequestParam("idfazenda") long idfazenda,
			@RequestParam("ativo") Boolean ativo) {
		Talhao talhao = new Talhao();
		talhao.setNome(nome);
		talhao.setArea(area);
		talhao.setSafra(daoSafra.getSafra(idsafra));
		talhao.setFazenda(daoFazenda.getFazenda(idfazenda));
		talhao.setAtivo(ativo);
		daoTalhao.persistir(talhao);
		return talhao;
	}
}
