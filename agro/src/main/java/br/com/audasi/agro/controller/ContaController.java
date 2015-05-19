package br.com.audasi.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.model.dao.DAOConta;

@RestController
public class ContaController {

	@Autowired
	private DAOConta daoConta;

	@RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Conta contaPorID(@PathVariable("id") Long id) {
		return daoConta.getConta(id);
	}

}
