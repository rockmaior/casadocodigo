package br.com.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Define uma classe controller dentro do projeto
 * @author mac-regis
 *
 */
@Controller
public class HomeController {
	/**
	 * Mapeia as requisicoes e define um metodo que retorna uma view.
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		System.out.println("Exibindo a home da CDC ");
		return "home";
	}
}
