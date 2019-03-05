package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Define uma classe controller dentro do projeto
 * @author mac-regis
 *
 */
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	/**
	 * Mapeia as requisicoes e define um metodo que retorna uma view.
	 * @return
	 */
//	@RequestMapping("/")
//	public String home() {
//		System.out.println("Exibindo a home da CDC ");
//		return "home";
//	}
	/**
	 * envia uma lista de produtos para a view
	 * @return
	 */
	@RequestMapping("/")
	@Cacheable(value="produtosHome")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Produto> produtos = produtoDao.listar();
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
}
