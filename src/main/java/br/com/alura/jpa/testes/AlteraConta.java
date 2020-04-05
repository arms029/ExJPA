package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria fábrica de gerenciamento de persistência
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persistência
		
		em.getTransaction().begin(); //inicia a transação
		
		Conta contaDoJose = em.find(Conta.class, 2L); 
		contaDoJose.setBanco("Ítau");
		
		em.getTransaction().commit(); //grava as alterações
		
		em.close();	//fecha a transação
	}
}
