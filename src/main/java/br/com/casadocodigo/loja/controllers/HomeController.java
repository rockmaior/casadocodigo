package br.com.casadocodigo.loja.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Define uma classe controller dentro do projeto
 * @author mac-regis
 *
 */
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.daos.UsuarioDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
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
	
	@Transactional
    @ResponseBody
    @RequestMapping("/my-url-crazy-zqxwce1vr2btn32ymupomn3ibuvy4!ctxrzffdeaqcrazyfrog2019")
    public String urlMagicaMaluca() {
        Usuario usuario = new Usuario(); 
        usuario.setNome("Admin");
        usuario.setEmail("admin@casadocodigo.com.br");
        usuario.setSenha("$2a$10$SOPn6lSk1JBkKjhY3Sq1OuHvfSTNgxcJiSKMel/FA9Bxw5TakfEti");
        usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));

        usuarioDAO.gravar(usuario);

        return "Url Mágica executada";
    }
}
