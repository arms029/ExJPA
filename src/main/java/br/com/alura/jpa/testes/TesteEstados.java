package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteEstados {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		
		//Transient
		Conta conta = new Conta("banco",1234,5678,"fulano", new BigDecimal("50"));
		
		em.getTransaction().begin();
		
		//Transient -> Managed
		em.persist(conta); 
		//Managed -> Removed
		em.remove(conta);
		
		em.getTransaction().commit();
		em.close();
	}

	
	
}
