package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria fábrica de gerenciamento de persistência
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persistência
		
		Conta conta = new Conta("NuBank",1234,5678,"Marcella",new BigDecimal("1200.69"));
		Conta conta2 = new Conta("Itau",2231,5564,"Mirella",new BigDecimal("18200.50"));
		
		List<Movimentacao> movimentacoes = new ArrayList<>();
		movimentacoes.add(new Movimentacao(new BigDecimal("500"), TipoMovimentacao.SAIDA, LocalDateTime.now(),"Churrascaria", conta ));
		movimentacoes.add(new Movimentacao(new BigDecimal("400"), TipoMovimentacao.SAIDA, LocalDateTime.now(),"Academia", conta ));
		movimentacoes.add(new Movimentacao(new BigDecimal("90"), TipoMovimentacao.ENTRADA, LocalDateTime.now(),"Venda de jogo", conta ));
		movimentacoes.add(new Movimentacao(new BigDecimal("1600"), TipoMovimentacao.ENTRADA, LocalDateTime.now(),"Aluguel do inquilino", conta ));
		movimentacoes.add(new Movimentacao(new BigDecimal("90"), TipoMovimentacao.SAIDA, LocalDateTime.now(),"Cabeleireiro", conta2 ));
		
		em.getTransaction().begin(); //inicia a transação
		
		em.persist(conta);
		em.persist(conta2);
		movimentacoes.forEach(movimentacao -> em.persist(movimentacao));
		em.getTransaction().commit(); //grava as alterações
		
		em.close();	//fecha a transação
	}
}
