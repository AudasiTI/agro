package br.com.audasi.agro.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Fazenda;
import br.com.audasi.agro.model.dao.DAOFazenda;
import br.com.audasi.agro.model.dao.DAOSafra;
import br.com.audasi.agro.model.dao.DAOTalhao;

@RestController
public class HomeController {

	@Autowired
	private DAOFazenda daoFazenda;
	@Autowired
	private DAOSafra daoSafra;
	@Autowired
	private DAOTalhao daoTalhao;

	public DAOFazenda getDaoFazenda() {
		return daoFazenda;
	}

	public DAOSafra getDaoSafra() {
		return daoSafra;
	}

	public DAOTalhao getDaoTalhao() {
		return daoTalhao;
	}

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		model.put("fazendas", getDaoFazenda().list(0, 100));
		model.put("safras", getDaoSafra().list(0, 100));
		return "index";
	}


}
