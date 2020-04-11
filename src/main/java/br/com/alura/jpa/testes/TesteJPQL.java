package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TesteJPQL {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor asc";
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = query.getResultList();
		resultList.forEach(resultado -> System.out.println(resultado));
		
	}
}
