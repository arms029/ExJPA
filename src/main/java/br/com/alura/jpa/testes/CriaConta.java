package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); //Cria f�brica de gerenciamento de persist�ncia
		EntityManager em = emf.createEntityManager(); // Cria um objeto do tipo gerenciamento de persist�ncia
		
		ArrayList<Conta> contas = criaContas();
		
		em.getTransaction().begin(); //inicia a transa��o
		
		contas.forEach(conta -> em.persist(conta)); //persiste os objeto
		em.getTransaction().commit(); //grava as altera��es
		
		em.close();	//fecha a transa��o
	}

	private static ArrayList<Conta> criaContas() {
		ArrayList<Conta> contas = new ArrayList();
		contas.add(new Conta("itau",1234,5678,"Jos�", new BigDecimal("0.1")));
		contas.add(new Conta("santander",1321,5434,"Maria", new BigDecimal("500")));
		contas.add(new Conta("nullbank",2465,9978,"Pedro", new BigDecimal("2500")));
		contas.add(new Conta("byebank",1012,2100,"Aline", new BigDecimal("80000")));
		return contas;
	}
}
