package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria fábrica de gerenciamento de persistência
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persistência
		
		ArrayList<Conta> contas = criaContas();
		
		em.getTransaction().begin(); //inicia a transação
		
		contas.forEach(conta -> em.persist(conta)); //persiste os objeto
		em.getTransaction().commit(); //grava as alterações
		
		em.close();	//fecha a transação
	}

	private static ArrayList<Conta> criaContas() {
		ArrayList<Conta> contas = new ArrayList();
		contas.add(new Conta("itau",1234,5678,"José", new BigDecimal("0.1")));
		contas.add(new Conta("santander",1321,5434,"Maria", new BigDecimal("500")));
		contas.add(new Conta("nullbank",2465,9978,"Pedro", new BigDecimal("2500")));
		contas.add(new Conta("byebank",1012,2100,"Aline", new BigDecimal("80000")));
		return contas;
	}
}
