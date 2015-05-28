package br.com.audasi.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Status;
import br.com.audasi.agro.entity.Usuario;
import br.com.audasi.agro.model.dao.DAOUsuario;

@RestController
public class UsuarioController {

	@Autowired
	private DAOUsuario daoUsuario;

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody Status autentica(@RequestBody Usuario user) {
		Usuario usuario = daoUsuario.getUsuario(user.getLogin(),
				user.getPassword());
		if (usuario == null) {
			return new Status(false);
		} else {
			return new Status(true);
		}
	}

	@RequestMapping(value = "/usuario/{login}", method = RequestMethod.GET)
	@ResponseBody
	public Usuario usuarioPorLogin(@PathVariable("login") String login) {
		return daoUsuario.getUsuario(login);
	}

}
