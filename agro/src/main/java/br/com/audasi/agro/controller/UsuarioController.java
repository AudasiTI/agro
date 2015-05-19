package br.com.audasi.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Usuario;
import br.com.audasi.agro.model.dao.DAOUsuario;

@RestController
public class UsuarioController {

	@Autowired
	private DAOUsuario daoUsuario;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String autentica(@RequestParam("login") String login,
			@RequestParam("senha") String senha) {
		Usuario usuario = daoUsuario.getUsuario(login, senha);
		if (usuario == null) {
			return "Falha";
		} else {
			return "Sucesso";
		}
	}

	@RequestMapping(value = "/usuario/{login}", method = RequestMethod.GET)
	@ResponseBody
	public Usuario usuarioPorLogin(@PathVariable("login") String login) {
		return daoUsuario.getUsuario(login);
	}

}
