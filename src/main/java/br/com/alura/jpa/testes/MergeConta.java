package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class MergeConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager(); 
		
		Conta contaDaIsabela = new Conta("Santander",9909,9902,"Maria",new BigDecimal("500.1"));
		
		em.getTransaction().begin();
		em.persist(contaDaIsabela); 
		em.getTransaction().commit(); 
		em.close(); //Managed -> Detached
		
		contaDaIsabela.setBanco("NuBank");
		contaDaIsabela.setTitular("Isabela");
		
		em2.getTransaction().begin(); 
		//em2.persist(contaDaIsabela); //PersistentObjectException, objeto está detached!!!
		em2.merge(contaDaIsabela); //Detached -> Managed
		em2.getTransaction().commit(); 
		em2.close();
		
	}
}
