package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class TestaRelacionamentos {
	public static void main(String... args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Neg�cios");
		Categoria categoria3 = new Categoria("Assalto");
		
		Conta conta = new Conta("NuBank",1234,5678,"Ana",new BigDecimal("20000"));
		Cliente cliente = new Cliente("Ana", "dev", "Rua do mel�o, 564", conta);

		Movimentacao movimentacao1 = new Movimentacao(new BigDecimal("200"), 
				TipoMovimentacao.SAIDA, LocalDateTime.now(),"Viagem � SP", Arrays.asList(categoria1, categoria2), conta);
		
		Movimentacao movimentacao2 = new Movimentacao(new BigDecimal("300"), 
				TipoMovimentacao.SAIDA, LocalDateTime.now(),"Viagem � RJ", Arrays.asList(categoria1, categoria2, categoria3), conta);
		
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin(); //inicia a transa��o
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(categoria3);
		em.persist(conta);
		em.persist(cliente);
		em.persist(movimentacao1);
		em.persist(movimentacao2);

		em.getTransaction().commit(); //grava as altera��es
		em.close();	//fecha a transa��o
		
	}
}
