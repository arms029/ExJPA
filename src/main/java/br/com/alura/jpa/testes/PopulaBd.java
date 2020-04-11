package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;
import br.com.alura.jpa.util.JPAUtil;

public class PopulaBd {
	public static void main(String[] args) {

		Categoria categoria4 = new Categoria("Compra");
		Categoria categoria5 = new Categoria("Venda");
		Categoria categoria6 = new Categoria("Gastronomia");
		Categoria categoria7 = new Categoria("Saude");
		
		Conta conta = new Conta("Itau",1234,5678,"Jorge",new BigDecimal("10000"));
		Cliente cliente = new Cliente("Jorge", "pedreiro", "Rua do matos, 514", conta);

		Movimentacao movimentacao1 = new Movimentacao(new BigDecimal("200"), 
				TipoMovimentacao.SAIDA, LocalDateTime.now(),"Almoço Restaurante", Arrays.asList(categoria6, categoria4), conta);
		
		Movimentacao movimentacao2 = new Movimentacao(new BigDecimal("300"), 
				TipoMovimentacao.ENTRADA, LocalDateTime.now(),"Venda de máscaras", Arrays.asList(categoria5, categoria7), conta);
		
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin(); //inicia a transação
		
		em.persist(categoria4);
		em.persist(categoria5);
		em.persist(categoria6);
		em.persist(categoria7);
		em.persist(conta);
		em.persist(cliente);
		em.persist(movimentacao1);
		em.persist(movimentacao2);

		em.getTransaction().commit(); //grava as alterações
		em.close();	//fecha a transação
	}

}
