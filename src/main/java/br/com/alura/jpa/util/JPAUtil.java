package br.com.alura.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//private static Logger log = Logger.getLogger(JPAUtil.class); // import org.apache.log4j.Logger;

	/** Unidade de persistencia definida no arquivo <code>persistence.xml</code> */
	private static final String PERSISTENCE_UNIT_NAME = "contas"; //nome da unidade de persist�ncia
	
	private static EntityManagerFactory emf;

	//Bloco est�tico, roda o c�digo uma �nica vez.
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
        	//log.error("N�o conseguiu carregar a EntityManagerFactory: "+ex.getMessage());
        	System.out.println("N�o conseguiu carregar a EntityManagerFactory: " +ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * @return Cria e retorna um componente <code>EntityManager</code>.
     * @throws Lan�a <code>RuntimeException</code> se <code>EntityManagerFactory</code> estiver fechada. 
     */
    public static EntityManager createEntityManager() {
    	if (!emf.isOpen())
    		throw new RuntimeException("EntityManagerFactory est� fechada!");
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
