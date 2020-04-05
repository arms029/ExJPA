package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria f�brica de gerenciamento de persist�ncia
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persist�ncia
		
		em.getTransaction().begin(); //inicia a transa��o
		
		Conta contaDoJose = em.find(Conta.class, 2L); 
		contaDoJose.setBanco("�tau");
		
		em.getTransaction().commit(); //grava as altera��es
		
		em.close();	//fecha a transa��o
	}
}
