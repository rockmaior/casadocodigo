package br.com.casadocodigo.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Repository
@Transactional
public class ProdutoDAO {
	@PersistenceContext
	private EntityManager manager;

	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("SELECT distinct (p) FROM Produto p", Produto.class).getResultList();
	}

	public Produto find(Integer id) {
		return manager
				.createQuery("SELECT DISTINCT (p) FROM Produto p JOIN FETCH p.precos precos WHERE p.id = :id", Produto.class)
				.setParameter("id", id).getSingleResult();
	}
	
	public BigDecimal somaProdutoPorTipo(TipoPreco tipoPreco){
		TypedQuery<BigDecimal> query = manager.createQuery("select sum(preco.valor) from Produto p join p.precos preco where preco.tipo = :tipoPreco" , BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco);
		return query.getSingleResult();
	}
}
