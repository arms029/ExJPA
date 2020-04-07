package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria fábrica de gerenciamento de persistência
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persistência
		
		Conta contaDaMarcella = new Conta("NuBank",1234,5678,"Marcella",new BigDecimal("1200.69"));
		Cliente marcella = new Cliente("Marcella", "Designer", "Rua malta 632", contaDaMarcella);

		Conta contaDaMirella = new Conta("Itau",2231,5564,"Mirella",new BigDecimal("18200.50"));
		Cliente mirella = new Cliente("Mirella", "Back-end dev", "Rua lopes 132", contaDaMirella);
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria("Festa"));
		categorias.add(new Categoria("jogos"));
		categorias.add(new Categoria("napalm"));
		
		List<Movimentacao> movimentacoes = new ArrayList<>();
		movimentacoes.add(new Movimentacao(new BigDecimal("2900"), TipoMovimentacao.ENTRADA, LocalDateTime.now(),
				"Fogo infinito", categorias));
		
		
		em.getTransaction().begin(); //inicia a transação
		
		em.persist(contaDaMarcella);
		em.persist(marcella);
		em.persist(contaDaMirella);
		em.persist(mirella);
		categorias.forEach(categoria -> em.persist(categoria));
		movimentacoes.forEach(movimentacao -> em.persist(movimentacao));
		
		em.getTransaction().commit(); //grava as alterações
		em.close();	//fecha a transação
	}

}
