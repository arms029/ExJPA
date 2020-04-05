package br.com.alura.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//private static Logger log = Logger.getLogger(JPAUtil.class); // import org.apache.log4j.Logger;

	/** Unidade de persistencia definida no arquivo <code>persistence.xml</code> */
	private static final String PERSISTENCE_UNIT_NAME = "contas"; //nome da unidade de persistência
	
	private static EntityManagerFactory emf;

	//Bloco estático, roda o código uma única vez.
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
        	//log.error("Não conseguiu carregar a EntityManagerFactory: "+ex.getMessage());
        	System.out.println("Não conseguiu carregar a EntityManagerFactory: " +ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * @return Cria e retorna um componente <code>EntityManager</code>.
     * @throws Lança <code>RuntimeException</code> se <code>EntityManagerFactory</code> estiver fechada. 
     */
    public static EntityManager createEntityManager() {
    	if (!emf.isOpen())
    		throw new RuntimeException("EntityManagerFactory está fechada!");
    	return emf.createEntityManager();
    }
    
    /**
     * Fecha o <code>EntityManagerFactory</code>.
     */
    public static void closeEntityManagerFactory() {
    	if (emf.isOpen()) {
    		emf.close();
    	}
    }

}
