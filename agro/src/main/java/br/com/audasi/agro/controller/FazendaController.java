package br.com.audasi.agro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.RequestWrapper;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Conta;
import br.com.audasi.agro.entity.Fazenda;
import br.com.audasi.agro.model.dao.DAOConta;
import br.com.audasi.agro.model.dao.DAOFazenda;

@RestController
public class FazendaController {

	@Autowired
	private DAOFazenda daoFazenda;

	@Autowired
	private DAOConta daoConta;

	@RequestMapping(value = "/fazenda/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Fazenda fazendaPorID(@PathVariable("id") Long id) {
		return daoFazenda.getFazenda(id);
	}

	@RequestMapping(value = "/fazenda", method = RequestMethod.GET)
	@ResponseBody
	public List<Fazenda> listaFazendas() {
		return daoFazenda.list(0, 100);
	}

	@RequestMapping(value = "/fazenda", method = RequestMethod.POST)
	public @ResponseBody Fazenda adicionar(@RequestBody final String novaFazenda) {
		Fazenda fazenda = new Fazenda();
		ObjectMapper mapper = new ObjectMapper();
		try {
			fazenda =  mapper.readValue(novaFazenda, Fazenda.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conta conta = new Conta();
		conta.setId(1);
		fazenda.setConta(conta);
		fazenda.setNome(novaFazenda);
		fazenda.setAtivo(true);
		daoFazenda.persistir(fazenda);
		return fazenda;
	}

	@RequestMapping(value = "/fazenda/conta/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Fazenda> fazendasPorConta(@PathVariable("id") Long id) {
		List<Fazenda> lista = new ArrayList<Fazenda>();
		lista.addAll(daoFazenda.getFazendasPorConta(daoConta.getConta(id), 0,
				100));
		return lista;
	}

}
