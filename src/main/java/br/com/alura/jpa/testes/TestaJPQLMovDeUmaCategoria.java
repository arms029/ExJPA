package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TestaJPQLMovDeUmaCategoria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntityManager();
		
		Categoria categoria = new Categoria();
		categoria.setId(4L);
		
		String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();
		resultList.forEach(resultado -> System.out.println(resultado));
	}
}
