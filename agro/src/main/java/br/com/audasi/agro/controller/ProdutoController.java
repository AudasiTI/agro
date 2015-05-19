package br.com.audasi.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.audasi.agro.entity.Produto;
import br.com.audasi.agro.model.dao.DAOProduto;

@RestController
public class ProdutoController {

	@Autowired
	private DAOProduto daoProduto;

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Produto produtoPorID(@PathVariable("id") int id) {
		return daoProduto.getProduto(id);
	}

	@RequestMapping(value = "/produto", method = RequestMethod.POST)
	@ResponseBody
	public Produto adicionar(@RequestParam("nome") String nome) {
		Produto produto = new Produto();
		produto.setNome(nome);
		daoProduto.persistir(produto);
		return produto;
	}
}
